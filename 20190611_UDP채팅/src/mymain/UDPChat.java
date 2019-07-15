package mymain;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UDPChat extends JFrame {

	// 메시지 출력창
	JTextArea jta_display;

	// 주소입력창/메시지창
	JTextField jtf_address;
	JTextField jtf_message;

	// 대화명
	String nick_name = "홍길동";

	// UDP 소켓
	DatagramSocket udp_socket;

	// 폰트
	Font font = new Font("굴림체", Font.BOLD, 20);

	public UDPChat() {
		// TODO Auto-generated constructor stub
		super("UDP채팅");// 제목

		// 출력창 초기화
		init_display();

		// 입력창 초기화
		init_input();

		// 각컨트롤에 폰트지정
		jta_display.setFont(font);

		jtf_address.setFont(font);
		jtf_message.setFont(font);

		// 키이벤트 초기화
		init_key_event();

		// 소켓초기화
		init_socket();

		// 위치 크기 x y w h
		// super.setBounds(500, 200, 300, 300);
		setLocation(500, 200);

		pack();

		// 화면에 보이기
		super.setVisible(true);

		// 종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_socket() {
		// TODO Auto-generated method stub

		try {
			// 통신포트 열기
			udp_socket = new DatagramSocket(7000);

			// 메시지 수신
			read_message();

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 생성시 사용할 포트지정
	}

	private void read_message() {
		// TODO Auto-generated method stub
		/*
		 * class ReadThread extends Thread{
		 * 
		 * @Override public void run() { // TODO Auto-generated method stub while(true)
		 * { //메시지 도착시 수신..(언제) System.out.println(Thread.currentThread().getName()); }
		 * } } new ReadThread().start();
		 */

		// 익명내부클래스로 선언
		new Thread() {
			public void run() {
				while (true) {

					try {
						// 메시지 도착시 수신..(언제)
						// System.out.println(Thread.currentThread().getName());

						byte[] read_buff = new byte[512]; // 수신 버퍼
						DatagramPacket dp = new DatagramPacket(read_buff, read_buff.length);

						udp_socket.receive(dp);
						
					
						// 수신메시지
						byte[] data = dp.getData();

						// byte [] -> string 객체생성
						// read_msg = "홍길동#안녕하세요" 라고 들어온다.
						// trim 공백을없에준다. 꼭필요한 데이터만 읽어들인다.

						String read_msg = new String(data, 0, data.length).trim();

						String[] msg_array = read_msg.split("#");
						// 결과 = msg_array = {"홍길동","안녕하세요"}

						// 화면출력
						String display_message = String.format("[%s]님 말씀:\r\n   %s\r\n", msg_array[0], msg_array[1]);
						//출력창에 넣기
						jta_display.append(display_message);

						//문서의길이
						int position = jta_display.getDocument().getLength();
						//문서의 끝에 Caret을 위치시킨다
						jta_display.setCaretPosition(position);
						
						//발신자 확인
						InetAddress ia =dp.getAddress(); //메시지 전송자 ip
						System.out.printf("[%s](%s)\n",read_msg,ia.getHostAddress());
						


					} catch (IOException e) {
						e.printStackTrace();
					}
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
				// 눌린키값
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					// 메시지 전송
					send_message();
				}

			}
		};

		// 이벤트 등록
		// 이벤트소스.addKeyListener(처리객체);
		jtf_message.addKeyListener(listener);

	}

	protected void send_message() {
		// TODO Auto-generated method stub

		// 입력된 메시지 얻어오기=>공백제거
		String message = jtf_message.getText().trim();

		if (message.isEmpty()) {// 입력메시지가 없으면 끝내라..
			jtf_message.setText("");
			return;
		}

		// 있으면 전송
		// 전송데이터 패키징(포장) : 홍길동#안녕하세요
		String send_msg = String.format("%s#%s", nick_name, message);

		// 목적지주소 얻어오기
		String ip = jtf_address.getText(); // ip = 255,255,255,255
		try {

			InetAddress ia = InetAddress.getByName(ip);
			// UDP소켓에 데이터 전송은 DatagramPacket에 포장해서 전달
			byte[] send_bytes = send_msg.getBytes();
			DatagramPacket dp = new DatagramPacket(send_bytes, send_bytes.length, ia, 7000);

			// 전송
			udp_socket.send(dp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 화면에 출력
		/*
		 * String display_message = String.format("[%s]님 말씀:\r\n   %s\r\n", nick_name,
		 * message ); //출력창에 넣기 jta_display.append(display_message);
		 * 
		 * //문서의길이 int position = jta_display.getDocument().getLength(); //문서의 끝에 Caret을
		 * 위치시킨다 jta_display.setCaretPosition(position);
		 */

		// 현재입력창 비우기
		jtf_message.setText("");

	}

	// 입력창 초기화
	private void init_input() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(2, 1));
		this.add(p, "South");

		// 주소창 넣기
		p.add(jtf_address = new JTextField("255.255.255.255"));

		// 메시지 입력창 넣기
		p.add(jtf_message = new JTextField());

		// 입력창에 포커스 지정 ????
		jtf_message.requestFocus();

	}

	// 출력창 초기화
	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();// 여러줄을 입/출력하는 컨트롤

		JScrollPane jsp = new JScrollPane(jta_display);// 스크롤기능갖는 컨트롤

		// jsp크기 설정
		jsp.setPreferredSize(new Dimension(400, 500));

		this.add(jsp, "Center");

		/*
		 * // 읽기전용을 변경 jta_display.setEditable(false); String display_message =
		 * String.format("[%s]님 말씀:\r\n   %s\r\n", msg_array[0], msg_array[1]); //출력창에
		 * 넣기 jta_display.append(display_message);
		 * 
		 * //문서의길이 int position = jta_display.getDocument().getLength(); //문서의 끝에 Caret을
		 * 위치시킨다 jta_display.setCaretPosition(position);
		 */
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPChat();
	}
}