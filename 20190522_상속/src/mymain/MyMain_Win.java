package mymain;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MyMain_Win extends JFrame {

	int screen_w, screen_h;

	public MyMain_Win() {
		// ����â
		super("��������������");

		// ��ġ����
		super.setLocation(200, 200);

		// ȭ���ػ�
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		screen_w = d.width;
		screen_h = d.height;

		System.out.printf("�ػ� : %d x %d\n", screen_w, screen_h);

		// ũ�⼳��
		super.setSize(300, 300);

		// ũ�⺯��Ұ�
		super.setVisible(false); // ture ������ ũ�⺯�氡���ϴ�.

		// �̷��Ծ����ִ� ������ ���� frame�� �ڵ����� ã�Ƽ���. ���پ��⸸�ϸ�ȴ�.

		// ȭ�鿡 �����ֱ�
		super.setVisible(true);

		// ����
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Ű���� �̺�Ʈ
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				// System.out.println(e);
				// ����Ű������ keyevent e �����´�.
				int key = e.getKeyCode();

				// ���� ������ ��ġ ���ϱ�
				Point pt = getLocation();
				System.out.printf("x=%d y=%d\n", pt.x, pt.y);

				if (key == KeyEvent.VK_LEFT) {
					pt.x -= 10;
				} else if (key == KeyEvent.VK_RIGHT) {
					pt.x += 10;
				} else if (key == KeyEvent.VK_UP) {
					pt.y -= 10;
				} else if (key == KeyEvent.VK_DOWN) {
					pt.y += 10;
				}

				// �����츦 ���ġ
				setLocation(pt);

				/*
				 * if (pt.x == 1600) { setLocation(-300, pt.y); } 
				 * else if (pt.x == -300) {setLocation(1600, pt.y); } 
				 * else if (pt.y == 900) { setLocation(pt.x, -300); }
				 * else if (pt.y == -300) { setLocation(pt.x, 900); }
				 */
					
				if (pt.x == screen_w) {
					setLocation(-300, pt.y);
				} else if (pt.x == -300) {
					setLocation(screen_w, pt.y);
				} else if (pt.y == screen_h) {
					setLocation(pt.x, -300);
				} else if (pt.y == -300) {
					setLocation(pt.x, screen_h);
				}
			}

		});

	}

	public static void main(String[] args) {
		// �ڽ��� ��ü����
		new MyMain_Win();
	}

}
