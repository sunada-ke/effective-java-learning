package chapter13;

/**
 * クラスとメンバーへのアクセス可能性を最小限にする
 */
public class Main {

	public static void main(String[] args) {
		Person person = new Person("Keisuke", 25);
		person.showProfile();
	}
}
