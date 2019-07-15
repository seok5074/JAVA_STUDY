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

	//��,����ʵ�
	JTextField  jtf_no,jtf_name,jtf_kor,jtf_eng,jtf_mat,jtf_tot,jtf_avg,jtf_rank;
	
	//�۾���ư
	JButton jbt_new,jbt_update,jbt_delete,jbt_prev,jbt_next;
	
	//��ȸ
	JTable  jtb_display;
	
	
	boolean bAdd=false;//�߰� or �����۾�����
	
	int current_pos = -1;//���� ��µǴ� ������ �ε���
	
	//DB�κ��� ������ ����list
	List<SungVo> sung_list;
		
	
	public Main_Sung() {
		// TODO Auto-generated constructor stub
		super("��������");//Ÿ��Ʋ

		
		//������ʵ� �� �۾���ư �ʱ�ȭ
		init_inputs();
		//��ȸâ �ʱ�ȭ
		init_display();
		
		//��ġ �� ũ������
		//setBounds(200, 100, 400, 300);
		setLocation(300, 100);
		setResizable(false);
		pack();
		//�������
		setVisible(true);
		//����		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���������͸� ���
		display_sung_list();
		//�����Ͱ� ������ ������ġ������ 1��°(current_pos = 0)
		if(sung_list.size()>0) {
			current_pos=0;
			//�Է�â�� ���� ������ ���
			display_sung_input();
		}
		
		my_enable_buttons();
		
		//JTable���� Ŭ���̵Ǹ�..
		init_jtable_mouse_event();
		
	}
	
	private void init_jtable_mouse_event() {
		// TODO Auto-generated method stub
		MouseAdapter adapter = new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//JTable���� ���õ� �� index����
				current_pos = jtb_display.getSelectedRow();
				display_sung_input();
			}
		};
		
		//JTable���� ���콺�� Ŭ���� �Ǹ�...
		jtb_display.addMouseListener(adapter);
		
		
	}

	private void display_sung_input() {
		// TODO Auto-generated method stub
		SungVo  vo = sung_list.get(current_pos);
		
		//vo�� ������ ���� ����Ʈ�ѿ� �ִ´�
		jtf_no.setText(vo.getNo()+"");
		jtf_name.setText(vo.getName());
		jtf_kor.setText(vo.getKor()+"");
		jtf_eng.setText(vo.getEng()+"");
		jtf_mat.setText(vo.getMat()+"");
		jtf_tot.setText(vo.getTot()+"");
		jtf_avg.setText(vo.getAvg());
		jtf_rank.setText(vo.getRank()+"");
		
		//������ġ�� ���� ����
		jtb_display.setRowSelectionInterval(current_pos, current_pos);
		
		
		
	}

	//ArrayList�� JTable�� ��ġ�� ��ġ�� ����
	class SungTableModel extends AbstractTableModel
	{
		//����
		String [] title = {"��ȣ","�̸�","����","����","����","����","���","���"};
		
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
			//row�̿��ؼ� ����� ������ü������ ���´�
			SungVo  vo = sung_list.get(row);
			
			//col�̿��ؼ� ��ä���
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
		//Dao�� �̿��ؼ� ����List������
		sung_list =  SungTBDao.getInstance().selectList();
		//JTable�� ��ġ��=>SungTableModel��� ��ġ
		jtb_display.setModel(new SungTableModel());
		
	}




	private void init_inputs() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		//�Է�â
		JPanel p1 = new JPanel(new GridLayout(4, 4));
		
		p1.add(new JLabel("�̸�:"));
		p1.add(jtf_name=new JTextField());
		
		p1.add(new JLabel("��ȣ:"));
		p1.add(jtf_no=new JTextField());
				
		
		p1.add(new JLabel("����:"));
		p1.add(jtf_kor=new JTextField());
		
		p1.add(new JLabel("����:"));
		p1.add(jtf_tot=new JTextField());
		
		p1.add(new JLabel("����:"));
		p1.add(jtf_eng=new JTextField());
		
		p1.add(new JLabel("���:"));
		p1.add(jtf_avg=new JTextField());
		
		p1.add(new JLabel("����:"));
		p1.add(jtf_mat=new JTextField());
		
		p1.add(new JLabel("���:"));
		p1.add(jtf_rank=new JTextField());
		
		
		//��ȣ ���� ��� ����� �б� ����
		jtf_no.setEditable(false);
		jtf_tot.setEditable(false);
		jtf_avg.setEditable(false);
		jtf_rank.setEditable(false);
				
		
		
		//�۾���ư
		JPanel p2 = new JPanel(new GridLayout(1, 5));
		p2.add(jbt_prev 	= new JButton("����"));
		p2.add(jbt_new 		= new JButton("�߰�"));
		p2.add(jbt_update 	= new JButton("����"));
		p2.add(jbt_delete 	= new JButton("����"));
		p2.add(jbt_next 	= new JButton("����"));
		
		
		p.add(p1,"Center");
		p.add(p2,"South");
		
		this.add(p,"Center");
		
		//��ư�̺�Ʈ �ʱ�ȭ
		init_button_event();
		
	}
	
	private void init_button_event() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�̺�Ʈ�� �߻���Ų ��ư
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
		//ó���̾ƴϸ� Ȱ��ȭ
		jbt_prev.setEnabled( bAdd==false && current_pos > 0 );
		//�������� �ƴϸ� Ȱ��ȭ
		jbt_next.setEnabled( bAdd==false && current_pos < sung_list.size()-1);
		
		//������ư Ȱ��ȭ 
		jbt_delete.setEnabled( bAdd==false && sung_list.size() > 0);
		
		//������ư Ȱ��ȭ
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
		
		//1.����Ȯ��(���������ҷ�?)
		int result = JOptionPane.showConfirmDialog(this, 
				                                   "���� �����Ͻðڽ��ϱ�?",
				                                   "����",
				                                   JOptionPane.YES_NO_OPTION);
		//�������� ������� ������..
		if(result!=JOptionPane.YES_OPTION)return;
				
		//2.������ no ������ ( delete sungtb where no= ? )
		int no = Integer.parseInt(jtf_no.getText());
		
		//4.������������ ������ ���
		if(current_pos == sung_list.size()-1)
			current_pos--;
		
		//����
		int res = SungTBDao.getInstance().delete(no);
		
		//��ü������ �о����
		display_sung_list();
		
		//������ �����Ͱ� ������ �Է�â�� ������ ���
		if(sung_list.size()>0) {
			//�Է�â ����ؾ� �� ������
			display_sung_input();
		}else {// �����Ͱ� ������=>�Է�â ����� ������ġ=-1
			clear_input();
			current_pos=-1;
		}
		
		//��ư���� ����
		my_enable_buttons();	
		
	}




	protected void on_update() {
		// TODO Auto-generated method stub
		
		//�Է°� �о����
		String name = jtf_name.getText().trim();
		String str_kor = jtf_kor.getText().trim();
		String str_eng = jtf_eng.getText().trim();
		String str_mat = jtf_mat.getText().trim();
		
		if(name.isEmpty()) {
			JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���!!");
			jtf_name.setText("");//�̸��Է�ĭ �����
			jtf_name.requestFocus();
			return;
		}
		
		if(str_kor.isEmpty()) {
			JOptionPane.showMessageDialog(this, "���������� �Է��ϼ���!!");
			jtf_kor.setText("");
			jtf_kor.requestFocus();
			return;
		}
		
		if(str_eng.isEmpty()) {
			JOptionPane.showMessageDialog(this, "���������� �Է��ϼ���!!");
			jtf_eng.setText("");
			jtf_eng.requestFocus();
			return;
		}
		
		if(str_mat.isEmpty()) {
			JOptionPane.showMessageDialog(this, "���������� �Է��ϼ���!!");
			jtf_mat.setText("");
			jtf_mat.requestFocus();
			return;
		}


		int kor,eng,mat;
		
		try {
			//���ڿ�->����
			kor = Integer.parseInt(str_kor);
			eng = Integer.parseInt(str_eng);
			mat = Integer.parseInt(str_mat);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "������ ���ڸ� �Է��ϼ���!!");
			return;
		}
				
		if(bAdd==true) { //���
			
			//����� ������ ����
			SungVo  vo = new SungVo(name, kor, eng, mat);
			
			//DB Insert
			int res = SungTBDao.getInstance().insert(vo);
			
			//��ü��� ����ϱ�
			display_sung_list();
			
			//������ġ ����: insert�� �����Ͱ� �������� ����
			current_pos = sung_list.size()-1;
			//�Է�â ����
			display_sung_input();
			
			//�۾����¸� �ʱ���·� ����
			bAdd = false;
			jbt_new.setText("�߰�");
			jbt_update.setText("����");
						
			
		}else {//����
			
			//����Ȯ��
			int result = 
					JOptionPane.showConfirmDialog(
					this, 
					"���� �����Ͻðڽ��ϱ�?",//message 
					"����",//title
					JOptionPane.YES_NO_OPTION);
			
			//��(YES_OPTION)��ư�� ������ �ʾ����� ���� ���ϰڴ�
			//System.out.println(result);
			if(result != JOptionPane.YES_OPTION) {
				//���������� �����ֱ�
				display_sung_input();
				return;
			}
			
					
			//������ ��ȣ �������
			int no = Integer.parseInt(jtf_no.getText());
			//���������� ����
			SungVo vo = new SungVo(no, name, kor, eng, mat);
			
			//DB update
			int res = SungTBDao.getInstance().update(vo);
			
			//��ü������ ����
			display_sung_list();
			
			//���������͵� ����
			display_sung_input();
						
			
		}
		
		my_enable_buttons();
		
	}




	protected void on_new() {
		// TODO Auto-generated method stub
		bAdd = !bAdd;
		
		if(bAdd==true) {//��� �����۾�
		    //�Է�â�� ��簪 �����
			clear_input();
		    
		}else {//���������� �����ֱ�
			if(current_pos!=-1)
			   display_sung_input();

		}
		
		//��ưĸ��(Ÿ��Ʋ) ����
		jbt_new.setText( bAdd ? "���" : "�߰�" );
		jbt_update.setText( bAdd ? "���" : "����");
		
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
		
		//�Է���Ŀ�� �̸��� ������ ���´�
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