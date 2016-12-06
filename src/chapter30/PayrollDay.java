package chapter30;

public enum PayrollDay {

	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

	private static final int HOURS_PER_SHIFT = 8;

	// 賃金の計算。
	// 例として double で計算しているが、本来ならば double は使用すべきではない。
	double pay(double hoursWorked, double payRate) {
		double basePay = hoursWorked * payRate;
		double overtimePay;

		// コードを共有するために switch で分岐している。
		switch (this) {
		case SATURDAY:
		case SUNDAY:
			overtimePay = hoursWorked * payRate / 2;
			break;
		default: // 平日
			overtimePay = hoursWorked <= HOURS_PER_SHIFT ? 0 : (hoursWorked - HOURS_PER_SHIFT) * payRate / 2;
			break;
		}
		return basePay + overtimePay;
	}
}
