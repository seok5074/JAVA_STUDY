package mymain;

import java.util.Arrays;

import myutil.MyArray;

public class MyMain_�迭1 {
	/*
	 * �迭
	 * ������ �ڷ����� �����Ҵ�Ǵ� �ڷᱸ��
	 *  ����
	 *  1.�ϰ�ó��
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] mr = new int[4];
		
		mr[0] =1;
		mr[1] =2;
		mr[2] =3;
		mr[3] =4;
		//mr[4] =5; �迭��÷�ڰ� ������ �Ѿ ����.
		
		//�ϰ�ó�� ���
		System.out.printf("mr's length : %d\n",mr.length);
		for(int i=0;i<mr.length;i++) { // i = 0 1 2 3
			mr[i]= i+1;
			
		}
		//���
		/*
		 * System.out.printf("mr[0]=%d\n",mr[0]); 
		 * System.out.printf("mr[1]=%d\n",mr[1]);
		 * System.out.printf("mr[2]=%d\n",mr[2]); 
		 * System.out.printf("mr[3]=%d\n",mr[3]);
		 */
		//�ϰ�ó�����
		for(int i=0;i<mr.length;i++) {
			System.out.printf("mr[%d] = %d\n",i,mr[i]);
		}
		//��¿�û
		MyArray.displayArray(mr);
		System.out.println();
		//�������
		System.out.println("---clear---");
		MyArray.clearArray(mr);
		MyArray.displayArray(mr);
		System.out.println();
		
		//���� ������� ä���
		System.out.println("������� ä���");
		MyArray.setArray(mr);
		MyArray.displayArray(mr);
		System.out.println();
		
		//���ϴ� ������ ä���
		System.out.println("---���ϴ°� ä���---");
		MyArray.fill(mr, 9);
		MyArray.displayArray(mr);
		System.out.println();
		
		System.out.println("---���ϴ°� �� ä���---");
		MyArray.fill(mr, 1, 4);
		MyArray.displayArray(mr);
		System.out.println();
		
		System.out.println("---���ϴ°� ������ ä���---");
		MyArray.fill(mr, 0, 2, 5);
		MyArray.displayArray(mr);
		System.out.println(); //{ 5 5 5 9 } 
		
		
		//������ü(array)�̿�
		System.out.println("������ü �̿� : ---���ϴ°� ������ ä���---");
		//            start start+count
		//				1 , 2 , 3 =>1���� 2��������¶�
		//				1, 1+2,3 =>1���� 3������ { 5 3 3 9 } 
		Arrays.fill(mr, 1,	  1+2,			3);
		MyArray.displayArray(mr);
		System.out.println(); //{ 5 3 5 9 } 
		//						
		
	}

}
