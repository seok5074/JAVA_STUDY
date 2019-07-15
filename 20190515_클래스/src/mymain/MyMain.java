package mymain;

import myutil.MyDate;

public class MyMain {

	public static void main(String[] args) {
		
		//참조변수선언
		MyDate in;
		//객체생성
		in = new MyDate();
		//접근허용
		in.year=2019;
		/*
		 * in.month=5; (X)
		 * in.day=15;  (X) 같은객체가 아니라서 접근거부
		 * in.week=1;  (X)
		 */
	}

}
