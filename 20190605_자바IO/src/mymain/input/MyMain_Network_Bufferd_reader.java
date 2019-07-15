package mymain.input;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyMain_Network_Bufferd_reader {

	public static void main(String[] args) throws Exception {

	String str_url="https://www.naver.com";
	
	URL url = new URL(str_url);
	
	//네이버 서버로부터 inputStream얻기
	InputStream is = url.openStream();
	
	InputStreamReader isr = new InputStreamReader(is,"utf-8");

	
	int count=0;
	
	while(true) {
		int ch =isr.read();
		if(ch==-1)break; //ctrl+z exit
		System.out.printf("%c",ch);
		Thread.sleep(50);
		count++;
		if(count>1000)break;
	}
	
	}

}
