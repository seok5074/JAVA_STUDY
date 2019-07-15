package mymain;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_FlowLayout extends JFrame {

	public MyMain_FlowLayout() {
		super("FlowLayout연습"); // 제목 작성

		//배치방법변경
		FlowLayout fl =new FlowLayout(FlowLayout.LEFT , 10 ,10);
		this.setLayout(fl);
		
		//container 윈도우 추가 : add(component);
		for(int i=1;i<=10;i++) {
			String caption = String.format("bt_%02d",i); //칸맞추기
			JButton bt1 = new JButton(caption);
			this.add(bt1);
		}
		//위치크기		 x     y    w   h
		super.setBounds(500, 200, 300, 300);

		//화면에 보이기
		super.setVisible(true);

		//종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyMain_FlowLayout();
	}

}