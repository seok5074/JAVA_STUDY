package mymain;

import myutil.MyArray2;

public class MyMain_�迭2�ʱ�ȭ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �ʱ�ȭ
		// 2�����迭�� �ٻ����Ѵ�.
		int[][] mm = new int[][] { 
				{ 1, 2, 3, 4 }, // 0��
				{ 5, 6, 7, 8 }, // 1��
				{ 9, 10, 11, 12 } // 2��
		}; // 2�����迭 ���ʱ�ȭ�� �̷��� �Ѵ�.
			// 3�� 4��

		// �̷������� ���������ִ�.
		int[][] mm1 = { 
				{ 1, 2, 3, 4 }, // 0��
				{ 5, 6, 7, 8 }, // 1��
				{ 9, 10, 11, 12 } // 2��
		}; // 2�����迭 ���ʱ�ȭ�� �̷��� �Ѵ�.
			// 3�� 4��
		
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
