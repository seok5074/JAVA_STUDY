package mymain;

class TestMethod{
	//call by name : �̸��� �̿��ؼ� ȣ��
	public void title() {
		System.out.println("---�޼ҵ�ȣ�� ����---");
	}
	//call by value : �̸��� ���� �����ؼ� ȣ��
	public int puls(int a, int b) {
		return a+b;
	}
	//call by reference : �̸�+�������� �����ؼ� ȣ��
	public void title(String My_title2) {
		System.out.printf(My_title2);
		
	}
	
}


public class MyMain_Methodȣ���� {

	public static void main(String[] args) {
		TestMethod tm =new TestMethod();//��ü ���� 
		tm.title();
		
		String My_title= new String("---���� ������ Ÿ��Ʋ---");
		tm.title(My_title);
	}
}
