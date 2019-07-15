package myutil;


//The type 초등학생 must implement the inherited abstract method 학생.공부한다()
//↑ 재정의를 해야한다
public class 초등학생 extends 학생 {

	//학생.공부한다() 재정의(override) 를한다.
	public void 공부한다() {
		System.out.println("==초등학생:구구단==");
		
	}
}
