package mymain;

import myutil.MyArray;

public class MyMain_�迭1�ʱ�ȭ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�迭�ʱ�ȭ	
		//			new�ڷ���(��������)	 {�ʱ�ȭ��Ҹ��}
		//						0  1  2  3  4
		int [] mr = new int[] {10, 20 , 30 , 40 , 50 }; // �ʱ�ȭ���Ǹ��� �迭���� ����
		//�����ǥ����
		int [] nr= 				{10,20,30,40,50};// �迭�� �����ϰ� �ʱ�ȭ��Ҹ�ϸ� �൵�ȴ�.
		//	������ǥ��  �蹬�������� �������ش�.
		// �ʱ�ȭ��Ű�¹��
			
		MyArray.displayArray(mr);  
		MyArray.displayArray(nr);
		
		
		//��ü�迭
		String [] sido_array = new String[3];  //�����迭
		sido_array[0]=new String("����");
		sido_array[1]="��õ";
		sido_array[2]="����";
		
		MyArray.displayArray(sido_array);
		
		//��ü�迭 �ʱ�ȭ
		String [] fruit_array = new String[] { 
										new String("���"),	//0
										"��",				//1
										"����",				//2
										"����"				//3
										};
		
		//							0     1     2      3
		String [] fruit_array1 = {"���","��","����","����","����"};
		
		MyArray.displayArray(fruit_array);
		MyArray.displayArray(fruit_array1);
		
		for(int i=0;i<fruit_array1.length;i++)
			System.out.printf("fruit_array1[%d] :%s\n",i,fruit_array1[i]);
		
		String [] tti_array= { "������","��","��","����","��","��", "ȣ����",
				   "�䳢", "��", "��", "��","��" };
		int year =1980;
		int tti_index=year%12;
		System.out.printf("%d����� %s��\n",year,tti_array[tti_index]);
	}
}
