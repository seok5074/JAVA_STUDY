package mymain;

public class Method1 {
	static int plus(int a, int b) {
		// int a=x , int b= y �� �ν��̵ȴ�.
		int c = a + b;
		return c;// �ڽ��� ȣ���Ѱ����� �����ض�.
	}

	static int hap(int n){
		int sum=0;
		for(int i=0;i<=n;i++){
			sum +=i;			
		}
		return sum;
	}
	//n������ m�� �������: hap(10������ ���߿���.3�ǹ�������ض�)->3+6+9
	static int hap1(int n, int m){
		int sum1=0;
		/*
		 * ���1 
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
		res=hap(x);// x���� ��
		System.out.printf("%d�������� : %d\n",x,res);
		
		x=10;
		y=3;
		res=hap1(x,y);
		System.out.printf("%d���� %d������� : %d\n",x,y,res);
	}

}
