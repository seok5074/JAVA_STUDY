package mymain;

import myutil.MyDate2;

public class MyMain_this {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate2 md2=new MyDate2();
		MyDate2 md22=new MyDate2();
		System.out.println("외부에서 확인한 객체정보 : "+ md2);
		md2.display_this();
		System.out.println("외부에서 확인한 객체정보 : "+ md22);
		md22.display_this();
	
	}

}
