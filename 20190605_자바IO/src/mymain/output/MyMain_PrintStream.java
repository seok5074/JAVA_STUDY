package mymain.output;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class MyMain_PrintStream {

	public static void main(String[] args) throws Exception {

		OutputStream os = new FileOutputStream("b.txt");

		//printStream Filter
		
		PrintStream out = new PrintStream(os);
		
		out.println("안녕하세요");
		out.println(3.14);
		out.println(true);
		
		out.printf("내이름은 [%s] 나이는 %d살", "홍길동",30);
		
		out.flush();
		
		//닫기 : 열린 역순으로 
		out.close();
		os.close();
	}

}
