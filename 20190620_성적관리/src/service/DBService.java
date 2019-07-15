package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

	static {
		//OracleDriver 메모리에 적재
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Single-ton Pattern Code: 객체를 1개만 생성해서 서비스하도록 ...
	//자신의 객체를 참조하는 변수
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
	
	//오라클로부터 컨넥션 획득
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
