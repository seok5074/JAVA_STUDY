package mymain;

import java.util.Calendar;
import java.util.Scanner;

import myutil.MyCalendar;

public class MyMain_달력 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int year,month;
		MyCalendar mc = new MyCalendar();
		
		while(true) {
			System.out.print("년/월 입력  (종료:0) :");
			year= scan.nextInt();
			if(year==0)break;
			month =scan.nextInt();
			
			//달력생성하는 객체 년/월을 넘긴다
			mc.setDate(year, month);
			
			//생성된달력을 출력
			mc.display();
			
		}
		System.out.println("-end-");
	}

}
