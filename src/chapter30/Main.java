package chapter30;

/**
 * int 定数の代わりに enum を使用する
 */
public final class Main {

	public static void main(String[] args) {
		// enum が Java で提供される前は以下の Constants クラスのように定数を宣言していた。
		// これは int enum パターンとして知られている。
		System.out.println(Constants.APPLE_FUJI);

		// int enum パターンは多くの欠点を持っている。
		// 1: 型安全性が提供されない
		// 2: 名前空間が提供されない (接頭語(ex:APPLE_)を付与する必要がある)
		// 3: グループの定数をイテレートできない
		// 4: 表示可能な文字列に変換できない

		// int enum パターンと同じようなパターンに String enum パターンがある。
		// しかし、以下のような欠点がある。
		// 文字列比較になるためパフォーマンスが悪い
		// 誤字に対応できない(フィールド定数を利用せず、ハードコードする人が出てくる)
		System.out.println(Constants.PERSON);

		// Java 1.5 より、enum 型が利用できる。
		// enum は public static final フィールドを通して、
		// 個々の列挙定数インスタンスにアクセスできるクラスである。
		// さらに、各列挙定数インスタンスはシングルトン化されている。
		// これに加えて、enum 型は型安全と名前空間を持つ。
		// int enum パターンでは APPLE_FUJI と ORANGE_NAVEL は比較可能で実行できるが、
		// enum 型では Apple.FUJI と Orange.NOVEL は比較できず、コンパイルエラーとなる。
		// また、toString() で表示可能な文字列に変換できる。
		if (Apple.FUJI != Apple.GRANNY_SMITH) {
			System.out.println("False");
		}

		// enum 型はフィールドとメソッドを持つことが可能。
		// enum の値セットは values() メソッドで取得することができる。
		// これらを合わせて使うと、各惑星上での重さを出力するプログラムを簡単に書くことができる。
		double earthWeight = Double.parseDouble("10.0");
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		// values() で enum の値セットを取得。
		for (Planet p : Planet.values()) {
			System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
		}

		// Planet の例では定数ごとのフィールド値が異なるだけで、メソッド振る舞いは同じ。
		// もし、定数ごとにメソッドの振る舞いを変えたい場合には定数固有メソッド実装を利用する。
		double result = Operation.PLUS.apply(10, 10);
		System.out.println(result);

		// 定数固有メソッドの場合、enum 定数間でコード共有することを困難にしている。
		// この場合、新たな enum 定数が増えた場合、switch 文を追加することを忘れる可能性がある。
		double payResult = PayrollDay.SUNDAY.pay(8.0, 1.0);
		System.out.println(payResult);

		// enum 定数間でコードを共有し、enum 定数を追加した場合にメソッド実装を
		// 強制する方法がある。戦略 enum と呼ばれる。
		// 戦略 enum を利用することで、switch 文や定数固有メソッド実装の必要性を
		// StrategyPayrollDay から排除する。
		// このパターンは switch 文より簡潔ではないが、より安全でより柔軟。
		double strategyPayResult = StrategyPayrollDay.SUNDAY.pay(8.0, 1.0);
		System.out.println(strategyPayResult);

		// パフォーマンスに対して、enum は int 定数と比べて遜色ない。
		// enum 型は固定数の定数が必要な場合には常に使用すべき。
		// 惑星、週の曜日、チェスの駒のような「自然な列挙型」や、
		// メニュー上の選択肢、操作コード、コマンドラインのフラグなど、
		// コンパイル時に全ての可能な値が分かっているもの。
	}
}
