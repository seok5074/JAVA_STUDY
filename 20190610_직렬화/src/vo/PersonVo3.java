package vo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/*
 VO(Value Object) 값을 관리하는 객체 <= Read Only Object(<-이렇게 해석하는사람도 있다)
 DTO(Data Transfer Object)
 =Read/Write

*/
//Externalizable 
//getter/setter 하는이유 데이터를 다시 읽어들일때 오류가 뜬다.
public class PersonVo3 implements Externalizable {
	String name;
	int age; // transient 직렬화대상에서 제외된다.
	String addr;

	public PersonVo3() { // 2. 기본생성자는 무조건 생성되어있야한다.

	}

	public PersonVo3(String name, int age, String addr) { // 1. 생성후
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

	// 직렬화순서가 틀리면안된다.
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
