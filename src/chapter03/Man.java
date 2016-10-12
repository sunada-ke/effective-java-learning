package chapter03;

public final class Man {

	public static final Man INSTANCE = new Man();

	// シングルトンに強制するため、コンストラクタを private にし、
	// 外部からインスタンスを生成させないようにする。
	private Man() {
		// リフレクションを利用されると private コンストラクタを呼び出すことができるので、
		// 例外を投げる。
		throw new UnsupportedOperationException();
	}

	public void print() {
		System.out.println("Hello");
	}
}
