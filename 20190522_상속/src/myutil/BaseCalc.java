package myutil;

//						↓숨겨진언어 : 묵시적존재
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

		return b==0 ? 0: a/b; // 삼항연산자 b가 0이면 계산불가
	}
}
