package mymain;

import myutil.AdvanceCalc;
import myutil.BaseCalc;

public class MyMain_Calc {
	
	//������ object��ɸ����
	static void onlyObject(Object ob) {
		//					Object ob =ac;   -> up-casting
		System.out.println(ob.toString());
		//int res = ob.plus(1,2); ������.
	}
	
	//�������� BaseCalc�� ���ѵǾ��ִ�.
	static void onlyBaseCalc(BaseCalc bc) {
	//							BaseCalc bc =ac;  // up-casting
	//				basecalc �ȿ��ִ� �Ĺۿ� ������.
		int x =10, y=10,z;
		z=bc.puls(x, y);
		//z=bc.hap(x,y); ���ǰ� �ȵ��ִ�. advancedcalc �ȿ��ֱ⶧���� ���Ұ�
		System.out.println(z);
	}
	//object �� BaseCalc ����ϰٴ�. 
	static void useBaseCalc(Object ob) {
		//�ڱ������� ����Ҽ��ִ�. ������ ������Ȯ���� ��������Ѵ�.
		int a=1 ,b=2,c;
		c =((BaseCalc)ob).puls(a, b); 
		//����������Ȯ�� ����̵Ǵ� �ܰ迡�����ش�ȴ�.
		//BaseCalc bc=ob; �ȵȴ�.
		BaseCalc bc =(BaseCalc) ob; //�̷��� �տ� Ȯ���ڸ� �ٿ�����Ѵ�.
		//object ob Ÿ���� basecalc bc Ÿ������ ����Ȯ�����ش�.
		c=bc.miuns(a, b);
		System.out.println(c);
		
		
	}

	public static void main(String[] args) {
		
		
		AdvanceCalc ac=new AdvanceCalc();
		
		onlyObject(ac);
		
		onlyBaseCalc(ac);
		
		useBaseCalc(ac);
		
		Object ob=new Object(); //���ʿ� basecalc ���������ʾƼ� ����
		useBaseCalc(ob);		// �����ϴ°��� ��������� �ȴ�.
		
		
		int a=10, b=3,c;
		c =ac.puls(a, b);

		System.out.printf("%d + %d = %d\n",a,b,c);
		c =ac.hap(a);
		System.out.printf("%d�������� %d\n",a,c);
		
		
		
		
		
		
		
		
	}
	
	
	

}
