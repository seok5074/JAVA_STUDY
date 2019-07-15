package mymain;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MyMain_Set {

	public static void main(String[] args) {

		
		/* 				Set
		 1. 객체 순서없이 저장관리하는 객체
		 2.중복값을 허용하지 않는다.
		 
		 
		 
		 */
		
		
		
		Random rand = new Random();
		
		int count =6;
		//Set<Int> lottoSet = new TreeSet<Integer>(); // 정렬해서가져오기위함 int 를쓰면안된다.
		//의미 :
		//설명서			  =		설계서
		
		//인터페이스		  = 	클래스
		Set<Integer> lottoSet = new TreeSet<Integer>(); // 정렬해서가져오기위함

	
		while(count>0) { 
			
			int no = rand.nextInt(45)+1; // 1~45까지
			//추가실패할 경우는 동일한 수가 있는 경우: 다시 시도해라
			if(lottoSet.add(no)==false)continue;
			
			count--;
		}
			System.out.println(lottoSet);
			System.out.println();
			System.out.println("===개선 loop이용해서 요소 추출");
			
			//		lottoSet =>[ , , , , , ]
			for(Integer no : lottoSet) {  // lottoset에 있는 요소들을 순서대로 빼온다.
				System.out.printf("%3d",no);
			}
			System.out.println();
			System.out.println();

			System.out.println("==Iterator이용해서 요소 추출");
			//		lottoSet =>[ , , , , , ]
			Iterator<Integer> it = lottoSet.iterator();
			while(it.hasNext()) {//관리할요소가 있냐 라고 물어본다.
				
				int no = it.next(); //가져오기
				System.out.printf("%3d",no);	
			}
			System.out.println();
	}
	

}
