package chapter27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * ジェネリックメソッドを使用する。
 */
public final class Main {

	public static void main(String[] args) {
		// クラスだけではなく、メソッドもジェネリック化が可能。
		// static のユーティリティメソッドは特にジェネリック化の良い兆候。
		// Collections の全てのアルゴリズムメソッド(binarySearch,sort)はジェネリック化されている。

		// 2 つの Set の和集合を返すメソッドを考えてみる。
		Set<String> set1 = new HashSet<>();
		set1.add("aaa");
		Set<String> set2 = new HashSet<>();
		set2.add("bbb");

		System.out.println(union1(set1, set2));
		System.out.println(union2(set1, set2));

		// union2() のようなジェネリックメソッドの特徴は、型パラメータの値を
		// 明示的(ex:String,Integer)に指定する必要がないこと。
		// これはコンパイラが型推論を行い、自動的に実型パラメータを決定して検証を行っているため。
		// 引数が Set<String> だと分かっているため、型パラメータ E が String でなければならないことが
		// 分かっている。

		// 型パラメータがその型パラメータ自身と関係する、何らかの制約で制限されていることがある
		// 再帰型境界と呼ばれる。
		// 最もよく知られた再帰型境界は Comparable インタフェース。
		List<String> strs = Arrays.asList("aaa", "bbbb", "ccccc", "dddddd");
		String result = max(strs);
		System.out.println(result);
	}

	// 原型を使用しているため、警告が発生する。
	private static Set union1(Set s1, Set s2) {
		Set result = new HashSet(s1);
		result.addAll(s2);
		return result;
	}

	// ジェネリックメソッド。警告は発生しない。
	// 型安全を提供。
	private static <E> Set<E> union2(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}

	// List の要素(T)を比較する。
	private static <T extends Comparable<T>> T max(List<T> list) {
		Iterator<T> i = list.iterator();
		T result = i.next();
		while (i.hasNext()) {
			T t = i.next();
			// T が Comparable を extends していることが
			// 分かっているため、compareTo() メソッドを呼び出せる。
			if (t.compareTo(result) > 0) {
				result = t;
			}
		}
		return result;
	}

}
