package mymain;

import java.sql.Connection;

import service.DBService;

public class Test_DBService {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		for(int i=0;i<10;i++)
		{
			//DBService service =new DBService();
			//DBService service = DBService.getInstance();
			//Connection conn = service.getConnection();
			
			Connection conn = DBService.getInstance().getConnection();
			
			
			if(conn!=null) {
				System.out.println("--success--");
				conn.close();
			}
			
			
		}
		
	}

}
