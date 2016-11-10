package chapter20;

public final class Circle extends AbstractFigure {

	private final double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	double area() {
		return Math.PI * (radius * radius);
	}
}
