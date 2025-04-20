/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.systems.modules.movement.elytrafly.modes;

import meteordevelopment.meteorclient.events.entity.player.PlayerMoveEvent;
import meteordevelopment.meteorclient.mixininterface.IVec3d;
import meteordevelopment.meteorclient.systems.modules.movement.elytrafly.ElytraFlyMode;
import meteordevelopment.meteorclient.systems.modules.movement.elytrafly.ElytraFlyModes;

public class Control extends ElytraFlyMode {
	public Control() {
		super(ElytraFlyModes.Control);
	}
	private boolean moving;
	private float yaw;
	private float pitch;
	private float p;
	private double velocity;
	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		if (!mc.player.isGliding()) {return;}

		updateControlMovement();
		pitch = 0;

		boolean movingUp = false;

		if (!mc.options.sneakKey.isPressed() && mc.options.jumpKey.isPressed() && velocity > elytraFly.speed_control.get() * 0.4) {
			p = (float) Math.min(p + 0.1 * (1 - p) * (1 - p) * (1 - p), 1f);

			pitch = Math.max(Math.max(p, 0) * -90, -90);

			movingUp = true;
			moving = false;
		} else {
			velocity = elytraFly.speed_control.get();
			p = -0.2f;
		}

		velocity = moving ? elytraFly.speed_control.get() : Math.min(velocity + Math.sin(Math.toRadians(pitch)) * 0.08, elytraFly.speed_control.get());

		double cos = Math.cos(Math.toRadians(yaw + 90));
		double sin = Math.sin(Math.toRadians(yaw + 90));

		double x = moving && !movingUp ? cos * elytraFly.speed_control.get() : movingUp ? velocity * Math.cos(Math.toRadians(pitch)) * cos : 0;
		double y = pitch < 0 ? velocity * elytraFly.upMultiplier_control.get() * -Math.sin(Math.toRadians(pitch)) * velocity : -elytraFly.fallSpeed_control.get();
		double z = moving && !movingUp ? sin * elytraFly.speed_control.get() : movingUp ? velocity * Math.cos(Math.toRadians(pitch)) * sin : 0;

		y *= Math.abs(Math.sin(Math.toRadians(movingUp ? pitch : mc.player.getPitch())));

		if (mc.options.sneakKey.isPressed() && !mc.options.jumpKey.isPressed()) {
			y = -elytraFly.downSpeed_control.get();
		}

		((IVec3d) event.movement).meteor$set(x, y, z);
		if (elytraFly.resetSpeed.get()) {
			mc.player.setVelocity(0, 0, 0);
		}
	}

	private void updateControlMovement() {
		float yaw = mc.player.getYaw();

		float forward = mc.player.input.getMovementInput().y;
		float sideways = mc.player.input.getMovementInput().x;

		if (forward > 0) {
			moving = true;
			yaw += sideways > 0 ? -45 : sideways < 0 ? 45 : 0;
		} else if (forward < 0) {
			moving = true;
			yaw += sideways > 0 ? -135 : sideways < 0 ? 135 : 180;
		} else {
			moving = sideways != 0;
			yaw += sideways > 0 ? -90 : sideways < 0 ? 90 : 0;
		}

		this.yaw = yaw;
	}
}
