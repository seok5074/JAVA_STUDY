package myutil;

public class MyMath {
	
	private MyMath() {	
	}// 애초에 문제가 될거같은문제를 
	 // 막으면된다. private로 막으면된다.
	
	public static int plus(int a, int b) {
		return a+b;
	}
}
//결국엔 객체생성을 막을려고 쓴다?