package mymain;

import java.util.Scanner;

import myutil.MyInfo;

public class jumin {
	public static void main(String[] args) {
	
		Scanner scan =new Scanner(System.in);
		String jumin_no;
		MyInfo jumin = new MyInfo();
		while(true) {
			System.out.print("주민번호");
			jumin_no=scan.next();
			//입력받은주민번호넣는다
			jumin.setJumin_no(jumin_no);
			
			int year =jumin.getYear();
			int age =jumin.getAge();
		}
	}

}
