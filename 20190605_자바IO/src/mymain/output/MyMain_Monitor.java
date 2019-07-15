package mymain.output;

import java.io.IOException;
import java.io.OutputStream;

public class MyMain_Monitor {

	public static void main(String[] args) throws IOException {

		//outoutStream -> filteredOutputStream
		OutputStream os = System.out;
		//모니터출력
		os.write(65);//write 코드는 아스키코드만 출력가능
		System.out.println();
		os.write(String.valueOf(3.14).getBytes());
		System.out.println();
		os.write(String.valueOf(true).getBytes());
		System.out.println();
		String msg ="안녕하세요";
		
		os.write(msg.getBytes());

		os.flush();
	}

}
