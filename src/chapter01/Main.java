package chapter01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * コンストラクタの代わりに static ファクトリーメソッドを検討する
 */
public final class Main {

	public static void main(String[] args) {

		//
		// 長所 1:名前を持つことができる。
		//

		// 素数である確率が高い数を返す static ファクトリーメソッド。
		// 名前をつけることでどのようなインスタンスが返却されるのか分かりやすい。
		// コンストラクタだと、メソッド名がクラス名になってしまうので分かりづらい。
		BigInteger.probablePrime(4, new Random());

		//
		// 長所 2:メソッドが呼び出されるごとにインスタンスを生成する必要がなくなる
		//

		// 不必要に重複したオブジェクトの生成を防ぐことが可能。
		// 同値のオブジェクトを生成し、その生成コストが高い場合にはパフォーマンスが大幅に向上する。
		Person person = Person.getInstance();
		person.showProfile();

		//
		// 長所 3: メソッドの戻り値型にサブタイプのオブジェクトも返せる
		//

		// Collections#unmodifiableList() はメソッド内部で引数で渡された List が RandomAccess
		// ならば、List のサブタイプである UnmodifiableRandomAccessList を返す。
		Collections.unmodifiableList(new ArrayList<>());

		//
		// 短所 1: サブクラスが作れなくなる
		//

		// インスタンスの生成方法を static ファクトリーメソッドに限定してしまうと、
		// コンストラクタを private にする必要があるため、結果的にサブクラスを作れなくなる。
		// Person クラスはコンストラクタが private であるため、サブクラスを作れない。
		// その場合は継承ではなく、コンポジションを利用する。

		//
		// 短所 2: 他の static メソッドと区別がつかなくなる
		//

		// コンストラクタは API ドキュメントでも目立つが、static メソッドは
		// 他の static メソッドに埋もれ、コンストラクトすることがアピールできない。
		// よって、命名規則で見つけやすくする。

		// valueOf : 同じ値を持つインスタンスを返す。型変換メソッド。
		// of : valueOfのシンプル命名。
		// getInstance : 返すインスタンスが再利用オブジェクトの可能性あり。
		// newInstance : 返すインスタンスは新しく生成したオブジェクト。
		// getType : getInstance の返すクラスがメソッド所有クラスと異なる版。
		// newType : newInstance の返すクラスがメソッド所有クラスと異なる版。
	}

}
