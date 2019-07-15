package mymain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test_JDBC {
//0������ �ϴ°�
	// ����Ŭ����̹� �ε�

	static {
		// o.orcledriver loading
		// ojdvc14.jar �ݵ�� �ؾߵȴ�.
		// JDBC 50,jar or ojcbc.60 buli �߰� ������쿡�� ���̵��ȴ�.

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

		System.out.println("���Ἲ��");

		// 2.���ó����ü ������(Statement or preparedStatement)
		// ��Ȱ ��� sql����� ó���Ҽ��ִ�.
		Statement stmt = conn.createStatement();

		// String sql ="drop table TTT";
		// String sql ="insert into TTT values(100)";
		// stmt.executeUpdate(sql);

		/*
		 * USER -> DB stmt.executeUpdate(sql); <= insert.update.delete.create table ���
		 * 
		 * DB -> user stmt.executeQuery(sql) <= select ���
		 * 
		 */
		// 3. ResultSet ���
		// ��ȸ
		// String sql = "select deptno,loc,dname from dept";
		String sql = "select deptno �μ���ȣ,dname �μ���,loc ��ġ from dept";

		ResultSet rs = stmt.executeQuery(sql);

		// cursor ��ġ -> BOF ��ġ
		// ó������ ������ �ݺ��ض�...
		while (rs.next()) {
			// rs�� ��� ����Ű��������?->1���� ���ڵ�

			// �Ⱦ��°�����
			/*��
			 * int deptno = rs.getInt(1); 
			 * String dname = rs.getString(2); 
			 * String loc = rs.getString(3);
			 */
			
			/* sql1�ϰ��
			 * int deptno = rs.getInt("deptno"); 
			 * String dname = rs.getString("dname"); 
			 * String loc = rs.getString("loc");
			 */
			//sql2�ϰ��
			int deptno = rs.getInt("�μ���ȣ");
			String str_no = rs.getString("�μ���ȣ");
			String dname = rs.getString("�μ���");
			String loc = rs.getString("��ġ");
			System.out.printf("%s-%s-%s\n", str_no, dname, loc);
		}

		// 5.�ݱ� ��ȯ
		rs.close();
		stmt.close();
		conn.close();

	}

}
