package mymain;

import java.util.Scanner;

import myutil.MyInfo;

public class MyMain_MyInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int year;
		MyInfo info =new MyInfo();
		
		while(true) {
			System.out.print("����⵵: ");
			year =scan.nextInt();
			//�Է¹��� �⵵�� info���� �־��ش�.
			info.setYear(year);
			
			//���� �� ���� ���⿩��
			int age= info.getAge();
			String tti =info.getTti();
			String ganji =info.getGangji();
			boolean isyoon = info.isYoon();
			
			System.out.print("===[�������]===");
			System.out.printf("���� :%d��\n",age);
			System.out.printf("�� :%s(��)\n",tti);
			System.out.printf("���� :%s\n",ganji);
			System.out.printf("���� :%s\n",isyoon ?"����":"���");
			
		}

	}

}
