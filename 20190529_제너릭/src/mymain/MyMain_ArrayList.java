package mymain;

import java.util.ArrayList;
import java.util.List;

public class MyMain_ArrayList {

	public static void main(String[] args) {
		List<String> fruit_list  = new ArrayList<String>();
		
		fruit_list.add("���");
		fruit_list.add("����");
		fruit_list.add("����");
		fruit_list.add("����");
		
		System.out.println("ö�ڸ� �̿��� ��� ����");
		for(int i=0;i<fruit_list.size();i++) { // i=0 1 2 3
			String fruit =fruit_list.get(i);
			System.out.printf("%5s",fruit);
		}
		System.out.println();
		System.out.println();
		System.out.println("==���� loop�� �̿��� ��� ����==");
		
		for(String fruit : fruit_list) {
			System.out.printf("%5s",fruit);
		}
		System.out.println();
		System.out.println();
		
		
		
	}

}
