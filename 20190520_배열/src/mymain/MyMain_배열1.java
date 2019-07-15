package mymain;

import java.util.Arrays;

import myutil.MyArray;

public class MyMain_배열1 {
	/*
	 * 배열
	 * 동일한 자료형의 연속할당되는 자료구조
	 *  이점
	 *  1.일괄처리
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] mr = new int[4];
		
		mr[0] =1;
		mr[1] =2;
		mr[2] =3;
		mr[3] =4;
		//mr[4] =5; 배열의첨자가 범위를 넘어서 썻다.
		
		//일괄처리 계산
		System.out.printf("mr's length : %d\n",mr.length);
		for(int i=0;i<mr.length;i++) { // i = 0 1 2 3
			mr[i]= i+1;
			
		}
		//출력
		/*
		 * System.out.printf("mr[0]=%d\n",mr[0]); 
		 * System.out.printf("mr[1]=%d\n",mr[1]);
		 * System.out.printf("mr[2]=%d\n",mr[2]); 
		 * System.out.printf("mr[3]=%d\n",mr[3]);
		 */
		//일괄처리출력
		for(int i=0;i<mr.length;i++) {
			System.out.printf("mr[%d] = %d\n",i,mr[i]);
		}
		//출력요청
		MyArray.displayArray(mr);
		System.out.println();
		//값지우기
		System.out.println("---clear---");
		MyArray.clearArray(mr);
		MyArray.displayArray(mr);
		System.out.println();
		
		//값을 순서대로 채우기
		System.out.println("순서대로 채우기");
		MyArray.setArray(mr);
		MyArray.displayArray(mr);
		System.out.println();
		
		//원하는 값으로 채우기
		System.out.println("---원하는값 채우기---");
		MyArray.fill(mr, 9);
		MyArray.displayArray(mr);
		System.out.println();
		
		System.out.println("---원하는곳 값 채우기---");
		MyArray.fill(mr, 1, 4);
		MyArray.displayArray(mr);
		System.out.println();
		
		System.out.println("---원하는곳 범위값 채우기---");
		MyArray.fill(mr, 0, 2, 5);
		MyArray.displayArray(mr);
		System.out.println(); //{ 5 5 5 9 } 
		
		
		//기존객체(array)이용
		System.out.println("기존객체 이용 : ---원하는곳 범위값 채우기---");
		//            start start+count
		//				1 , 2 , 3 =>1부터 2전까지라는뜻
		//				1, 1+2,3 =>1부터 3전까지 { 5 3 3 9 } 
		Arrays.fill(mr, 1,	  1+2,			3);
		MyArray.displayArray(mr);
		System.out.println(); //{ 5 3 5 9 } 
		//						
		
	}

}
