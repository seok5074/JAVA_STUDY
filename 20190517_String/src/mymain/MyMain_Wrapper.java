package mymain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyMain_Wrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.�⺻�� �ڷ��� -> ��ü���ڷ������� ����
		// 		int -> interger class cf(double->Double)
		//				int�� ���õ� ����� ����
		//2. java Colletction��ü : Data��������ϴ� ��ü
		// 	 -> �ڹ��� ��簴ü�� ��������� �Ҽ��ִ�.
		// ArrayList
			
		
		int n=10;
		ArrayList list =new ArrayList();
		// n�� �����ҷ���
		//int -> integer�� ��ü�� �����ؾ��Ѵ�.
		Integer nob = new Integer(n);
		//list.add(nob); // <= ������ �ȴ�.
		list.add(n); // list.add(new Integer(n)) <= �ڹٰ� �ڵ����� �������ش�.
					//								auto boxing(JDK5.0 later)��������
		
		
		Integer nob1=n; // new Integer(n)<-�̶��� ����ڽ��̵ȴ�.
		
		int m = nob1.intValue(); //Integer�� �������ִ°��� int���ڽ������
								 //��ü�� ������ ���� int������ ��ȯ
		
		//Auto-unboxing
		
		int k = nob1;// nob1.intValue() �� �ش�
		
		double d=nob1; // nob1.doubleValue()
		
		
		
	}

}
