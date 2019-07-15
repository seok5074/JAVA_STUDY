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

	// GrimPan크기
	final static int WIDTH = 600;
	final static int HEIGHT = 400;

	// 이미지 로드
	static Image image;
	static {
		image = new ImageIcon("게.png").getImage();
	}

	GrimPan grimPan;
	Font font = new Font("굴림체", Font.BOLD, 30);

	// 공에 대한 변수
	int ball_radius = 10;// 반지름
	// 화면정중앙
	int ball_x = WIDTH / 2 - ball_radius;
	int ball_y = HEIGHT / 2 - ball_radius;

	// 공의방향 결정
	boolean bRight = true;// 좌우결정한다
	boolean bDown = true;// 상하결정한다,

	// 그림판을 내부 클래스로 선언
	// paintComponent : 언제호출되냐?
	// 1.프로그램시작
	// 2.현재화면의 변화(가려졌다 다시나타나면)
	// 3.사용자가 호출(간접호출)
	// grimPan.repaint() call ->
	class GrimPan extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			// Dimension d = getSize();
			// System.out.printf("W=%d H=%d\n",d.width,d.height);
			// System.out.println("---call---");
			// 그리기 연습
			// draw_test(g);

			// 이전화면 지우기
			g.clearRect(0, 0, MoveBall.WIDTH, MoveBall.HEIGHT);

			// 공그리기
			g.setColor(Color.RED);
			g.fillOval(ball_x, ball_y, ball_radius * 2, ball_radius * 2);

		}
	}

	public void draw_test(Graphics g) {
		// TODO Auto-generated method stub
		// Graphics : 그리기 객체
		// 폰트적용
		g.setFont(font);

		// Gradiation
		for (int i = 0; i < 256; i++) {
			Color color = new Color(i, i, 0);
			g.setColor(color);
			g.drawLine(0, i, WIDTH, i);
		}

//문자열 출력		
		String message = "안녕하세요";
		// 그림자출력 x y
		g.drawString(message, 200 + 1, 30 + 1);
		// 칼라적용
		g.setColor(Color.red);
		g.drawString(message, 200, 30);
//도형출력	
		// 사각형
		g.setColor(Color.blue);
		g.drawRect(10, 50, 100, 100);// 테두리만
		g.fillRect(120, 50, 100, 100);// 채워서 그리기

		// 타원
		g.setColor(Color.green);
		g.drawOval(10, 160, 100, 100);
		g.fillOval(120, 160, 100, 100);

		g.setColor(new Color(255, 255, 0));
		// 선 x1 y1 x2 y2
		g.drawLine(10, 300, 210, 300);

//이미지 출력
		g.drawImage(image, 300, 100, this);
		g.drawImage(image, 300, 250, this);

	}

	Timer timer;

	public MoveBall() {
		// TODO Auto-generated constructor stub
		super("공굴리기");// 제목

		// 그림판생성
		init_grimpan();

		// 키보드초기화
		init_key_event();

		// 위치 크기 x y w h
		// super.setBounds(500, 200, 600, 400);
		super.setLocation(500, 200);

		// 크기변경불가
		super.setResizable(false);

		// 자식윈도우 크기에 맞춰서 프레임을 씌우기
		super.pack();

		// 화면에 보이기
		super.setVisible(true);

		// 종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 타이머 생성
		init_timer();

	}

	private void init_key_event() {

//		this.addKeyListener(처리객체);
		/*
		 * 1.첫번째 방법 class MyKeyEvent implements KeyListener{ public void
		 * keyTyped(KeyEvent e) { } public void keyPressed(KeyEvent e) { } public void
		 * keyReleased(KeyEvent e) { } }
		 */
		/*
		 * 2.두번째방법 class MyKeyAdapter extends KeyAdapter{
		 * 
		 * @Override public void keyPressed(KeyEvent e) { }
		 * 
		 * }
		 */

		// 3.세번째방법
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

				// 공키우기
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

		// 현재객체에서 키가 눌리면 처리객체 에게 처리를 위임
		this.addKeyListener(key_listener);
	}

	private void init_grimpan() {
		// TODO Auto-generated method stub
		grimPan = new GrimPan();
		// 크기지정
		grimPan.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		// 현재 프레임 중에 추가
		this.add(grimPan, "Center");
	}

	private void init_timer() {
		// TODO Auto-generated method stub

		// 타이머로부터 호출받는 객체
		ActionListener timer_listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// System.out.println("--timer call--");
				process();//

				// 다시그려라
				grimPan.repaint();
			}
		};

		// 시간(1/1000초)
		timer = new Timer(10, timer_listener);

		timer.start();

	}

	// 간격정하기

	protected void process() {
		// 공이동

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

		// 오른쪽벽에 닿았냐?
		if (ball_x + ball_radius * 2 > WIDTH) {
			bRight = false;
			ball_x = WIDTH - ball_radius * 2;
			gameover++;

		} else if (ball_x < 0) {// 왼쪽벽에 닿았냐?
			bRight = true;
			ball_x = 0;
			gameover++;

		}

		// 위 아래 체크
		else if (ball_y + ball_radius * 2 > HEIGHT) {
			bDown = false;
			ball_y = HEIGHT - ball_radius * 2;
			gameover++;

		} else if (ball_y < 0) {// 윗쪽벽에 닿았냐?
			bDown = true;
			ball_y = 0;
			gameover++;
		}

		if (gameover == 10) {
			System.out.println("게임오버");

		} else if (gameover >= 100) {
			System.out.println("WIN");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MoveBall();
	}
}
//JFrame : 윈도우의 기능들이 있는거(border , )
//JPannel: 그냥 패널만 있는 거