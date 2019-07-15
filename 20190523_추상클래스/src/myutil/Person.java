package myutil;

public class Person extends Object {
	String name;
	int age;
	String tel;
	
	public Person() {
		
	}
	// alt + shift +s 

	public Person(String name, int age, String tel) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
	}
	@Override
	// 내가 지정한 재정의 를 호출
	public String toString() {

		return String.format("%s - %d - %s", name,age,tel);
	}
}
