package myutil;
/*
abstract class MyAbs{
	 int	ZERO=0; // <- �̰Ǻ�����
}
*/
/*
abstract class MyAbs{
	 int minus(int a, int b); <= �߻�޼ҵ� �ȿ��� abstract �� ���ٿ����Ѵ� 
}
*/
public interface BaseCalc {

	//���α��� : ���,�߻�޼ҵ常
	
	public static final double PI =3.14; //���
	//interface ���ο��� final �����ص� final�� �ؼ��Ѵ�.
						  int	ZERO=0; // <= �̰� ������ȴ� 
						  
	public abstract int plus(int a ,int b); // {}<-interface ������ {} ����������.
	//abstract �����ص� abstract��� �ؼ��̵ȴ�. interface������������
					  int minus(int a, int b);
						  
}
