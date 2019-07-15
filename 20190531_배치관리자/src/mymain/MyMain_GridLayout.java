package mymain;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_GridLayout extends JFrame {

	public MyMain_GridLayout() {
		super("GridLayout"); // ���� �ۼ�

		//��ġ��������� : ��켱�� �켱������ ��ġ
		//							 ��  ��
		GridLayout gl =new GridLayout(3, 4,5,5);
		this.setLayout(gl);
		
		for(int i=0;i<12;i++) {
			JButton bt = new JButton("bt");
			this.add(bt);
		}
		
		//��ġũ��		 x     y    w   h
		super.setBounds(500, 200, 300, 300);

		//ȭ�鿡 ���̱�
		super.setVisible(true);

		//�����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyMain_GridLayout();
	}

}