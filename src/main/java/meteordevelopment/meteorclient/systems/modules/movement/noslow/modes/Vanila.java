package meteordevelopment.meteorclient.systems.modules.movement.noslow.modes;

import meteordevelopment.meteorclient.main.events.PlayerUseMultiplierEvent;
import meteordevelopment.meteorclient.systems.modules.movement.noslow.NoSlowMode;
import meteordevelopment.meteorclient.systems.modules.movement.noslow.NoSlowModes;

public class Vanila extends NoSlowMode {
	public Vanila() {
		super(NoSlowModes.Vanila);
	}

	@Override
	public void onUse(PlayerUseMultiplierEvent event) {
		if (mc.player.isSneaking()) {
			event.setForward(settings.sneakForward.get().floatValue());
			event.setSideways(settings.sneakSideways.get().floatValue());
		}
		else if (mc.player.isUsingItem()) {
			event.setForward(settings.usingForward.get().floatValue());
			event.setSideways(settings.usingSideways.get().floatValue());
		}
		else {
			event.setForward(settings.otherForward.get().floatValue());
			event.setSideways(settings.otherSideways.get().floatValue());
		}
	}
}
