package mymain;

import myutil.MyDate;

public class MyMain_������ {

	public static void main(String[] args) {
	/*
	 *1�μ��� 
	 *MyDate m1 =new MyDate(); 
	 *m1.display();
	 */	  
	  MyDate m1 =new MyDate();
	  m1.display();
	  
	  // ������ ��
	  MyDate m2 = new MyDate(2019, 5, 16);
	  m2.display();
	  
	  //�ϳ�������
	  MyDate m3=new MyDate(2020);
	  m3.display();
	  //�ΰ�����
	  
	  MyDate m4 =new MyDate(2020,6);
	  m4.display();
	  
	  // �����ִ����� �״�� �޴¸�ɽ�
	  MyDate m5 = new MyDate(m2);
	  m5.display();
	 
	  
	}

}
