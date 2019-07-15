package mymain;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMain_BorderLayout extends JFrame {

	public MyMain_BorderLayout() {
		super("BorderLayout"); // ���� �ۼ�

		//JFrame�� �⺻ Layout BorderLayout
		
		JButton jbt_east= new JButton("East");
		JButton jbt_west= new JButton("West");
		JButton jbt_south= new JButton("South");
		JButton jbt_north= new JButton("North");
		//JButton jbt_center= new JButton("Center");
		
		//��ġ���������ϸ� �⺻��ġ�� center�̴�
		//		������Ʈ   ��ġ
		this.add(jbt_east,"East");
		this.add(jbt_west,BorderLayout.WEST); // west
		// 			��ġ, ������Ʈ
		this.add("South",jbt_south);
		this.add(BorderLayout.NORTH,jbt_north);
		//�߾�÷��
		JPanel p = new JPanel(); // container
		p.setBackground(Color.GRAY);
		this.add(p);// this.add(p,"Center");
		
		//Pannel ���� ��ư�ø���
		for(int i=1;i<=6;i++) {
			JButton bt = new JButton("bt_"+ i); //ĭ���߱�
			p.add(bt);
		}
		
		
		
		//��ġũ��		 x     y    w   h
		super.setBounds(500, 200, 300, 300);

		//ȭ�鿡 ���̱�
		super.setVisible(true);

		//�����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyMain_BorderLayout();
	}

}