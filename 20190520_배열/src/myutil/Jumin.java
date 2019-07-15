package myutil;

public class Jumin {

	String jumin_no;
	
	int year;//출생년도
	

	public int getYear() {
		return year;
	}

	public String getJumin_no() {
		return jumin_no;
	}

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
		//            01234567890123 <= index   
		//jumin_no = "901212-1234567";
		//                                start, start+count                                          
		String str_year = jumin_no.substring(0, 0+2);// "90"
		//     String => int형변환 : "90" => 90
		int    im_year  = Integer.parseInt(str_year);
		
		//성별자리 문자 1개 얻어오기
		char gender = jumin_no.charAt(7);
		if(gender=='1' || gender=='2' || gender=='5' || gender=='6')
			im_year = im_year + 1900;
		else
			im_year = im_year + 2000;
		//출생년도저장하는 변수에 넣는다
		this.year = im_year;
		
	}
	public String getSex() {
		char gender = jumin_no.charAt(7);
		if(gender=='1' || gender=='3')
			return "남자";
		return "여자";		
	}
	public String getLocal() {
		String str_year = jumin_no.substring(8, 10);
		int    local  = Integer.parseInt(str_year);
		switch(local) {
			case 0:return "서울";
			case 1:return "경기";
			case 2:return "강원";
			case 3:return "충남";
			case 4:return "전북";
			case 5:return "경북";
			case 6:return "경남";
		}
		/*
		 * if(local>=0 && local<=8)return "서울"; else if(local >=9 && local<=12) return
		 * "경기";
		 */
		return "제주도";
	}
	public String getSeason() {
		String str_year = jumin_no.substring(2, 4);
		int    season  = Integer.parseInt(str_year);
		switch (season/3) {
			case 1:return "봄"; // month /3 = 3 4 5 경우
			case 2:return "여름"; // month /3 = 6 7 8 경우
			case 3:return "가을"; // month /3 = 9 10 11 경우
		}
		return "겨울";
	}
	
	public String getTti() {
		
		// return : 자신을 호출한곳으로 복귀해라
		// return : 값 자신을 호출한곳으로 값을갖기고 복귀
		
		String [] tti_array= { "원숭이",
							   "닭",
							   "개",
							   "돼지",
							   "쥐",
							   "소",
							   "호랑이",
							   "토끼",
							   "용",
							   "뱀",
							   "말",
							   "양"
							   };
		return tti_array[year%12];  // 배열을이용한 값계산
		
	}
	public String getGangji() {
		//배열처리법
		//10간 : year%10
		String[] gan_array= {"경","신","임","계","갑","을","병","정"
							,"무","기"};
		//12지 : year%12
		String[] ji_array= {"신","유","술","해","자","축","인","묘"
							,"진","사","오","미"};
		String gan =gan_array[year%10]; //10개중1글자
		String ji =ji_array[year%12];  //12개중1글자
		return String.format("%s%s년", gan,ji);// static 변수를 활용한 return 활용
		//해당형식을 내용 string으로 생성
	}
	public String getGanji2() {
		String gan_str ="경신임계갑을병정무기";
		String ji_str ="신유술해자축인묘진사오미";
		
		return String.format("%c%c년", gan_str.charAt(year%10),ji_str.charAt(year%12));
	}
	public boolean isValid() {
		//		              01234567890123 <= index   
		//		  jumin_no = "901212-1234567";
		//					  234567 892345 <=계산기능값
		// 유효성검사
		int sum=0;
		// char숫자형 문자 => 숫자로바꾸기
		// ex) '2'-'0' => 50-48=2 0의문자를빼면된다.
		//숫자변환방법
		//int su =jumin_no.charAt(0)-'0';
		//int su1 =Integer.parseInt(jumin_no.substring(0,0+1)); //"9"
		//기본 양식↓
		/*
		 * sum =sum+(jumin_no.charAt(0)-'0')*2; sum =sum+(jumin_no.charAt(1)-'0')*3; sum
		 * =sum+(jumin_no.charAt(2)-'0')*4; sum =sum+(jumin_no.charAt(3)-'0')*5; sum
		 * =sum+(jumin_no.charAt(4)-'0')*6; sum =sum+(jumin_no.charAt(5)-'0')*7; sum
		 * =sum+(jumin_no.charAt(7)-'0')*8; sum =sum+(jumin_no.charAt(8)-'0')*9; sum
		 * =sum+(jumin_no.charAt(9)-'0')*2; sum =sum+(jumin_no.charAt(10)-'0')*3; sum
		 * =sum+(jumin_no.charAt(11)-'0')*4; sum =sum+(jumin_no.charAt(12)-'0')*5;
		 */
	
		//for문형식↓
		/*
		int check_su=2;
		for(int i= 0;i<=12;i++) {
			if(i==6)continue; //6이면 6을무시하고 7부터 위에서 시작하는것
				sum =sum+(jumin_no.charAt(i)-'0')*check_su;
				check_su++;
				if(check_su>9)check_su=2;
			
		}
		*/
		// 방법3
		//
//        01234567890123 <= index   
//		  jumin_no = "901212-1234567";
//					  2345670892345
	//					   0 1 2 3 4 5 6 7 8 9 0 1 2
		int [] check_su = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		for(int i=0;i<=12;i++)
			sum =sum+(jumin_no.charAt(i)-'0')*check_su[i];
		
		sum =sum%11;
		sum=11-sum;
		sum =sum%10;
		
		//System.out.printf("sum= \n" + sum);
		//주민번호의 마지막숫자
		int last_no =jumin_no.charAt(13)-'0';
		
		
		return (sum==last_no);
	}
	
	public int getAge() {
		int age = 2019 - this.year + 1;
		return age;
	}


	
	
	
	
}
