package chapter2;

public final class PersonForBuilder {

	// 必須。
	private String name;

	// 必須。
	private String gender;

	// オプション。
	private int age;

	// オプション。
	private String birthplace;

	// Builder を内部クラスで作成。
	// 内部クラスにすることで外部クラスとの関係性が分かりやすくなる。
	public static class Builder {

		private String name;

		private String gender;

		private int age;

		private String birthplace;

		public Builder(String name, String gender) {
			this.name = name;
			this.gender = gender;
		}

		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Builder birthplace(String birthplace) {
			this.birthplace = birthplace;
			return this;
		}

		public PersonForBuilder build() {
			return new PersonForBuilder(this);
		}
	}

	private PersonForBuilder(Builder builder) {
		this.name = builder.name;
		this.gender = builder.gender;
		this.age = builder.age;
		this.birthplace = builder.birthplace;
	}

	public void showProfile() {
		System.out.println("name is " + this.name);
		System.out.println("gender is " + this.gender);
		System.out.println("age is " + this.age);
		System.out.println("birthplace is " + this.birthplace);
	}
}
