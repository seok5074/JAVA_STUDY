package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

	static {
		//OracleDriver �޸𸮿� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Single-ton Pattern Code: ��ü�� 1���� �����ؼ� �����ϵ��� ...
	//�ڽ��� ��ü�� �����ϴ� ����
	static DBService  single=null;
	
	public static DBService getInstance() {
		
		if(single==null)
			single = new DBService();
		return single;
	}
	
	private DBService() {
		// TODO Auto-generated constructor stub
		//System.out.println("--DBService()--");
	}
	
	//����Ŭ�κ��� ���ؼ� ȹ��
	public Connection getConnection() {
		Connection conn = null;
		
		String url  = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String pwd  = "test";
		
		try {
			
			conn = DriverManager.getConnection(url, user, pwd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
