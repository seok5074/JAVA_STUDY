package mymain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import vo.PersonComp;
import vo.PersonVo;

public class MyMain_Arrays {

	public static void main(String[] args) {

		System.out.println("aBC".compareTo("ABC"));
		
		PersonVo [] p_array = {
						new PersonVo("다길동",50,"서울 관악 신림 2"), //0
						new PersonVo("나길동",30,"서울 관악 신림 3"), //1
						new PersonVo("마길동",10,"서울 관악 신림 4"), //2
						new PersonVo("가길동",40,"서울 관악 신림 1"), //3
						new PersonVo("라길동",20,"서울 관악 신림 5"), //4
				};
		
		//ArrayList
		List<PersonVo> p_list =new ArrayList<PersonVo>();
		p_list.add(new PersonVo("다길동",50,"서울 관악 신림 2"));
		p_list.add(new PersonVo("라길동",20,"서울 관악 신림 1"));
		p_list.add(new PersonVo("가길동",10,"서울 관악 신림 3"));
		p_list.add(new PersonVo("나길동",10,"서울 관악 신림 4"));
		p_list.add(new PersonVo("마길동",40,"서울 관악 신림 5"));
		
		System.out.println("==ArrayList 원본데이터==");
		for(PersonVo p : p_list)
			System.out.println(p);
		System.out.println();
		
		
		Collections.sort(p_list, new PersonComp());
		
		System.out.println("==ArrayList sort==");
		for(PersonVo p : p_list)
			System.out.println(p);
		System.out.println();
		
		

		System.out.println("--original data--");
		for(PersonVo p : p_array)
				System.out.println(p);
		
		
		//객체를 정렬하려면 정렬기준객체를 줘야한다.
		//sort  ↓오류
		//Arrays.sort(p_array,정렬기준객체);
		PersonComp comp = new PersonComp();
		Arrays.sort(p_array,comp);
		
		System.out.println("after srot data");
		for(PersonVo p : p_array)
			System.out.println(p);
		System.out.println();

		
		//이름순 내림차순
		comp.setSort_field(PersonComp.SORT_FIELD_NAME); //이름기준으로 셋팅
		comp.setSort_method(PersonComp.SORT_METHOD_DESC);//디센딩으로 셋팅
		
		Arrays.sort(p_array,comp);
		
		System.out.println("--after sort(이름순 내림차순)==");
		for(PersonVo p : p_array)
			System.out.println(p);
		System.out.println();
		
		
		//나이순 오름차순
		comp.setSort_field(PersonComp.SORT_FIELD_AGE);
		comp.setSort_method(PersonComp.SORT_METHOD_ASC);
		Arrays.sort(p_array,comp);

		
		System.out.println("--나이순 오른차순--");
		for(PersonVo p :p_array)
			System.out.println(p);
		System.out.println();
		
		comp.setSort_field(PersonComp.SORT_FIELD_AGE);
		comp.setSort_method(PersonComp.SORT_METHOD_DESC);
		
		Arrays.sort(p_array,comp);

		
		System.out.println("--나이순 내림차순--");
		for(PersonVo p :p_array)
			System.out.println(p);
		System.out.println();

		comp.setSort_field(PersonComp.SORT_FIELD_ADDR);
		comp.setSort_method(PersonComp.SORT_METHOD_ASC);
		
		Arrays.sort(p_array,comp);
		
		System.out.println("--주소순 오름차순--");

		for(PersonVo p :p_array)
			System.out.println(p);
		System.out.println();
		
		comp.setSort_field(PersonComp.SORT_FIELD_ADDR);
		comp.setSort_method(PersonComp.SORT_METHOD_DESC);
		 
		Arrays.sort(p_array,comp);
		
		System.out.println("--주소순 내림차순--");

		for(PersonVo p :p_array)
			System.out.println(p);
		System.out.println();
	}

}
