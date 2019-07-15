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

	// �޽��� ���â
	JTextArea jta_display;

	// �ּ��Է�â/�޽���â
	JTextField jtf_address;
	JTextField jtf_message;

	// ��ȭ��
	String nick_name = "ȫ�浿";

	// UDP ����
	DatagramSocket udp_socket;

	// ��Ʈ
	Font font = new Font("����ü", Font.BOLD, 20);

	public UDPChat() {
		// TODO Auto-generated constructor stub
		super("UDPä��");// ����

		// ���â �ʱ�ȭ
		init_display();

		// �Է�â �ʱ�ȭ
		init_input();

		// ����Ʈ�ѿ� ��Ʈ����
		jta_display.setFont(font);

		jtf_address.setFont(font);
		jtf_message.setFont(font);

		// Ű�̺�Ʈ �ʱ�ȭ
		init_key_event();

		// �����ʱ�ȭ
		init_socket();

		// ��ġ ũ�� x y w h
		// super.setBounds(500, 200, 300, 300);
		setLocation(500, 200);

		pack();

		// ȭ�鿡 ���̱�
		super.setVisible(true);

		// �����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_socket() {
		// TODO Auto-generated method stub

		try {
			// �����Ʈ ����
			udp_socket = new DatagramSocket(7000);

			// �޽��� ����
			read_message();

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ������ ����� ��Ʈ����
	}

	private void read_message() {
		// TODO Auto-generated method stub
		/*
		 * class ReadThread extends Thread{
		 * 
		 * @Override public void run() { // TODO Auto-generated method stub while(true)
		 * { //�޽��� ������ ����..(����) System.out.println(Thread.currentThread().getName()); }
		 * } } new ReadThread().start();
		 */

		// �͸���Ŭ������ ����
		new Thread() {
			public void run() {
				while (true) {

					try {
						// �޽��� ������ ����..(����)
						// System.out.println(Thread.currentThread().getName());

						byte[] read_buff = new byte[512]; // ���� ����
						DatagramPacket dp = new DatagramPacket(read_buff, read_buff.length);

						udp_socket.receive(dp);
						
					
						// ���Ÿ޽���
						byte[] data = dp.getData();

						// byte [] -> string ��ü����
						// read_msg = "ȫ�浿#�ȳ��ϼ���" ��� ���´�.
						// trim �����������ش�. ���ʿ��� �����͸� �о���δ�.

						String read_msg = new String(data, 0, data.length).trim();

						String[] msg_array = read_msg.split("#");
						// ��� = msg_array = {"ȫ�浿","�ȳ��ϼ���"}

						// ȭ�����
						String display_message = String.format("[%s]�� ����:\r\n   %s\r\n", msg_array[0], msg_array[1]);
						//���â�� �ֱ�
						jta_display.append(display_message);

						//�����Ǳ���
						int position = jta_display.getDocument().getLength();
						//������ ���� Caret�� ��ġ��Ų��
						jta_display.setCaretPosition(position);
						
						//�߽��� Ȯ��
						InetAddress ia =dp.getAddress(); //�޽��� ������ ip
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
				// ����Ű��
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					// �޽��� ����
					send_message();
				}

			}
		};

		// �̺�Ʈ ���
		// �̺�Ʈ�ҽ�.addKeyListener(ó����ü);
		jtf_message.addKeyListener(listener);

	}

	protected void send_message() {
		// TODO Auto-generated method stub

		// �Էµ� �޽��� ������=>��������
		String message = jtf_message.getText().trim();

		if (message.isEmpty()) {// �Է¸޽����� ������ ������..
			jtf_message.setText("");
			return;
		}

		// ������ ����
		// ���۵����� ��Ű¡(����) : ȫ�浿#�ȳ��ϼ���
		String send_msg = String.format("%s#%s", nick_name, message);

		// �������ּ� ������
		String ip = jtf_address.getText(); // ip = 255,255,255,255
		try {

			InetAddress ia = InetAddress.getByName(ip);
			// UDP���Ͽ� ������ ������ DatagramPacket�� �����ؼ� ����
			byte[] send_bytes = send_msg.getBytes();
			DatagramPacket dp = new DatagramPacket(send_bytes, send_bytes.length, ia, 7000);

			// ����
			udp_socket.send(dp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ȭ�鿡 ���
		/*
		 * String display_message = String.format("[%s]�� ����:\r\n   %s\r\n", nick_name,
		 * message ); //���â�� �ֱ� jta_display.append(display_message);
		 * 
		 * //�����Ǳ��� int position = jta_display.getDocument().getLength(); //������ ���� Caret��
		 * ��ġ��Ų�� jta_display.setCaretPosition(position);
		 */

		// �����Է�â ����
		jtf_message.setText("");

	}

	// �Է�â �ʱ�ȭ
	private void init_input() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(2, 1));
		this.add(p, "South");

		// �ּ�â �ֱ�
		p.add(jtf_address = new JTextField("255.255.255.255"));

		// �޽��� �Է�â �ֱ�
		p.add(jtf_message = new JTextField());

		// �Է�â�� ��Ŀ�� ���� ????
		jtf_message.requestFocus();

	}

	// ���â �ʱ�ȭ
	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();// �������� ��/����ϴ� ��Ʈ��

		JScrollPane jsp = new JScrollPane(jta_display);// ��ũ�ѱ�ɰ��� ��Ʈ��

		// jspũ�� ����
		jsp.setPreferredSize(new Dimension(400, 500));

		this.add(jsp, "Center");

		/*
		 * // �б������� ���� jta_display.setEditable(false); String display_message =
		 * String.format("[%s]�� ����:\r\n   %s\r\n", msg_array[0], msg_array[1]); //���â��
		 * �ֱ� jta_display.append(display_message);
		 * 
		 * //�����Ǳ��� int position = jta_display.getDocument().getLength(); //������ ���� Caret��
		 * ��ġ��Ų�� jta_display.setCaretPosition(position);
		 */
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPChat();
	}
}