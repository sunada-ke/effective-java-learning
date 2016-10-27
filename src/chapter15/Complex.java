package chapter15;

/**
 * 複素数(実数部分と虚数部分を持つ数。ex:－4+6i)を表すクラス。
 */
public final class Complex {

	// インスタンスを共有しても問題ない。
	// 別スレッドでインスタンスの状態が変わることがない。
	public static final Complex ZERO = new Complex(0, 0);

	// 実数
	private final double re;

	// 虚数
	private final double im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public double realPart() {
		// アクセッサーを提供しているが、参照渡しではなく値渡し。
		return re;
	}

	public double imaginaryPart() {
		return im;
	}

	public Complex add(Complex c) {
		// 新しいインスタンスを返す(防御的コピー)
		return new Complex(re + c.re, im + c.im);
	}

	public Complex subtract(Complex c) {
		return new Complex(re - c.re, im - c.im);
	}

	public Complex multiply(Complex c) {
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
	}

	public Complex devide(Complex c) {
		double tmp = c.re * c.re + c.im * c.im;
		return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
	}

	@Override
	public String toString() {
		return "(" + re + " + " + im + "i)";
	}
}
