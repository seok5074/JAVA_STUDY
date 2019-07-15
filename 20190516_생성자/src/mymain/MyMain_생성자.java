package mymain;

import myutil.MyDate;

public class MyMain_생성자 {

	public static void main(String[] args) {
	/*
	 *1로수정 
	 *MyDate m1 =new MyDate(); 
	 *m1.display();
	 */	  
	  MyDate m1 =new MyDate();
	  m1.display();
	  
	  // 세개수 정
	  MyDate m2 = new MyDate(2019, 5, 16);
	  m2.display();
	  
	  //하나만수정
	  MyDate m3=new MyDate(2020);
	  m3.display();
	  //두개수정
	  
	  MyDate m4 =new MyDate(2020,6);
	  m4.display();
	  
	  // 먼저있던값을 그대로 받는명령식
	  MyDate m5 = new MyDate(m2);
	  m5.display();
	 
	  
	}

}
