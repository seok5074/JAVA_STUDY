package mymain;

import java.util.Scanner;

import myutil.Lotto;

public class MyMain_Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// ����� �Է¹�ȣ(6�ڸ�)
		int[] user_no = new int[6];
		Lotto lotto =new Lotto();
		
		while (true) {
			System.out.print("�ζǹ�ȣ6�ڸ��� �Է�(����� 0) : ");
			// for����Ȱ���� �迭 ���
			/*
			 * for (int i = 0; i < user_no.length; i++) user_no[i] = scan.nextInt(); if
			 * (user_no[0] == 0) break;
			 */
			  user_no[0]= scan.nextInt(); 
			  if (user_no[0] == 0)break; // ù��° 0�� �Է��ϸ� �����ض�...
			  user_no[1]= scan.nextInt(); 
			  user_no[2]=scan.nextInt(); 
			  user_no[3]= scan.nextInt(); 
			  user_no[4]= scan.nextInt();
			  user_no[5]= scan.nextInt();
			  
			  //����� ��ȣ�� lotto ��ü���� �����Ѵ� ���͸����ؼ� ����
			  lotto.setUser_no(user_no);
			 
			  //��÷����
			  lotto.make_win_no();
			  
			  //���
			  
			  lotto.display();
			  
		}
		System.out.println("end");

	}

}
