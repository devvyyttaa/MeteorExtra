package meteordevelopment.meteorclient.main.events.hud;
import meteordevelopment.meteorclient.main.events.Cancellable;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;

public class RenderMountHealthBarEvent extends Cancellable {
	private static final RenderMountHealthBarEvent INSTANCE = new RenderMountHealthBarEvent();
	private DrawContext context;
	public static RenderMountHealthBarEvent get(DrawContext context) {
		INSTANCE.context = context;
		return INSTANCE;
	}
}
