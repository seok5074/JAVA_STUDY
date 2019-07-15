package mymain;

import java.util.Scanner;

import myutil.Snail;

public class MyMain_Snail {

	public static void main(String[] args) {

		int chasu;
		Scanner scan = new Scanner(System.in);

		Snail snail = new Snail();

		while (true) {

			System.out.print("차수 (종료 :0) :");
			chasu = scan.nextInt();
			if (chasu == 0)
				break;
			snail.setChasu(chasu);

			snail.display();
			

		}
		
		System.out.println("--end--");
	}

}
