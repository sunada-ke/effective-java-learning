package chapter2;

/*
 * 数多くのコンストラクタパターンに直面した時には、ビルダーを検討する。
 */
public final class Main {

	public static void main(String[] args) {

		//
		// コンストラクタでパラメータを設定する場合。
		//

		// 多くのパラメータがある場合、クライアントコードを書くのが困難になり、加えてコードを読むことも困難になる。
		// さらに同じ型のパラメータが続く場合、実装者は注意しなければならない。
		// また、パラメータで、必須パラメータとオプションパラメータが存在する場合、コンストラクタを複数用意しなければならなくなる。
		new PersonForConstructor("Sunada", "man", 25);

		//
		// セッターでパラメータを設定する場合。
		//

		// 生成が複数の呼び出しに分割されるために、その途中でオブジェクトが不整合な状態になるかもしれない。
		// コンストラクタ呼び出し時にクラスの状態を決定できないため、不変クラスにできない。
		PersonForSetter person = new PersonForSetter();
		person.setName("Sunada");
		person.setGender("man");
		person.setAge(25);
		person.setBirthPlace("Yamaguchi");

		//
		// Builder でパラメータを設定する場合。
		//

		// Builder を利用することで、コードを書くのが容易になるし、読むことも容易になる。
		// そしてパラメータに対する不変式を強制できる。一度 build メソッドを読んだ後に状態を変更できない。
		// 設定するパラメータ数が多い場合には Builder を利用すること。将来、パラメータが増えた場合にも容易に対応できる。
		PersonForBuilder personForBuilder = new PersonForBuilder.Builder("Sunada", "man").age(25)
				.birthplace("Yamaguchi").build();
		personForBuilder.showProfile();
	}

}
