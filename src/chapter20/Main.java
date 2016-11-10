package chapter20;

public final class Main {

	public static void main(String[] args) {

		// タグ付きクラスを利用した例。
		FigureForTag circleForTag = new FigureForTag(10.0);
		System.out.println(circleForTag.area());

		FigureForTag rectangleForTag = new FigureForTag(10.0, 20.0);
		System.out.println(rectangleForTag.area());

		// タグ付きクラスに対するクラス階層による置き換え。
		// コードが簡潔で明瞭。各特性の実装に対しては独自のクラスが割り当てられており、
		// それらのクラスは無関係なデータフィールドを負っていない。
		// 全てのフィールドは final にできる。
		AbstractFigure circle = new Circle(10.0);
		System.out.println(circle.area());

		AbstractFigure rectangle = new Rectangle(10.0, 20.0);
		System.out.println(rectangle.area());
	}
}
