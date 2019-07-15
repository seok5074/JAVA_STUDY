package myutil;
/*
abstract class MyAbs{
	 int	ZERO=0; // <- 이건변수다
}
*/
/*
abstract class MyAbs{
	 int minus(int a, int b); <= 추상메소드 안에선 abstract 를 꼭붙여야한다 
}
*/
public interface BaseCalc {

	//내부구성 : 상수,추상메소드만
	
	public static final double PI =3.14; //상수
	//interface 내부에선 final 생략해도 final로 해석한다.
						  int	ZERO=0; // <= 이건 상수가된다 
						  
	public abstract int plus(int a ,int b); // {}<-interface 영역에 {} 를쓸수없다.
	//abstract 생략해도 abstract라고 해석이된다. interface내에서만가능
					  int minus(int a, int b);
						  
}
