package mymain;

import myutil.MyArrayList;

public class MyMain_MyArrayList {

	public static void main(String[] args) {

		// try ~ catch block 생성 단축키
		// 블록체크후 alt shift z

		try {
			MyArrayList list = new MyArrayList();
			System.out.println("list size : " + list.size());

			list.add(1);
			list.add(2);
			list.add(3);

			// 다른변수도 저장은된다 .
			// 한자료형만 쓰도록한다.
			// list.add(new String("dddd"));
			// list.add(1.0);
			// list.add(true);

			System.out.println("list size : " + list.size());

			// integer => int : auto-unboxing
			// 안전한방법으로 갈려면
			// Integer -> int : auto-unboxing
			int index = 0;
			int n = (Integer) list.get(index);
			System.out.println(n);

			System.out.println("--before delete---");
			for (int i = 0; i < list.size(); i++) {
				System.out.printf("list's %d번째 데이터 : %d\n", i + 1, list.get(i));
			}

			// 2번째 데이터 삭제

			list.remove(2);

			System.out.println("--ater delete---");
			for (int i = 0; i < list.size(); i++) {
				System.out.printf("list's %d번째 데이터 : %d\n", i + 1, list.get(i));
			}
			//2번데이터삽입
			list.insert(1, 100);

			System.out.println("--ater insert---");
			for (int i = 0; i < list.size(); i++) {
				System.out.printf("list's %d번째 데이터 : %d\n", i + 1, list.get(i));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
