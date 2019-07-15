package myutil;

public class MyInfo {
	
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
		//			 01234567890123 <- index
		//jumin_no ="901212-1234567";
		//								start, start+count
		String str_year= jumin_no.substring(0,2); //90을때옴
		int im_year = Integer.parseInt(str_year);
		//성별자리 문자 1개 얻어오기
		char gender = jumin_no.charAt(7);
		if(gender=='1' || gender=='1' || gender=='5' || gender=='6')
			im_year = im_year+1900;
		else
			im_year = im_year+2000;
		//출생년도저장하는 변수에 넣는다.
		year=im_year;
	}
	public String getSex() {
		String gender1 = jumin_no.substring(7);
		if(gender1=="1" || gender1=="1" || 
				gender1=="5" || gender1=="6")
			gender1="남";
		else
			gender1="여";
		return gender1;		
		
	}
	
	public String getTti() {
		// return : 자신을 호출한곳으로 복귀해라
		// return : 값 자신을 호출한곳으로 값을갖기고 복귀
		switch(this.year%12)
		{
			case 0 : return "원숭이";
			case 1 : return "닭";
			case 2 : return "개";
			case 3 : return  "돼지";
			case 4 : return "쥐";
			case 5 : return "소";
			case 6 : return "호랑이";
			case 7 : return "토끼";
			case 8 : return "용";
			case 9 :  return "뱀";
			case 10 : return "말";
			case 11 : return "양";
		}
		return "";
	}
	public String getGangji() {
		String gan="";
		String ji="";
		switch(year%10)
		{
			case 4:gan="갑"; break;
			case 5:gan="을"; break;
			case 6:gan="병"; break;
			case 7:gan="정"; break;
			case 8:gan="무"; break;
			case 9:gan="기"; break;
			case 0:gan="경"; break;
			case 1:gan="신"; break;
			case 2:gan="임"; break;
			case 3:gan="계"; break;
		}
		switch(year%12)
		{
			case 4:ji="자"; break;
			case 5:ji="축"; break;
			case 6:ji="인"; break;
			case 7:ji="묘"; break;
			case 8:ji="진"; break;
			case 9:ji="사"; break;
			case 10:ji="오"; break;
			case 11:ji="미"; break;
			case 0:ji="신"; break;
			case 1:ji="유"; break;
			case 2:ji="술"; break;
			case 3:ji="해"; break;
		}		
		return String.format("%s%s년", gan,ji);// static 변수를 활용한 return 활용
		//해당형식을 내용 string으로 생성
	}
	public int getAge() {
		int age=2019-this.year+1;
		
		return age;
	}
}





/*
 * String str_month= jumin_no.substring(2,4); int im_month =
 * Integer.parseInt(str_month);
 */