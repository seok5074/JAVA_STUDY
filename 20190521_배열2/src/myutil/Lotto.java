package myutil;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	private int[] user_no;// ����ڹ�ȣ
	// ��÷��ȣ
	private int[] win_no = new int[7];

	// �����߻� ��ü
	Random rand = new Random();
	// ��� ������ ���
	int rank;
	int count;

	public void setUser_no(int[] user_no) {
		this.user_no = user_no;

		calc_rank();
	}
	//������(count/rank)
	void calc_rank() {
		count = 0;
		// win_no  �� user_no ��
		for(int i=0;i<6;i++) {
			for(int k=0;k<6;k++) {
				if(user_no[i]==win_no[k]) {
					count++;
					break;
				}
			}
		}
		
		//������
		if(count==6) rank = 1;
		else if(count==5) rank=3;
		else if(count==4) rank=4;
		else if(count==3) rank=5;
		
		//2����
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
			// �����߻�(1~45)
			int su = rand.nextInt(45) + 1;
			// �ߺ��� üũ
			for (int k = 0; k < i; k++) {
				if (su == win_no[k]) {// ������ ���� ������
					i--;
					continue OUT_FOR;
				}
			}

			win_no[i] = su;
		}

		// ���ʽ���ȣ�� ������ ���ڸ� 6�ڸ� ��Ʈ
		Arrays.sort(win_no, 0, 0 + 6);

	}

	public void display() {

		// ��÷��ȣ ���
		System.out.print("��÷��ȣ:[");
		for (int i = 0; i < win_no.length; i++) {
			if (i < 6)
				System.out.printf("%3d", win_no[i]);
			else// ���ʽ���ȣ
				System.out.printf(" (%3d)", win_no[i]);
		}
		System.out.println("]");

		System.out.printf("�������� : %d\n", count);
		if (count >= 3) {
			System.out.printf("��� %d\n", rank);
		} else
			System.out.println("��");

	}

	
}