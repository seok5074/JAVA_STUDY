package mymain;

import java.util.Calendar;
import java.util.Scanner;

import myutil.MyCalendar;

public class MyMain_�޷� {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int year,month;
		MyCalendar mc = new MyCalendar();
		
		while(true) {
			System.out.print("��/�� �Է�  (����:0) :");
			year= scan.nextInt();
			if(year==0)break;
			month =scan.nextInt();
			
			//�޷»����ϴ� ��ü ��/���� �ѱ��
			mc.setDate(year, month);
			
			//�����ȴ޷��� ���
			mc.display();
			
		}
		System.out.println("-end-");
	}

}
