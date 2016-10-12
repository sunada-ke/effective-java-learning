package chapter14;

import java.awt.Dimension;

/**
 * publicのクラスではpublicのフィールドではなくアクセッサーメソッドを使う
 */
public class Main {

	public static void main(String[] args) {
		// 下記クラスは悪い例。
		// public フィールドを private フィールドに変更し、アクセッサメソッドを提供したほうが良い。
		// フィールドを public に設定すると、不変式を強制できないし、フィールド変更時の補助処理を行うことができなくなる。
		Dimension dimension = new Dimension(1, 1);

		// アクセッサメソッドを使用した例。
		Person person = new Person();
		person.setName("Keisuke");
		person.setAge(25);
		person.showProfile();
	}
}
