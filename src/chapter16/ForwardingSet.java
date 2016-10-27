package chapter16;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * 再利用可能な転送クラス。
 */
public class ForwardingSet<E> implements Set<E> {

	// private のフィールドにインスタンスを持たせる。
	private final Set<E> s;

	public ForwardingSet(Set<E> s) {
		this.s = s;
	}

	@Override
	public int size() {
		return s.size();
	}

	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return s.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return s.iterator();
	}

	@Override
	public Object[] toArray() {
		return s.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return s.toArray(a);
	}

	@Override
	public boolean add(E e) {
		return s.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return s.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return s.contains(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// 他のクラスに処理を委譲する。
		// よって、InstrumentedSet クラスには何も影響を与えなくて済む。
		return s.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return s.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return s.removeAll(c);
	}

	@Override
	public void clear() {
		s.clear();
	}
}
