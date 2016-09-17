package chapter2;

public final class PersonForSetter {

	// 必須。
	private String name;

	// 必須。
	private String gender;

	// オプション。
	private int age;

	// オプション。
	private String birthplace;

	public PersonForSetter() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBirthPlace(String birthplace) {
		this.birthplace = birthplace;
	}

	public void showProfile() {
		System.out.println("name is " + this.name);
		System.out.println("gender is " + this.gender);
		System.out.println("age is " + this.age);
		System.out.println("birthplace is " + this.birthplace);
	}
}
