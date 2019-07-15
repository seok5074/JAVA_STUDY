package mymain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMain_Map {
//데이터를 저장해놓고 하나씩 필요할때 호출한다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> telMap = new HashMap<Integer, String>();
		
		telMap.put(1, "010-1111-1111");
		telMap.put(2, "010-2111-1111");
		telMap.put(3, "010-3111-1111");
		telMap.put(4, "010-4111-1111");
		telMap.put(5, "010-5111-1111");
		
		int short_no =3;
		String tel = telMap.get(short_no);
		System.out.printf("단축번호 %d : %s\n",short_no,tel);
		System.out.println();
		
		//Map의 key집합
		Set<Integer>keySet = telMap.keySet();
		
		//전체데이터호출
		for(Integer key :keySet) {
			//keySet = [1,2,3,4,5]
			System.out.printf("단축번호 %d : %s\n",key,telMap.get(key));

		}
	}

}
