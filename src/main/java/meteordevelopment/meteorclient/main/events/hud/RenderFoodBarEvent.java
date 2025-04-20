package meteordevelopment.meteorclient.main.events.hud;
import meteordevelopment.meteorclient.main.events.Cancellable;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;

public class RenderFoodBarEvent extends Cancellable {
	private static final RenderFoodBarEvent INSTANCE = new RenderFoodBarEvent();
	private DrawContext context;
	private PlayerEntity player;
	private int top;
	private int right;
	public static RenderFoodBarEvent get(DrawContext context, PlayerEntity player, int top, int right) {
		INSTANCE.context = context;
		INSTANCE.player = player;
		INSTANCE.top = top;
		INSTANCE.right = right;
		return INSTANCE;
	}
}
