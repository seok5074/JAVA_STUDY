package mymain.input;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_FileInputStream {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        InputStream is = new FileInputStream("src/mymain/input/MyMain_FileInputStream.java");
        
		InputStreamReader isr = new InputStreamReader(is);
//ÇÑ±Û
        while(true) {
        	int ch = isr.read();
        	if(ch==-1)break;
        	System.out.printf("%c", ch);
        	Thread.sleep(10);
        }
		
		
	}

}
