package chapter14;

// 外部クラス。
public final class Outer {

	public static void main(String[] args) {
		// クラスがパッケージプライベート、もしくは private のネストしたクラスの場合、
		// クラスフィールドを直接公開することは本質的に問題ない。
		// この方法はアクセッサメソッドの方法よりは、クラス定義およびそのクラスを使用している
		// クライアントのコードの両方で見やすいコードとなりうる。
		// クラスフィールドを変更した場合、変更の影響範囲がパーッケージ内もしくは外部クラス内にとどまる。
		Innar innar = new Innar();
		innar.str = "innar";
	}

	// private のネストした内部クラス。
	private static class Innar {
		// public で外部クラスに公開。
		public String str;
	}
}
