package mymain;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import vo.PersonVo;

public class MyMain_Person_Array_seriaizable {

	public static void main(String[] args) throws Exception {
		/*
		PersonVo[] p_array = { new PersonVo("�ϱ浿", 20, "���� ���� �Ÿ�1��"), new PersonVo("�̱浿", 30, "���� ���� �Ÿ�2��"),
				new PersonVo("��浿", 40, "���� ���� �Ÿ�3��") };

		// ��ü����
		FileOutputStream fos = new FileOutputStream("Person_array.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//����
		oos.writeObject(p_array);
		
		//�ݱ�
		oos.close();
		fos.close();
		*/
		FileInputStream fis = new FileInputStream("Person_array.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		PersonVo [] p_array1 =   (PersonVo []) ois.readObject();
		
		ois.close();
		fis.close();
		
		for(PersonVo p : p_array1)
			System.out.printf("%s %d %s\n",p.getName(),p.getAge(),p.getAddr());
		
	}

}
