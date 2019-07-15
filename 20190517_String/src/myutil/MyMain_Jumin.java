package mymain;

import java.util.Scanner;

import myutil.Jumin;

public class MyMain_Jumin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String jumin_no;
		Jumin jumin = new Jumin();
		
		while(true) {
			
			System.out.print("주민번호:");
			jumin_no = scan.next();
			//입력받은 주민번호 넣는다
			jumin.setJumin_no(jumin_no);
			
			int year 		= jumin.getYear();
			int age  		= jumin.getAge();
			String tti 		= jumin.getTti();
			String ganji	= jumin.getGanji();
			String season 	= jumin.getSeason();
			String sex 		= jumin.getSex();
			String local 	= jumin.getLocal();
			//유효성 
			boolean bValid = jumin.isValid();
			
			System.out.println("---[정보]---");
			
			if(bValid) {
				System.out.printf("출생년도:%d(%s)\n",year,ganji);
				System.out.printf("출생지역:%s\n",local);
				System.out.printf("나이:%d(살)(%s)\n",age,tti);
				System.out.printf("성별:%s\n",sex);
				System.out.printf("출생계절:%s\n",season);
			}else {
				System.out.println("--잘못된 주민번호입니다--");
			}
			
			
		}
		
		
		
		
		
	}

}
