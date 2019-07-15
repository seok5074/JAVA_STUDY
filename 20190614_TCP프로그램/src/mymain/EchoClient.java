package mymain;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) throws Exception {

		// 객체생성과 동시에 연결요청
		// localhost: 자신의 컴퓨터의 도메인
		 //Socket client = new Socket("localhost", 8000);
		//Socket client = new Socket("192.168.0.28", 8000);
		Socket client = new Socket("192.168.0.19", 8000);

		
		//송신메시지 출력
		String msg ="...";

		//소켓으로부터 전송 스트림 획득
		OutputStream os = client.getOutputStream();
		
		//전송 : String -> byte[]변환하여 전송
		os.write(msg.getBytes());
		
		//데이터 수신
		InputStream is =client.getInputStream();
		byte [] buff = new byte[100];
		int len = is.read(buff);
		String read_msg = new String(buff,0,len);
		
		System.out.printf("에코레이터 : %s\n",read_msg);
		
		
	}

}
