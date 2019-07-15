package mymain;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWin2 extends JFrame {

	// <- here : member선언부분...Inner class
	private void setTitleChange(String title) {
		this.setTitle(title);
	}
	
	
	class MyButtonEventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("--한국어 : 안녕하세요!!--");
			//frame title 변경 : 내부클래스에서는 외부클래스의 모든멤버를 사용할수있다.
			setTitleChange("한국어 : 안녕하세요");
		}
		
	}
	
	
	public MyWin2() {
		super(""); // 제목 작성
		
		//JButton  :swing 객체		버튼생성
		//or Button:awt 객체
		
		JButton jbt_kor = new JButton("한국어 인사말");
		JButton jbt_jap = new JButton("일본어 인사말");
		JButton jbt_chi = new JButton("중국어 인사말");
		JButton jbt_eng = new JButton("영  어 인사말");


		
		//생성된 버튼 JFrame 적재
		
		  this.add(jbt_kor); 
		  this.add(jbt_jap); 
		  this.add(jbt_chi); 
		  this.add(jbt_eng);
		 

		//적재방법 변경
		this.setLayout(new GridLayout(4,1));
		
		// 위치변경
		/*
		 * this.add(jbt_kor,"East"); 
		 * this.add(jbt_jap,"North");
		 * this.add(jbt_chi,"South"); 
		 * this.add(jbt_eng,"West");
		 */
		
		
		//이벤트등록
		//ActionListener를 사용하는 컴포넌트(컨트롤) : JButton.JMenuItem.JTimer
		ActionListener listener = new MyButtonEventHandler();
		
		//이벤트소스.addActionListener(처리객체);
		jbt_kor.addActionListener(listener);
		
		
		//
		int a; // 지역변수(local variable)
		//버튼이벤트 처리객체(로컬내부클래스)
		class MyButtonEventHandler2 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("--일본어 : こんにちは--");
				setTitleChange("일본어 : こんにちは");	
			}
		}
		//일본어 인사말 버튼 클릭시 이벤트 등록
		/*ActionListener listener_jap=new
		 *MyButtonEventHandler2(); jbt_jap.addActionListener(listener_jap);*/
		//↓축약해서쓴거
		jbt_jap.addActionListener(new MyButtonEventHandler2());
		
		//중국어인사말 버튼클릭시 처리할 객체 설계(익명 내부 클래스)
		ActionListener listener_chi =new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("--중국어 : nihao--");
				setTitleChange("중국어 : nihao");		
			}
		};
		jbt_chi.addActionListener(listener_chi);

		
		//영어인사말 버튼클릭시 이벤트 처리
		jbt_eng.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("--영  어 : Hello--");
				setTitleChange("영  어 : Hello");		
			}
		});
		
		
		//위치크기		 x     y    w   h
		super.setBounds(500, 200, 300, 300);

		//화면에 보이기
		super.setVisible(true);

		//종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyWin2();
	}

}