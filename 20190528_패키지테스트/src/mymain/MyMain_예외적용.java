package mymain;

public class MyMain_�������� {

	public static void main(String[] args) throws InterruptedException {

		int a = 100, b = 0, c;
		// ����ó������

		while (true) {
			
			b=(int)(Math.random()*2);
			try {
				// �����ؾ��� �ڵ�
				c = a / b;
				System.out.println("result:"+c);
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("0���γ�����������!");
				Thread.sleep(3000);

			}
		}
	}

}
