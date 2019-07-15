package mymain;

import myutil.MyArray2;

public class MyMain_배열2초기화 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 초기화
		// 2차원배열은 다생략한다.
		int[][] mm = new int[][] { 
				{ 1, 2, 3, 4 }, // 0행
				{ 5, 6, 7, 8 }, // 1행
				{ 9, 10, 11, 12 } // 2행
		}; // 2차원배열 값초기화는 이렇게 한다.
			// 3행 4열

		// 이런식으로 만들어볼수도있다.
		int[][] mm1 = { 
				{ 1, 2, 3, 4 }, // 0행
				{ 5, 6, 7, 8 }, // 1행
				{ 9, 10, 11, 12 } // 2행
		}; // 2차원배열 값초기화는 이렇게 한다.
			// 3행 4열
		
		int [][] mm2= {
				{1,2},
				{3,4,5},
				{6,7,8,9}};
		
		
		MyArray2.display(mm);
		System.out.println("===========");
		MyArray2.display(mm1);
		System.out.println("===========");
		MyArray2.display(mm2);
		
		
		
		
	}

}
