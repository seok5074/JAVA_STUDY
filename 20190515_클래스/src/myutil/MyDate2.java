package myutil;

public class MyDate2 {
	
	//member field
	private int year;
	private int month;
	private int day;
	
	//member method
	//setter method
	//���� : set�ʵ��(����)
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
	//���� : get�ʵ��() -> ex)getYear()
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setDate(int year ,int month, int day) {
		//�����ڿ� ����ʵ尡 �̸��� �����ϸ�
		// �����ؼ� ǥ���ؾ��Ѵ�.
		this.year= year;
		this.month =month;
		this.day= day;
		
	}
	//�� �� ��
	public void display() {
		System.out.printf("%d-%d-%d\n",year,month,day);	
	}
	public void display2() {
			System.out.printf("%d��%02d��%d��\n",year,month,day);	
	}
	
}
