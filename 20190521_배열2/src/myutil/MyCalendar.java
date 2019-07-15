package myutil;

import java.util.Calendar;

public class MyCalendar {

	// 매월의 마지막날을 기록해주는역할 <= index = month-1
	int[] month_array = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	int[][] cal_array;
	int year, month;

	public void setDate(int year, int month) {
		this.year = year;
		this.month = month;

		

		if (isYoon())
			month_array[1] = 29;
		else
			month_array[1] = 28;
		// 달력생성하는 메소드
		make_calendar();
	}

	private boolean isYoon() {
		return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0);
	}

	private void make_calendar() {
		cal_array = new int[6][7];
		
		int yoil; // 열첨자 로 사용
		int week=0; // 행첨자 로 사용
		
		// 요일첨자 구하기
		Calendar c = Calendar.getInstance();
		c.set(year,month-1,1);
		yoil =c.get(Calendar.DAY_OF_WEEK)-1;
		
		int yoil1=yoil-1;
		int last_day=((month-2)<0) ? month_array[11] : month_array[month-2];
		for(int i=last_day;true;i--) {
			cal_array[week][yoil1]=i;
			yoil1--;
			if(yoil1<0) break;
		}

		/*
		 * int yoil2=yoil+1; for(int k=month_array[month+2];k>=31;k++) {
		 * cal_array[week][yoil2]=k; yoil2++; if(yoil2>0) break; }
		 */
		
		//달력채우기
		for(int i=1;i<=month_array[month-1];i++) {
			cal_array[week][yoil]=i;
			yoil++; //다음칸이동한다
			if(yoil>6) {
				week++;
				yoil=0;
			}
		}
		//현재월 마지막 다음칸에 위치(Week.yoil)
		int su=1;
		while(true){
			cal_array[week][yoil] =su++;
			yoil++; //다음칸이동한다
			if(yoil>6) {
				week++;
				//끝까지 채우면은.
				if(week>5)break;
				
				yoil=0;
			}
		}
	}
	

	public void display() {
		System.out.printf("%15d년 %02d월\n", year, month);
		String[] title = { "SUN", "MON", "TUE", "WED","THR", "FRI", "SAT" };
		for (int i = 0; i < title.length; i++)
			System.out.printf("%4s", title[i]);
		System.out.println();
		for (int i = 0; i < cal_array.length; i++) {
			for (int k = 0; k < cal_array[i].length; k++) {
				System.out.printf("%4d", cal_array[i][k]);

			}
			System.out.println();
		}
	}

}
