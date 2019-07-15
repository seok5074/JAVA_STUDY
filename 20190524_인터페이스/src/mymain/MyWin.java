package mymain;

import java.awt.Frame;
import java.awt.event.WindowListener;

public class MyWin extends Frame{

	public MyWin() {
		super("윈도우 이벤트 연습");
		
		//위치와 크기지정
		super.setBounds(200, 100, 300, 300);
		
		super.setVisible(true);
		
		
		WindowListener listener = new MyWindowEventListener();
		
		this.addWindowListener(listener);
		
		
		//윈도우 이벤트 등록
		//위임 이벤트 모델(event Delegation Model)
		//이벤트소스.addXxxx이벤트종류Listener(이벤트를담당하는 처리객체); <=해석
		//						처리객체는 windowListener를 implements해놓은 객체이어야한다.
		this.addWindowListener(null);
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyWin();
	}

}
