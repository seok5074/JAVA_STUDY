package mymain.output;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class MyMain_PrintStream {

	public static void main(String[] args) throws Exception {

		OutputStream os = new FileOutputStream("b.txt");

		//printStream Filter
		
		PrintStream out = new PrintStream(os);
		
		out.println("�ȳ��ϼ���");
		out.println(3.14);
		out.println(true);
		
		out.printf("���̸��� [%s] ���̴� %d��", "ȫ�浿",30);
		
		out.flush();
		
		//�ݱ� : ���� �������� 
		out.close();
		os.close();
	}

}
