package mymain;

import myutil.MyArray;

public class MyMain_배열1초기화방법 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//배열초기화	
		//			new자료형(갯수생략)	 {초기화요소목록}
		//						0  1  2  3  4
		int [] mr = new int[] {10, 20 , 30 , 40 , 50 }; // 초기화가되면은 배열갯수 생략
		//명시적표현↑
		int [] nr= 				{10,20,30,40,50};// 배열을 생략하고 초기화요소목록만 줘도된다.
		//	묵시적표현  ↑묵시적으로 인정해준다.
		// 초기화시키는방법
			
		MyArray.displayArray(mr);  
		MyArray.displayArray(nr);
		
		
		//객체배열
		String [] sido_array = new String[3];  //참조배열
		sido_array[0]=new String("서울");
		sido_array[1]="인천";
		sido_array[2]="대전";
		
		MyArray.displayArray(sido_array);
		
		//객체배열 초기화
		String [] fruit_array = new String[] { 
										new String("사과"),	//0
										"배",				//1
										"참외",				//2
										"포도"				//3
										};
		
		//							0     1     2      3
		String [] fruit_array1 = {"사과","배","참외","포도","망고"};
		
		MyArray.displayArray(fruit_array);
		MyArray.displayArray(fruit_array1);
		
		for(int i=0;i<fruit_array1.length;i++)
			System.out.printf("fruit_array1[%d] :%s\n",i,fruit_array1[i]);
		
		String [] tti_array= { "원숭이","닭","개","돼지","쥐","소", "호랑이",
				   "토끼", "용", "뱀", "말","양" };
		int year =1980;
		int tti_index=year%12;
		System.out.printf("%d년생은 %s띠\n",year,tti_array[tti_index]);
	}
}
