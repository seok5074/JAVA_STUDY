package mymain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MoveBall extends JFrame {

	// GrimPanũ��
	final static int WIDTH = 600;
	final static int HEIGHT = 400;

	// �̹��� �ε�
	static Image image;
	static {
		image = new ImageIcon("��.png").getImage();
	}

	GrimPan grimPan;
	Font font = new Font("����ü", Font.BOLD, 30);

	// ���� ���� ����
	int ball_radius = 10;// ������
	// ȭ�����߾�
	int ball_x = WIDTH / 2 - ball_radius;
	int ball_y = HEIGHT / 2 - ball_radius;

	// ���ǹ��� ����
	boolean bRight = true;// �¿�����Ѵ�
	boolean bDown = true;// ���ϰ����Ѵ�,

	// �׸����� ���� Ŭ������ ����
	// paintComponent : ����ȣ��ǳ�?
	// 1.���α׷�����
	// 2.����ȭ���� ��ȭ(�������� �ٽó�Ÿ����)
	// 3.����ڰ� ȣ��(����ȣ��)
	// grimPan.repaint() call ->
	class GrimPan extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			// Dimension d = getSize();
			// System.out.printf("W=%d H=%d\n",d.width,d.height);
			// System.out.println("---call---");
			// �׸��� ����
			// draw_test(g);

			// ����ȭ�� �����
			g.clearRect(0, 0, MoveBall.WIDTH, MoveBall.HEIGHT);

			// ���׸���
			g.setColor(Color.RED);
			g.fillOval(ball_x, ball_y, ball_radius * 2, ball_radius * 2);

		}
	}

	public void draw_test(Graphics g) {
		// TODO Auto-generated method stub
		// Graphics : �׸��� ��ü
		// ��Ʈ����
		g.setFont(font);

		// Gradiation
		for (int i = 0; i < 256; i++) {
			Color color = new Color(i, i, 0);
			g.setColor(color);
			g.drawLine(0, i, WIDTH, i);
		}

//���ڿ� ���		
		String message = "�ȳ��ϼ���";
		// �׸������ x y
		g.drawString(message, 200 + 1, 30 + 1);
		// Į������
		g.setColor(Color.red);
		g.drawString(message, 200, 30);
//�������	
		// �簢��
		g.setColor(Color.blue);
		g.drawRect(10, 50, 100, 100);// �׵θ���
		g.fillRect(120, 50, 100, 100);// ä���� �׸���

		// Ÿ��
		g.setColor(Color.green);
		g.drawOval(10, 160, 100, 100);
		g.fillOval(120, 160, 100, 100);

		g.setColor(new Color(255, 255, 0));
		// �� x1 y1 x2 y2
		g.drawLine(10, 300, 210, 300);

//�̹��� ���
		g.drawImage(image, 300, 100, this);
		g.drawImage(image, 300, 250, this);

	}

	Timer timer;

	public MoveBall() {
		// TODO Auto-generated constructor stub
		super("��������");// ����

		// �׸��ǻ���
		init_grimpan();

		// Ű�����ʱ�ȭ
		init_key_event();

		// ��ġ ũ�� x y w h
		// super.setBounds(500, 200, 600, 400);
		super.setLocation(500, 200);

		// ũ�⺯��Ұ�
		super.setResizable(false);

		// �ڽ������� ũ�⿡ ���缭 �������� �����
		super.pack();

		// ȭ�鿡 ���̱�
		super.setVisible(true);

		// �����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Ÿ�̸� ����
		init_timer();

	}

	private void init_key_event() {

//		this.addKeyListener(ó����ü);
		/*
		 * 1.ù��° ��� class MyKeyEvent implements KeyListener{ public void
		 * keyTyped(KeyEvent e) { } public void keyPressed(KeyEvent e) { } public void
		 * keyReleased(KeyEvent e) { } }
		 */
		/*
		 * 2.�ι�°��� class MyKeyAdapter extends KeyAdapter{
		 * 
		 * @Override public void keyPressed(KeyEvent e) { }
		 * 
		 * }
		 */

		// 3.����°���
		KeyListener key_listener = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode(); // VK(virtual key)

				if (key == KeyEvent.VK_LEFT) {
					bRight = false;
				} else if (key == KeyEvent.VK_RIGHT) {
					bRight = true;
				} else if (key == KeyEvent.VK_DOWN) {
					bDown = true;
				} else if (key == KeyEvent.VK_UP) {
					bDown = false;
				}

				// ��Ű���
				if (key == KeyEvent.VK_ADD || key == KeyEvent.VK_SPACE) { // +
					ball_radius++;
					if (ball_radius > 50) {
						ball_radius = 50;
					}
				} else if (key == KeyEvent.VK_SUBTRACT || key == KeyEvent.VK_ALT) {// -
					ball_radius--;
					if (ball_radius < 5) {
						ball_radius = 5;
					}

				}
				if (key == KeyEvent.VK_S) {
					if (timer.isRunning())
						timer.stop();
					else
						timer.restart();
				}

			}
		};

		// ���簴ü���� Ű�� ������ ó����ü ���� ó���� ����
		this.addKeyListener(key_listener);
	}

	private void init_grimpan() {
		// TODO Auto-generated method stub
		grimPan = new GrimPan();
		// ũ������
		grimPan.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		// ���� ������ �߿� �߰�
		this.add(grimPan, "Center");
	}

	private void init_timer() {
		// TODO Auto-generated method stub

		// Ÿ�̸ӷκ��� ȣ��޴� ��ü
		ActionListener timer_listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// System.out.println("--timer call--");
				process();//

				// �ٽñ׷���
				grimPan.repaint();
			}
		};

		// �ð�(1/1000��)
		timer = new Timer(10, timer_listener);

		timer.start();

	}

	// �������ϱ�

	protected void process() {
		// ���̵�

		// ball_x--;

		move_ball();

	}

	int gan = 5;
	int gameover = 0;

	private void move_ball() {

		if (bRight)
			ball_x += gan;
		else
			ball_x -= gan;

		if (bDown)
			ball_y += gan;
		else
			ball_y -= gan;

		// �����ʺ��� ��ҳ�?
		if (ball_x + ball_radius * 2 > WIDTH) {
			bRight = false;
			ball_x = WIDTH - ball_radius * 2;
			gameover++;

		} else if (ball_x < 0) {// ���ʺ��� ��ҳ�?
			bRight = true;
			ball_x = 0;
			gameover++;

		}

		// �� �Ʒ� üũ
		else if (ball_y + ball_radius * 2 > HEIGHT) {
			bDown = false;
			ball_y = HEIGHT - ball_radius * 2;
			gameover++;

		} else if (ball_y < 0) {// ���ʺ��� ��ҳ�?
			bDown = true;
			ball_y = 0;
			gameover++;
		}

		if (gameover == 10) {
			System.out.println("���ӿ���");

		} else if (gameover >= 100) {
			System.out.println("WIN");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MoveBall();
	}
}
//JFrame : �������� ��ɵ��� �ִ°�(border , )
//JPannel: �׳� �гθ� �ִ� ��