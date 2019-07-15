package mymain;

import javax.print.DocFlavor.STRING;

/*
 * final
 * 1. final 자료형 변수 = 초기값; <=상수선언할시 사용
 * 2. 메소드 : final 반환형 메소드명() <-  더이상 override(재정의)하지마라
 * 3. class : final class 클래스명{} <= 더이상 확장하지말아라
 */

class A{
	public void sub( ) {}
	final public void sub1( ) {}
	
}
final class AA extends A{
	public void sub() {}
	//public void sub1() {}		Cannot override the final method from A
	//							 재정의되지않는다.
}

//class MyString extends String{} stirng은 final이 있다.


//class AAA extends AA{ 	The type AAA cannot subclass the final class AA
//							AA로부터 상속받지못한다. 확장하지못한다.
public class MyMain_final {

	//상수선언
	public static final double PI=3.14; //3.14의값으로만진행된다.
	
	public static void main(String[] args) {
		//PI=3.1451952; //final 코드기때문에 수정이안된다.
		//				The final field MyMain_final.PI cannot be assigned
		AA aa =new AA();
		//AAA aaa = new AAA();
		
	}

}
