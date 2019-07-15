package mymain.output;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class MyMain_FileOutoutStream {

	public static void main(String[] args) throws Exception {

		OutputStream os =new FileOutputStream("a.txt");
		
		
		os.write(65);
		
		
		os.write(String.valueOf(3.14).getBytes());
		
		
		os.write(String.valueOf(true).getBytes());
		
		
		String msg ="æ»≥Á«œººø‰";
		
		
		os.write(msg.getBytes());
		
		
		os.flush();
		
		
		os.close();
		
		
		
	}

}
