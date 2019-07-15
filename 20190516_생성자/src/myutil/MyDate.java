package myutil;

import java.util.Calendar;

/*
������(�޼ҵ�)
1.��ü������ �ڵ�ȣ��
2.�ʱ�ȭ����
3.�������� : JVM�ڵ�����(�ʱ�ȭ ���ϰڴ� ����) ��������
			��.overload�� �����ڰ� �����ҽ� �⺻ �����ڷ� �ۼ��ϴ°� ����.
4.overload�� �����ϴ�.(�پ��ѹ������ ��ü�� �����Ҽ� �ִ�.)
5.����
	1.public Ŭ�����̸�() <= Ŭ�������� �޼ҵ� ����
				 		  <= ��ȯ���� ����.
	
6. this()������
 : ������ �������� ��밡��(������ ù��° ���)
 
*/
public class MyDate {
	// member field / instance ����
	// -> �ڵ��ʱ�ȭ
	// ->��ü�� ��������� �����̵ȴ�.
	// ������ : 0
	// boolean:false
	// ���������� : null
	int year;
	int month;
	int day;

	// �⺻������(default constructor)

	public MyDate() { // <- ����������
		System.out.println("--MyDate()--"); // ����ʵ� �ʱ�ȭ
		// -> 0���� �ʱ�ȭ���� 1�� �ʱ�ȭ�� ��Ű�°�
		// year = month = day = 1;
		// ����ý����� �ð������ϴ½�
		Calendar c = Calendar.getInstance();
		year=c.get(Calendar.YEAR);
		month=c.get(Calendar.MONTH)+1;
		day=c.get(Calendar.DATE); // calendar.day_of_month
	}

	// ��ü�� �ϳ��� �����ҽ� ���
	/*
	 * public MyDate(int y) 
	 * { System.out.println("--MyDate(y)--"); 
	 * year = y; 
	 * month =
	 * day = 1; }
	 */
	public MyDate(int y) {
		this(); //ȣ�� -> ��������� MyDate�� ȣ���ѰŴ�
		System.out.println("--MyDate(y)--");
		//this(); -> �������� �ڿ����� �ȵȴ�.
	 	year = y; 
	 	//month = day = 1; 
	 }
	// 2��������
	public MyDate(int y, int m) {
		this(y); // <- MyDate(int y) ȣ��
		System.out.println("--MyDate(y,m)--");
		//year = y;
		month = m;
		//day = 1;
	}

	// �����ִ����� �״�� �ʱ�ȭ�ؼ� �ްٴٴ� ��ɽ�
	public MyDate(MyDate date) {
		System.out.println("--MyDate(date)--");
		year = date.year;
		month = date.month;
		day = date.day;

	}

	// ��ü�� �����Ҷ� ���ϴ°����� ȣ�Ⱑ��
	public MyDate(int y, int m, int d) {
		System.out.println("--MyDate(y,m,d)--");
		year = y;
		month = m;
		day = d;
	}

	public void display() {
		System.out.printf("%d %d %d\n", 
				this.year, 
				this.month, 
				this.day); 
		// this�� ���������� �Ⱥٿ��� �ڹٳ����� ���������� 
		// �ڵ����� �Ѵ�.
	}

}
