package mymain;

import java.util.ArrayList;


import myutil.MyArrayList;

public class MyMain_MyArrayList_Generic {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//����Ÿ���� string���� �����̵ȴ�.
		//��� �ٸ�Ÿ������ �������������Ѵ�.
		MyArrayList<String> sidoList = new MyArrayList<String>();
		//						�迭�ε�����
		sidoList.add("����");  //0
		sidoList.add("���");  //1
		sidoList.add("��õ");  //2
		sidoList.add("����");  //3
		
		String sido = sidoList.get(1);
		
		
		//����API
		ArrayList sidoList1 = new ArrayList();
		sidoList1.add("����"); //0
		sidoList1.add("���"); //1
		sidoList1.add("��õ"); //2
		sidoList1.add("����"); //3
		sidoList1.add(1234);

		
		String sido1 = (String)sidoList1.get(1);
		
		


	}
}