package mymain;

import myutil.Myutil;

public class Method2{

	public static void main(String[] args) {

		//Myutil ��ü������
		Myutil util=new Myutil();
		int line_len=36;
		
		//����� ��ȯ *---*---*
		//
		
		System.out.printf("%16s\n", "[��������]");
		util.draw_line(line_len,'=');
		//System.out.println("------------------------------------------");
		System.out.println("��ȣ	�̸�	���� ���� ����  ���� ");
		util.draw_line(line_len,"=");//util.draw_line();;
		System.out.println("1	�ϱ浿	 88   99   77");
		System.out.println("1	�̱浿	 88   99   77");
		System.out.println("1	��浿	 88   99   77");
		util.draw_line(line_len,'*',5,'-',2);//util.draw_line();
		System.out.println();
		System.out.println("��		 290  290  241      ");
		util.draw_line(line_len);//util.draw_line();
		
		util.draw_line2(line_len,'*',1,'-',3);
		
		
		
		
	}

}
