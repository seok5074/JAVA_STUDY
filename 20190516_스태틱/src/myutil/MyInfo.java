package myutil;

import java.util.Calendar;

public class MyInfo {
	int year;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	//나이구하기
	public int getAge() {
		Calendar c= Calendar.getInstance();
		int current_year =c.get(Calendar.YEAR);
		int age =current_year-this.year+1;
		return age;
	}
	//띠구하기
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
	public boolean isYoon() {
		return this.year %4==0 || this.year%400==0 && this.year%100!=0;
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
}

