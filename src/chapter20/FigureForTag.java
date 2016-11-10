package chapter20;

/**
 * 円または四角の面積を計算するクラス。
 */
public final class FigureForTag {

	// クラス内に enum 宣言、フィールド、switch 文を含む
	// 決まりきったコードが散らばっている。
	// 複数の実装が単一クラスにごちゃごちゃに詰め込まれているので、
	// 読みやすさが損なわれている。
	// 他の特性に属する関係のないフィールドをインスタンスは抱えるので、
	// メモリ量が増加する。
	// コンストラクタが無関係のフィールドを初期化しない限り、フィールドを final にできない。

	private enum Shape {
		RECTANGLE, CIRCLE
	};

	private final Shape shape;

	private double length;

	private double width;

	private double radius;

	FigureForTag(double radius) {
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	FigureForTag(double length, double width) {
		shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}

	public double area() {
		switch (shape) {
		case RECTANGLE:
			return length * width;
		case CIRCLE:
			return Math.PI * (radius * radius);
		default:
			throw new AssertionError();
		}
	}
}
