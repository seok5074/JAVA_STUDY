package mymain;

import javax.swing.JFrame;

public class MyWin extends JFrame {

	public MyWin() {
		super("���񹻷�����"); // ���� �ۼ�

		//��ġũ��		 x     y    w   h
		super.setBounds(500, 200, 300, 300);

		//ȭ�鿡 ���̱�
		super.setVisible(true);

		//�����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyWin();
	}

}