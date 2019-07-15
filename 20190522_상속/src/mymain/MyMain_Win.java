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
		// 상태창
		super("내가만든윈도우");

		// 위치설정
		super.setLocation(200, 200);

		// 화면해상도
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		screen_w = d.width;
		screen_h = d.height;

		System.out.printf("해상도 : %d x %d\n", screen_w, screen_h);

		// 크기설정
		super.setSize(300, 300);

		// 크기변경불가
		super.setVisible(false); // ture 설정시 크기변경가능하다.

		// 이렇게쓸수있는 이유는 위에 frame이 자동으로 찾아서다. 갖다쓰기만하면된다.

		// 화면에 보여주기
		super.setVisible(true);

		// 종료
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 키보드 이벤트
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				// System.out.println(e);
				// 눌린키정보가 keyevent e 에들어온다.
				int key = e.getKeyCode();

				// 현재 윈도우 위치 구하기
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

				// 윈도우를 재배치
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
		// 자신의 객체생성
		new MyMain_Win();
	}

}
