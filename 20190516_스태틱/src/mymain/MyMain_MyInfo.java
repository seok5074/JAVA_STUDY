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
			System.out.print("출생년도: ");
			year =scan.nextInt();
			//입력받은 년도를 info에게 넣어준다.
			info.setYear(year);
			
			//나이 띠 간지 윤년여부
			int age= info.getAge();
			String tti =info.getTti();
			String ganji =info.getGangji();
			boolean isyoon = info.isYoon();
			
			System.out.print("===[정보출력]===");
			System.out.printf("나이 :%d살\n",age);
			System.out.printf("띠 :%s(띠)\n",tti);
			System.out.printf("간지 :%s\n",ganji);
			System.out.printf("윤년 :%s\n",isyoon ?"윤년":"평년");
			
		}

	}

}
