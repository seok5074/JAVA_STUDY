package mymain;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) throws Exception {

		// ��ü������ ���ÿ� �����û
		// localhost: �ڽ��� ��ǻ���� ������
		 //Socket client = new Socket("localhost", 8000);
		//Socket client = new Socket("192.168.0.28", 8000);
		Socket client = new Socket("192.168.0.19", 8000);

		
		//�۽Ÿ޽��� ���
		String msg ="...";

		//�������κ��� ���� ��Ʈ�� ȹ��
		OutputStream os = client.getOutputStream();
		
		//���� : String -> byte[]��ȯ�Ͽ� ����
		os.write(msg.getBytes());
		
		//������ ����
		InputStream is =client.getInputStream();
		byte [] buff = new byte[100];
		int len = is.read(buff);
		String read_msg = new String(buff,0,len);
		
		System.out.printf("���ڷ����� : %s\n",read_msg);
		
		
	}

}
