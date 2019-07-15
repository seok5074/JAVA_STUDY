package myutil;

import java.util.Calendar;

/*
생성자(메소드)
1.객체생성시 자동호출
2.초기화목적
3.생략가능 : JVM자동생성(초기화 안하겠는 의지) 가능은함
			단.overload된 생성자가 존재할시 기본 생성자로 작성하는게 좋다.
4.overload가 가능하다.(다양한방법으로 객체를 생성할수 있다.)
5.형식
	1.public 클래스이름() <= 클래스명의 메소드 형식
				 		  <= 반환형이 없다.
	
6. this()생성자
 : 생성자 내에서만 사용가능(무조건 첫번째 명령)
 
*/
public class MyDate {
	// member field / instance 변수
	// -> 자동초기화
	// ->객체가 만들어지면 생성이된다.
	// 숫자형 : 0
	// boolean:false
	// 참조형변수 : null
	int year;
	int month;
	int day;

	// 기본생성자(default constructor)

	public MyDate() { // <- 생성자형식
		System.out.println("--MyDate()--"); // 멤버필드 초기화
		// -> 0으로 초기화보단 1로 초기화를 시키는것
		// year = month = day = 1;
		// 현재시스템의 시간을구하는식
		Calendar c = Calendar.getInstance();
		year=c.get(Calendar.YEAR);
		month=c.get(Calendar.MONTH)+1;
		day=c.get(Calendar.DATE); // calendar.day_of_month
	}

	// 객체를 하나만 수정할시 사용
	/*
	 * public MyDate(int y) 
	 * { System.out.println("--MyDate(y)--"); 
	 * year = y; 
	 * month =
	 * day = 1; }
	 */
	public MyDate(int y) {
		this(); //호출 -> 결과적으로 MyDate를 호출한거다
		System.out.println("--MyDate(y)--");
		//this(); -> 어떤명려보다 뒤에오면 안된다.
	 	year = y; 
	 	//month = day = 1; 
	 }
	// 2개를수정
	public MyDate(int y, int m) {
		this(y); // <- MyDate(int y) 호출
		System.out.println("--MyDate(y,m)--");
		//year = y;
		month = m;
		//day = 1;
	}

	// 먼저있던값을 그대로 초기화해서 받겟다는 명령식
	public MyDate(MyDate date) {
		System.out.println("--MyDate(date)--");
		year = date.year;
		month = date.month;
		day = date.day;

	}

	// 객체를 생성할때 원하는값으로 호출가능
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
		// this를 생략한이유 안붙여도 자바내에서 생략참조를 
		// 자동으로 한다.
	}

}
