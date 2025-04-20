package meteordevelopment.meteorclient.systems.modules.combat.killaura;

public enum KillAuraPlusModes {
	None,
	Matrix;

	@Override
	public String toString() {
		return super.toString().replaceAll("Plus", "+").replaceAll("_", " ");
	}
}
