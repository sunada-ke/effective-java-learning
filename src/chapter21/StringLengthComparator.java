package chapter21;

public final class StringLengthComparator {

	public int compare(String s1, String s2) {
		// 文字列の長さを比較するコンパレータ。
		return s1.length() - s2.length();
	}
}
