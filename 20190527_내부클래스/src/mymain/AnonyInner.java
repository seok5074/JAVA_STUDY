package mymain;

interface TestInter {
	int data = 10010; // 상수

	void printData();
}

public class AnonyInner {

	public void test() {

		/*
		 * //인터페이스를 구현한 클래스 선언 class TestInterimpl implements Testinter{
		 * 
		 * public void printData() { System.out.println("data *data) "); }
		 * 
		 * } new TestInterimpl().printData(); }
		 * 
		 * public static void main().String[] args) {
		 */
		//인터페이스와 추사클래스는 겍체생성과  동시에 재정읠 하면 생성가능하다;
			new TestInter() {
			
			@Override
			public void printData() {	
				// TODO Auto-generated method stub
				System.out.println("data : " + data);
			}
		}.printData();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AnonyInner().test();
	}

}
