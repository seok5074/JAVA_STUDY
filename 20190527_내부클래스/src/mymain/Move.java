package mymain;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.xml.crypto.Data;

public class Move extends JFrame {

	public Move() {
		super("�����̴�������"); // ���� �ۼ�

	
		// �������ư ����
		JButton leftup = new JButton("��");
		JButton up = new JButton("��");
		JButton rightup = new JButton("��");

		JButton left = new JButton("��");
		JButton center = new JButton("��");
		JButton right = new JButton("��");

		JButton leftdown = new JButton("��");
		JButton down = new JButton("��");
		JButton rightdown = new JButton("��");
		
		this.setLayout(new GridLayout(3, 3));


		this.add(leftup);
		this.add(up);
		this.add(rightup);

		this.add(left);
		this.add(center);
		this.add(right);

		this.add(leftdown);
		this.add(down);

		this.add(rightdown);
		
		
		
		//�̺�Ʈ ���
		
		//�̺�Ʈ ó����ü ����
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			// ActionEvent :�̺����� ������Ų ��Ʈ������(����.���� <-�������ش�.)
			//	System.out.println(e);
			//	System.out.println(new Date(e.getWhen()));
			//	�̺�Ʈ�� �߻���Ų ��Ʈ�� ����
			Object evt_ob =e.getSource();
			
			//��������������ġ�� ���ϱ�
			Point pt =getLocation();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			int screen_w = d.width;
			int screen_h = d.height;
			//System.out.printf("�ػ� : %d x %d\n", screen_w, screen_h);
			System.out.printf("x=%d y=%d\n", pt.x, pt.y);

			
			if(evt_ob == leftup) {
				pt.x = pt.x -10;
				pt.y = pt.y -10;
			}
			else if(evt_ob == up) {
				//System.out.println("up click");
				//System.out.println(pt);
				pt.y =pt.y-10;

			}
			else if(evt_ob == rightup) {
				pt.x = pt.x +10;
				pt.y = pt.y -10;
			}
			else if(evt_ob == left) {
				pt.x =pt.x -10;
			}
			else if(evt_ob == right) {
				pt.x =pt.x +10;
			}
			else if(evt_ob == center) {
				pt.x=screen_h/2-150;
				pt.y=screen_w/2-150;
			}
			else if(evt_ob == down) {
				pt.y=pt.y+10;
			}
			else if(evt_ob == leftdown) {
				pt.x =pt.x -10;
				pt.y=pt.y+10;
			}
			else if(evt_ob == rightdown) {
				pt.x=pt.x+10;
				pt.y=pt.y+10;
			}
			else if(pt.x == 700 && pt.y == 400) {
				pt.x=600;
				pt.y=300;
			}
			
			
			//�����츦 �̵�
			setLocation(pt);
			
			}
		};
		
		//�̺�Ʈ���
		
		leftup.addActionListener(listener);
		up.addActionListener(listener);
		rightup.addActionListener(listener);

		left.addActionListener(listener);
		center.addActionListener(listener);
		right.addActionListener(listener);

		leftdown.addActionListener(listener);
		down.addActionListener(listener);
		rightdown.addActionListener(listener);
		

		
		
		
		// ��ġũ�� x y w h
		super.setBounds(500, 200, 300, 300);

		// ũ�����
		super.setResizable(false);

		// ȭ�鿡 ���̱�
		super.setVisible(true);

		// �����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	}

	public static void main(String[] args) {

		new Move();
	}

}