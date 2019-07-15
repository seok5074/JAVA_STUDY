package mymain;

public class Method1 {
	static int plus(int a, int b) {
		// int a=x , int b= y 로 인식이된다.
		int c = a + b;
		return c;// 자신을 호출한곳으로 복귀해라.
	}

	static int hap(int n){
		int sum=0;
		for(int i=0;i<=n;i++){
			sum +=i;			
		}
		return sum;
	}
	//n까지의 m의 배수의합: hap(10까지의 수중에서.3의배수를구해라)->3+6+9
	static int hap1(int n, int m){
		int sum1=0;
		/*
		 * 방법1 
		 * for(int a=0;a<=n;a++) 
		 * 		if(a%3==0) sum1 = sum1+a;
		 */
		for(int a=0;a<=n;a+=m)
				sum1 = sum1+a;
					
		return sum1;
	}

	public static void main(String[] args) {

		int x = 10, y = 20, res;
		res = Method1.plus(x, y);

		System.out.printf("%d+ %d = %d\n", x, y, res);
		res=hap(x);// x까지 합
		System.out.printf("%d까지의합 : %d\n",x,res);
		
		x=10;
		y=3;
		res=hap1(x,y);
		System.out.printf("%d까지 %d배수의합 : %d\n",x,y,res);
	}

}
