package mymain;

import myutil.BaseCalc;
import myutil.BaseCalcmpl;

public class MyMain_BaseCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//	�����κ�	 =    ��ü����
		//  interface	 =	  class
		//  ����		 =	  ���輭
		BaseCalcmpl calc = new BaseCalcmpl();
		
		int a=10 ,b=5,c;
		
		c = calc.plus(a,b);
		System.out.printf("%d + %d = %d\n",a,b,c);
		c= calc.minus(a, b);
		System.out.printf("%d - %d = %d\n",a,b,c);
	}

}
