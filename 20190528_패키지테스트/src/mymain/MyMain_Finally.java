package mymain;

import java.io.FileInputStream;
import java.io.IOException;

public class MyMain_Finally {

	public static void main(String[] args) {

		
		//파일읽기 용도의 객체
		FileInputStream fis =null;
		
		
		
		try {
			fis =new FileInputStream("src/mymain/MyMain_Finally.java");
			byte [] buff = new byte[4096];
			int len = fis.read(buff);
			System.out.printf("파일크기 : %d(byte)\n",len);
			//							     시작 크기
			String readStr = new String(buff, 0,  len);
			
			System.out.println("=====내용=====");
			System.out.println(readStr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				//파일닫기
				if(fis!=null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
