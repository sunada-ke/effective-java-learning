package chapter05;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class Person {

	private final Date birthDate;

	private static final Date BOOM_START;

	private static final Date BOOM_END;

	static {
		// isBabyBoomer メソッドが呼び出されるごとに、Calendar インスタンス、Timezone インスタンス、
		// Date インスタンスを生成する代わりに、クラスが初期化された時点で 1 度だけインスタンスを生成する。
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = calendar.getTime();
		calendar.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = calendar.getTime();
	}

	public Person(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isBabyBoomer() {
		// 下記は悪い例。
		// isBabyBoomer メソッドが呼されるごとに、不必要に新たなインスタンスを生成している。

		// Calendar calendar =
		// Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		// calendar.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		// Date boomStart = calendar.getTime();
		// calendar.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		// Date boomEnd = calendar.getTime();
		//
		// return birthDate.compareTo(boomStart) >= 0 &&
		// birthDate.compareTo(boomEnd) < 0;

		return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
	}

}
