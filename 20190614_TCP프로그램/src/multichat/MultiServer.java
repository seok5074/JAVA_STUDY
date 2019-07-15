package multichat;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiServer extends JFrame {

	//쓰레드 동기화 객체
	Object syncObj = new Object();
	
	
	JTextArea  jta_display;//서버모니터링
	JTextField jtf_count;  //접속자수
	
	Font font = new Font("굴림체", Font.BOLD, 20);
	
	//서버소켓
	ServerSocket server;
	
	//자소켓들을 저장할 객체
	List<ReadThread> socketList = new ArrayList<ReadThread>();
		
	//접속자 목록을 저장할 객체
	List<String> userList = new ArrayList<String>();
	
	//접속자 목록을 출력
	JList<String> jlist_user;
	
	
	public MultiServer() {
		// TODO Auto-generated constructor stub
		super("멀티서버");//제목

		//컨트롤 초기화
		init_component();
		
		//접속자 목록 초기화
		init_user_list();
		
		//서버소켓초기화
		init_server();
				
		
		//위치 크기      x     y   w    h
		//super.setBounds(500, 200, 300, 300);
	    setLocation(500, 200);
	    
	    pack();

		//화면에 보이기
		super.setVisible(true);

		//종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_user_list() {
		// TODO Auto-generated method stub
		jlist_user = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_user);
		
		jsp.setPreferredSize(new Dimension(150, 0));
		
		this.add(jsp,"East");
				
	}

	private void init_server() {
		// TODO Auto-generated method stub
		
		try {
			//System.out.println(Thread.currentThread().getName());
			server = new ServerSocket(8100);
			
			//접속대기 쓰레드 할당
			new Thread() {
				
				public void run() {
					//System.out.println(Thread.currentThread().getName());
					display("--서버 대기중...--");
					
					while(true) {
						
						//접속대기
						try {
							Socket child = server.accept();
							
							
							//ReadThread생성
							ReadThread rt = new ReadThread(child);
							rt.start();//쓰레드 구동
							
							//소켓목록 추가
							socketList.add(rt);
							
							//접속자수 출력
							display_user_count();
							
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}.start();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	protected void display_user_count() {
		// TODO Auto-generated method stub
		int user_count = socketList.size();
		jtf_count.setText(user_count + "");
		
	}

	protected void display(String msg) {
		// TODO Auto-generated method stub
		jta_display.append(msg);
		jta_display.append("\r\n");
		
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);
			
		
	}

	private void init_component() {
		// TODO Auto-generated method stub
		//모니터창 초기화
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);
		jsp.setPreferredSize(new Dimension(400, 400));
		this.add(jsp,"Center");
		
		//접속자수 목록 출력
		JPanel  p = new JPanel(new GridLayout(1,3));
		JLabel jlb_title = new JLabel("접속자수", JLabel.RIGHT);
		jtf_count  = new JTextField("0");
		JLabel jlb_2 = new JLabel("(명)");
		
		p.add(jlb_title);
		p.add(jtf_count);
		p.add(jlb_2);
		this.add(p,"South");
		
		//인원수 중앙정렬
		jtf_count.setHorizontalAlignment(JTextField.CENTER);
		
		//폰트설정
		jta_display.setFont(font);
		jlb_title.setFont(font);
		jlb_2.setFont(font);
		jtf_count.setFont(font);
		
		//모니터창 읽기전용
		jta_display.setEditable(false);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiServer();
	}
	
	
//---- 수신용 쓰레드 내부클래스로 선언-------
	class ReadThread extends Thread
	{
		Socket child;
		BufferedReader br;//수신문자스트림
		
		public ReadThread(Socket child) {
			super();
			this.child = child;
			
			try {
				InputStream is = child.getInputStream();//수신스트림 획득
				InputStreamReader isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}


		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				
				try {
					String read_msg = br.readLine();//라인단위로 데이터일기
					if(read_msg==null) {
						//System.out.println("--case 1--");
						//정상종료
						break;//상대소켓이 닫힌경우
					}

					//서버모니터링
					display(read_msg);
					//System.out.println(read_msg);
					
					
					// read_msg = "IN#홍길동"
					// read_msg = "MSG#홍길동#잘지내~~"
					// read_msg = "DRAW#x#y#thick#r#g#b"
					//입장메시지면
					if(read_msg.startsWith("IN")) {
					
						synchronized (syncObj) 
						{
							//입장처리
							process_in(read_msg);
						}
						
					}else if(read_msg.startsWith("MSG")) {//일반채팅메시지면...
						synchronized (syncObj) 
						{
							//채팅처리 : String send_msg = read_msg + "\n";
							String send_msg = String.format("%s\n", read_msg);
							send_message_all(send_msg);
														
						}
					}else if(read_msg.startsWith("DRAW")) {//그리기메시지면
						synchronized (syncObj) 
						{
							//그리기처리
							String send_msg = String.format("%s\n", read_msg);
							send_message_all(send_msg);
						}
					}
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					//상대방소켓이 닫힌경우
					//비정상종료
					//System.out.println("--case 2--");
					break;
					
				}
			}//end-while

			synchronized (syncObj) 
			{
				//퇴장상황
			   
				// this가 socketList에 몇번째 index
				int del_index = socketList.indexOf(this);
				//퇴장자 nick_name
				String out_name = userList.get(del_index);	
				
				//유저목록에서 제거
				userList.remove(del_index);
				//유저정보가 갱신
				display_user_list();
				
				
				//1.socketList로부터 자신의 객체를 제거
				socketList.remove(this);
				//인원수변동내역 출력
				display_user_count();
				
				//갱신된 유저목록 각 클라이언트에게 전송
				send_user_list();
				
				
				//퇴장자 정보를 각 클라이언트에게 전송
				String send_msg = String.format("OUT#%s\n", out_name);
				send_message_all(send_msg);
				
				
			
			}
			
			
		}
		
	}
//End ReadThread-----------------------------	


	public void process_in(String read_msg) {
		// TODO Auto-generated method stub
		
		String send_msg = String.format("%s\n", read_msg);
		//각 클라이언트에게 전송
		send_message_all(send_msg);
		
		//read_msg = "IN#홍길동"
		String nick_name = read_msg.replaceAll("IN#","");
		
		//입장유저 등록
		userList.add(nick_name);
		
		//갱신된 유저목록 보여줘라...
		display_user_list();
		
		//갱신된 유저목록 각 클라이언트에게 전송
		send_user_list();
		
	}

	private void send_user_list() {
	// TODO Auto-generated method stub
		//전송할 유저리스트를 포장
		StringBuffer sb = new StringBuffer("LIST#");
		for(String user : userList) {
			sb.append(user);
			sb.append("#");
		}
		
		sb.append("\n");
		
		String send_user_msg = sb.toString();
		//System.out.println(send_user_msg);
		
		//모든 접속자에게 전송
		send_message_all(send_user_msg);
		
		
	}

	private void send_message_all(String message) {
		// TODO Auto-generated method stub
		//ArrayList 개선 loop반복
		//for(ReadThread rt : socketList) {//
		for(int i=0;i< socketList.size();i++) {
			ReadThread rt = socketList.get(i);
			
			try {
				//ReadThread내의 자소켓으로 부터 전송스트림을 얻는다
				OutputStream os = rt.child.getOutputStream();
				//전송
				os.write(message.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void display_user_list() {
		// TODO Auto-generated method stub
		//ArrayList -> Array추출
		String [] user_array = new String[userList.size()];
		userList.toArray(user_array);
		
		//유저배열을 JList에 넣기
		jlist_user.setListData(user_array);
		
		
	}
	
	
	
	
}