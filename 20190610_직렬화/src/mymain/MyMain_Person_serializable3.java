package mymain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vo.PersonVo3;

public class MyMain_Person_serializable3 {

	public static void main(String[] args) throws Exception {

		// 저장(직렬화)(마샬링)
		PersonVo3 p = new PersonVo3("일길동", 30, "서울 관악 신림");

		// 직렬화를 통한 객체 저장
		FileOutputStream fos = new FileOutputStream("person3.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(p);

		// 닫기 : 닫기는 열린 역순으로 무조건 닫아야한다 oos.close(); fos.close();

		System.out.println("--success save--");

		// 복원 읽어오기 : 언마샬링(역직렬화)
		FileInputStream fis = new FileInputStream("person3.dat");
		// ObjectInputStream으로 저장된 객체정보를 objecteinputStream으로
		// 읽어와야한다.
		ObjectInputStream ois = new ObjectInputStream(fis);

		// 복원시키고 읽어들이는 작업.
		// 저장된 객체 정보를 파일로부터 읽어와서 객체조립(복원)을시킨다.
		// 복원후 객체정보를 반환 한다.
		PersonVo3 p1 = (PersonVo3) ois.readObject();

		// 닫기 : 닫기는 열린 역순으로 무조건 닫아야한다
		ois.close();
		fis.close();

		// 복원 된 객체 확인
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getAddr());

	}

}
