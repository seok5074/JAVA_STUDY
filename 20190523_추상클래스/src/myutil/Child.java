package myutil;

public class Child extends Parent{

	@Override
	public void sub() {//��Ӱ���
		super.sub(); // parent ȣ�� -> 
		
		System.out.println("==childsub()==");
			
	}
	//�Ǹ������� ������ ���� ȣ��ȴ�.
	
	
}
