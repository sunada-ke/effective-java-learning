package chapter06;

import java.util.Arrays;

public final class Stack {

	@SuppressWarnings("serial")
	private static class EmptyStackException extends RuntimeException {
	}

	private static final int DEFAULT_CAPACITY = 16;

	private Object[] elements;

	private int size = 0;

	public Stack() {
		this.elements = new Object[DEFAULT_CAPACITY];
	}

	public void push(Object object) {
		ensureCapacity();
		elements[size] = object;
		size++;
	}

	// 廃れた参照を取り除いていない例。
	// public Object pop() {
	// if (size == 0) {
	// throw new EmptyStackException();
	// }
	// return elements[--size];
	// }

	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		Object object = elements[--size];

		// 廃れた参照を取り除く。
		// 廃れた参照は決してそれを通してオブジェクトが参照されることがない単なる参照。
		// この場合、要素配列の「有効な部分」外の参照は廃れたものになっている。有効な部分とは size 未満のインデックスを持つ要素部分。
		// 配列の無効な部分味をなさないことはプログラマしか分からない。ゆえに JVM のガーベッジコレクタの対象とならない。
		// null を代入することで、それらの参照が間違って利用した際に例外が発生し、エラーに気付くことが容易。
		elements[size] = null;
		return object;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			// スタックの容量が足りないのであるならば、2 倍に増やす。
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}
