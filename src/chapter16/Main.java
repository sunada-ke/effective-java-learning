package chapter16;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 継承よりコンポジションを選ぶ
 */
public class Main {

	public static void main(String[] args) {
		// 継承を利用した例。
		// 要素数を数える HashSet を拡張した CountedHashSet だが、
		// 結果が正しくならない。
		CountedHashSet<String> countedHashSet = new CountedHashSet<String>();
		countedHashSet.addAll(Arrays.asList("Person", "Animal"));
		System.out.println("追加した要素数は " + countedHashSet.getAddCount());

		// メソッド呼び出しと異なり、継承はカプセル化を破る。
		// サブクラスは適切に機能するために、スーパークラスの実装の詳細に依存する。
		// スーパークラスはリリースごとに変更されるかもしれないし、もしスーパクラスが変更されたら、
		// サブクラスのコードが一斉変更されてなくても、機能しなくなる可能性がある。
		// サブクラスはスーパークラスと一緒に変わっていかなければいけない。
		//
		// サブクラスはスーパークラスのメソッドをオーバーライドすることがあるが、
		// 後々、スーパークラスがたまたまサブクラスの同じシグネチャと同じ戻り値型のメソッドを提供した場合、
		// 気づかないうちにサブクラスでオーバーライドしてしまうことになり、サブクラスがスーパークラスのメソッドと
		// 同じ結果を提供するかは分からない。
		// また後々、スーパークラスが新たなメソッドを提供し、
		// サブクラスで同じジグネチャで異なる戻り値型のメソッドを定義していた場合、
		// コンパイルに失敗してしまう。

		// コンポジションを利用した例。
		// 別クラスに処理を委譲させているため、結果が正しく表示される。
		InstrumentedSet<String> instrumentedSet = new InstrumentedSet<String>(new HashSet<String>());
		instrumentedSet.addAll(Arrays.asList("Person", "Animal"));
		System.out.println("追加した要素数は " + instrumentedSet.getAddCount());
	}

}
