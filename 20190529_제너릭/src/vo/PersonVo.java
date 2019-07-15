package vo;

//vo ��
/*
vo(Value Object)
 1.���� ���� �����ϴ� ��ü
cf=PersonVo : ���������� ���� �����ϴ� ��ü 
   ProductVo: ��ǰ������ ���� �����Ѵ� ��ü
 2.DTD(Data Transfer Object): ������ ���ް�ü
    TO(		Transfer Object):
    cf)PersonDTO
 */

public class PersonVo {
	//personVo ���鶧 getter setter�� ������ �������Ѵ�.
	String name;
	int age;
	String addr;
	
	
	//�����Ģ -> OverLoad�� �����ڰ� ������ �⺻�����ڴ� ������ ����
	public PersonVo() {
		
	}
	
	public PersonVo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	
	@Override
	public String toString() {
		
		return String.format("[%s / %d /  %s]",name,age,addr);
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
