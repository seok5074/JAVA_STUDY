package myutil;

public class MyMath {
	
	//중복메소드(method overload)
	public static int plus(int a, int b) {
		return a+b;
	}
	public long plus(long a, long b) {
		return a+b;
	}
	public float plus(float a, float b) {
		return a+b;
	}    
	public double plus(double a, double b) {
		return a+b;
	}
	public int minus(int a, int b) {
		return a-b;
	}
	public int multiply(int a,int b) {
		return a*b;
	}
	public int divide(int a, int b) {
		return (b==0)? 0:a/b;
	}
	public int mod(int a, int b) {
		return a%b;
	}
	//2수중 큰수
	public int max(int a, int b) {
		int re;
		if(a<b)
			re =b;
		else
			re=a;
		return re;
		
	}
	//method overload는 호출정보가 틀려야된다.
	//성립안되는이유는 호출정보가 동일함
	//					반환정보만 틀림
	//public double max(int a, int b) {
	//return 0;
	//}
	//3수중 큰수
	public int max(int a, int b,int c) {
		int re1 = 0;
		if(a>b && a>c)
			re1=a;
		else if(b>a && b>c)
			re1=b;
		else
			re1=c;
		return re1;
	}
	public double fact(int n) {
		double re2 = 1.0;
		for(int i = n ; i >= 1 ; i--){ 
            re2 = re2 * i;
		}
		return re2;	
	}//팩토리얼 구하기
	public double CtoF(double c) {
		double re3=0;
		re3 =(c*1.8)+32;
		return re3;
	}//섭씨 ->화씨변환
	public double FtoC(double c) {
		double re4=0;
		re4 =(c-32)/1.8;
		return re4;
	}//화시 -> 섭씨변환

	

}
