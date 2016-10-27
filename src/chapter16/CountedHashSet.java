package chapter16;

import java.util.Collection;
import java.util.HashSet;

@SuppressWarnings("serial")
public class CountedHashSet<E> extends HashSet<E> {

	private int count = 0;

	public CountedHashSet() {
	}

	public CountedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override
	public boolean add(E e) {
		// このメソッド呼び出されてしまう。
		count++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		count += c.size();

		// HashSet#addAll() は内部で HashSet#add() を呼び出すため、
		// CountedHashSet#add() が呼び出されてしまう。
		return super.addAll(c);
	}

	public int getAddCount() {
		return count;
	}
}
