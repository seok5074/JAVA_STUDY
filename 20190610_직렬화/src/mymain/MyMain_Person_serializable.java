package mymain;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import vo.PersonVo;

public class MyMain_Person_serializable {

	public static void main(String[] args) throws Exception {
		/*
		 * //����(����ȭ)(������) PersonVo p = new PersonVo("�ϱ浿", 30, "���� ���� �Ÿ�");
		 * 
		 * // ����ȭ�� ���� ��ü ���� FileOutputStream fos = new FileOutputStream("person.dat");
		 * ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * 
		 * // ���� oos.writeObject(p);
		 * 
		 * // �ݱ� : �ݱ�� ���� �������� ������ �ݾƾ��Ѵ� oos.close(); fos.close();
		 * 
		 * System.out.println("--success save--");
		 */

		// ���� �о���� : �𸶼���(������ȭ)
		FileInputStream fis = new FileInputStream("person.dat");
		// ObjectInputStream���� ����� ��ü������ objecteinputStream����
		// �о�;��Ѵ�.
		ObjectInputStream ois = new ObjectInputStream(fis);

		//������Ű�� �о���̴� �۾�.
		//����� ��ü ������ ���Ϸκ��� �о�ͼ� ��ü����(����)����Ų��.
		//������ ��ü������ ��ȯ �Ѵ�.
		PersonVo p1 =  (PersonVo) ois.readObject();
		
		
		// �ݱ� : �ݱ�� ���� �������� ������ �ݾƾ��Ѵ�
		ois.close();
		fis.close();
		
		
		//���� �� ��ü Ȯ��
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getAddr());
		
	}

}
