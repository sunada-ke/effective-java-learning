package chapter4;

public final class StringUtils {

	// ユーティリティクラスなので、インスタンス化させる必要はない。
	private StringUtils() {
		// クラス内部からの呼び出しも防ぐ。
		throw new UnsupportedOperationException();
	}

	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
}
