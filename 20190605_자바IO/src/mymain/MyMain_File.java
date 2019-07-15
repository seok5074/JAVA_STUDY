package mymain;

import java.io.File;

public class MyMain_File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//    \\ => '\'
		File  f = new File("c:\\java_study\\_ABC");
		if(!f.exists()) {//�������� ������...
			System.out.println("--�������� �ʽ��ϴ�--");
			f.mkdir();//����
		}else { //�����ϸ�...
			System.out.println("--�����մϴ�--");
			f.delete();//����
		}
		
		//ȭ�ϸ�� �˻�
		File f1 = new File("c:\\jAVA");
		//�ش��������� ȭ�ϸ���� �迭�� ��ȯ
		File [] f_array = f1.listFiles();
		
		for(File ff : f_array) {
			
			//ȭ�ϸ� ���
			String name = ff.getName();
			//ȭ��ũ��
			long len = ff.length();
			
			String str="";
			
			StringBuffer sb = new StringBuffer();
			
			if(ff.isDirectory()) {
				sb.append("[D]");
				//str = String.format("[D]%s(%d bytes)\n", name,len);
			}else if(ff.isFile()) {
				sb.append("[F]");
				//str = String.format("[F]%s(%d bytes)\n", name,len);
			}
			
			if(ff.isHidden()) {
				sb.append("[H]");
				//str = String.format("[H]%s(%d bytes)\n", name,len);
			}
			
			str = String.format("%s%s(%d bytes)\n",sb.toString(), name,len);
			
			System.out.print(str);
			
		}
		
		
		
		
	}

}

