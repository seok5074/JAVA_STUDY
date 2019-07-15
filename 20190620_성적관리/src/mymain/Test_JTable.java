package mymain;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Test_JTable extends JFrame {

	
	JTable  jtb_display;
	
	//JTable��ġ�� ����
	class MyTableModel extends AbstractTableModel
	{
		//                   0       1      2       3
		String [] title = {"��ȣ","�̸�","�ּ�","��ȭ��ȣ","���̵�","��й�ȣ"};
		
        //�÷� ���(Ÿ��Ʋ)
		@Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return title[column];
		}


		//�÷���������
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return title.length;
		}

		
		//�������
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 10;
		}

		
		//����ȣ�� �ǳ�? ���ȣ��?=>��x����ŭ
		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub
			String content = String.format("(%d,%d)", row,col);
			
			return content;
		}
		
	}
	
	Font  font = new Font("����ü",Font.BOLD,16);
	
	public Test_JTable() {
		// TODO Auto-generated constructor stub
		super("");//����

		//�߾ӿ� JTable��ġ
		jtb_display = new JTable();
		JScrollPane jsp = new JScrollPane(jtb_display);
		add(jsp);
		
		jtb_display.setFont(font);
		
		//��ġ�� ����
		jtb_display.setModel(new MyTableModel());
		
		
		//��ġ ũ��      x     y   w    h
		super.setBounds(500, 200, 500, 500);

		//ȭ�鿡 ���̱�
		super.setVisible(true);

		//�����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test_JTable();
	}
}