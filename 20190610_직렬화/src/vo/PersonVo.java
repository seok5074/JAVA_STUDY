package vo;

import java.io.Serializable;

/*
 VO(Value Object) ���� �����ϴ� ��ü <= Read Only Object(<-�̷��� �ؼ��ϴ»���� �ִ�)
 DTO(Data Transfer Object)
 =Read/Write

*/
// Serializable  -> ����ȭ ����� ���� ��ü�� ����
//getter/setter �ϴ����� �����͸� �ٽ� �о���϶� ������ ���.
public class PersonVo implements Serializable{
	String name;
	int age;  //transient ����ȭ��󿡼� ���ܵȴ�. 
	String addr;
	
	public PersonVo() { // 2. �⺻�����ڴ� ������ �����Ǿ��־��Ѵ�.
		
	}
	
	
	public PersonVo(String name, int age, String addr) { // 1. ������
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
