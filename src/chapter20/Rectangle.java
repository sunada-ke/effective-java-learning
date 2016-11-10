package chapter20;

public final class Rectangle extends AbstractFigure {

	private final double length;

	private final double witdh;

	public Rectangle(double length, double witdh) {
		this.length = length;
		this.witdh = witdh;
	}

	@Override
	double area() {
		return length * witdh;
	}
}
