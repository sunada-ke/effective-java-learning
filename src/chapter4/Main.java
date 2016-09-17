package chapter4;

/*
 * private のコンストラクタでインスタンス化不可能を強制する
 */
public final class Main {

	public static void main(String[] args) {

		boolean isEmpty = StringUtils.isEmpty("");
		if (isEmpty) {
			System.out.println("Empty");
		}
	}
}
