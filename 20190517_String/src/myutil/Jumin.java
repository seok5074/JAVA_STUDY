package myutil;

import java.util.Calendar;

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
	
	//유효성 검사
	public boolean isValid() {
		//            01234567890123 <= index   
		//jumin_no = "901212-1234567";
		//            234567 892345  <=  
		//유효성 체크
		int sum = 0;
		// char숫자형 문자=>숫자로 바꾸기: '0':48  '1':49  '2': 50
		// ex)    '2'-'0' => 50-48=>2
		// 숫자변환방법
		//int su  = jumin_no.charAt(0)-'0';
		//int su = Integer.parseInt(jumin_no.substring(0, 0+1)); //"9"
		
		//방법1
		/*
		sum = sum + (jumin_no.charAt(0)-'0')*2;
		sum = sum + (jumin_no.charAt(1)-'0')*3;
		sum = sum + (jumin_no.charAt(2)-'0')*4;
		sum = sum + (jumin_no.charAt(3)-'0')*5;
		sum = sum + (jumin_no.charAt(4)-'0')*6;
		sum = sum + (jumin_no.charAt(5)-'0')*7;
		sum = sum + (jumin_no.charAt(7)-'0')*8;
		sum = sum + (jumin_no.charAt(8)-'0')*9;
		sum = sum + (jumin_no.charAt(9)-'0')*2;
		sum = sum + (jumin_no.charAt(10)-'0')*3;
		sum = sum + (jumin_no.charAt(11)-'0')*4;
		sum = sum + (jumin_no.charAt(12)-'0')*5;
		*/
		//방법2
		int check_su = 2;
		for(int i=0;i<=12;i++) {
			if(i==6)continue;
			sum = sum + (jumin_no.charAt(i)-'0')*check_su;
			check_su++;
			if(check_su>9)check_su=2;
		}
		
		sum = sum % 11;
		sum = 11 - sum;
		sum = sum % 10;
		
		//System.out.println("sum=" + sum);
		
		//주민번호의 마지막 숫자
		int last_no = jumin_no.charAt(13)-'0';
		
		return (sum==last_no);
	}
	
	//출생지역코드
	public String getLocal() {
		
		//	          01234567890123 <= index   
		//jumin_no = "901212-1234567";
		String str_local = jumin_no.substring(8,8+2);
		int local = Integer.parseInt(str_local);
		 
		if(local>=0 && local<=8)return "서울";
		else if(local>=9 && local<=12)return "부산";
		else if(local>=13 && local<=15)return "인천";
		else if(local>=16 && local<=25)return "경기도";

		
		return "";
	}
	
	
	//계절구하기
	public String getSeason() {
		//      	  01234567890123 <= index   
		//jumin_no = "901212-1234567";
		String str_month = jumin_no.substring(2,2+2);
		int    month = Integer.parseInt(str_month);
		switch(month/3) //<=기준값 (월/3) 으로 나눠서 체크
		{
			case 1 : return "봄";   // month: 3  4  5일경우
			case 2 : return "여름"; // month: 6  7  8일경우
			case 3 : return "가을"; // month: 9 10 11일경우
		}
		
		return "겨울";
	}
	
	//성별구하기
	public String getSex() {
		//성별자리 문자 1개 얻어오기
		char gender = jumin_no.charAt(7);
		/*
		                  1900     2000 
		  내국인 남자       1       3 
		         여자       2       4
		  
		  외국인 남자       5       7  
		         여자       6       8 
		 */
		if(gender=='1' || gender=='3' || gender=='5' || gender=='7')
			return "남자";
		
		return "여자";
	}
	
	//나이구하기
	public int getAge() {
		Calendar c = Calendar.getInstance();
		int current_year = c.get(Calendar.YEAR);
		int age = current_year - this.year + 1;
		return age;
	}
	
	//띠구하기
	public String getTti() {
		
		//return;      자신을 호출한곳으로 복귀해라
		//return 값;   자신을 호출한곳으로 값을 갖고 복귀해라.
		
		// 자 축 인 묘 진 사 오 미 신 유 술 해
		// 4  5  6  7  8  9  10 11  0  1  2  3
		
		// 출생년도%12=>0~11
		switch(this.year%12)
		{
			case  0: return "원숭이";
			case  1: return "닭";
			case  2: return "개";
			case  3: return "돼지";
			case  4: return "쥐";
			case  5: return "소";
			case  6: return "호랑이";
			case  7: return "토끼";
			case  8: return "용";
			case  9: return "뱀";
			case 10: return "말";
			case 11: return "양";
		}
		return "";
	}
	
    
	//윤년여부
	public boolean isYoon() {
		
		return (year%400==0  || (year%4==0 && year%100!=0));
	}
	
	public String getGanji() {
		String gan="";
		String ji="";
		
		//10간
		// 갑 을 병 정 무 기 경 신 임 계
		// 4  5  6  7  8  9   0  1  2  3  <= 출생년도%10
		switch(year%10)
		{
			case 0 : gan = "경";break;
			case 1 : gan = "신";break;
			case 2 : gan = "임";break;
			case 3 : gan = "계";break;
			case 4 : gan = "갑";break;
			case 5 : gan = "을";break;
			case 6 : gan = "병";break;
			case 7 : gan = "정";break;
			case 8 : gan = "무";break;
			case 9 : gan = "기";break;
		}
		//12지
		// 자 축 인 묘 진 사 오 미 신 유 술 해
	    // 4  5  6  7  8  9  10 11  0  1  2  3 <= 출생년도%12
		switch(year%12)
		{
			case  0:ji="신";break;
			case  1:ji="유";break;
			case  2:ji="술";break;
			case  3:ji="해";break;
			case  4:ji="자";break;
			case  5:ji="축";break;
			case  6:ji="인";break;
			case  7:ji="묘";break;
			case  8:ji="진";break;
			case  9:ji="사";break;
			case 10:ji="오";break;
			case 11:ji="미";break;
		}

		//System.out.printf("%s%s년",gan,ji);//오갑년
		//return gan+ji+"년";
		return String.format("%s%s년", gan,ji); //해당형식의 내용 String으로 생성
		
	}
	
	
	
	
}
