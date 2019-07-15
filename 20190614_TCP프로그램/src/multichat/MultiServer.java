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

	//������ ����ȭ ��ü
	Object syncObj = new Object();
	
	
	JTextArea  jta_display;//��������͸�
	JTextField jtf_count;  //�����ڼ�
	
	Font font = new Font("����ü", Font.BOLD, 20);
	
	//��������
	ServerSocket server;
	
	//�ڼ��ϵ��� ������ ��ü
	List<ReadThread> socketList = new ArrayList<ReadThread>();
		
	//������ ����� ������ ��ü
	List<String> userList = new ArrayList<String>();
	
	//������ ����� ���
	JList<String> jlist_user;
	
	
	public MultiServer() {
		// TODO Auto-generated constructor stub
		super("��Ƽ����");//����

		//��Ʈ�� �ʱ�ȭ
		init_component();
		
		//������ ��� �ʱ�ȭ
		init_user_list();
		
		//���������ʱ�ȭ
		init_server();
				
		
		//��ġ ũ��      x     y   w    h
		//super.setBounds(500, 200, 300, 300);
	    setLocation(500, 200);
	    
	    pack();

		//ȭ�鿡 ���̱�
		super.setVisible(true);

		//�����ڵ�
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
			
			//���Ӵ�� ������ �Ҵ�
			new Thread() {
				
				public void run() {
					//System.out.println(Thread.currentThread().getName());
					display("--���� �����...--");
					
					while(true) {
						
						//���Ӵ��
						try {
							Socket child = server.accept();
							
							
							//ReadThread����
							ReadThread rt = new ReadThread(child);
							rt.start();//������ ����
							
							//���ϸ�� �߰�
							socketList.add(rt);
							
							//�����ڼ� ���
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
		//�����â �ʱ�ȭ
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);
		jsp.setPreferredSize(new Dimension(400, 400));
		this.add(jsp,"Center");
		
		//�����ڼ� ��� ���
		JPanel  p = new JPanel(new GridLayout(1,3));
		JLabel jlb_title = new JLabel("�����ڼ�", JLabel.RIGHT);
		jtf_count  = new JTextField("0");
		JLabel jlb_2 = new JLabel("(��)");
		
		p.add(jlb_title);
		p.add(jtf_count);
		p.add(jlb_2);
		this.add(p,"South");
		
		//�ο��� �߾�����
		jtf_count.setHorizontalAlignment(JTextField.CENTER);
		
		//��Ʈ����
		jta_display.setFont(font);
		jlb_title.setFont(font);
		jlb_2.setFont(font);
		jtf_count.setFont(font);
		
		//�����â �б�����
		jta_display.setEditable(false);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiServer();
	}
	
	
//---- ���ſ� ������ ����Ŭ������ ����-------
	class ReadThread extends Thread
	{
		Socket child;
		BufferedReader br;//���Ź��ڽ�Ʈ��
		
		public ReadThread(Socket child) {
			super();
			this.child = child;
			
			try {
				InputStream is = child.getInputStream();//���Ž�Ʈ�� ȹ��
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
					String read_msg = br.readLine();//���δ����� �������ϱ�
					if(read_msg==null) {
						//System.out.println("--case 1--");
						//��������
						break;//�������� �������
					}

					//��������͸�
					display(read_msg);
					//System.out.println(read_msg);
					
					
					// read_msg = "IN#ȫ�浿"
					// read_msg = "MSG#ȫ�浿#������~~"
					// read_msg = "DRAW#x#y#thick#r#g#b"
					//����޽�����
					if(read_msg.startsWith("IN")) {
					
						synchronized (syncObj) 
						{
							//����ó��
							process_in(read_msg);
						}
						
					}else if(read_msg.startsWith("MSG")) {//�Ϲ�ä�ø޽�����...
						synchronized (syncObj) 
						{
							//ä��ó�� : String send_msg = read_msg + "\n";
							String send_msg = String.format("%s\n", read_msg);
							send_message_all(send_msg);
														
						}
					}else if(read_msg.startsWith("DRAW")) {//�׸���޽�����
						synchronized (syncObj) 
						{
							//�׸���ó��
							String send_msg = String.format("%s\n", read_msg);
							send_message_all(send_msg);
						}
					}
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					//��������� �������
					//����������
					//System.out.println("--case 2--");
					break;
					
				}
			}//end-while

			synchronized (syncObj) 
			{
				//�����Ȳ
			   
				// this�� socketList�� ���° index
				int del_index = socketList.indexOf(this);
				//������ nick_name
				String out_name = userList.get(del_index);	
				
				//������Ͽ��� ����
				userList.remove(del_index);
				//���������� ����
				display_user_list();
				
				
				//1.socketList�κ��� �ڽ��� ��ü�� ����
				socketList.remove(this);
				//�ο����������� ���
				display_user_count();
				
				//���ŵ� ������� �� Ŭ���̾�Ʈ���� ����
				send_user_list();
				
				
				//������ ������ �� Ŭ���̾�Ʈ���� ����
				String send_msg = String.format("OUT#%s\n", out_name);
				send_message_all(send_msg);
				
				
			
			}
			
			
		}
		
	}
//End ReadThread-----------------------------	


	public void process_in(String read_msg) {
		// TODO Auto-generated method stub
		
		String send_msg = String.format("%s\n", read_msg);
		//�� Ŭ���̾�Ʈ���� ����
		send_message_all(send_msg);
		
		//read_msg = "IN#ȫ�浿"
		String nick_name = read_msg.replaceAll("IN#","");
		
		//�������� ���
		userList.add(nick_name);
		
		//���ŵ� ������� �������...
		display_user_list();
		
		//���ŵ� ������� �� Ŭ���̾�Ʈ���� ����
		send_user_list();
		
	}

	private void send_user_list() {
	// TODO Auto-generated method stub
		//������ ��������Ʈ�� ����
		StringBuffer sb = new StringBuffer("LIST#");
		for(String user : userList) {
			sb.append(user);
			sb.append("#");
		}
		
		sb.append("\n");
		
		String send_user_msg = sb.toString();
		//System.out.println(send_user_msg);
		
		//��� �����ڿ��� ����
		send_message_all(send_user_msg);
		
		
	}

	private void send_message_all(String message) {
		// TODO Auto-generated method stub
		//ArrayList ���� loop�ݺ�
		//for(ReadThread rt : socketList) {//
		for(int i=0;i< socketList.size();i++) {
			ReadThread rt = socketList.get(i);
			
			try {
				//ReadThread���� �ڼ������� ���� ���۽�Ʈ���� ��´�
				OutputStream os = rt.child.getOutputStream();
				//����
				os.write(message.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void display_user_list() {
		// TODO Auto-generated method stub
		//ArrayList -> Array����
		String [] user_array = new String[userList.size()];
		userList.toArray(user_array);
		
		//�����迭�� JList�� �ֱ�
		jlist_user.setListData(user_array);
		
		
	}
	
	
	
	
}