package chapter22;

public final class Calculator {

	// Calculator の static メンバクラスとして実装。
	// 内部クラスと外部クラスの関連が明白であり、利用側も意図がわかりやすい。
	// Operation.PLUS より Calculator.Operation.PLUS の方が良い。
	public static enum Operation {

		PLUS("+") {
			@Override
			double apply(double x, double y) {
				return x + y;
			}
		},
		MINUS("-") {
			@Override
			double apply(double x, double y) {
				return x - y;
			}
		},
		TIMES("*") {
			@Override
			double apply(double x, double y) {
				return x * y;
			}
		},
		DIVIDE("/") {
			@Override
			double apply(double x, double y) {
				return x / y;
			}
		};

		private String value;

		Operation(String value) {
			this.value = value;
		}

		abstract double apply(double x, double y);
	}

	// 何らかの実装。
}
