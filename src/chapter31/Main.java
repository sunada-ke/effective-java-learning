package chapter31;

/**
 * 序数の代わりにインスタンスフィールドを利用する
 */
public final class Main {

	public static void main(String[] args) {
		// enum は ordinal() というメソッドを持っている。
		// 列挙宣言での位置を返す。
		System.out.println(Week.Sunday.ordinal());
		System.out.println(Week.Monday.ordinal());
		System.out.println(Week.Tuesday.ordinal());
		System.out.println(Week.Wednesday.ordinal());
		System.out.println(Week.Thursday.ordinal());
		System.out.println(Week.Friday.ordinal());
		System.out.println(Week.Saturday.ordinal());

		// 下記では、アンサンブルのメンバーの人数を ordinal() を使って実装している。

		// カルテットの人数を表示。
		System.out.println("QUARTET:" + BadEnsemble.QUARTET.ordinal());

		// この状態では上手く動くが、今後の発展を考えると以下のような問題が生じる。
		// 定数を並び替えるとメソッドが動作しなくなる。
		// 同じ数字を持つ定数（たとえば 8 人のミュージシャンがいるダブルカルテット）は割り当てられない。

		// ordinal() は EnumSet や EnumMap など、enum に対するデータ構造を実装する手助けとして提供されている。
		// そのため、普通の開発者が ordinal() を使うことはほぼない。

		// ordinal() で使用せず、インスタンスフィールドを利用する。
		System.out.println("DOUBLE_QUARTET:" + Ensemble.DOUBLE_QUARTET.numberOfMusicians());
	}

}
