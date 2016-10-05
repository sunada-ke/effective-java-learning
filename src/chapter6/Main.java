package chapter6;

/*
 * 廃れたオブジェクト参照を取り除く
 */
public final class Main {

	public static void main(String[] args) {

		// 配列を使った独自のメモリの管理の例。
		Stack stack = new Stack();
		stack.push(new Object());
		stack.pop();
	}

}
