package mymain;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class test {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		String src_file = "c:\\jAVA\\��.png";  //����
		String desc_file = "c:\\jAVA\\��2.png";//����
		
		fis = new FileInputStream(src_file);  //�������� �о����
		fos = new FileOutputStream(desc_file);//�������� ����
		
		byte [] buff = new byte[1024];
		
		//��� �����Ҷ����� �ݺ�
		while(true) {
			//�б�
			int len = fis.read(buff);
			if(len==-1)break;

			System.out.println(len);
			//���������� �������Ͽ� ����
			fos.write(buff,0,len);
		}
		//�ݱ�
		fis.close();
		fos.close();
	}
	

}
