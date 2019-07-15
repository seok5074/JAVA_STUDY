package myutil;

abstract public class 학생 {
	
	int 학년;
	int 학번;
	
	//추상적으로 설계된 메소드(구체적표현이 불가능한 메소드)
	abstract public void 공부한다();
	//추상클래스는 객체생성이 불가하다.
}
