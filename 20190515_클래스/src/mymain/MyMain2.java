package mymain;

import myutil.MyDate2;

public class MyMain2 {

	public static void main(String[] args) {
		
		MyDate2 md2 = new MyDate2();
		
//		md2.year=2019;(X) <- ���������� �ȵȴ�.
		// ������������ ������ �Ұ��ϴ� �ٸ��������
		// �������Ѵ�.
		
		md2.setYear(2019);
		md2.setMonth(5);
		md2.setDay(15);
		
//		int yaer= md2.year;
		int year=md2.getYear();
		int month=md2.getMonth();
		int day=md2.getDay();
		
		
		System.out.printf("%d-%d-%d\n",year,month,day);
		
		md2.setDate(1950, 06, 25);
		md2.display();
	
		//������� : 1950�� 06�� 25�� �ϰ�������
		md2.display2();
	}

}
