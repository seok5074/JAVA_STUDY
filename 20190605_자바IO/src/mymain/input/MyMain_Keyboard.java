package mymain.input;

import java.io.IOException;
import java.io.InputStream;

public class MyMain_Keyboard {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is =System.in;
		
		System.out.println("Á¾·á ctrl +z");
		while(true) {
			int ch =is.read();
			if(ch==-1)break; //ctrl+z exit
			System.out.printf("%c",ch);
		}
		System.out.println("--end--");
	}

}
