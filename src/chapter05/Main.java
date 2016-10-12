package chapter05;

import java.util.Date;

/**
 * 不必要なオブジェクトの生成を避ける
 */
public final class Main {

	public static void main(String[] args) {
		// オブシェクトが不変であれば常に再利用が可能。例えば、String クラス。

		// 不必要なオブジェクトの生成を行っている例。
		// String クラスのコンストラクタ引数である "abc" はそれ自体が String インスタンスであり、
		// コンストラクタで生成される全てのインスタンスと機能的には同じ。
		String str1 = new String("abc");

		// この場合、実行されるごとに新たなインスタンスを生成しないで、
		// 1 つの String インスタンスを使用する。
		// 同一の JVM で動作し、同じ文字列リテラルを持っている他のコードが同じ String インスタンスを使用することが
		// 保証されている。
		String str2 = "abc";

		// 別の例。
		// コンストラクタは実行されるごとに新しいインスタンスを生成するが、
		// この static ファクトリーメソッドは新たなオブジェクトの生成を行わない。
		Boolean bool1 = new Boolean("true");
		Boolean bool2 = Boolean.valueOf("true");

		// 可変オブジェクトであっても、オブジェクトの状態が変更されないと分かっているならば再利用が可能。
		Person person = new Person(new Date());
		person.isBabyBoomer();

		// 自動ボクシングの例。
		// たった 1 文字の違いで不必要なオブジェクトの生成を行なってしまっている。
		// ボクシングされた基本データ型より、基本データ型を選び、意図しない自動ボクシングに注意すること。
		Long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
