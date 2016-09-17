package chapter3;

/**
 * private のコンストラクタか enum 型でシングルトン特性を強制する
 */
public final class Main {

	public static void main(String[] args) {

		//
		// シングルトンクラスを作成する方法
		//

		// 方法 1. public final フィールドによるシングルトン
		Man person = Man.INSTANCE;
		person.print();

		// 方法 2. static ファクトリーメソッドによるシングルトン
		Woman animal = Woman.getInstance();
		animal.print();

		// 方法 1、方法 2 でシングルトンクラスをシリアライズ化する場合、全てのフィールドを transient と宣言し、
		// さらに readResolve メソッドを提供する必要がある。
		// そうしないと、シリアライズ化した場合に複数のインスタンス成されてしまい、シングルトンを保てなくなる。

		// 方法 3. enum によるシングルトン
		// enum によるシングルトンく採用されていないが、シングルトンを強制する方法としては最善。
		// enum を利用した場合、シリアライズ化の機構を備えており、
		// シリアライズ攻撃やリフレクション攻撃に直面しても複数のインスタンス生成を阻止する。
		Shemale shemale = Shemale.INSTANCE;
		shemale.print();
	}
}
