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
						new PersonVo("�ٱ浿",50,"���� ���� �Ÿ� 2"), //0
						new PersonVo("���浿",30,"���� ���� �Ÿ� 3"), //1
						new PersonVo("���浿",10,"���� ���� �Ÿ� 4"), //2
						new PersonVo("���浿",40,"���� ���� �Ÿ� 1"), //3
						new PersonVo("��浿",20,"���� ���� �Ÿ� 5"), //4
				};
		
		//ArrayList
		List<PersonVo> p_list =new ArrayList<PersonVo>();
		p_list.add(new PersonVo("�ٱ浿",50,"���� ���� �Ÿ� 2"));
		p_list.add(new PersonVo("��浿",20,"���� ���� �Ÿ� 1"));
		p_list.add(new PersonVo("���浿",10,"���� ���� �Ÿ� 3"));
		p_list.add(new PersonVo("���浿",10,"���� ���� �Ÿ� 4"));
		p_list.add(new PersonVo("���浿",40,"���� ���� �Ÿ� 5"));
		
		System.out.println("==ArrayList ����������==");
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
		
		
		//��ü�� �����Ϸ��� ���ı��ذ�ü�� ����Ѵ�.
		//sort  �����
		//Arrays.sort(p_array,���ı��ذ�ü);
		PersonComp comp = new PersonComp();
		Arrays.sort(p_array,comp);
		
		System.out.println("after srot data");
		for(PersonVo p : p_array)
			System.out.println(p);
		System.out.println();

		
		//�̸��� ��������
		comp.setSort_field(PersonComp.SORT_FIELD_NAME); //�̸��������� ����
		comp.setSort_method(PersonComp.SORT_METHOD_DESC);//�𼾵����� ����
		
		Arrays.sort(p_array,comp);
		
		System.out.println("--after sort(�̸��� ��������)==");
		for(PersonVo p : p_array)
			System.out.println(p);
		System.out.println();
		
		
		//���̼� ��������
		comp.setSort_field(PersonComp.SORT_FIELD_AGE);
		comp.setSort_method(PersonComp.SORT_METHOD_ASC);
		Arrays.sort(p_array,comp);

		
		System.out.println("--���̼� ��������--");
		for(PersonVo p :p_array)
			System.out.println(p);
		System.out.println();
		
		comp.setSort_field(PersonComp.SORT_FIELD_AGE);
		comp.setSort_method(PersonComp.SORT_METHOD_DESC);
		
		Arrays.sort(p_array,comp);

		
		System.out.println("--���̼� ��������--");
		for(PersonVo p :p_array)
			System.out.println(p);
		System.out.println();

		comp.setSort_field(PersonComp.SORT_FIELD_ADDR);
		comp.setSort_method(PersonComp.SORT_METHOD_ASC);
		
		Arrays.sort(p_array,comp);
		
		System.out.println("--�ּҼ� ��������--");

		for(PersonVo p :p_array)
			System.out.println(p);
		System.out.println();
		
		comp.setSort_field(PersonComp.SORT_FIELD_ADDR);
		comp.setSort_method(PersonComp.SORT_METHOD_DESC);
		 
		Arrays.sort(p_array,comp);
		
		System.out.println("--�ּҼ� ��������--");

		for(PersonVo p :p_array)
			System.out.println(p);
		System.out.println();
	}

}
