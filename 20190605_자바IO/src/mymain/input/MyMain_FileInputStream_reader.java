package mymain.input;

import java.io.FileInputStream;
import java.io.InputStream;

public class MyMain_FileInputStream_reader {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        InputStream is = new FileInputStream("src/mymain/input/MyMain_FileInputStream.java");
        
        while(true) {
        	int ch = is.read();
        	if(ch==-1)break;
        	System.out.printf("%c", ch);
        	Thread.sleep(10);
        }
		
		
	}

}
