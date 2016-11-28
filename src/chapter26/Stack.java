package chapter26;

import java.util.Arrays;

public final class Stack<E> {

	@SuppressWarnings("serial")
	private static class EmptyStackException extends RuntimeException {
	}

	private static final int DEFAULT_CAPACITY = 16;

	private E[] elements;

	private int size = 0;

	// elements 配列は push(E) からの E インスタンスだけを含むことが分かっているため、
	// 警告を抑制する。
	@SuppressWarnings("unchecked")
	public Stack() {
		// 下記で無検査警告が出てしまうので、@SuprpressWarnings アノテーションを利用する。
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size] = e;
		size++;
	}

	public E pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		E e = elements[--size];
		elements[size] = null;
		return e;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			// スタックの容量が足りないのであるならば、2 倍に増やす。
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

}
