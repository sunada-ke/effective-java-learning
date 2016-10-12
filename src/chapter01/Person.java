package chapter01;

public final class Person {

	private static final Person INSTANCE = new Person();

	// シングルトンに強制するため、コンストラクタを private にし、
	// 外部からインスタンスを生成させないようにする。
	private Person() {
	}

	public static Person getInstance() {
		return INSTANCE;
	}

	public void showProfile() {
		System.out.println("My name is Legend.");
	}
}
