package mymain;

import javax.print.DocFlavor.STRING;

/*
 * final
 * 1. final �ڷ��� ���� = �ʱⰪ; <=��������ҽ� ���
 * 2. �޼ҵ� : final ��ȯ�� �޼ҵ��() <-  ���̻� override(������)��������
 * 3. class : final class Ŭ������{} <= ���̻� Ȯ���������ƶ�
 */

class A{
	public void sub( ) {}
	final public void sub1( ) {}
	
}
final class AA extends A{
	public void sub() {}
	//public void sub1() {}		Cannot override the final method from A
	//							 �����ǵ����ʴ´�.
}

//class MyString extends String{} stirng�� final�� �ִ�.


//class AAA extends AA{ 	The type AAA cannot subclass the final class AA
//							AA�κ��� ��ӹ������Ѵ�. Ȯ���������Ѵ�.
public class MyMain_final {

	//�������
	public static final double PI=3.14; //3.14�ǰ����θ�����ȴ�.
	
	public static void main(String[] args) {
		//PI=3.1451952; //final �ڵ�⶧���� �����̾ȵȴ�.
		//				The final field MyMain_final.PI cannot be assigned
		AA aa =new AA();
		//AAA aaa = new AAA();
		
	}

}
