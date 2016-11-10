package chapter19;

/**
 * 型を定義するためにインターフェイスを使用する
 */
public final class Main implements ConstantsInterface {

	public static void main(String[] args) {
		// インターフェイスをクラスが実装するということは、
		// そのクラスのインスタンスでクライアントは何ができるのかについて
		// 述べていないといけない。

		// 下記の例はインターフェイスを定数用途として利用している悪い例。
		// インターフェイスなのに、実装の詳細を取り扱ってる。
		// インターフェイス実装先クラスの名前空間を汚している。
		System.out.println(JAVA);

		// インターフェイス利用する代わりに enum クラスか定数クラスを利用する。
		System.out.println(Constants.RUBY);
		System.out.println(ConstantsEnum.OBJECTIVE_C.name());
	}
}
