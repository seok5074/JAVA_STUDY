package mymain;

import java.util.Scanner;

public class 연습문제4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "사과   1  배 2 수박 3   참외 4 포도";
		Scanner scan = new Scanner(str);
		//  정규식
		//  \s: 공백  <= \\s를 붙인이유는 "\"를 문자로 인식시키기위함
		//  \d: 숫자
		//  *  : 0개 이상
		//  정규식으로 분리기준문자 지정
		scan.useDelimiter("\\s*\\d\\s*");
		while(scan.hasNext()) {
			System.out.print(scan.next() + "/");
		}
		
		
		
	}

}
