package meteordevelopment.meteorclient.systems.modules.movement.scaffold;

import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.main.events.PlayerUseMultiplierEvent;
import net.minecraft.client.MinecraftClient;

public class ScaffoldMode {
	protected final MinecraftClient mc;
	protected final ScaffoldPlus settings;
	private final ScaffoldModes type;

	public ScaffoldMode(ScaffoldModes type) {
		this.settings = Modules.get().get(ScaffoldPlus.class);
		this.mc = MinecraftClient.getInstance();
		this.type = type;
	}
	public void onUse(PlayerUseMultiplierEvent event) { }
}
