package mymain.input;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyMain_Network_reader {

	public static void main(String[] args) throws Exception {

	String str_url="https://www.naver.com";
	
	URL url = new URL(str_url);
	
	//���̹� �����κ��� inputStream���
	InputStream is = url.openStream();
	
	InputStreamReader isr = new InputStreamReader(is,"utf-8");

	//bufferdReader Filter
	BufferedReader br = new BufferedReader(isr);
	
	int line_count =0;
	while(true) {
		//int ch =br.read();
		//���پ� �о����
		String str =br.readLine();
		
		if(str==null)break; // ����������  �������Ѵ�
		
		//if(ch==-1)break; //ctrl+z exit
		System.out.println(str);
		Thread.sleep(50);
		
		line_count++;
		if(line_count>100)break;
	}
	
	}

}
