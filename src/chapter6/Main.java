package chapter6;

import java.util.Map;
import java.util.WeakHashMap;

/*
 * 廃れたオブジェクト参照を取り除く
 */
public final class Main {

	public static void main(String[] args) {

		// 配列を使った独自のメモリの管理の例。
		Stack stack = new Stack();
		stack.push(new Object());
		stack.pop();

		// オブジェクト参照を一旦キャッシュに保持すると、オブジェクトへの参照がそこにあることを忘れがちになる。
		// そこで、弱い参照をもつ WeakHashMap で保持することが推奨されている。
		// WeakHashMap はエントリのキーが弱い参照で保持されており、そのキーが外部から参照されなくなると、GC の対象となる。
		// コールバックやリスナーも同様で、クライアントが削除を忘れた場合にはリークしてしまうため、同じく WeakHashMap で保持するべき。
		Integer key = new Integer(1);
		Map<Integer, String> cache = new WeakHashMap<Integer, String>();
		cache.put(key, "entry");
		// エントリーに対するキー値の参照に null を設定。
		key = null;
		// 明示的に GC。
		System.gc();
		// キーが外部から参照されていないため、GC の対象となる。
		System.out.println(cache.get(new Integer(1)));
	}

}
