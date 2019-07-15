package mymain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TEST_JDBC_Sawon {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String pwd = "test";

		Connection conn = DriverManager.getConnection(url, user, pwd);
		System.out.println("연결확인");
		
		Statement stmt = conn.createStatement();
		String sql ="select * from sawon";
		
		ResultSet re = stmt.executeQuery(sql);
		
		while(re.next()) {
			int sabun = re.getInt("sabun");
			String saname = re.getString("saname");
			String sahire = re.getString("sahire");
			int sapay= re.getInt("sapay");
			String samgr = re.getString("samgr");
			
			System.out.printf("%d-%s-%s-%d-%s\n",sabun,saname,sahire,sapay,samgr);
		}
		re.close();
		stmt.close();
		conn.close();
	}

}
