package mymain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class test3 {

	public static void main(String[] args) throws Exception {
		InputStream r = System.in;
		InputStreamReader reader = new InputStreamReader(r);
		BufferedReader br = new BufferedReader(reader);

		System.out.println("�Է�");
		String a = br.readLine(); // readLine�޼ҵ带 �̿��ϸ� ���ͱ⸦ �Է��� ������ �Է��ߴ� ���ڿ� ���θ� ���� �� �ְ� �˴ϴ�.
		System.out.println(a);

	}
}
