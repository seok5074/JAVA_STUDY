package mymain;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import dao.SungTBDao;
import vo.SungVo;

public class Main_Sung extends JFrame {

	//입,출력필드
	JTextField  jtf_no,jtf_name,jtf_kor,jtf_eng,jtf_mat,jtf_tot,jtf_avg,jtf_rank;
	
	//작업버튼
	JButton jbt_new,jbt_update,jbt_delete,jbt_prev,jbt_next;
	
	//조회
	JTable  jtb_display;
	
	
	boolean bAdd=false;//추가 or 수정작업여부
	
	int current_pos = -1;//현재 출력되는 데이터 인덱스
	
	//DB로부터 가져온 성적list
	List<SungVo> sung_list;
		
	
	public Main_Sung() {
		// TODO Auto-generated constructor stub
		super("성적관리");//타이틀

		
		//입출력필드 및 작업버튼 초기화
		init_inputs();
		//조회창 초기화
		init_display();
		
		//위치 및 크기지정
		//setBounds(200, 100, 400, 300);
		setLocation(300, 100);
		setResizable(false);
		pack();
		//보여줘라
		setVisible(true);
		//종료		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//성적데이터를 출력
		display_sung_list();
		//데이터가 있으면 현재위치정보를 1번째(current_pos = 0)
		if(sung_list.size()>0) {
			current_pos=0;
			//입력창에 현재 데이터 출력
			display_sung_input();
		}
		
		my_enable_buttons();
		
		//JTable에서 클릭이되면..
		init_jtable_mouse_event();
		
	}
	
