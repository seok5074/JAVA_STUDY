package mymain;

import myutil.MyArray;

public class MyMain_Varargs {

	
	// ellipis(������ȣ) ...
	static void int_varargs(int ... nr) {
	// 
	//int_varargs(10);���   int [] nr ={10};
	//int_varargs(20);���   int [] nr ={10,20};
	//int_varargs(30);���   int [] nr ={10,20,30};
	//int_varargs(40);���   int [] nr ={10,20,30,40};
	System.out.printf("---nr's length : %d\n",nr.length);
	for(int i=0;i<nr.length;i++) {
		System.out.printf("nr[%d]: %d\n",i,nr[i]);
		}
	}
	
	//n���� ���߿��� ���� ū���� ���ϼ���.
	static int max(int ... nr) {
		int max_val=Integer.MIN_VALUE;
		/* ���彬���
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

		
		// ȣ����
		// �޼ҵ� �����ε带 4�����������Ѵ�.
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
