package mymain;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws Exception {

		// 1.server ��Ʈ�Ҵ�
		ServerSocket server = new ServerSocket(8000);

		System.out.println("--���������...--");

		while (true) {
			// ���Ӵ�� -> �����ϻ��� -> ����ó��..

			Socket child = server.accept();

			// Ŭ���̾�Ʈ�κ��� ���۵� ������ ����
			// 1.�������κ��� ���Ž�Ƽ��ȹ��
			InputStream is = child.getInputStream();
			// 2.�����ͼ���
			byte[] buff = new byte[100];
			int len = is.read(buff);
			// ���Ź��������� byte->string
			String read_msg = new String(buff, 0, len);
			System.out.printf("--���ŵ� ������ %s\n", read_msg);

			
			//���ŵ����͸� Ŭ���̾�Ʈ���� ������
			//Ŭ���̾�Ʈ�� �����͸� ������ �ƿ���Ʈ������ �ٽ� ������
			
			OutputStream os = child.getOutputStream();
			
			os.write(read_msg.getBytes());
			
			
			
			// �����û�� ���� ������ �˼��ִ�.
			//InetAddress ia = child.getInetAddress();
			//System.out.printf("--[%s]�� �����û\n", ia.getHostAddress());
			
			
			
			

		}
	}

}
