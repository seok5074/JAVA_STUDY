package mymain;

import myutil.����л�;
import myutil.���л�;
import myutil.�ʵ��л�;
import myutil.�л�;

public class MyMain_�л� {

	
	static void  ��Ӵ�(�л� [] student) {
		//������ (Polymorphism): ������ ��ɿ� ���ؼ� �޴� ��ü����
		//�ڽŸ��� �ൿ
		/*for(int i=0;i<student.length;i++) {
			�л� st =student[i];*/
		for(�л� st : student) { // �迭�� ��� ������� for�� �ݺ��� �־��ش�.
			st.�����Ѵ�();
		}
	}// �̸�ɹ��� ���������ν� ������ �� ����������Ѵ�.
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�߻�Ŭ������ ��ü���� �Ұ� �����ص� �������ȴ�. ����������.
		//�л� s1 = new �л�(); //Cannot instantiate the type �л�
								// �ν��Ͻ� ������ �Ұ�
		//ctrl + shift +o 
		�л�[] student = new �л�[3];
		student[0] = new �ʵ��л�();
		student[1] = new ���л�();
		student[2] = new ����л�();

		��Ӵ�(student);
		//1.�θ�Ÿ������ �޴´�.
		�л� st =new �ʵ��л�();
		//2.������(override)�� �޼ҵ�
		st.�����Ѵ�();
		
		//�迭
		int [] nr = {1,2,3,4};
		for(int n:nr) { // <- ������ loop
			System.out.println(n);
		}
		
		
	}

}
