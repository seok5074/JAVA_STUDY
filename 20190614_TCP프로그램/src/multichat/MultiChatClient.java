package multichat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatClient extends JFrame {

	
	//출력창
	JTextArea jta_display;
	
	//입력창
	JTextField jtf_message;
	//접속버튼
	JButton jbt_connect;
	
	
	//대화명
	String nick_name = "퇴근빌런";
	
	//클라이언트소켓
	Socket client;
	BufferedReader br = null;
	
	//접속상태 변수
	boolean bConnect=false;
	
	//접속자목록을 보여줄 리스트 컨트롤
	JList<String> jlist_user;
		
	Font font = new Font("굴림체", Font.BOLD, 16);
	
	
	//그림판관련 메뉴
	JPanel grimPan;
	int red=255,green=0,blue=0;//색상
	int thick=5;//선굵기
	
	Image memPan;//메모리상의 그림판
	
		
	
	
	
	public MultiChatClient() {
		// TODO Auto-generated constructor stub
		super("멀티채팅클라이언트");//제목

		//출력창 초기화
		init_display();
		//접속자목록창 초기화
		init_user_list();
		
		//입력창 초기화
		init_input();
		
		//그림판 초기화
		init_grimpan();
		
		jta_display.setFont(font);
		jtf_message.setFont(font);
		jlist_user.setFont(font);
		
		
		//키이벤트 초기화
		init_key_event();
		
		
		//위치 크기      x     y   w    h
		//super.setBounds(500, 200, 300, 300);
		setLocation(700, 200);
		
		pack();

		//화면에 보이기
		super.setVisible(true);

		//종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//메모리 화면 생성
		memPan = grimPan.createImage(400, 400);
		
		//메모리판에 그릴 그리기도구 얻는다
		//Graphics  g = memPan.getGraphics();
		//g.drawString("안녕하세요", 100, 100);
		
		//그리기 마우스 이벤트초기화
		init_mouse_event();
		

	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
				//연결되지 않았으면 끝내라..
				if(bConnect==false) return;
				
				//마우스 위치
				int x = e.getX();
				int y = e.getY();
				
				//전송데이터 포장
				String send_msg = String.format("DRAW#%d#%d#%d#%d#%d#%d\n", 
						                              x, y,thick,red,green,blue 
						);
				//전송
				try {
					
					client.getOutputStream().write(send_msg.getBytes());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				/*
				//그리기색상
				Color color  = new Color(red, green, blue);
				//그리기 도구 구하기
				Graphics  g = memPan.getGraphics();
				g.setColor(color);//색상지정
				//메모리에 그리기
				g.fillOval(x-thick, y-thick, thick*2, thick*2);
				//grimPan을 다시 그려라..
				grimPan.repaint();
				*/
												
				
			}
		};
		
		grimPan.addMouseMotionListener(adapter);
		
		
	}

	private void init_grimpan() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		this.add(p,BorderLayout.WEST);
		
		//그림판생성
		grimPan = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				//메모리 그림판내용->복사
				g.drawImage(memPan, 0, 0,this);
			}
			
		};
		
		grimPan.setPreferredSize(new Dimension(400,400));
		p.add(grimPan,BorderLayout.CENTER);
		
		//그림판 메뉴
		JPanel southP = new JPanel(new GridLayout(1,3));
		p.add(southP,BorderLayout.SOUTH);
		
		//메뉴1: 선굵기 메뉴(JComboBox)
		Integer [] thick_array = { 5,10,15,20,25,30,40,50,550};
		JComboBox<Integer> jcb_thick = new JComboBox<Integer>(thick_array);
		southP.add(jcb_thick);
		
		//메뉴2: 색상버튼
		JButton jbt_color = new JButton("선색상");
		southP.add(jbt_color);
		
		//메뉴3: 지우기
		JButton jbt_clear = new JButton("지우기");
		southP.add(jbt_clear);
		
		
		
		//선굵기 선택 이벤트
		jcb_thick.addItemListener( new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//콤보박스에서 선택 Item값 얻기
				thick = (int)jcb_thick.getSelectedItem();
			}
		});
		
		//선색상 클릭시 이벤트
		jbt_color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//현재 선택된 칼라
				Color color = new Color(red,green,blue);
				Color res_color = JColorChooser.showDialog(MultiChatClient.this, 
						                                   "선색상을 선택하세요", 
						                                    color);
				//취소
				if(res_color==null) return;
				
				//선택된 칼라에서 각각의 R,G,B값 추출
				red   = res_color.getRed();
				green = res_color.getGreen();
				blue  = res_color.getBlue();
								
				
			}
		});
		
		//지우기 버튼 클릭시 이벤트
		jbt_clear.addActionListener( new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//메모리판 지우기
				Graphics g = memPan.getGraphics();
				g.clearRect(0, 0, 400, 400);
				
				grimPan.repaint();
				
			}
		});
		
		
		
		
		
	}

	private void init_key_event() {
		// TODO Auto-generated method stub
		
		KeyListener listener = new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//눌린키값
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {
					send_message();
				}
				
			}
		};
		
		//메시시지 입력창에서 키가 눌리면 listener에게 처리 위임
		jtf_message.addKeyListener(listener);
		
		
	}

	protected void send_message() {
		// TODO Auto-generated method stub
		if(bConnect==false) {
			jtf_message.setText("");//입력값 지우기
			JOptionPane.showMessageDialog(this, "연결후에 메시지 전송하세요!!");
			return;
		}
		
		//메시지 내용 읽어오기
		String message = jtf_message.getText().trim();
		if(message.isEmpty()) {//공백이나 입력하지 않고 엔터치면
			jtf_message.setText("");
			return;
		}
		
		//전송메시지 포장
		String send_msg = String.format("MSG#%s#%s\n", nick_name,message);
		
		
		try {
			//전송
			client.getOutputStream().write(send_msg.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//이전입력정보 지우기
		jtf_message.setText("");
		
		
		
	}

	private void init_user_list() {
		// TODO Auto-generated method stub
		jlist_user = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_user);
		
		jsp.setPreferredSize(new Dimension(150,0));
		
		this.add(jsp, BorderLayout.EAST);
		
		
	}

	private void init_input() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		this.add(p,"South");
		
		jtf_message = new JTextField();
		jbt_connect = new JButton("연결");
		p.add(jtf_message,"Center");
		p.add(jbt_connect,"East");
		
		//버튼클릭시 이벤트
		jbt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				on_connect();// on_ : callback 메소드
			}
		});
		
		
		
	}

	protected void on_connect() {
		// TODO Auto-generated method stub
		bConnect = !bConnect;
		
		
		if(bConnect) { //연결
			
			try {
				client= new Socket("192.168.0.19", 8100);
				
				//연결성공시...                 "IN#홍길동\n" 
				String send_msg = String.format("IN#%s\n", nick_name);
				//소켓으로부터 전송 스트림을 얻어오기
				OutputStream os = client.getOutputStream();
				//전송
				os.write(send_msg.getBytes());
								
				
				//메시지 읽어오기
				read_message();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(this, "연결실패했습니다");
				bConnect=false;				
			}
			
		}else { //끊기
			
			try {
				
				client.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		//버튼 캡션 변경
		jbt_connect.setText(bConnect ? "끊기" : "연결");
				
		
	}

	
	
	private void read_message() {
		// TODO Auto-generated method stub
		
		try {
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//수신용 쓰레드
		new Thread() {
			
			public void run() {
				
				while(true) {
					
					//수신대기
					try {
						
						String read_msg = br.readLine();
						if(read_msg==null)break;//상대소켓이 닫히면
						//read_msg="IN#길동1"
						//read_msg="OUT#길동1"
						//read_msg="LIST#길동1#길동2#길동3#"
						//read_msg="MSG#길동1#안녕방가워..."
						//read_msg="DRAW#x#y#thick#r#g#b"
						if(read_msg.startsWith("IN")) {
							//입장처리
							String name = read_msg.replaceAll("IN#", "");
							String display_msg = String.format("[입장] %s님 입장하셨습니다", name);
							display(display_msg);
							
							
						}else if(read_msg.startsWith("OUT")) {
							//퇴장처리
							String name = read_msg.replaceAll("OUT#", "");
							String display_msg = String.format("[퇴장] %s님 퇴장하셨습니다", name);
							display(display_msg);
							
						}else if(read_msg.startsWith("LIST")) {
							//유저목록
							display_user_list(read_msg);
							
						}else if(read_msg.startsWith("MSG")) {
							//채팅내용
							//read_msg="MSG#길동1#안녕방가워..."
							String message = read_msg.replaceAll("MSG#", "");
							// message = "길동1#안녕방가워..."
							String [] msg_array = message.split("#");
							//                  0            1
							// msg_array = { "길동1" , "안녕방가워..."};
							String display_msg = String.format("[%s]님 말씀:\r\n  %s", 
									                          msg_array[0], msg_array[1]);
							//출력창에 출력
							display(display_msg);
														
							
						}else if(read_msg.startsWith("DRAW")) {
							//그리기
							//read_msg="DRAW#x#y#thick#r#g#b"
							draw_grimpan(read_msg);
							
						}
						
					
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						//비정상종료(상대소켓닫힌경우)
						break;
					}
					
					
				}//end-while
				
				//모든정보를 초기화
				bConnect = false;
				jbt_connect.setText("연결");
				
				//유저목록 초기화
				String [] user_array = new String[0];
				jlist_user.setListData(user_array);
				
				
				
								
			}
			
		}.start();
		
				
		
		
	}

	protected void draw_grimpan(String read_msg) {
		// TODO Auto-generated method stub
		//read_msg="DRAW#x#y#thick#r#g#b"
		String message = read_msg.replaceAll("DRAW#", "");
		// message = "x#y#thick#r#g#b";
		String [] msg_array = message.split("#");
		//                         0   1     2      3     4        5 
		// String [] msg_array = {"x","y","thick","red","green","blue"};
		int x     = Integer.parseInt(msg_array[0]);
		int y     = Integer.parseInt(msg_array[1]);
		int thick = Integer.parseInt(msg_array[2]);
		//색상정보
		int rr    = Integer.parseInt(msg_array[3]);
		int gg    = Integer.parseInt(msg_array[4]);
		int bb    = Integer.parseInt(msg_array[5]);
		
		//메모리판에 그리기 도구 구하기
		Graphics g = memPan.getGraphics();
		//그리기 색상
		Color color = new Color(rr,gg,bb);
		g.setColor(color);
		
		//원그리기(메모리에 그리기)
		g.fillOval(x-thick, y-thick, thick*2, thick*2);
		
		//메모리 내용->화면에 출력
		grimPan.repaint();
			
		
		
	}

	protected void display_user_list(String message) {
		// TODO Auto-generated method stub
		//message = "LIST#길동1#길동2#길동3#"
		message = message.replaceAll("LIST#", "");
		//message = "길동1#길동2#길동3#"
		String [] user_array = message.split("#");
		//배열로 설정
		jlist_user.setListData(user_array);
		
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);
		
		jsp.setPreferredSize(new Dimension(400, 400));
		
		this.add(jsp,"Center");
		
		//읽기전용
		jta_display.setEditable(false);
	}
	
	protected void display(String msg) {
		// TODO Auto-generated method stub
		jta_display.append(msg);
		jta_display.append("\r\n");
		
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);
			
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiChatClient();
	}
}