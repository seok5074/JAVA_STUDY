package mymain;

import java.util.Scanner;

import myutil.MyInfo;

public class jumin {
	public static void main(String[] args) {
	
		Scanner scan =new Scanner(System.in);
		String jumin_no;
		MyInfo jumin = new MyInfo();
		while(true) {
			System.out.print("�ֹι�ȣ");
			jumin_no=scan.next();
			//�Է¹����ֹι�ȣ�ִ´�
			jumin.setJumin_no(jumin_no);
			
			int year =jumin.getYear();
			int age =jumin.getAge();
		}
	}

}
