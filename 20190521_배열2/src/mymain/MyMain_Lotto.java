package mymain;

import java.util.Scanner;

import myutil.Lotto;

public class MyMain_Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// 사용자 입력번호(6자리)
		int[] user_no = new int[6];
		Lotto lotto =new Lotto();
		
		while (true) {
			System.out.print("로또번호6자리를 입력(종료는 0) : ");
			// for문을활용한 배열 방식
			/*
			 * for (int i = 0; i < user_no.length; i++) user_no[i] = scan.nextInt(); if
			 * (user_no[0] == 0) break;
			 */
			  user_no[0]= scan.nextInt(); 
			  if (user_no[0] == 0)break; // 첫번째 0을 입력하면 종료해라...
			  user_no[1]= scan.nextInt(); 
			  user_no[2]=scan.nextInt(); 
			  user_no[3]= scan.nextInt(); 
			  user_no[4]= scan.nextInt();
			  user_no[5]= scan.nextInt();
			  
			  //사용자 번호를 lotto 객체에게 전달한다 셋터를통해서 전달
			  lotto.setUser_no(user_no);
			 
			  //추첨실행
			  lotto.make_win_no();
			  
			  //출력
			  
			  lotto.display();
			  
		}
		System.out.println("end");

	}

}
