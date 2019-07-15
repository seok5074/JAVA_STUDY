package mymain;

import myutil.MyDate2;

public class MyMain2 {

	public static void main(String[] args) {
		
		MyDate2 md2 = new MyDate2();
		
//		md2.year=2019;(X) <- 직접접근은 안된다.
		// 직접접근으로 수정이 불가하니 다른방식으로
		// 수정을한다.
		
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
	
		//출력형식 : 1950년 06월 25일 하고싶을경우
		md2.display2();
	}

}
