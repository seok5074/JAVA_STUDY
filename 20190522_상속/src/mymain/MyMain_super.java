package mymain;

import myutil.Child;

public class MyMain_super {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����ϴ¹��.
		Child c1 = new Child(); // 1. �⺻�����ڷλ���
		c1.display();
		
		Child c2 =new Child(50); // �� �ʱ�ȭ
		c2.display();
		
		// parent ���� �����ʱ�ȭ�ϰ� child ���� �ʱ�ȭ�Ѵ�.
		Child c3 =new Child(100,1000); // �ΰ��ǰ��� �ʱ�ȭ
		c3.display();
		
		
	}

}
