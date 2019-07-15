package mymain;

import myutil.고등학생;
import myutil.중학생;
import myutil.초등학생;
import myutil.학생;

public class MyMain_학생 {

	
	static void  어머님(학생 [] student) {
		//다형성 (Polymorphism): 동일한 명령에 대해서 받는 객체마다
		//자신만의 행동
		/*for(int i=0;i<student.length;i++) {
			학생 st =student[i];*/
		for(학생 st : student) { // 배열의 요소 순서대로 for문 반복시 넣어준다.
			st.공부한다();
		}
	}// 이명령문만 실행함으로써 재정의 된 명령을실행한다.
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//추상클래스는 객체생성 불가 생성해도 문제가된다. 쓸수가없다.
		//학생 s1 = new 학생(); //Cannot instantiate the type 학생
								// 인스턴스 생성이 불가
		//ctrl + shift +o 
		학생[] student = new 학생[3];
		student[0] = new 초등학생();
		student[1] = new 중학생();
		student[2] = new 고등학생();

		어머님(student);
		//1.부모타입으로 받는다.
		학생 st =new 초등학생();
		//2.재정의(override)된 메소드
		st.공부한다();
		
		//배열
		int [] nr = {1,2,3,4};
		for(int n:nr) { // <- 개선된 loop
			System.out.println(n);
		}
		
		
	}

}
