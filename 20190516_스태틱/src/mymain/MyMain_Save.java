package mymain;

import myutil.Save;

public class MyMain_Save {

	public static void main(String[] args) {
		//��ü���������� ��밡��
		// Ŭ������.������=��;
		//Save.rate=0.2; //���� ����
		
		Save s1 = new Save("�ϱ浿",1000000);
		Save s2 = new Save("�̱浿",2000000);
		Save s3 = new Save("��浿",3000000);
		
		//���������� ���
		s1.display();
		s2.display();
		s3.display();
		
		System.out.println("===��������:0.1->0.2===");
		//��ü������ ����� 
		//��ü��.������=��;
		
		s1.rate=0.2;
		//s2.rate=0.2; ���ü�� ������ ����Ҽ��ִ�.
		
		s1.display();
		s2.display();
		s3.display();

	}

}
