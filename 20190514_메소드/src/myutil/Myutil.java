package myutil;

public class Myutil {

	// method overload : method 명은 동일하나 인자정보가 틀린 메소드
	// (중복 메소드)

	public void draw_line() {
		System.out.println("--------------------------------");

	}

	public void draw_line(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print('-');
		}
		System.out.println();
	}

	public void draw_line(int n, char ch) {
		for (int i = 0; i < n; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}

	public void draw_line(int n, String ch) {
		for (int i = 0; i < n; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}

	// n : 전체길이
	// ch1 : 패턴문자1
	// len1: 패턴문자1의 길이
	// ch2 : 패턴문자2
	// len2: 패턴문자2의 길이
	// ex) **---**---**---* <=util.draw_line(50,'*',2,'-',3);
	//retrun을 활용한 목록
	public void draw_line(int n, char ch1, int len1, char ch2, int len2) {
		int count = 0;
		while (true) {
			for (int a = 0; a < len1; a++) {
				System.out.print(ch1);
				count++;
				if (count == n) {
				    System.out.println();
					return;
				}
			}
			
			for (int a = 0; a < len2; a++) {
				System.out.print(ch2);
				count++;
				if (count == n) {
				    System.out.println();
					return;
				}
			}
			
			
		}
		
	}
	// break 문을 이용한 설정
	public void draw_line2(int n, char ch1, int len1, char ch2, int len2) {
		int count = 0;
		END_WHILE:
		while (true) {
			for (int a = 0; a < len1; a++) {
				System.out.print(ch1);
				count++;
				if (count == n) {
				   break END_WHILE;
				}
			}
			
			for (int a = 0; a < len2; a++) {
				System.out.print(ch2);
				count++;
				if (count == n) {
				   break END_WHILE;
				}
			}
			
			
		}
		System.out.println();
	}//end-while
	

}
