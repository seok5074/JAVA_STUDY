package mymain;

import myutil.Child;
import myutil.Parent;
import myutil.Person;

public class MyMain_재정의 {

	public static void main(String[] args) {
		Parent p = new Child();
		p.sub();

		StringBuffer sb = new StringBuffer();
		sb.append("오늘은 ");
		sb.append("재정의와 ");
		sb.append("추상클래스를 ");
		sb.append("배웠습니다. ");
		// 이렇게 써도된다.
		System.out.println(sb); // sb.toString() 내부적으로 호출된다.

		Person person = new Person("홍길동", 30, "010-111-1111");
		System.out.println(person); //person.tostring() 호출 (재정의를함)
		

	}

}
