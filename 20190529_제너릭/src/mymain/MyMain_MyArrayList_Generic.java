package mymain;

import java.util.ArrayList;


import myutil.MyArrayList;

public class MyMain_MyArrayList_Generic {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//저장타입이 string으로 고정이된다.
		//대신 다른타입으로 저장을하지못한다.
		MyArrayList<String> sidoList = new MyArrayList<String>();
		//						배열로따지면
		sidoList.add("서울");  //0
		sidoList.add("경기");  //1
		sidoList.add("인천");  //2
		sidoList.add("대전");  //3
		
		String sido = sidoList.get(1);
		
		
		//기존API
		ArrayList sidoList1 = new ArrayList();
		sidoList1.add("서울"); //0
		sidoList1.add("경기"); //1
		sidoList1.add("인천"); //2
		sidoList1.add("대전"); //3
		sidoList1.add(1234);

		
		String sido1 = (String)sidoList1.get(1);
		
		


	}
}