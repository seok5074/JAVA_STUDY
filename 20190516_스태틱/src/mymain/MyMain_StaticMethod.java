package mymain;

import myutil.MyMath;

public class MyMain_StaticMethod {

	public static void main(String[] args) {
		int a=10 ,b=10,res;
		//static method�� ��ü�������� �ʰ� ���
		//Ŭ������,�޼ҵ��()ȣ��
		res=MyMath.plus(a,b);
		
		
		/* MyMath mm =new MyMath(); 
		 * res =mm.plus(a, b);
		 */
		System.out.printf("%d + %d = %d\n",a,b,res);
		
		/*
		 * Math m=new Math(); 
		 * The constructor Math() is not visible 
		 * �ܺο��� ���������ִ�. private �μ����̵Ǽ�
		 */
		
		//System.out.println(Math.sin(270*Math.PI/180));
		System.out.println(Math.sqrt(16)); // ��Ʈ����
		System.out.println(Math.pow(2, 10));
		
	}
	

}
