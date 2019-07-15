package mymain;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_GridLayout extends JFrame {

	public MyMain_GridLayout() {
		super("GridLayout"); // 제목 작성

		//배치방법을변경 : 행우선을 우선적으로 배치
		//							 행  열
		GridLayout gl =new GridLayout(3, 4,5,5);
		this.setLayout(gl);
		
		for(int i=0;i<12;i++) {
			JButton bt = new JButton("bt");
			this.add(bt);
		}
		
		//위치크기		 x     y    w   h
		super.setBounds(500, 200, 300, 300);

		//화면에 보이기
		super.setVisible(true);

		//종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyMain_GridLayout();
	}

}