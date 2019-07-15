package mymain;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMain_BorderLayout extends JFrame {

	public MyMain_BorderLayout() {
		super("BorderLayout"); // 제목 작성

		//JFrame은 기본 Layout BorderLayout
		
		JButton jbt_east= new JButton("East");
		JButton jbt_west= new JButton("West");
		JButton jbt_south= new JButton("South");
		JButton jbt_north= new JButton("North");
		//JButton jbt_center= new JButton("Center");
		
		//위치지정을안하면 기본위치는 center이다
		//		컴포넌트   위치
		this.add(jbt_east,"East");
		this.add(jbt_west,BorderLayout.WEST); // west
		// 			위치, 컴포넌트
		this.add("South",jbt_south);
		this.add(BorderLayout.NORTH,jbt_north);
		//중앙첨부
		JPanel p = new JPanel(); // container
		p.setBackground(Color.GRAY);
		this.add(p);// this.add(p,"Center");
		
		//Pannel 위에 버튼올리기
		for(int i=1;i<=6;i++) {
			JButton bt = new JButton("bt_"+ i); //칸맞추기
			p.add(bt);
		}
		
		
		
		//위치크기		 x     y    w   h
		super.setBounds(500, 200, 300, 300);

		//화면에 보이기
		super.setVisible(true);

		//종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyMain_BorderLayout();
	}

}