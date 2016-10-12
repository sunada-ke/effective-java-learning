package chapter13;

public final class Person {

	// 不必要にアクセス修飾子を public にしない。
	// public にしてしまうと以下の問題が発生してしまう。
	// 1. フィールドに保存できる値を制限することを放棄することになる。
	// 2. フィールドに関係する不変式を強制することも放棄することになる。
	// 3. フィールドが変更された時に何らかしらの処理を行うことを放棄することになる。
	// 4. 結果的に public の可変フィールドを持つクラスはスレッドセーフではない。
	private final String name;

	private final int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void showProfile() {
		System.out.println("Name is " + name);
		System.out.println("Age is " + age);
	}
}
