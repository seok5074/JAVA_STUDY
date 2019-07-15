package mymain;

import myutil.Myutil;

public class Method2{

	public static void main(String[] args) {

		//Myutil 객체를생성
		Myutil util=new Myutil();
		int line_len=36;
		
		//선모양 변환 *---*---*
		//
		
		System.out.printf("%16s\n", "[성적관리]");
		util.draw_line(line_len,'=');
		//System.out.println("------------------------------------------");
		System.out.println("번호	이름	국어 영어 수학  총점 ");
		util.draw_line(line_len,"=");//util.draw_line();;
		System.out.println("1	일길동	 88   99   77");
		System.out.println("1	이길동	 88   99   77");
		System.out.println("1	삼길동	 88   99   77");
		util.draw_line(line_len,'*',5,'-',2);//util.draw_line();
		System.out.println();
		System.out.println("계		 290  290  241      ");
		util.draw_line(line_len);//util.draw_line();
		
		util.draw_line2(line_len,'*',1,'-',3);
		
		
		
		
	}

}
