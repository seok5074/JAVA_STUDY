package mymain;

import java.io.IOException;
import java.util.Base64;

public class MyMain_Base64 {

	public static void main(String[] args)  throws IOException{
		
		
		String pwd="1234";
		//���ڵ�
		String encoded = Base64.getEncoder().encodeToString(pwd.getBytes("utf-8"));
		
		System.out.printf("���ڵ��� : %s\n",pwd);
		System.out.printf("���ڵ���: %s\n",encoded);
		
		//���ڵ�(��ȣȭ)
		byte [] decoded = Base64.getDecoder().decode(encoded);
		String decodeStr = new String(decoded,"utf-8");
		System.out.printf("���ڵ��� : %s\n",decodeStr);
		
	}

}
