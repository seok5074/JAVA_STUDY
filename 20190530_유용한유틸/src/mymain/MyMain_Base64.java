package mymain;

import java.io.IOException;
import java.util.Base64;

public class MyMain_Base64 {

	public static void main(String[] args)  throws IOException{
		
		
		String pwd="1234";
		//인코딩
		String encoded = Base64.getEncoder().encodeToString(pwd.getBytes("utf-8"));
		
		System.out.printf("인코딩전 : %s\n",pwd);
		System.out.printf("인코딩후: %s\n",encoded);
		
		//디코딩(복호화)
		byte [] decoded = Base64.getDecoder().decode(encoded);
		String decodeStr = new String(decoded,"utf-8");
		System.out.printf("디코딩후 : %s\n",decodeStr);
		
	}

}
