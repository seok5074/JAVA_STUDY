package mymain;

import java.util.ArrayList;
import java.util.List;

public class MyMain_ArrayList {

	public static void main(String[] args) {
		List<String> fruit_list  = new ArrayList<String>();
		
		fruit_list.add("사과");
		fruit_list.add("딸기");
		fruit_list.add("포도");
		fruit_list.add("참외");
		
		System.out.println("철자를 이용한 요소 추출");
		for(int i=0;i<fruit_list.size();i++) { // i=0 1 2 3
			String fruit =fruit_list.get(i);
			System.out.printf("%5s",fruit);
		}
		System.out.println();
		System.out.println();
		System.out.println("==개선 loop를 이용한 요소 추출==");
		
		for(String fruit : fruit_list) {
			System.out.printf("%5s",fruit);
		}
		System.out.println();
		System.out.println();
		
		
		
	}

}
