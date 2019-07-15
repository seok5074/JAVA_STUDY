package mymain.input;

import java.io.InputStream;
import java.net.URL;

public class MyMain_Network {

	public static void main(String[] args) throws Exception {

	String str_url="https://www.naver.com";
	
	URL url = new URL(str_url);
	
	//네이버 서버로부터 inputStream얻기
	InputStream is = url.openStream();
	
	
	
	int count=0;
	
	while(true) {
		int ch =is.read();
		if(ch==-1)break; //ctrl+z exit
		System.out.printf("%c",ch);
		Thread.sleep(50);
		count++;
		if(count>1000)break;
	}
	
	}

}
