package meteordevelopment.meteorclient.main.events.packets;

import meteordevelopment.meteorclient.main.events.Cancellable;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;

public class PacketEvent {
	public static class Receive extends Cancellable {
		private static final Receive INSTANCE = new Receive();

		public Packet<?> packet;
		public PacketListener packetListener;

		public static Receive get(Packet<?> packet, PacketListener listener) {
			INSTANCE.setCancelled(false);
			INSTANCE.packet = packet;
			INSTANCE.packetListener = listener;
			return INSTANCE;
		}
	}

	public static class Send extends Cancellable {
		private static final Send INSTANCE = new Send();

		public Packet<?> packet;

		public static Send get(Packet<?> packet) {
			INSTANCE.setCancelled(false);
			INSTANCE.packet = packet;
			return INSTANCE;
		}
	}

	public static class Sent {
		private static final Sent INSTANCE = new Sent();

		public Packet<?> packet;

		public static Sent get(Packet<?> packet) {
			INSTANCE.packet = packet;
			return INSTANCE;
		}
	}
}
