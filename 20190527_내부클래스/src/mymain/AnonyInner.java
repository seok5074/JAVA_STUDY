package mymain;

interface TestInter {
	int data = 10010; // ���

	void printData();
}

public class AnonyInner {

	public void test() {

		/*
		 * //�������̽��� ������ Ŭ���� ���� class TestInterimpl implements Testinter{
		 * 
		 * public void printData() { System.out.println("data *data) "); }
		 * 
		 * } new TestInterimpl().printData(); }
		 * 
		 * public static void main().String[] args) {
		 */
		//�������̽��� �߻�Ŭ������ ��ü������  ���ÿ� ������ �ϸ� ���������ϴ�;
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
