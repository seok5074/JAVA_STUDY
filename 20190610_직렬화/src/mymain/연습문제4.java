package mymain;

import java.util.Scanner;

public class ��������4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "���   1  �� 2 ���� 3   ���� 4 ����";
		Scanner scan = new Scanner(str);
		//  ���Խ�
		//  \s: ����  <= \\s�� ���������� "\"�� ���ڷ� �νĽ�Ű������
		//  \d: ����
		//  *  : 0�� �̻�
		//  ���Խ����� �и����ع��� ����
		scan.useDelimiter("\\s*\\d\\s*");
		while(scan.hasNext()) {
			System.out.print(scan.next() + "/");
		}
		
		
		
	}

}
