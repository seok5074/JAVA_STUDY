package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SungVo;

public class SungTBDao {

	//Single-ton Pattern Code: 객체를 1개만 생성해서 서비스하도록 ...
	//자신의 객체를 참조하는 변수
	static SungTBDao single = null;

	public static SungTBDao getInstance() {

		if (single == null)
			single = new SungTBDao();
		return single;
	}
	
	//성적데이터 조회
	public List<SungVo> selectList(){
		
		List<SungVo> list = new ArrayList<SungVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		
		String sql = "select * from sungtb_view";
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.SQL명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);
			//3.명령수행후=>결과행 처리
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
                //레코드1개 저장객체
				SungVo vo = new SungVo();
				//현재 rs의 위치(Cursor)
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name") );
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("tot"));
				vo.setAvg(rs.getString("avg"));
				vo.setRank(rs.getInt("rank"));
								
				//ArrayList추가
				list.add(vo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				//닫기(열린역순)
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//성적 추가
	public int insert(SungVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int res = 0;//                         parameter index=>       1 2 3 4
		String sql = "insert into sungtb values(seq_sungtb_no.nextVal, ?,?,?,?)";
		
		try {
			//1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			//2.SQL처리객체 얻기
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter 셋팅
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
						
			//4.DB Insert
			// res : 처리된 행수 
			res = pstmt.executeUpdate();
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return res;
		
	}

	public int update(SungVo vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int res = 0;//  parameter index=>    1     2     3    4           5 
		String sql = "update sungtb set name=?,kor=?,eng=?,mat=? where no=?";
		
		try {
			//1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			//2.SQL처리객체 얻기
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter 셋팅
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getNo());			
			//4.DB update
			// res : 처리된 행수 
			res = pstmt.executeUpdate();
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

	public int delete(int no) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int res = 0;//  parameter index=>         1  
		String sql = "delete from sungtb where no=?";
		
		try {
			//1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			//2.SQL처리객체 얻기
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter 셋팅
			pstmt.setInt(1, no);
			//4.DB delete
			// res : 처리된 행수 
			res = pstmt.executeUpdate();
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
	public SungVo selectOne(int idx) {

		SungVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.SQL명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);
			//3.명령수행후=>결과행 처리
			rs = pstmt.executeQuery();

			if (rs.next()) {
				//레코드1개 저장객체
				vo = new SungVo();
				//현재 rs의 위치(Cursor)

				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//닫기(열린역순)
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	
	
	
	
}






