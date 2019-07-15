package mymain;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UDPChat1 extends JFrame {

	// 메시지 출력창
	JTextArea jta_display;

	// 주소입력창
	JTextField jtf_address;
	JTextField jtf_message;

	// 대화명
	String nick_name = "홍길동";

	// udp 소켓
	DatagramSocket udp_socket;

	// 폰트설정
	Font font = new Font("굴림체", Font.BOLD, 20);

	public UDPChat1() {
		super("UDPCHAT"); // 제목 작성

		// 출력창 초기화
		init_display();

		// 입력창 초기화
		init_input();

		// 각 컨트롤에 폰트지정
		jta_display.setFont(font);

		jtf_address.setFont(font);
		jtf_message.setFont(font);

		// 키이벤트 초기화
		init_key_event();

		// 소켓 초기화
		init_socket();

		// 위치크기 x y w h
		// super.setBounds(500, 200, 300, 300);
		setLocation(500, 200);

		pack();

		// 화면에 보이기
		super.setVisible(true);

		// 종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_socket() {
		try {
			// 통신포트 열기
			udp_socket = new DatagramSocket(7000);// 생성시 사용할 포트지정

			// 메시지 수신
			read_message();
		} catch (SocketException e) {
			e.printStackTrace();
		}

	}

	private void read_message() {
		/*
		 * class ReadThread extends Thread{
		 * 
		 * @Override public void run() {
		 * 
		 * super.run(); } } new ReadThread().start(); ↓동일방법이다.
		 */
		// 익명내부클래스로 선언
		new Thread() {
			public void run() {
				while (true) {
					// 메시지 도착시 수신 (언제 도착할지 모르니 대기해야한다.)
					System.out.println(Thread.currentThread().getName());
				}
			}
		}.start();

	}

	private void init_key_event() {
		// TODO Auto-generated method stub
		KeyListener listener = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					// 메시지 전송
					send_message();
				}
			}

		};
		// 이벤트 등록
		// 이벤트 소스. addkey/listener(처리객체)
		jtf_message.addKeyListener(listener);
	}

	protected void send_message() {
		// 입력된 메시지 얻어오기
		String message = jtf_message.getText().trim();
		if (message.isEmpty()) {// 입력메시지가 없으면 끝내라
			jtf_message.setText("");

			return;
		}

		// 있으면 전송(나중에)

		// 화면에 출력
		String display_message = String.format("[%s]님 말씀 :\r\n %s\n", nick_name, message);

		// 출력창에 넣기
		jta_display.append(display_message);

		// 문서의 길이
		int position = jta_display.getDocument().getLength();

		// 문서의 끝에 caret을 위치시킨다,
		jta_display.setCaretPosition(position);

		// go현재 입려창 바꾸기
		jtf_message.setText("");

	}

	// 입력창 초기화
	private void init_input() {
		JPanel p = new JPanel(new GridLayout(2, 1));
		this.add(p, "South");

		// 주소창 입력
		p.add(jtf_address = new JTextField("255,255,255,255"));
		// 메세지 입력창 넣기
		p.add(jtf_message = new JTextField());

		//입력창에 포커스 집어넣기 
		jtf_message.requestFocus();
		
	}

	// 출력창 초기화
	private void init_display() {

		jta_display = new JTextArea(); // 여러줄을 입 출력하는 컨트롤
		JScrollPane jsp = new JScrollPane(jta_display);

		// JScrollPane 크기 설정
		jsp.setPreferredSize(new Dimension(400, 500));

		this.add(jsp, "Center");

		// 읽기전용으로 변경
		jta_display.setEditable(false);
	}

	public static void main(String[] args) {

		new UDPChat1();
	}

}
