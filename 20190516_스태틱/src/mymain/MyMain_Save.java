package mymain;

import myutil.Save;

public class MyMain_Save {

	public static void main(String[] args) {
		//객체생성전에도 사용가능
		// 클래스명.변수명=값;
		//Save.rate=0.2; //이율 지정
		
		Save s1 = new Save("일길동",1000000);
		Save s2 = new Save("이길동",2000000);
		Save s3 = new Save("삼길동",3000000);
		
		//저축자정보 출력
		s1.display();
		s2.display();
		s3.display();
		
		System.out.println("===이율변경:0.1->0.2===");
		//객체생성후 사용방법 
		//객체명.변수명=값;
		
		s1.rate=0.2;
		//s2.rate=0.2; 어떤객체를 가지고도 사용할수있다.
		
		s1.display();
		s2.display();
		s3.display();

	}

}
