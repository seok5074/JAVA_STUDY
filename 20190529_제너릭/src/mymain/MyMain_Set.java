package mymain;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MyMain_Set {

	public static void main(String[] args) {

		
		/* 				Set
		 1. ��ü �������� ��������ϴ� ��ü
		 2.�ߺ����� ������� �ʴ´�.
		 
		 
		 
		 */
		
		
		
		Random rand = new Random();
		
		int count =6;
		//Set<Int> lottoSet = new TreeSet<Integer>(); // �����ؼ������������� int ������ȵȴ�.
		//�ǹ� :
		//����			  =		���輭
		
		//�������̽�		  = 	Ŭ����
		Set<Integer> lottoSet = new TreeSet<Integer>(); // �����ؼ�������������

	
		while(count>0) { 
			
			int no = rand.nextInt(45)+1; // 1~45����
			//�߰������� ���� ������ ���� �ִ� ���: �ٽ� �õ��ض�
			if(lottoSet.add(no)==false)continue;
			
			count--;
		}
			System.out.println(lottoSet);
			System.out.println();
			System.out.println("===���� loop�̿��ؼ� ��� ����");
			
			//		lottoSet =>[ , , , , , ]
			for(Integer no : lottoSet) {  // lottoset�� �ִ� ��ҵ��� ������� ���´�.
				System.out.printf("%3d",no);
			}
			System.out.println();
			System.out.println();

			System.out.println("==Iterator�̿��ؼ� ��� ����");
			//		lottoSet =>[ , , , , , ]
			Iterator<Integer> it = lottoSet.iterator();
			while(it.hasNext()) {//�����ҿ�Ұ� �ֳ� ��� �����.
				
				int no = it.next(); //��������
				System.out.printf("%3d",no);	
			}
			System.out.println();
	}
	

}
