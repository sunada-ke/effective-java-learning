package chapter22;

import java.util.AbstractSet;
import java.util.Iterator;

// 非 static クラスの典型的な使用方法。
public final class MySet<E> extends AbstractSet<E> {

	// クラスの大部分の処理を省略。

	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	@Override
	public int size() {
		return 0;
	}

	// イテレータを非 static クラスのメンバクラスとして実装。
	private class MyIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public E next() {
			return null;
		}
	}

}
