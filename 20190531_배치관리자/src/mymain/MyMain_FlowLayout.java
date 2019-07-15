package mymain;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_FlowLayout extends JFrame {

	public MyMain_FlowLayout() {
		super("FlowLayout����"); // ���� �ۼ�

		//��ġ�������
		FlowLayout fl =new FlowLayout(FlowLayout.LEFT , 10 ,10);
		this.setLayout(fl);
		
		//container ������ �߰� : add(component);
		for(int i=1;i<=10;i++) {
			String caption = String.format("bt_%02d",i); //ĭ���߱�
			JButton bt1 = new JButton(caption);
			this.add(bt1);
		}
		//��ġũ��		 x     y    w   h
		super.setBounds(500, 200, 300, 300);

		//ȭ�鿡 ���̱�
		super.setVisible(true);

		//�����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyMain_FlowLayout();
	}

}