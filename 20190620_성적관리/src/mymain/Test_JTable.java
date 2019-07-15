package mymain;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Test_JTable extends JFrame {

	
	JTable  jtb_display;
	
	//JTable배치모델 선언
	class MyTableModel extends AbstractTableModel
	{
		//                   0       1      2       3
		String [] title = {"번호","이름","주소","전화번호","아이디","비밀번호"};
		
        //컬럼 헤딩(타이틀)
		@Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return title[column];
		}


		//컬럼갯수지정
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return title.length;
		}

		
		//행수지정
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 10;
		}

		
		//언제호출 되나? 몇번호출?=>행x열만큼
		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub
			String content = String.format("(%d,%d)", row,col);
			
			return content;
		}
		
	}
	
	Font  font = new Font("굴림체",Font.BOLD,16);
	
	public Test_JTable() {
		// TODO Auto-generated constructor stub
		super("");//제목

		//중앙에 JTable배치
		jtb_display = new JTable();
		JScrollPane jsp = new JScrollPane(jtb_display);
		add(jsp);
		
		jtb_display.setFont(font);
		
		//배치모델 설정
		jtb_display.setModel(new MyTableModel());
		
		
		//위치 크기      x     y   w    h
		super.setBounds(500, 200, 500, 500);

		//화면에 보이기
		super.setVisible(true);

		//종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test_JTable();
	}
}