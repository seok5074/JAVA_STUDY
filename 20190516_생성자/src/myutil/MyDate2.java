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
		//�����̸��� �Ȱ����� this�� �����ϸ�ȵȴ�.
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
		System.out.println("���ο���Ȯ�ε� ����� : "+ this);
	}
	
}
