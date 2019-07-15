package mymain;

import myutil.MyArray;

public class MyMain_Varargs {

	
	// ellipis(생략부호) ...
	static void int_varargs(int ... nr) {
	// 
	//int_varargs(10);경우   int [] nr ={10};
	//int_varargs(20);경우   int [] nr ={10,20};
	//int_varargs(30);경우   int [] nr ={10,20,30};
	//int_varargs(40);경우   int [] nr ={10,20,30,40};
	System.out.printf("---nr's length : %d\n",nr.length);
	for(int i=0;i<nr.length;i++) {
		System.out.printf("nr[%d]: %d\n",i,nr[i]);
		}
	}
	
	//n개의 수중에서 가장 큰값을 구하세요.
	static int max(int ... nr) {
		int max_val=Integer.MIN_VALUE;
		/* 가장쉬운법
		 * MyArray.array_sort_desc(nr);
		 * 
		 * return nr[0];
		 */
		for(int i=0;i<nr.length;i++) {
				if(nr[i] >max_val) { 
					 max_val = nr[i];
			}
		}
		return max_val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 호출방법
		// 메소드 오버로드를 4개만들어줘야한다.
		int_varargs();
		int_varargs(10);
		int_varargs(10,20);
		int_varargs(10,20,30);
		int_varargs(10,20,30,40);
		
		int max_val =max(10,5,20,3,2);
		System.out.println(max_val);
		
		max_val = max(100,10,5,20,3,2,1000,1980,2019);
		System.out.println(max_val);
	}

}
