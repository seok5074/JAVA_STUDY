package myutil;

public class MyDate2 {
	
	//member field
	private int year;
	private int month;
	private int day;
	
	//member method
	//setter method
	//명명법 : set필드명(인자)
	public int getYear() {
		return year;
	}
	public void setYear(int y) {
		year = y;
	}
	public void setMonth(int m) {
		month = m;
		}
	public int getMonth() {
		return month;
	}
	//getter method
	//명명법 : get필드명() -> ex)getYear()
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setDate(int year ,int month, int day) {
		//가인자와 멤버필드가 이름이 동일하면
		// 구분해서 표현해야한다.
		this.year= year;
		this.month =month;
		this.day= day;
		
	}
	//년 월 일
	public void display() {
		System.out.printf("%d-%d-%d\n",year,month,day);	
	}
	public void display2() {
			System.out.printf("%d년%02d월%d일\n",year,month,day);	
	}
	
}
