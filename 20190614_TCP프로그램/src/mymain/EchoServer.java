package mymain;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws Exception {

		// 1.server 포트할당
		ServerSocket server = new ServerSocket(8000);

		System.out.println("--서버대기중...--");

		while (true) {
			// 접속대기 -> 자코켓생성 -> 연결처리..

			Socket child = server.accept();

			// 클라이언트로부터 전송된 데이터 수신
			// 1.소켓으로부터 수신스티림획득
			InputStream is = child.getInputStream();
			// 2.데이터수신
			byte[] buff = new byte[100];
			int len = is.read(buff);
			// 수신받은데이터 byte->string
			String read_msg = new String(buff, 0, len);
			System.out.printf("--수신된 데이터 %s\n", read_msg);

			
			//수신데이터를 클라이언트에게 재전송
			//클라이언트가 데이터를 보내면 아웃스트림으로 다시 재전송
			
			OutputStream os = child.getOutputStream();
			
			os.write(read_msg.getBytes());
			
			
			
			// 연결요청한 상대방 정보를 알수있다.
			//InetAddress ia = child.getInetAddress();
			//System.out.printf("--[%s]가 연결요청\n", ia.getHostAddress());
			
			
			
			

		}
	}

}
