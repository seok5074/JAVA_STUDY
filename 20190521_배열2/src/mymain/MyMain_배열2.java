package mymain;

import myutil.MyArray2;

public class MyMain_�迭2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] mm =new int[3][4];
		MyArray2.setArray(mm);//������� ���� �ο��Ѵ�.
		MyArray2.display(mm);
		
		System.out.println("7��ä���");
		MyArray2.fill(mm, 7);
		MyArray2.display(mm);
		
		//�������̹迭(���Ǳ��̰� ������)
		int [][] mm2=new int[3][];
		
		mm2[0]=new int[2];
		mm2[1]=new int[3];
		mm2[2]=new int[4];
		
		System.out.println("�������� �迭");
		MyArray2.setArray(mm2);
		MyArray2.display(mm2);
		
	}

}
