package mymain;

public class MyMain_예외적용 {

	public static void main(String[] args) throws InterruptedException {

		int a = 100, b = 0, c;
		// 예외처리구분

		while (true) {
			
			b=(int)(Math.random()*2);
			try {
				// 수행해야할 코드
				c = a / b;
				System.out.println("result:"+c);
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("0으로나누지말랬지!");
				Thread.sleep(3000);

			}
		}
	}

}
