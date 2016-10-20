package chapter13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Constants {

	// 長さが 0 ではない配列は常に可変であることを意識する必要がある。
	// final フィールドの変数は参照は変更できないが、内部のデータ変更できてしまう。
	// public static final の配列フィールドやそのような配列を返すアクセッサーを持つのはほとんど誤り。
	// 変更不可能な配列として他クラスに返す必要がある。
	private static final String[] PRIVATE_STRING_VALUES = { "a", "b", "c" };

	// 変更不可能にする。
	public static final List<String> STRING_VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_STRING_VALUES));
}
