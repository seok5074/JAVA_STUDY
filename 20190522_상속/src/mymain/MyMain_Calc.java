package mymain;

import myutil.AdvanceCalc;
import myutil.BaseCalc;

public class MyMain_Calc {
	
	//오로지 object기능만사용
	static void onlyObject(Object ob) {
		//					Object ob =ac;   -> up-casting
		System.out.println(ob.toString());
		//int res = ob.plus(1,2); 못쓴다.
	}
	
	//사용범위가 BaseCalc로 재한되어있다.
	static void onlyBaseCalc(BaseCalc bc) {
	//							BaseCalc bc =ac;  // up-casting
	//				basecalc 안에있는 식밖에 못쓴다.
		int x =10, y=10,z;
		z=bc.puls(x, y);
		//z=bc.hap(x,y); 정의가 안되있다. advancedcalc 안에있기때문에 사용불간
		System.out.println(z);
	}
	//object 로 BaseCalc 사용하겟다. 
	static void useBaseCalc(Object ob) {
		//자기의지로 사용할수있다. 강제로 사용범위확장을 시켜줘야한다.
		int a=1 ,b=2,c;
		c =((BaseCalc)ob).puls(a, b); 
		//강제사용범위확정 상속이되는 단계에서만해당된다.
		//BaseCalc bc=ob; 안된다.
		BaseCalc bc =(BaseCalc) ob; //이렇게 앞에 확장자를 붙여줘야한다.
		//object ob 타입을 basecalc bc 타입으로 영역확대해준다.
		c=bc.miuns(a, b);
		System.out.println(c);
		
		
	}

	public static void main(String[] args) {
		
		
		AdvanceCalc ac=new AdvanceCalc();
		
		onlyObject(ac);
		
		onlyBaseCalc(ac);
		
		useBaseCalc(ac);
		
		Object ob=new Object(); //애초에 basecalc 존재하지않아서 오류
		useBaseCalc(ob);		// 존재하는값을 대입해줘야 된다.
		
		
		int a=10, b=3,c;
		c =ac.puls(a, b);

		System.out.printf("%d + %d = %d\n",a,b,c);
		c =ac.hap(a);
		System.out.printf("%d까지의합 %d\n",a,c);
		
		
		
		
		
		
		
		
	}
	
	
	

}
