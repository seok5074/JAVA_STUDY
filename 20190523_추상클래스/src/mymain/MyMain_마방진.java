package mymain;

import java.util.Scanner;

import myutil.MaBangJin;

public class MyMain_������ {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int chasu;
		while (true) {
			System.out.print("����(���� 0): ");
			chasu=scan.nextInt();
			MaBangJin ma =new MaBangJin();
			
			//����
			if(chasu==0) break;
			
			if(chasu%2==0) {
				System.out.println("Ȧ���� �Է�");
				continue;
			}
			ma.setChasu(chasu);
			
			ma.display();
			
		}
		System.out.println("end");
	}

}
