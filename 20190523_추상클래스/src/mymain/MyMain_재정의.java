package mymain;

import myutil.Child;
import myutil.Parent;
import myutil.Person;

public class MyMain_������ {

	public static void main(String[] args) {
		Parent p = new Child();
		p.sub();

		StringBuffer sb = new StringBuffer();
		sb.append("������ ");
		sb.append("�����ǿ� ");
		sb.append("�߻�Ŭ������ ");
		sb.append("������ϴ�. ");
		// �̷��� �ᵵ�ȴ�.
		System.out.println(sb); // sb.toString() ���������� ȣ��ȴ�.

		Person person = new Person("ȫ�浿", 30, "010-111-1111");
		System.out.println(person); //person.tostring() ȣ�� (�����Ǹ���)
		

	}

}
