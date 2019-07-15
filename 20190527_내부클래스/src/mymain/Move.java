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
		super("움직이는윈도우"); // 제목 작성

	
		// 각방향버튼 생성
		JButton leftup = new JButton("↖");
		JButton up = new JButton("↑");
		JButton rightup = new JButton("↗");

		JButton left = new JButton("←");
		JButton center = new JButton("○");
		JButton right = new JButton("→");

		JButton leftdown = new JButton("↙");
		JButton down = new JButton("↓");
		JButton rightdown = new JButton("↘");
		
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
		
		
		
		//이벤트 등록
		
		//이벤트 처리객체 생성
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			// ActionEvent :이베느를 말생시킨 컨트롤정보(누가.언제 <-정보를준다.)
			//	System.out.println(e);
			//	System.out.println(new Date(e.getWhen()));
			//	이벤트를 발생시킨 컨트롤 정보
			Object evt_ob =e.getSource();
			
			//현재윈도우의위치를 구하기
			Point pt =getLocation();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			int screen_w = d.width;
			int screen_h = d.height;
			//System.out.printf("해상도 : %d x %d\n", screen_w, screen_h);
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
			
			
			//윈도우를 이동
			setLocation(pt);
			
			}
		};
		
		//이벤트등록
		
		leftup.addActionListener(listener);
		up.addActionListener(listener);
		rightup.addActionListener(listener);

		left.addActionListener(listener);
		center.addActionListener(listener);
		right.addActionListener(listener);

		leftdown.addActionListener(listener);
		down.addActionListener(listener);
		rightdown.addActionListener(listener);
		

		
		
		
		// 위치크기 x y w h
		super.setBounds(500, 200, 300, 300);

		// 크기고정
		super.setResizable(false);

		// 화면에 보이기
		super.setVisible(true);

		// 종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	}

	public static void main(String[] args) {

		new Move();
	}

}