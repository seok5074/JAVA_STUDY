package mymain;

import java.util.ArrayList;
import java.util.List;

import vo.PersonVo;

public class MyMain_PersonVo {

	public static void main(String[] args) {
		List<PersonVo>p_list =new ArrayList<PersonVo>();
		
		p_list.add(new PersonVo("�ϱ浿", 21, "���� ���� �Ÿ�1��"));
		p_list.add(new PersonVo("�̱浿", 22, "���� ���� �Ÿ�2��"));
		p_list.add(new PersonVo("��浿", 23, "���� ���� �Ÿ�3��"));
		p_list.add(new PersonVo("��浿", 24, "���� ���� �Ÿ�4��"));
		p_list.add(new PersonVo("���浿", 25, "���� ���� �Ÿ�5��"));
		
		System.out.println("===���� loop�̿��ؼ� ��� ����");
		for(PersonVo p : p_list) {
			System.out.println(p);
		}
		System.out.println("÷�ڸ��̿��� ���");
		for(int i=0;i<p_list.size();i++) {
			PersonVo p = p_list.get(i);
			System.out.printf("%d : %s\n",i,p);
		}
	}
	
}
