package mymain;

import java.io.FileInputStream;
import java.io.IOException;

public class MyMain_Finally {

	public static void main(String[] args) {

		
		//�����б� �뵵�� ��ü
		FileInputStream fis =null;
		
		
		
		try {
			fis =new FileInputStream("src/mymain/MyMain_Finally.java");
			byte [] buff = new byte[4096];
			int len = fis.read(buff);
			System.out.printf("����ũ�� : %d(byte)\n",len);
			//							     ���� ũ��
			String readStr = new String(buff, 0,  len);
			
			System.out.println("=====����=====");
			System.out.println(readStr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				//���ϴݱ�
				if(fis!=null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
