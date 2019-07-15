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
			String name = String.format("�浿%04d", i); // "�浿0001" �� ���������.
			int age = 20 + i % 11; // 20~30�εȴ�.
			String addr = String.format("���� ���� �Ÿ�%d��", i % 3 + 1);

			PersonVo p = new PersonVo(name, age, addr);
			// map���߰�
			personMap.put(name, p);
			// Arraylist���߰�
			p_list.add(p);
		}
		//map�� �̿��Ѱ˻�
		String search_name = "�浿0050";
		//key�� �̿��ؼ� �ܹ��� �˻��Ѵ�.
		PersonVo search_p = personMap.get(search_name);
		System.out.printf("�˻��̸�[%s]: %s\n", search_name, search_p);
		
		// Arraylist �̿��� �˻� : ���������� �˻��Ǿ� ��ȿ�����ϼ����ִ�.

		int count =0;
		for(int i=0;i<p_list.size();i++) {
			count++;
			
			PersonVo pp =p_list.get(i);
			//�˻��̸��� ���� ��ü�� �߰��ϰ��Ѵ�.
			if(pp.getName().equals(search_name)) {
				System.out.printf("�˻��̸�[%s]: %s(�˻�Ƚ��:%d)\n", search_name, search_p,count);
				break;
				
			}
			
		}
	}
	

}
