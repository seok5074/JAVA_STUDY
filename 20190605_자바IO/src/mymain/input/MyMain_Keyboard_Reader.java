package mymain.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_Keyboard_Reader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is =System.in;
		
		//�Է´����� char������ �ް��ؾ��Ѵ�.
		InputStreamReader isr = new InputStreamReader(is);
		
		System.out.println("���� ctrl +z");
		while(true) {
			int ch =isr.read();
			if(ch==-1)break; //ctrl+z exit
			System.out.printf("%c",ch);
		}
		System.out.println("--end--");
	}

}
