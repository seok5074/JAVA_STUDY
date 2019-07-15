package vo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/*
 VO(Value Object) ���� �����ϴ� ��ü <= Read Only Object(<-�̷��� �ؼ��ϴ»���� �ִ�)
 DTO(Data Transfer Object)
 =Read/Write

*/
//Externalizable 
//getter/setter �ϴ����� �����͸� �ٽ� �о���϶� ������ ���.
public class PersonVo3 implements Externalizable {
	String name;
	int age; // transient ����ȭ��󿡼� ���ܵȴ�.
	String addr;

	public PersonVo3() { // 2. �⺻�����ڴ� ������ �����Ǿ��־��Ѵ�.

	}

	public PersonVo3(String name, int age, String addr) { // 1. ������
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

	// ����ȭ������ Ʋ����ȵȴ�.
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name =(String)in.readObject();
		age =in.readInt();
		
		
	}

}
