package mymain;

import java.io.File;

public class MyMain_File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//    \\ => '\'
		File  f = new File("c:\\java_study\\_ABC");
		if(!f.exists()) {//존재하지 않으면...
			System.out.println("--존재하지 않습니다--");
			f.mkdir();//생성
		}else { //존재하면...
			System.out.println("--존재합니다--");
			f.delete();//삭제
		}
		
		//화일목록 검색
		File f1 = new File("c:\\jAVA");
		//해당폴더밑의 화일목록을 배열로 반환
		File [] f_array = f1.listFiles();
		
		for(File ff : f_array) {
			
			//화일명 얻기
			String name = ff.getName();
			//화일크기
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

