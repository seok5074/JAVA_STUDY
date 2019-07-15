package mymain;

import myutil.MyMath;

public class MyMain_MyMath {

	public static void main(String[] args) {
		
		MyMath mm=new MyMath();
		
		int x=10,y=5,res;
		res=MyMath.plus(x,y);
		System.out.printf("%d+%d=%d\n",x,y,res);
		
		int x1=10,y1=5,res1;
		res1=mm.max(x1,y1);
		System.out.printf("%d\n",res1);
		
		int x2=10,y2=5,z2=31,res2;
		res2=mm.max(x2,y2,z2);
		System.out.printf("%d\n",res2);
		
		
		int x3=5; 
		double res31; 
		res31=mm.fact(x3); 
		System.out.printf("%.1f\n",res31);
		 		
		double x4=38.0,res4;
		res4 =mm.CtoF(x4);
		System.out.printf("%.1f\n",res4);
		
		double x5=150.0,res5;
		res5=mm.FtoC(x5);
		System.out.printf("%f\n",res5);
	}

}
