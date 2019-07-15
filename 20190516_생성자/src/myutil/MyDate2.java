package myutil;

public class MyDate2 {
	int year;
	int month;
	int day;
	
	public MyDate2() {
		
		
	}

	public MyDate2(int year, int month, int day) {
		//super();
		this.year = year;
		this.month = month;
		this.day = day;
		//변수이름이 똑같을시 this를 생략하면안된다.
	}

	public MyDate2(int year) {
		//super();
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	public void display_this() {
		System.out.println("내부에서확인된 결과값 : "+ this);
	}
	
}
