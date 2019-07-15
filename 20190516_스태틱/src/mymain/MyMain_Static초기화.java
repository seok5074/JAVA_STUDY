package mymain;

public class MyMain_Static초기화 {
	
	//static 초기화
	static {
		//일반적으로 static 초기화해서 쓰는역할
		//DB : Database Driver Loading...
		//image : Image Loading...
		//sound : Sound Loading...
		System.out.println("0순위로 출력");
	}

	public static void main(String[] args) {
		System.out.println("1.내가제일먼저 실행");
			String s2 =new String("");
	}

}
