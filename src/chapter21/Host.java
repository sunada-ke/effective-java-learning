package chapter21;

import java.util.Comparator;

// 具象戦略クラスを提供するクラス。
public final class Host {

	// 文字列の長さを比較する「ため」の具象戦略クラス。
	// private クラスになっているため、外部からインスタンス化することは不可能。
	private static final class StringLenCom implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
	}

	// シングルトンインスタンスを提供。
	public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StringLenCom();
}
