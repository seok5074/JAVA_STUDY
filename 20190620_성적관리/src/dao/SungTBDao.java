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

	//Single-ton Pattern Code: ��ü�� 1���� �����ؼ� �����ϵ��� ...
	//�ڽ��� ��ü�� �����ϴ� ����
	static SungTBDao single = null;

	public static SungTBDao getInstance() {

		if (single == null)
			single = new SungTBDao();
		return single;
	}
	
	//���������� ��ȸ
	public List<SungVo> selectList(){
		
		List<SungVo> list = new ArrayList<SungVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		
		String sql = "select * from sungtb_view";
		
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.SQL���ó����ü ������
			pstmt = conn.prepareStatement(sql);
			//3.��ɼ�����=>����� ó��
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
                //���ڵ�1�� ���尴ü
				SungVo vo = new SungVo();
				//���� rs�� ��ġ(Cursor)
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name") );
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("tot"));
				vo.setAvg(rs.getString("avg"));
				vo.setRank(rs.getInt("rank"));
								
				//ArrayList�߰�
				list.add(vo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				//�ݱ�(��������)
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
	
	//���� �߰�
	public int insert(SungVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int res = 0;//                         parameter index=>       1 2 3 4
		String sql = "insert into sungtb values(seq_sungtb_no.nextVal, ?,?,?,?)";
		
		try {
			//1.Connection ���
			conn = DBService.getInstance().getConnection();
			//2.SQLó����ü ���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter ����
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
						
			//4.DB Insert
			// res : ó���� ��� 
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
			//1.Connection ���
			conn = DBService.getInstance().getConnection();
			//2.SQLó����ü ���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter ����
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getNo());			
			//4.DB update
			// res : ó���� ��� 
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
			//1.Connection ���
			conn = DBService.getInstance().getConnection();
			//2.SQLó����ü ���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter ����
			pstmt.setInt(1, no);
			//4.DB delete
			// res : ó���� ��� 
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
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.SQL���ó����ü ������
			pstmt = conn.prepareStatement(sql);
			//3.��ɼ�����=>����� ó��
			rs = pstmt.executeQuery();

			if (rs.next()) {
				//���ڵ�1�� ���尴ü
				vo = new SungVo();
				//���� rs�� ��ġ(Cursor)

				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//�ݱ�(��������)
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






