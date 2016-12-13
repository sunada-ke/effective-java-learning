package chapter33;

public final class Herb {
	enum Type {
		Annual, Perennial, Biennial
	}

	public String name;

	public Type type;

	public Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}
}