package mymain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMain_Map {
//�����͸� �����س��� �ϳ��� �ʿ��Ҷ� ȣ���Ѵ�.
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
		System.out.printf("�����ȣ %d : %s\n",short_no,tel);
		System.out.println();
		
		//Map�� key����
		Set<Integer>keySet = telMap.keySet();
		
		//��ü������ȣ��
		for(Integer key :keySet) {
			//keySet = [1,2,3,4,5]
			System.out.printf("�����ȣ %d : %s\n",key,telMap.get(key));

		}
	}

}
