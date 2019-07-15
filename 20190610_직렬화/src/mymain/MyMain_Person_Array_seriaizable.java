package mymain;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import vo.PersonVo;

public class MyMain_Person_Array_seriaizable {

	public static void main(String[] args) throws Exception {
		/*
		PersonVo[] p_array = { new PersonVo("일길동", 20, "서울 관악 신림1동"), new PersonVo("이길동", 30, "서울 관악 신림2동"),
				new PersonVo("삼길동", 40, "서울 관악 신림3동") };

		// 객체저장
		FileOutputStream fos = new FileOutputStream("Person_array.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//저장
		oos.writeObject(p_array);
		
		//닫기
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
