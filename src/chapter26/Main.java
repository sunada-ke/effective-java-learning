package chapter26;

/**
 * ジェネリック型を使用する
 */
public final class Main {

	public static void main(String[] args) {
		// ジェネリック型はクライアントのコードでキャストが必要である型より、
		// 安全で使いやすい。

		// 以前、紹介した Stack の実装。
		// pop() した際に、キャストが必要になる。
		chapter06.Stack stringStack = new chapter06.Stack();
		stringStack.push("2");
		stringStack.push("1");
		// キャストが必要。
		String one = (String) stringStack.pop();
		String two = (String) stringStack.pop();

		// コマンドラインから入力された文字列を大文字で表示するプログラム。
		// ジェネリック型を利用した Stack の実装。
		// あらかじめ、型の指定を行なっているため、pop() した際にキャストが不要になる。
		Stack<String> stack = new Stack<String>();
		for (String arg : args) {
			stack.push(arg);
		}
		while (!stack.isEmpty()) {
			// キャストをする必要がない。
			String arg = stack.pop();
			System.out.println(arg.toUpperCase());
		}

		// 型パラメータに可能な値を制限するジェネリック型もある。
		// 例えば、java.util.DelayQueue。
		// 宣言は class DelayQueue<E extends Delayed> implements BlockingQueue<E>
		// とされている。
		// 型パラメータリスト (<E extends Delayed>) は、実型パラメータが Delayed のサブクラスであることを
		// 要求している。
		// このおけげで、DelayQueue 実装とそのクライアントは、明示的なキャスト要性や、ClassCastException
		// の危険性もなく、
		// DelayQueue の要素に対して、Delayed のメソッド(getDelay())を呼び出せる。
	}

}
