package mymain;

import java.util.ArrayList;

public class MyMain_ArrayList {

	public static void main(String[] args) {

		// ArrayList : 동적배열
		// collection: 자바의 모든객체만을 저장가능
		int[] nr = { 1, 2, 3 }; // <-갯수:3 <-배열의개수가 고정됨

		ArrayList list = new ArrayList();
		System.out.println("list's size =" + list.size());
		list.add(1); // <=list.add(new.Integer(1));
		list.add(2);
		list.add(3);
		System.out.println("list's size =" + list.size());
		/*
		 * 		0				1				2		<-첨자(index)
		 * new.Integer(1) new.Integer(2) new.Integer(3)
		 */

		/*
		 * System.out.printf("list's 1번째 데이터 : %d\n", list.get(0));
		 * System.out.printf("list's 1번째 데이터 : %d\n", list.get(1));
		 * System.out.printf("list's 1번째 데이터 : %d\n", list.get(2));
		 */
		
		System.out.println("==before delete");
		for(int i=0;i<list.size();i++) { // i= 0~1~2
			System.out.printf("list %d번째 데이터 : %d\n",i+1,list.get(i));
		}
		
		//삭제
		list.remove(1);
		
		System.out.println("==after delete");
		for(int i=0;i<list.size();i++) { // i= 0~1~2
			System.out.printf("list %d번째 데이터 : %d\n",i+1,list.get(i));	
		}
		System.out.println("list's size =" + list.size());

	}

}
