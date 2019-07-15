package myutil;

public class Child extends Parent{

	@Override
	public void sub() {//상속관계
		super.sub(); // parent 호출 -> 
		
		System.out.println("==childsub()==");
			
	}
	//맨마지막에 재정된 식이 호출된다.
	
	
}
