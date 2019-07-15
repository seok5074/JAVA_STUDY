package mymain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vo.PersonVo3;

public class MyMain_Person_serializable3 {

	public static void main(String[] args) throws Exception {

		// ����(����ȭ)(������)
		PersonVo3 p = new PersonVo3("�ϱ浿", 30, "���� ���� �Ÿ�");

		// ����ȭ�� ���� ��ü ����
		FileOutputStream fos = new FileOutputStream("person3.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(p);

		// �ݱ� : �ݱ�� ���� �������� ������ �ݾƾ��Ѵ� oos.close(); fos.close();

		System.out.println("--success save--");

		// ���� �о���� : �𸶼���(������ȭ)
		FileInputStream fis = new FileInputStream("person3.dat");
		// ObjectInputStream���� ����� ��ü������ objecteinputStream����
		// �о�;��Ѵ�.
		ObjectInputStream ois = new ObjectInputStream(fis);

		// ������Ű�� �о���̴� �۾�.
		// ����� ��ü ������ ���Ϸκ��� �о�ͼ� ��ü����(����)����Ų��.
		// ������ ��ü������ ��ȯ �Ѵ�.
		PersonVo3 p1 = (PersonVo3) ois.readObject();

		// �ݱ� : �ݱ�� ���� �������� ������ �ݾƾ��Ѵ�
		ois.close();
		fis.close();

		// ���� �� ��ü Ȯ��
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getAddr());

	}

}
