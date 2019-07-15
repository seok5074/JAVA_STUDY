package mymain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyMain_Wrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.기본형 자료형 -> 객체형자료형으로 포장
		// 		int -> interger class cf(double->Double)
		//				int와 관련된 기능을 구현
		//2. java Colletction객체 : Data저장관리하는 객체
		// 	 -> 자바의 모든객체를 저장관리를 할수있다.
		// ArrayList
			
		
		int n=10;
		ArrayList list =new ArrayList();
		// n을 저장할려면
		//int -> integer형 객체로 생성해야한다.
		Integer nob = new Integer(n);
		//list.add(nob); // <= 저장이 된다.
		list.add(n); // list.add(new Integer(n)) <= 자바가 자동으로 포장해준다.
					//								auto boxing(JDK5.0 later)부터지원
		
		
		Integer nob1=n; // new Integer(n)<-이때도 오토박싱이된다.
		
		int m = nob1.intValue(); //Integer가 가지고있는값을 int형박스로줘라
								 //객체가 소유한 값을 int형으로 반환
		
		//Auto-unboxing
		
		int k = nob1;// nob1.intValue() 로 준다
		
		double d=nob1; // nob1.doubleValue()
		
		
		
	}

}
