package mymain;

import javax.swing.JFrame;

public class MyWin extends JFrame {

	public MyWin() {
		super("제목뭘로하지"); // 제목 작성

		//위치크기		 x     y    w   h
		super.setBounds(500, 200, 300, 300);

		//화면에 보이기
		super.setVisible(true);

		//종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyWin();
	}

}