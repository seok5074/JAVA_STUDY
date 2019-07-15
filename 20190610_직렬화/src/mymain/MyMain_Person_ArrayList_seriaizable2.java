package mymain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import vo.PersonVo;

public class MyMain_Person_ArrayList_seriaizable2 {

	public static void main(String[] args) throws Exception {

		List<PersonVo> p_list = new ArrayList<PersonVo>();
		p_list.add(new PersonVo("�ϱ浿", 20, "���� ���� �Ÿ�1��"));
		p_list.add(new PersonVo("�̱浿", 30, "���� ���� �Ÿ�2��"));
		p_list.add(new PersonVo("��浿", 40, "���� ���� �Ÿ�3��"));

		FileOutputStream fos = new FileOutputStream("person_array_list.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		// ����
		oos.writeObject(p_list);
		
		// �ݱ�
		oos.close();
		fos.close();

		FileInputStream fis = new FileInputStream("person_array_list.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<PersonVo> p_list1 =  (List<PersonVo>) ois.readObject();
				
		ois.close();
		fis.close();
		
		for(PersonVo p : p_list1)
			System.out.printf("%s-%d-%s\n", p.getName(),p.getAge(),p.getAddr()  );
		

	}
}