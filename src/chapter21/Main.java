package chapter21;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 戦略を表現するために関数オブジェクトを使用する
 */
public final class Main {

	private static final Comparator<String> STRING_LENGTH_COMPARATOR = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
	};

	public static void main(String[] args) {
		// 関数オブジェクトとは、他のオブジェクトを受け取り、
		// 何らかの操作するためのメソッドを一つだけ持つオブジェクトのこと。
		// 例えば、ソート処理における java.util.Comparator クラスであり、
		// 引数で渡された他のオブジェクトを受け取り、比較する戦略を提供する。

		// 例えば、以下のクラスは文字列の長さを比較するメソッドを提供する。
		// 文字列比較に対する具象戦略クラスとも呼ばれる。
		StringLengthComparator comparator = new StringLengthComparator();
		int result = comparator.compare("abc", "efgh");

		// メソッドに StringLengthComparator クラスを渡すと、メソッドの呼び出された側では文字列の比較しかできなくなる。
		// 様々な型パラメータを比較する他の戦略も必要となる。
		// ジェネリクスを利用した戦略インターフェイスを利用する。

		String[] stringArrays1 = new String[3];
		stringArrays1[0] = "a";
		stringArrays1[1] = "c";
		stringArrays1[2] = "b";

		// Arrays.sort メソッドの中で Comparator.compare メソッドを呼び出している。
		Arrays.sort(stringArrays1, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 辞書順で比較。
				return o1.compareTo(o2);
			}
		});

		for (String str : stringArrays1) {
			System.out.println(str);
		}

		// しかし、匿名内部クラスを利用すると、毎回インスタンスを生成してしまうので、
		// 繰り返し実行するのであるならば、シングルトンインスタンスを使いまわした方が良い。
		String[] stringArrays2 = new String[3];
		stringArrays2[0] = "a";
		stringArrays2[1] = "ccc";
		stringArrays2[2] = "bb";

		Arrays.sort(stringArrays2, Host.STRING_LENGTH_COMPARATOR);

		for (String str : stringArrays2) {
			System.out.println(str);
		}

		// このクラス内で利用するだけであるならば、このクラス内に private のメンバを作成すれば良い。

		String[] stringArrays3 = new String[3];
		stringArrays3[0] = "a";
		stringArrays3[1] = "ccc";
		stringArrays3[2] = "bb";

		Arrays.sort(stringArrays3, STRING_LENGTH_COMPARATOR);

		for (String str : stringArrays3) {
			System.out.println(str);
		}
	}
}
