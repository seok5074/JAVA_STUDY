package mymain;

import java.util.ArrayList;
import java.util.List;

import vo.PersonVo;

public class MyMain_PersonVo {

	public static void main(String[] args) {
		List<PersonVo>p_list =new ArrayList<PersonVo>();
		
		p_list.add(new PersonVo("일길동", 21, "서울 관악 신림1동"));
		p_list.add(new PersonVo("이길동", 22, "서울 관악 신림2동"));
		p_list.add(new PersonVo("삼길동", 23, "서울 관악 신림3동"));
		p_list.add(new PersonVo("사길동", 24, "서울 관악 신림4동"));
		p_list.add(new PersonVo("오길동", 25, "서울 관악 신림5동"));
		
		System.out.println("===개선 loop이용해서 요소 추출");
		for(PersonVo p : p_list) {
			System.out.println(p);
		}
		System.out.println("첨자를이용한 출력");
		for(int i=0;i<p_list.size();i++) {
			PersonVo p = p_list.get(i);
			System.out.printf("%d : %s\n",i,p);
		}
	}
	
}
