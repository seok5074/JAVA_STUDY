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

	// �޽��� ���â
	JTextArea jta_display;

	// �ּ��Է�â
	JTextField jtf_address;
	JTextField jtf_message;

	// ��ȭ��
	String nick_name = "ȫ�浿";

	// udp ����
	DatagramSocket udp_socket;

	// ��Ʈ����
	Font font = new Font("����ü", Font.BOLD, 20);

	public UDPChat1() {
		super("UDPCHAT"); // ���� �ۼ�

		// ���â �ʱ�ȭ
		init_display();

		// �Է�â �ʱ�ȭ
		init_input();

		// �� ��Ʈ�ѿ� ��Ʈ����
		jta_display.setFont(font);

		jtf_address.setFont(font);
		jtf_message.setFont(font);

		// Ű�̺�Ʈ �ʱ�ȭ
		init_key_event();

		// ���� �ʱ�ȭ
		init_socket();

		// ��ġũ�� x y w h
		// super.setBounds(500, 200, 300, 300);
		setLocation(500, 200);

		pack();

		// ȭ�鿡 ���̱�
		super.setVisible(true);

		// �����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_socket() {
		try {
			// �����Ʈ ����
			udp_socket = new DatagramSocket(7000);// ������ ����� ��Ʈ����

			// �޽��� ����
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
		 * super.run(); } } new ReadThread().start(); �鵿�Ϲ���̴�.
		 */
		// �͸���Ŭ������ ����
		new Thread() {
			public void run() {
				while (true) {
					// �޽��� ������ ���� (���� �������� �𸣴� ����ؾ��Ѵ�.)
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
					// �޽��� ����
					send_message();
				}
			}

		};
		// �̺�Ʈ ���
		// �̺�Ʈ �ҽ�. addkey/listener(ó����ü)
		jtf_message.addKeyListener(listener);
	}

	protected void send_message() {
		// �Էµ� �޽��� ������
		String message = jtf_message.getText().trim();
		if (message.isEmpty()) {// �Է¸޽����� ������ ������
			jtf_message.setText("");

			return;
		}

		// ������ ����(���߿�)

		// ȭ�鿡 ���
		String display_message = String.format("[%s]�� ���� :\r\n %s\n", nick_name, message);

		// ���â�� �ֱ�
		jta_display.append(display_message);

		// ������ ����
		int position = jta_display.getDocument().getLength();

		// ������ ���� caret�� ��ġ��Ų��,
		jta_display.setCaretPosition(position);

		// go���� �Է�â �ٲٱ�
		jtf_message.setText("");

	}

	// �Է�â �ʱ�ȭ
	private void init_input() {
		JPanel p = new JPanel(new GridLayout(2, 1));
		this.add(p, "South");

		// �ּ�â �Է�
		p.add(jtf_address = new JTextField("255,255,255,255"));
		// �޼��� �Է�â �ֱ�
		p.add(jtf_message = new JTextField());

		//�Է�â�� ��Ŀ�� ����ֱ� 
		jtf_message.requestFocus();
		
	}

	// ���â �ʱ�ȭ
	private void init_display() {

		jta_display = new JTextArea(); // �������� �� ����ϴ� ��Ʈ��
		JScrollPane jsp = new JScrollPane(jta_display);

		// JScrollPane ũ�� ����
		jsp.setPreferredSize(new Dimension(400, 500));

		this.add(jsp, "Center");

		// �б��������� ����
		jta_display.setEditable(false);
	}

	public static void main(String[] args) {

		new UDPChat1();
	}

}
