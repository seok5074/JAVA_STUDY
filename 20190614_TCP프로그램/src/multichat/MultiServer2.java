package multichat;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiServer2 extends JFrame {

	JTextArea jta_dispaly; // 서버 모니터링
	JTextField jtf_count; // 접속자수 기록

	Font font = new Font("굴림체", Font.BOLD, 20);
	
	//서버소켓
	ServerSocket server;
	

	public MultiServer2() {
		super("멀티서버"); // 제목 작성

		// 컨트롤 초기화
		init_component();

		//서버초기화
		init_server();
		
		// 위치크기 x y w h
		// super.setBounds(500, 200, 300, 300);
		setLocation(500, 200);

		pack();

		// 화면에 보이기
		super.setVisible(true);

		// 종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_server() {
//									포트
		try {
			//System.out.println(Thread.currentThread().getName());
			server = new ServerSocket(8100);
			
			//접속대기 쓰레드 할당
			new Thread() {
				public void run() {
					//System.out.println(Thread.currentThread().getName());

					while(true) {
						//접속대기
						try {
							Socket child =server.accept();
							
							
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}.start();
			
			//접속대기
			Socket child =server.accept();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void init_component() {

		// 모니터창 초기화
		jta_dispaly = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_dispaly);
		jsp.setPreferredSize(new Dimension(400, 400));
		this.add(jsp, "Center");

		// 접속자수 목록출력
		JPanel p = new JPanel(new GridLayout(1, 3));
		JLabel jlb_title = new JLabel("접속자수", JLabel.RIGHT);
		jtf_count = new JTextField("0");
		JLabel jlb_2 = new JLabel("(명)");

		p.add(jlb_title);
		p.add(jtf_count);
		p.add(jlb_2);
		this.add(p, "South");

		// 인원수 중앙정렬
		jtf_count.setHorizontalAlignment(JTextField.CENTER);

		// 폰트설정
		jta_dispaly.setFont(font);
		jlb_title.setFont(font);
		jlb_2.setFont(font);
		jtf_count.setFont(font);

		// 모니터창 읽기전용
		jta_dispaly.setEditable(false);

	}

	public static void main(String[] args) {

		new MultiServer2();
	}

}