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

	
	//���â
	JTextArea jta_display;
	
	//�Է�â
	JTextField jtf_message;
	//���ӹ�ư
	JButton jbt_connect;
	
	
	//��ȭ��
	String nick_name = "��ٺ���";
	
	//Ŭ���̾�Ʈ����
	Socket client;
	BufferedReader br = null;
	
	//���ӻ��� ����
	boolean bConnect=false;
	
	//�����ڸ���� ������ ����Ʈ ��Ʈ��
	JList<String> jlist_user;
		
	Font font = new Font("����ü", Font.BOLD, 16);
	
	
	//�׸��ǰ��� �޴�
	JPanel grimPan;
	int red=255,green=0,blue=0;//����
	int thick=5;//������
	
	Image memPan;//�޸𸮻��� �׸���
	
		
	
	
	
	public MultiChatClient() {
		// TODO Auto-generated constructor stub
		super("��Ƽä��Ŭ���̾�Ʈ");//����

		//���â �ʱ�ȭ
		init_display();
		//�����ڸ��â �ʱ�ȭ
		init_user_list();
		
		//�Է�â �ʱ�ȭ
		init_input();
		
		//�׸��� �ʱ�ȭ
		init_grimpan();
		
		jta_display.setFont(font);
		jtf_message.setFont(font);
		jlist_user.setFont(font);
		
		
		//Ű�̺�Ʈ �ʱ�ȭ
		init_key_event();
		
		
		//��ġ ũ��      x     y   w    h
		//super.setBounds(500, 200, 300, 300);
		setLocation(700, 200);
		
		pack();

		//ȭ�鿡 ���̱�
		super.setVisible(true);

		//�����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//�޸� ȭ�� ����
		memPan = grimPan.createImage(400, 400);
		
		//�޸��ǿ� �׸� �׸��⵵�� ��´�
		//Graphics  g = memPan.getGraphics();
		//g.drawString("�ȳ��ϼ���", 100, 100);
		
		//�׸��� ���콺 �̺�Ʈ�ʱ�ȭ
		init_mouse_event();
		

	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
				//������� �ʾ����� ������..
				if(bConnect==false) return;
				
				//���콺 ��ġ
				int x = e.getX();
				int y = e.getY();
				
				//���۵����� ����
				String send_msg = String.format("DRAW#%d#%d#%d#%d#%d#%d\n", 
						                              x, y,thick,red,green,blue 
						);
				//����
				try {
					
					client.getOutputStream().write(send_msg.getBytes());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				/*
				//�׸������
				Color color  = new Color(red, green, blue);
				//�׸��� ���� ���ϱ�
				Graphics  g = memPan.getGraphics();
				g.setColor(color);//��������
				//�޸𸮿� �׸���
				g.fillOval(x-thick, y-thick, thick*2, thick*2);
				//grimPan�� �ٽ� �׷���..
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
		
		//�׸��ǻ���
		grimPan = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				//�޸� �׸��ǳ���->����
				g.drawImage(memPan, 0, 0,this);
			}
			
		};
		
		grimPan.setPreferredSize(new Dimension(400,400));
		p.add(grimPan,BorderLayout.CENTER);
		
		//�׸��� �޴�
		JPanel southP = new JPanel(new GridLayout(1,3));
		p.add(southP,BorderLayout.SOUTH);
		
		//�޴�1: ������ �޴�(JComboBox)
		Integer [] thick_array = { 5,10,15,20,25,30,40,50,550};
		JComboBox<Integer> jcb_thick = new JComboBox<Integer>(thick_array);
		southP.add(jcb_thick);
		
		//�޴�2: �����ư
		JButton jbt_color = new JButton("������");
		southP.add(jbt_color);
		
		//�޴�3: �����
		JButton jbt_clear = new JButton("�����");
		southP.add(jbt_clear);
		
		
		
		//������ ���� �̺�Ʈ
		jcb_thick.addItemListener( new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//�޺��ڽ����� ���� Item�� ���
				thick = (int)jcb_thick.getSelectedItem();
			}
		});
		
		//������ Ŭ���� �̺�Ʈ
		jbt_color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//���� ���õ� Į��
				Color color = new Color(red,green,blue);
				Color res_color = JColorChooser.showDialog(MultiChatClient.this, 
						                                   "�������� �����ϼ���", 
						                                    color);
				//���
				if(res_color==null) return;
				
				//���õ� Į�󿡼� ������ R,G,B�� ����
				red   = res_color.getRed();
				green = res_color.getGreen();
				blue  = res_color.getBlue();
								
				
			}
		});
		
		//����� ��ư Ŭ���� �̺�Ʈ
		jbt_clear.addActionListener( new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�޸��� �����
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
				//����Ű��
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {
					send_message();
				}
				
			}
		};
		
		//�޽ý��� �Է�â���� Ű�� ������ listener���� ó�� ����
		jtf_message.addKeyListener(listener);
		
		
	}

	protected void send_message() {
		// TODO Auto-generated method stub
		if(bConnect==false) {
			jtf_message.setText("");//�Է°� �����
			JOptionPane.showMessageDialog(this, "�����Ŀ� �޽��� �����ϼ���!!");
			return;
		}
		
		//�޽��� ���� �о����
		String message = jtf_message.getText().trim();
		if(message.isEmpty()) {//�����̳� �Է����� �ʰ� ����ġ��
			jtf_message.setText("");
			return;
		}
		
		//���۸޽��� ����
		String send_msg = String.format("MSG#%s#%s\n", nick_name,message);
		
		
		try {
			//����
			client.getOutputStream().write(send_msg.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�����Է����� �����
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
		jbt_connect = new JButton("����");
		p.add(jtf_message,"Center");
		p.add(jbt_connect,"East");
		
		//��ưŬ���� �̺�Ʈ
		jbt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				on_connect();// on_ : callback �޼ҵ�
			}
		});
		
		
		
	}

	protected void on_connect() {
		// TODO Auto-generated method stub
		bConnect = !bConnect;
		
		
		if(bConnect) { //����
			
			try {
				client= new Socket("192.168.0.19", 8100);
				
				//���Ἲ����...                 "IN#ȫ�浿\n" 
				String send_msg = String.format("IN#%s\n", nick_name);
				//�������κ��� ���� ��Ʈ���� ������
				OutputStream os = client.getOutputStream();
				//����
				os.write(send_msg.getBytes());
								
				
				//�޽��� �о����
				read_message();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(this, "��������߽��ϴ�");
				bConnect=false;				
			}
			
		}else { //����
			
			try {
				
				client.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		//��ư ĸ�� ����
		jbt_connect.setText(bConnect ? "����" : "����");
				
		
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
		
		//���ſ� ������
		new Thread() {
			
			public void run() {
				
				while(true) {
					
					//���Ŵ��
					try {
						
						String read_msg = br.readLine();
						if(read_msg==null)break;//�������� ������
						//read_msg="IN#�浿1"
						//read_msg="OUT#�浿1"
						//read_msg="LIST#�浿1#�浿2#�浿3#"
						//read_msg="MSG#�浿1#�ȳ�氡��..."
						//read_msg="DRAW#x#y#thick#r#g#b"
						if(read_msg.startsWith("IN")) {
							//����ó��
							String name = read_msg.replaceAll("IN#", "");
							String display_msg = String.format("[����] %s�� �����ϼ̽��ϴ�", name);
							display(display_msg);
							
							
						}else if(read_msg.startsWith("OUT")) {
							//����ó��
							String name = read_msg.replaceAll("OUT#", "");
							String display_msg = String.format("[����] %s�� �����ϼ̽��ϴ�", name);
							display(display_msg);
							
						}else if(read_msg.startsWith("LIST")) {
							//�������
							display_user_list(read_msg);
							
						}else if(read_msg.startsWith("MSG")) {
							//ä�ó���
							//read_msg="MSG#�浿1#�ȳ�氡��..."
							String message = read_msg.replaceAll("MSG#", "");
							// message = "�浿1#�ȳ�氡��..."
							String [] msg_array = message.split("#");
							//                  0            1
							// msg_array = { "�浿1" , "�ȳ�氡��..."};
							String display_msg = String.format("[%s]�� ����:\r\n  %s", 
									                          msg_array[0], msg_array[1]);
							//���â�� ���
							display(display_msg);
														
							
						}else if(read_msg.startsWith("DRAW")) {
							//�׸���
							//read_msg="DRAW#x#y#thick#r#g#b"
							draw_grimpan(read_msg);
							
						}
						
					
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						//����������(�����ϴ������)
						break;
					}
					
					
				}//end-while
				
				//��������� �ʱ�ȭ
				bConnect = false;
				jbt_connect.setText("����");
				
				//������� �ʱ�ȭ
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
		//��������
		int rr    = Integer.parseInt(msg_array[3]);
		int gg    = Integer.parseInt(msg_array[4]);
		int bb    = Integer.parseInt(msg_array[5]);
		
		//�޸��ǿ� �׸��� ���� ���ϱ�
		Graphics g = memPan.getGraphics();
		//�׸��� ����
		Color color = new Color(rr,gg,bb);
		g.setColor(color);
		
		//���׸���(�޸𸮿� �׸���)
		g.fillOval(x-thick, y-thick, thick*2, thick*2);
		
		//�޸� ����->ȭ�鿡 ���
		grimPan.repaint();
			
		
		
	}

	protected void display_user_list(String message) {
		// TODO Auto-generated method stub
		//message = "LIST#�浿1#�浿2#�浿3#"
		message = message.replaceAll("LIST#", "");
		//message = "�浿1#�浿2#�浿3#"
		String [] user_array = message.split("#");
		//�迭�� ����
		jlist_user.setListData(user_array);
		
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);
		
		jsp.setPreferredSize(new Dimension(400, 400));
		
		this.add(jsp,"Center");
		
		//�б�����
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