package mymain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test_JDBC {
//0순위로 하는것
	// 오라클드라이버 로딩

	static {
		// o.orcledriver loading
		// ojdvc14.jar 반드시 해야된다.
		// JDBC 50,jar or ojcbc.60 buli 추가 했을경우에는 안훠도된다.

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 1.connection
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String pwd = "test";

		Connection conn = DriverManager.getConnection(url, user, pwd);

		System.out.println("연결성공");

		// 2.명령처리객체 얻어오기(Statement or preparedStatement)
		// 역활 모든 sql명령을 처리할수있다.
		Statement stmt = conn.createStatement();

		// String sql ="drop table TTT";
		// String sql ="insert into TTT values(100)";
		// stmt.executeUpdate(sql);

		/*
		 * USER -> DB stmt.executeUpdate(sql); <= insert.update.delete.create table 사용
		 * 
		 * DB -> user stmt.executeQuery(sql) <= select 사용
		 * 
		 */
		// 3. ResultSet 사용
		// 조회
		// String sql = "select deptno,loc,dname from dept";
		String sql = "select deptno 부서번호,dname 부서명,loc 위치 from dept";

		ResultSet rs = stmt.executeQuery(sql);

		// cursor 위치 -> BOF 위치
		// 처음부터 끝까지 반복해라...
		while (rs.next()) {
			// rs는 어디를 가리키고있을까?->1개의 레코드

			// 안쓰는게좋다
			/*ㄴ
			 * int deptno = rs.getInt(1); 
			 * String dname = rs.getString(2); 
			 * String loc = rs.getString(3);
			 */
			
			/* sql1일경우
			 * int deptno = rs.getInt("deptno"); 
			 * String dname = rs.getString("dname"); 
			 * String loc = rs.getString("loc");
			 */
			//sql2일경우
			int deptno = rs.getInt("부서번호");
			String str_no = rs.getString("부서번호");
			String dname = rs.getString("부서명");
			String loc = rs.getString("위치");
			System.out.printf("%s-%s-%s\n", str_no, dname, loc);
		}

		// 5.닫기 반환
		rs.close();
		stmt.close();
		conn.close();

	}

}