	private void init_jtable_mouse_event() {
		// TODO Auto-generated method stub
		MouseAdapter adapter = new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//JTable에서 선택된 행 index구함
				current_pos = jtb_display.getSelectedRow();
				display_sung_input();
			}
		};
		
		//JTable에서 마우스가 클릭이 되면...
		jtb_display.addMouseListener(adapter);
		
		
	}

	private void display_sung_input() {
		// TODO Auto-generated method stub
		SungVo  vo = sung_list.get(current_pos);
		
		//vo의 각각의 값을 각컨트롤에 넣는다
		jtf_no.setText(vo.getNo()+"");
		jtf_name.setText(vo.getName());
		jtf_kor.setText(vo.getKor()+"");
		jtf_eng.setText(vo.getEng()+"");
		jtf_mat.setText(vo.getMat()+"");
		jtf_tot.setText(vo.getTot()+"");
		jtf_avg.setText(vo.getAvg());
		jtf_rank.setText(vo.getRank()+"");
		
		//현재위치의 행을 선택
		jtb_display.setRowSelectionInterval(current_pos, current_pos);
		
		
		
	}

	//ArrayList를 JTable에 배치할 배치모델 선언
	class SungTableModel extends AbstractTableModel
	{
		//제목
		String [] title = {"번호","이름","국어","영어","수학","총점","평균","등수"};
		
		@Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return title[column];
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return title.length;
		}

		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return sung_list.size();
		}

		
		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub
			//row이용해서 출력할 성적객체정보을 얻어온다
			SungVo  vo = sung_list.get(row);
			
			//col이용해서 열채우기
			switch(col)
			{
			   case  0 : return vo.getNo();
			   case  1 : return vo.getName();
			   case  2 : return vo.getKor();
			   case  3 : return vo.getEng();
			   case  4 : return vo.getMat();
			   case  5 : return vo.getTot();
			   case  6 : return vo.getAvg();
			   case  7 : return vo.getRank();
			}
			return null;
		}
	}

	

	private void display_sung_list() {
		// TODO Auto-generated method stub
		//Dao을 이용해서 성적List가져옴
		sung_list =  SungTBDao.getInstance().selectList();
		//JTable의 배치모델=>SungTableModel대로 배치
		jtb_display.setModel(new SungTableModel());
		
	}




	private void init_inputs() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		//입력창
		JPanel p1 = new JPanel(new GridLayout(4, 4));
		
		p1.add(new JLabel("이름:"));
		p1.add(jtf_name=new JTextField());
		
		p1.add(new JLabel("번호:"));
		p1.add(jtf_no=new JTextField());
				
		
		p1.add(new JLabel("국어:"));
		p1.add(jtf_kor=new JTextField());
		
		p1.add(new JLabel("총점:"));
		p1.add(jtf_tot=new JTextField());
		
		p1.add(new JLabel("영어:"));
		p1.add(jtf_eng=new JTextField());
		
		p1.add(new JLabel("평균:"));
		p1.add(jtf_avg=new JTextField());
		
		p1.add(new JLabel("수학:"));
		p1.add(jtf_mat=new JTextField());
		
		p1.add(new JLabel("등수:"));
		p1.add(jtf_rank=new JTextField());
		
		
		//번호 총점 평균 등수는 읽기 전용
		jtf_no.setEditable(false);
		jtf_tot.setEditable(false);
		jtf_avg.setEditable(false);
		jtf_rank.setEditable(false);
				
		
		
		//작업버튼
		JPanel p2 = new JPanel(new GridLayout(1, 5));
		p2.add(jbt_prev 	= new JButton("이전"));
		p2.add(jbt_new 		= new JButton("추가"));
		p2.add(jbt_update 	= new JButton("수정"));
		p2.add(jbt_delete 	= new JButton("삭제"));
		p2.add(jbt_next 	= new JButton("다음"));
		
		
		p.add(p1,"Center");
		p.add(p2,"South");
		
		this.add(p,"Center");
		
		//버튼이벤트 초기화
		init_button_event();
		
	}
	
	private void init_button_event() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//이벤트를 발생시킨 버튼
				Object evt_src = e.getSource();
				
				if(evt_src ==  jbt_new) on_new();
				else if(evt_src ==  jbt_update) on_update();
				else if(evt_src ==  jbt_delete) on_delete();
				else if(evt_src ==  jbt_prev) on_prev();
				else if(evt_src ==  jbt_next) on_next();
				
			}
		};
		
		jbt_new.addActionListener(listener);
		jbt_update.addActionListener(listener);
		jbt_delete.addActionListener(listener);
		jbt_prev.addActionListener(listener);
		jbt_next.addActionListener(listener);
		
		
	}




	protected void on_next() {
		// TODO Auto-generated method stub
		current_pos++;
		display_sung_input();
		
		my_enable_buttons();
				
	}


	private void my_enable_buttons() {
		// TODO Auto-generated method stub
		//처음이아니면 활성화
		jbt_prev.setEnabled( bAdd==false && current_pos > 0 );
		//마지막이 아니면 활성화
		jbt_next.setEnabled( bAdd==false && current_pos < sung_list.size()-1);
		
		//삭제버튼 활성화 
		jbt_delete.setEnabled( bAdd==false && sung_list.size() > 0);
		
		//수정버튼 활성화
		jbt_update.setEnabled( bAdd==true || sung_list.size() > 0);
		
		
	}

	protected void on_prev() {
		// TODO Auto-generated method stub
		current_pos--;
		display_sung_input();
		
		my_enable_buttons();
		
	}




	protected void on_delete() {
		// TODO Auto-generated method stub
		
		//1.삭제확인(정말삭제할래?)
		int result = JOptionPane.showConfirmDialog(this, 
				                                   "정말 삭제하시겠습니까?",
				                                   "삭제",
				                                   JOptionPane.YES_NO_OPTION);
		//삭제하지 않을경우 끝내라..
		if(result!=JOptionPane.YES_OPTION)return;
				
		//2.삭제할 no 얻어오기 ( delete sungtb where no= ? )
		int no = Integer.parseInt(jtf_no.getText());
		
		//4.마지막데이터 삭제할 경우
		if(current_pos == sung_list.size()-1)
			current_pos--;
		
		//삭제
		int res = SungTBDao.getInstance().delete(no);
		
		//전체데이터 읽어오기
		display_sung_list();
		
		//삭제후 데이터가 있으면 입력창에 데이터 출력
		if(sung_list.size()>0) {
			//입력창 출력해야 할 데이터
			display_sung_input();
		}else {// 데이터가 없으면=>입력창 지우고 현재위치=-1
			clear_input();
			current_pos=-1;
		}
		
		//버튼상태 변경
		my_enable_buttons();	
		
	}




	protected void on_update() {
		// TODO Auto-generated method stub
		
		//입력값 읽어오기
		String name = jtf_name.getText().trim();
		String str_kor = jtf_kor.getText().trim();
		String str_eng = jtf_eng.getText().trim();
		String str_mat = jtf_mat.getText().trim();
		
		if(name.isEmpty()) {
			JOptionPane.showMessageDialog(this, "이름을 입력하세요!!");
			jtf_name.setText("");//이름입력칸 지우기
			jtf_name.requestFocus();
			return;
		}
		
		if(str_kor.isEmpty()) {
			JOptionPane.showMessageDialog(this, "국어점수를 입력하세요!!");
			jtf_kor.setText("");
			jtf_kor.requestFocus();
			return;
		}
		
		if(str_eng.isEmpty()) {
			JOptionPane.showMessageDialog(this, "영어점수를 입력하세요!!");
			jtf_eng.setText("");
			jtf_eng.requestFocus();
			return;
		}
		
		if(str_mat.isEmpty()) {
			JOptionPane.showMessageDialog(this, "수학점수를 입력하세요!!");
			jtf_mat.setText("");
			jtf_mat.requestFocus();
			return;
		}


		int kor,eng,mat;
		
		try {
			//문자열->정수
			kor = Integer.parseInt(str_kor);
			eng = Integer.parseInt(str_eng);
			mat = Integer.parseInt(str_mat);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "점수는 숫자만 입력하세요!!");
			return;
		}
				
		if(bAdd==true) { //등록
			
			//등록할 데이터 포장
			SungVo  vo = new SungVo(name, kor, eng, mat);
			
			//DB Insert
			int res = SungTBDao.getInstance().insert(vo);
			
			//전체목록 출력하기
			display_sung_list();
			
			//현재위치 설정: insert된 데이터가 마지막에 저장
			current_pos = sung_list.size()-1;
			//입력창 보기
			display_sung_input();
			
			//작업상태를 초기상태로 변경
			bAdd = false;
			jbt_new.setText("추가");
			jbt_update.setText("수정");
						
			
		}else {//수정
			
			//수정확인
			int result = 
					JOptionPane.showConfirmDialog(
					this, 
					"정말 수정하시겠습니까?",//message 
					"수정",//title
					JOptionPane.YES_NO_OPTION);
			
			//예(YES_OPTION)버튼이 눌리지 않았으면 수정 안하겠다
			//System.out.println(result);
			if(result != JOptionPane.YES_OPTION) {
				//원래데이터 보여주기
				display_sung_input();
				return;
			}
			
					
			//수정할 번호 얻오오기
			int no = Integer.parseInt(jtf_no.getText());
			//수정데이터 포장
			SungVo vo = new SungVo(no, name, kor, eng, mat);
			
			//DB update
			int res = SungTBDao.getInstance().update(vo);
			
			//전체데이터 갱신
			display_sung_list();
			
			//수정데이터도 갱신
			display_sung_input();
						
			
		}
		
		my_enable_buttons();
		
	}




	protected void on_new() {
		// TODO Auto-generated method stub
		bAdd = !bAdd;
		
		if(bAdd==true) {//등록 예비작업
		    //입력창의 모든값 지우기
			clear_input();
		    
		}else {//원래데이터 보여주기
			if(current_pos!=-1)
			   display_sung_input();

		}
		
		//버튼캡션(타이틀) 변경
		jbt_new.setText( bAdd ? "취소" : "추가" );
		jbt_update.setText( bAdd ? "등록" : "수정");
		
		my_enable_buttons();
		
	}




	private void clear_input() {
		// TODO Auto-generated method stub
		jtf_no.setText("");
		jtf_name.setText("");
		jtf_kor.setText("");
		jtf_eng.setText("");
		jtf_mat.setText("");
		jtf_tot.setText("");
		jtf_avg.setText("");
		jtf_rank.setText("");
		
		//입력포커스 이름에 가져다 놓는다
		jtf_name.requestFocus();
				
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jtb_display = new JTable();
		JScrollPane  jsp = new JScrollPane(jtb_display);
		
		jsp.setPreferredSize(new Dimension(400, 200));
		
		this.add(jsp,"South");
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main_Sung();
	}

}