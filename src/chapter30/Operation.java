package chapter30;

public enum Operation {
	PLUS {
		double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS {
		double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES {
		double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE {
		double apply(double x, double y) {
			return x / y;
		}
	};

	// abstract method を宣言し、各定数の宣言時に振る舞いを定義することができる。
	// これによって、新たな定数を追加したとき、振る舞いを定義し忘れることがなくなる。
	// なぜなら、apply の実装を忘れた場合はコンパイルエラーになってしまうため。
	abstract double apply(double x, double y);
}
