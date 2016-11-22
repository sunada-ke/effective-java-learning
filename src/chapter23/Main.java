package chapter23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 新たなコードで原型を使用しない
 */
public final class Main {

	public static void main(String[] args) {
		// 型パラメータ（type parameter）をもつクラスやインタフェースは、ジェネリッククラスやジェネリックインタフェースと呼ばれる。
		// これらはまとめてジェネリクス型として知られている。
		// ジェネリクスが Java に追加される以前はコレクションから読み出した全てのオブジェクトをキャストする必要があった。

		// ジェネリック型に実型パラメータを与えないこともできる。これを原型と呼ぶ。

		// 以下、List インターフェイスを例にとる。
		// ジェネリック型 : List<E>
		// 仮型パラメータ : E
		// パラメータされた型 : List<String>
		// 実型パラメータ : String
		// 原型 : List
		List<String> strs = new ArrayList<>();

		// 以下、原型を利用する List の例。
		List integers = new ArrayList<>();
		integers.add("aaa");
		// 原型を利用してしまうと ClassCastException が発生してしまう。
		try {
			Integer integer = (Integer) integers.get(0);
		} catch (ClassCastException e) {
			System.out.println("ClassCastException occurred.");
		}

		// ジェネリクスを利用した List の例。
		List<Integer> ints = Arrays.asList(1);
		// 以下のコードは、コンパイルエラーが発生するため、事前にエラーが分かる。
		// ints.add("aaa");
		// 明示的なキャストが不要になる。
		Integer integerValue = ints.get(0);

		// 原型を利用してはならない。
		// なぜなら、原型はコンパイルすることができ(コンパイルの警告はでるが)、コンパイルされたコードは実行することが可能。
		// しかし、実行時に ClassCastException が発生する可能性があるため、
		// 原型は変数やメソッドパラメータなどで決して利用するべきではない。

		// 型要素が何であるかを気にしないリストに対して原型を使いたくなる場合がある。
		// 例えば、２ つのリストを比較し、共通の要素の数を返すメソッドを考えてみる。
		List<String> stringList = Arrays.asList("aaa", "bbb", "ccc");
		List<Integer> integerList = Arrays.asList(1, 2, 3);
		numElementsInCommon(stringList, integerList);

		// 原型を利用するケースは 2 つのみ。
		// 1 つ目はクラスリテラルを使う場合。
		Class clazz = List.class;
		// 2 つ目は instanceof 演算子を使う場合。
		if (stringList instanceof List) {
			// instanceof 演算子を使った場合は非境界ワイルドカード型にキャストして、利用することが推奨される。
			List<?> list = (List<?>) stringList;
		}
	}

	private static int numElementsInCommon(List<?> a, List<?> b) {
		// 非境界ワイルドカード型(?)を利用。
		// ジェネリックス型 List の非境界ワイルドカード型は List<?> と書く。
		// ジェネリクス型を利用したいが、実際の型パラメータが分からない、または気にしたくないという場合に利用。
		int result = 0;
		for (Object o1 : a) {
			if (b.contains(o1)) {
				result++;
			}
		}
		return result;
	}
}
