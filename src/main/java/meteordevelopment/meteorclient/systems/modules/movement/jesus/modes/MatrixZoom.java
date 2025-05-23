package meteordevelopment.meteorclient.systems.modules.movement.jesus.modes;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.mixininterface.IVec3d;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import meteordevelopment.meteorclient.systems.modules.movement.jesus.JesusMode;
import meteordevelopment.meteorclient.systems.modules.movement.jesus.JesusModes;

public class MatrixZoom extends JesusMode {
	public MatrixZoom() {
		super(JesusModes.Matrix_Zoom);
	}

	private final float range = 0.005f;

	@Override
	public void onTickEventPre(TickEvent.Pre event) {
		float yaw = mc.player.getYaw();
		Vec3d forward = Vec3d.fromPolar(0, yaw);
		Vec3d right = Vec3d.fromPolar(0, yaw + 90);

		double velX = 0;
		double velZ = 0;
		double s = 0.5;
		double speedValue = settings.speed.get();

		if (mc.options.forwardKey.isPressed()) {
			velX += forward.x * s * speedValue;
			velZ += forward.z * s * speedValue;
		}
		if (mc.options.backKey.isPressed()) {
			velX -= forward.x * s * speedValue;
			velZ -= forward.z * s * speedValue;
		}

		if (mc.options.rightKey.isPressed()) {
			velX += right.x * s * speedValue;
			velZ += right.z * s * speedValue;
		}
		if (mc.options.leftKey.isPressed()) {
			velX -= right.x * s * speedValue;
			velZ -= right.z * s * speedValue;
		}
		if (mc.world.getBlockState(new BlockPos(mc.player.getBlockX(), (int) (mc.player.getBlockY() + range), mc.player.getBlockZ())).getBlock() == Blocks.WATER && !mc.player.horizontalCollision) {
			((IVec3d) mc.player.getVelocity()).meteor$set(velX, 0, velZ);
		}
	}
}
