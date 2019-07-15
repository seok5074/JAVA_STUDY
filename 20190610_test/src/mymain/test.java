package mymain;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class test {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		String src_file = "c:\\jAVA\\게.png";  //원본
		String desc_file = "c:\\jAVA\\게2.png";//복사
		
		fis = new FileInputStream(src_file);  //원본파일 읽어오기
		fos = new FileOutputStream(desc_file);//복사파일 생성
		
		byte [] buff = new byte[1024];
		
		//모든 복사할때까지 반복
		while(true) {
			//읽기
			int len = fis.read(buff);
			if(len==-1)break;

			System.out.println(len);
			//읽은파일을 복사파일에 저장
			fos.write(buff,0,len);
		}
		//닫기
		fis.close();
		fos.close();
	}
	

}
