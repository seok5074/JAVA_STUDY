package myutil;

public class Myutil {

	// method overload : method ���� �����ϳ� ���������� Ʋ�� �޼ҵ�
	// (�ߺ� �޼ҵ�)

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

	// n : ��ü����
	// ch1 : ���Ϲ���1
	// len1: ���Ϲ���1�� ����
	// ch2 : ���Ϲ���2
	// len2: ���Ϲ���2�� ����
	// ex) **---**---**---* <=util.draw_line(50,'*',2,'-',3);
	//retrun�� Ȱ���� ���
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
	// break ���� �̿��� ����
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
