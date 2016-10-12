package chapter02;

public final class PersonForConstructor {

	// 必須。
	private String name;

	// 必須。
	private String gender;

	// オプション。
	private int age;

	// オプション。
	private String birthplace;

	public PersonForConstructor(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}

	public PersonForConstructor(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public PersonForConstructor(String name, String gender, int age, String birthplace) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.birthplace = birthplace;
	}

	public void showProfile() {
		System.out.println("name is " + this.name);
		System.out.println("gender is " + this.gender);
		System.out.println("age is " + this.age);
		System.out.println("birthplace is " + this.birthplace);
	}
}
