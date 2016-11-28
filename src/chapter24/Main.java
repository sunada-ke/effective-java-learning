package chapter24;

import java.util.ArrayList;
import java.util.List;

/**
 * 無検査警告を取り除く
 */
public final class Main {

	public static void main(String[] args) {
		// ジェネリクスを利用すると、無検査警告と呼ばれるコンパイラ警告が発生する場合がある。

		// 例えば、以下のコードは警告が発生する。
		List<Integer> numbers1 = new ArrayList();

		// 警告を取り除くためにはコードを以下のように変更する。
		List<Integer> numbers2 = new ArrayList<Integer>();

		// このように、多くの無検査警告は簡単に取り除くことができる。
		// なるべくコードを変更して無検査警告を取り除くべき。
		// 無検査警告がなければ実行時に ClassCastException が発生しないことを保障できるため、
		// プログラムの安全性を高めることができる。

		// 一方、コードの変更によって無検査警告を取り除くことができない場合がある。
		// この場合、警告を起こしているコードが型安全であることを論理的に示すことができるならば、
		// @SuprpressWarnings アノテーションで警告を抑制するべき。
		// 最初にコードが型安全だと明確に示すことなく警告を抑制すると、自分自身に誤った安心感を持たせてしまう。
		// 実際にはプログラム実行時に ClassCastException が発生する。

		// @SuprpressWarnings アノテーションは最小スコープに対して使用するべき。
		// 一般には、変数宣言、非常に短いメソッドやコンストクタ。
		// 広いスコープで使用してしまうと、重大な警告を隠蔽してしまうかもしれない。
		// クラスに全体に利用してはならない。

		// 例えば、ArrayList#toArray(T[] t) を考えてみる。
		// (T[]) Arrays.copyOf(elementData, size, a.getClass()); で無検査警告が発生するが、
		// List と同じ型(Integer)の配列を生成するので、キャストは常に安全となるので、
		// @SuprpressWarnings アノテーションを利用している。
		// Effective Java では変数宣言を利用して、最小スコープに対して@SuprpressWarnings アノテーションを
		// 利用することを伝えているが、Java 7 ではメソッドに対して利用している。
		// 参考:http://hjm333.hatenablog.com/entry/2016/01/30/120135
		Integer[] ints = new Integer[10];
		numbers2.toArray(ints);
	}
}
