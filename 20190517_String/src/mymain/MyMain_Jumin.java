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
			
			System.out.print("�ֹι�ȣ:");
			jumin_no = scan.next();
			//�Է¹��� �ֹι�ȣ �ִ´�
			jumin.setJumin_no(jumin_no);
			
			int year 		= jumin.getYear();
			int age  		= jumin.getAge();
			String tti 		= jumin.getTti();
			String ganji	= jumin.getGanji();
			String season 	= jumin.getSeason();
			String sex 		= jumin.getSex();
			String local 	= jumin.getLocal();
			//��ȿ�� 
			boolean bValid = jumin.isValid();
			
			System.out.println("---[����]---");
			
			if(bValid) {
				System.out.printf("����⵵:%d(%s)\n",year,ganji);
				System.out.printf("�������:%s\n",local);
				System.out.printf("����:%d(��)(%s)\n",age,tti);
				System.out.printf("����:%s\n",sex);
				System.out.printf("�������:%s\n",season);
			}else {
				System.out.println("--�߸��� �ֹι�ȣ�Դϴ�--");
			}
			
			
		}
		
		
		
		
		
	}

}
