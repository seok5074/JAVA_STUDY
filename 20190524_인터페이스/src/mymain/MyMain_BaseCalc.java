package mymain;

import myutil.BaseCalc;
import myutil.BaseCalcmpl;

public class MyMain_BaseCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//	참조부분	 =    객체생성
		//  interface	 =	  class
		//  설명서		 =	  설계서
		BaseCalcmpl calc = new BaseCalcmpl();
		
		int a=10 ,b=5,c;
		
		c = calc.plus(a,b);
		System.out.printf("%d + %d = %d\n",a,b,c);
		c= calc.minus(a, b);
		System.out.printf("%d - %d = %d\n",a,b,c);
	}

}
