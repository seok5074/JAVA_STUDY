package myutil;

//						���������� : ����������
public class BaseCalc /* extends Object */ {

	public int puls(int a, int b) {

		return a + b;
	}

	public int miuns(int a, int b) {

		return a - b;
	}

	public int multfly(int a, int b) {

		return a * b;
	}

	public int divide(int a, int b) {

		return b==0 ? 0: a/b; // ���׿����� b�� 0�̸� ���Ұ�
	}
}
