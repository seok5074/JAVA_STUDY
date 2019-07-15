package mymain;

import java.util.StringTokenizer;

public class MyMain_StringTokenizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sido = "서울 경기 인천 대전 대구 부산 광주 목포";
		// token : 공백(분리문자)기준으로 분리된 데이터
		StringTokenizer st = new StringTokenizer(sido);
		int count = st.countTokens();
		System.out.println(count);
		
		  while(st.hasMoreTokens()) {//분리할토큰이 있는지
			  String token = st.nextToken();
			  System.out.println(token);
		  }
		  
		  String fruit ="사과##배#참외#포도#수박#복숭아";
		  // 				 0  1  2  3    4    5    6  이렇게 인식이됬다
		  // 												 정확히나눈다
		  // String fruit ="사과##배#참외#포도#수박#복숭아";
		  //											분리구분문자(delimeter)
		  StringTokenizer tt=new StringTokenizer(fruit,"#");
		  while(tt.hasMoreTokens()) {
			  //String token = tt.nextToken(); // 바로출력해도됨
			  //System.out.println(token);
			  System.out.println(tt.nextToken()); // <-이렇게
		  }
		  
		  //string split() method를 이용한 문자열 분리
		  
		  String [] fruit_array=fruit.split("#"); // 문자열일 분리가된다.
		  //						  0     1     2      3      4       5
		  //String [] fruit_array= {"사과","배","참외","포도","수박","복숭아"};
		  System.out.println("===split를 이용한 문자열분리===");
		  for(int i=0;i<fruit_array.length;i++) {
			  System.out.printf("fruit_array[%d]:%s\n",i,fruit_array[i]);
		  }
		  
		  
		  
		  
		  System.out.println("---배열연습---");
		  //배열
		  //배열의 요소				0     1    2   3   4   
		  //						1	  2    3   4     5
		  String [] suja_array = {"하나","둘","셋","넷","다섯"};
		  int lenth =suja_array.length;// 배열 요소의 갯수
		  System.out.println(lenth); // 배열요소의 갯수
		  
		  for(int i=0;i<suja_array.length;i++) {// i=0 1 2 3 4
			  System.out.printf("suja_array[%d]:%s\n",i,suja_array[i]);
		  }
		  
		  
		  System.out.println(suja_array[2]);//배열요소 => 배열명[첨자]
		  System.out.println(suja_array[1]);
		  
		  //첨자			  0   1  2  3  4  5  6 7  8  9  10 11
		  int[] month_array= {31,28,31,30,31,30,31,31,30,31,30,31};
		  
		  int month =2;
		  System.out.printf("%d월은 %d일까지 있습니다.\n",month,month_array[month-1]);
		  
		  
		 
		
		  
		  
	}	

}
