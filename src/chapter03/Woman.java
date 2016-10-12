package chapter03;

public class Woman {

	private static final Woman INSTANCE = new Woman();

	// シングルトンに強制するため、コンストラクタを private にし、
	// 外部からインスタンスを生成させないようにする。
	private Woman() {
		// リフレクションを利用されると private コンストラクタを呼び出すことができるので、
		// 例外を投げる。
		throw new UnsupportedOperationException();
	}

	public static Woman getInstance() {
		return INSTANCE;
	}

	public void print() {
		System.out.println("Hello");
	}
}
