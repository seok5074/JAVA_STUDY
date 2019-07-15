package mymain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class MyMain_Properties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileReader fr =null;
		
		try {
			Properties prop = new Properties();
			//���Ϸκ��� �Ӽ��б�
			fr =new FileReader("db.properties");
			prop.load(fr);
			//�Ӽ� ��� ���
			prop.list(System.out);
			
			
			
			String driver =prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String pwd = prop.getProperty("pwd");
			System.out.println("==�о�� �Ӽ���(Value)==");
			System.out.println(driver);
			System.out.println(url);
			System.out.println(user);
			System.out.println(pwd);
			System.out.println();
			
			//key �̸� ����
			System.out.println("==Enumeration�� �̿��� �Ӽ����==");

			Enumeration keys = prop.propertyNames();
			while(keys.hasMoreElements()) {
				
				String key =(String)keys.nextElement();
				//							Ű��	value
				System.out.printf("%s=%s\n",key,    prop.getProperty(key));
			}
			
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}finally {
			try {
				if(fr!=null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
