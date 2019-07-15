package mymain;

import myutil.MyArrayList;

public class MyMain_MyArrayList {

	public static void main(String[] args) {

		// try ~ catch block ���� ����Ű
		// ���üũ�� alt shift z

		try {
			MyArrayList list = new MyArrayList();
			System.out.println("list size : " + list.size());

			list.add(1);
			list.add(2);
			list.add(3);

			// �ٸ������� �������ȴ� .
			// ���ڷ����� �������Ѵ�.
			// list.add(new String("dddd"));
			// list.add(1.0);
			// list.add(true);

			System.out.println("list size : " + list.size());

			// integer => int : auto-unboxing
			// �����ѹ������ ������
			// Integer -> int : auto-unboxing
			int index = 0;
			int n = (Integer) list.get(index);
			System.out.println(n);

			System.out.println("--before delete---");
			for (int i = 0; i < list.size(); i++) {
				System.out.printf("list's %d��° ������ : %d\n", i + 1, list.get(i));
			}

			// 2��° ������ ����

			list.remove(2);

			System.out.println("--ater delete---");
			for (int i = 0; i < list.size(); i++) {
				System.out.printf("list's %d��° ������ : %d\n", i + 1, list.get(i));
			}
			//2�������ͻ���
			list.insert(1, 100);

			System.out.println("--ater insert---");
			for (int i = 0; i < list.size(); i++) {
				System.out.printf("list's %d��° ������ : %d\n", i + 1, list.get(i));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
