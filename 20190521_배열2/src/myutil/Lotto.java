package myutil;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	private int[] user_no;// 사용자번호
	// 추첨번호
	private int[] win_no = new int[7];

	// 난수발생 객체
	Random rand = new Random();
	// 등수 맞은수 계산
	int rank;
	int count;

	public void setUser_no(int[] user_no) {
		this.user_no = user_no;

		calc_rank();
	}
	//등수계산(count/rank)
	void calc_rank() {
		count = 0;
		// win_no  와 user_no 비교
		for(int i=0;i<6;i++) {
			for(int k=0;k<6;k++) {
				if(user_no[i]==win_no[k]) {
					count++;
					break;
				}
			}
		}
		
		//등수계산
		if(count==6) rank = 1;
		else if(count==5) rank=3;
		else if(count==4) rank=4;
		else if(count==3) rank=5;
		
		//2등계산
		if(count==5) {
			for(int i=0;i<6;i++) {
				if(win_no[6]==user_no[i]) {
					rank=2;
					break;
				}
			}
		}
		
		
	}

	public void make_win_no() {
		OUT_FOR: for (int i = 0; i < win_no.length; i++) {
			// 난수발생(1~45)
			int su = rand.nextInt(45) + 1;
			// 중복수 체크
			for (int k = 0; k < i; k++) {
				if (su == win_no[k]) {// 동일한 수가 있으면
					i--;
					continue OUT_FOR;
				}
			}

			win_no[i] = su;
		}

		// 보너스번호를 제외한 앞자리 6자리 소트
		Arrays.sort(win_no, 0, 0 + 6);

	}

	public void display() {

		// 추첨번호 출력
		System.out.print("추첨번호:[");
		for (int i = 0; i < win_no.length; i++) {
			if (i < 6)
				System.out.printf("%3d", win_no[i]);
			else// 보너스번호
				System.out.printf(" (%3d)", win_no[i]);
		}
		System.out.println("]");

		System.out.printf("맞은개수 : %d\n", count);
		if (count >= 3) {
			System.out.printf("등수 %d\n", rank);
		} else
			System.out.println("꽝");

	}

	
}