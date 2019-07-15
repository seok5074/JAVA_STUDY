package mymain.input;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyMain_Network_reader {

	public static void main(String[] args) throws Exception {

	String str_url="https://www.naver.com";
	
	URL url = new URL(str_url);
	
	//네이버 서버로부터 inputStream얻기
	InputStream is = url.openStream();
	
	InputStreamReader isr = new InputStreamReader(is,"utf-8");

	//bufferdReader Filter
	BufferedReader br = new BufferedReader(isr);
	
	int line_count =0;
	while(true) {
		//int ch =br.read();
		//한줄씩 읽어오기
		String str =br.readLine();
		
		if(str==null)break; // 끝을만나면  끝나게한다
		
		//if(ch==-1)break; //ctrl+z exit
		System.out.println(str);
		Thread.sleep(50);
		
		line_count++;
		if(line_count>100)break;
	}
	
	}

}
