package mymain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.PersonVo;

public class MyMain_Map_PersonBo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, PersonVo> personMap = new HashMap<String, PersonVo>();

		List<PersonVo> p_list = new ArrayList<PersonVo>();

		for (int i = 1; i <= 100; i++) {
			String name = String.format("길동%04d", i); // "길동0001" 로 만들어진다.
			int age = 20 + i % 11; // 20~30로된다.
			String addr = String.format("서울 관악 신림%d동", i % 3 + 1);

			PersonVo p = new PersonVo(name, age, addr);
			// map에추가
			personMap.put(name, p);
			// Arraylist에추가
			p_list.add(p);
		}
		//map을 이용한검색
		String search_name = "길동0050";
		//key를 이용해서 단번에 검색한다.
		PersonVo search_p = personMap.get(search_name);
		System.out.printf("검색이름[%s]: %s\n", search_name, search_p);
		
		// Arraylist 이용한 검색 : 순차적으로 검색되어 비효율적일수도있다.

		int count =0;
		for(int i=0;i<p_list.size();i++) {
			count++;
			
			PersonVo pp =p_list.get(i);
			//검색이름을 갖는 객체를 발견하게한다.
			if(pp.getName().equals(search_name)) {
				System.out.printf("검색이름[%s]: %s(검색횟수:%d)\n", search_name, search_p,count);
				break;
				
			}
			
		}
	}
	

}
