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
	// ���� ������ ������ �� ȣ��
	public String toString() {

		return String.format("%s - %d - %s", name,age,tel);
	}
}
