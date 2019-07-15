package mymain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class test3 {

	public static void main(String[] args) throws Exception {
		InputStream r = System.in;
		InputStreamReader reader = new InputStreamReader(r);
		BufferedReader br = new BufferedReader(reader);

		System.out.println("입력");
		String a = br.readLine(); // readLine메소드를 이용하면 엔터기를 입력할 때까지 입력했던 문자열 전부를 읽을 수 있게 됩니다.
		System.out.println(a);

	}
}
