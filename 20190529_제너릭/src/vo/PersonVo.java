package vo;

//vo 란
/*
vo(Value Object)
 1.값을 저장 관리하는 객체
cf=PersonVo : 개인정보의 값을 관리하는 객체 
   ProductVo: 상품정보의 값을 관리한는 객체
 2.DTD(Data Transfer Object): 데이터 전달객체
    TO(		Transfer Object):
    cf)PersonDTO
 */

public class PersonVo {
	//personVo 만들때 getter setter는 무조건 만들어야한다.
	String name;
	int age;
	String addr;
	
	
	//절대규칙 -> OverLoad된 생성자가 있으면 기본생성자는 무조건 생성
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
