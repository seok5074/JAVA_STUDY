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

	JTextArea jta_dispaly; // ���� ����͸�
	JTextField jtf_count; // �����ڼ� ���

	Font font = new Font("����ü", Font.BOLD, 20);
	
	//��������
	ServerSocket server;
	

	public MultiServer2() {
		super("��Ƽ����"); // ���� �ۼ�

		// ��Ʈ�� �ʱ�ȭ
		init_component();

		//�����ʱ�ȭ
		init_server();
		
		// ��ġũ�� x y w h
		// super.setBounds(500, 200, 300, 300);
		setLocation(500, 200);

		pack();

		// ȭ�鿡 ���̱�
		super.setVisible(true);

		// �����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_server() {
//									��Ʈ
		try {
			//System.out.println(Thread.currentThread().getName());
			server = new ServerSocket(8100);
			
			//���Ӵ�� ������ �Ҵ�
			new Thread() {
				public void run() {
					//System.out.println(Thread.currentThread().getName());

					while(true) {
						//���Ӵ��
						try {
							Socket child =server.accept();
							
							
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}.start();
			
			//���Ӵ��
			Socket child =server.accept();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void init_component() {

		// �����â �ʱ�ȭ
		jta_dispaly = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_dispaly);
		jsp.setPreferredSize(new Dimension(400, 400));
		this.add(jsp, "Center");

		// �����ڼ� ������
		JPanel p = new JPanel(new GridLayout(1, 3));
		JLabel jlb_title = new JLabel("�����ڼ�", JLabel.RIGHT);
		jtf_count = new JTextField("0");
		JLabel jlb_2 = new JLabel("(��)");

		p.add(jlb_title);
		p.add(jtf_count);
		p.add(jlb_2);
		this.add(p, "South");

		// �ο��� �߾�����
		jtf_count.setHorizontalAlignment(JTextField.CENTER);

		// ��Ʈ����
		jta_dispaly.setFont(font);
		jlb_title.setFont(font);
		jlb_2.setFont(font);
		jtf_count.setFont(font);

		// �����â �б�����
		jta_dispaly.setEditable(false);

	}

	public static void main(String[] args) {

		new MultiServer2();
	}

}