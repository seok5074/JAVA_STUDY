package mymain.output;

import java.io.IOException;
import java.io.OutputStream;

public class MyMain_Monitor {

	public static void main(String[] args) throws IOException {

		//outoutStream -> filteredOutputStream
		OutputStream os = System.out;
		//��������
		os.write(65);//write �ڵ�� �ƽ�Ű�ڵ常 ��°���
		System.out.println();
		os.write(String.valueOf(3.14).getBytes());
		System.out.println();
		os.write(String.valueOf(true).getBytes());
		System.out.println();
		String msg ="�ȳ��ϼ���";
		
		os.write(msg.getBytes());

		os.flush();
	}

}
