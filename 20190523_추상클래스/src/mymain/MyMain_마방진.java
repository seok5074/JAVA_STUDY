package mymain;

import java.util.Scanner;

import myutil.MaBangJin;

public class MyMain_마방진 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int chasu;
		while (true) {
			System.out.print("차수(종료 0): ");
			chasu=scan.nextInt();
			MaBangJin ma =new MaBangJin();
			
			//종료
			if(chasu==0) break;
			
			if(chasu%2==0) {
				System.out.println("홀수만 입력");
				continue;
			}
			ma.setChasu(chasu);
			
			ma.display();
			
		}
		System.out.println("end");
	}

}
