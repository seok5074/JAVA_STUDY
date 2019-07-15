package mymain;

import myutil.MyMath;

public class MyMain_StaticMethod {

	public static void main(String[] args) {
		int a=10 ,b=10,res;
		//static method는 객체생성하지 않고 사용
		//클래스명,메소드명()호출
		res=MyMath.plus(a,b);
		
		
		/* MyMath mm =new MyMath(); 
		 * res =mm.plus(a, b);
		 */
		System.out.printf("%d + %d = %d\n",a,b,res);
		
		/*
		 * Math m=new Math(); 
		 * The constructor Math() is not visible 
		 * 외부에서 사용금지되있다. private 로설정이되서
		 */
		
		//System.out.println(Math.sin(270*Math.PI/180));
		System.out.println(Math.sqrt(16)); // 루트공식
		System.out.println(Math.pow(2, 10));
		
	}
	

}
