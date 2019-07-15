package mymain;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMain_CardLayout extends JFrame {

	// 카드를적재할패널
	JPanel centerPanel;

	CardLayout card = new CardLayout();

	public MyMain_CardLayout() {
		super("CardLayout"); // 제목 작성

		// 상단(North)위치 배치
		// JPanel생성자 + Layout지정
		// JPanel 위치에 바로 지정가능
		JPanel northPanel = new JPanel(new GridLayout(1, 3));
		this.add(northPanel, "North");

		JButton jbt_card1 = new JButton("card 1");
		JButton jbt_card2 = new JButton("card 2");
		JButton jbt_card3 = new JButton("card 3");

		northPanel.add(jbt_card1);
		northPanel.add(jbt_card2);
		northPanel.add(jbt_card3);

		// 버튼이벤트 처리
		ActionListener listener = new ActionListener() {

			@Override // 익명객체
			public void actionPerformed(ActionEvent e) {
				Object evt_bt = e.getSource();
				// 이벤트를 발생시킨 컨트롤정보
				if (evt_bt == jbt_card1) {
					card.show(centerPanel, "card1");
				} else if (evt_bt == jbt_card2) {
					card.show(centerPanel, "card2");
				} else if (evt_bt == jbt_card3) {
					card.show(centerPanel, "card3");

				}
			}
		};

		// 이벤트소스 -> 이벤트를 발생시킨 컨트롤
		// 이벤트소스.addActionlistener(처리객체)
		jbt_card1.addActionListener(listener);
		jbt_card2.addActionListener(listener);
		jbt_card3.addActionListener(listener);

		// 중앙(center)에 배치
		centerPanel = new JPanel();
		centerPanel.setLayout(card); // centerpanel의 배치방법은 cardlayout
		this.add(centerPanel, "Center");

		//
		JPanel cardP1 = new JPanel();
		cardP1.setBackground(Color.RED);

		cardP1.add(new JButton("1"));
		cardP1.add(new JButton("2"));
		cardP1.add(new JButton("3"));

		JPanel cardP2 = new JPanel();
		cardP2.setBackground(Color.GREEN);

		JPanel cardP3 = new JPanel();
		cardP3.setBackground(Color.BLUE);

		// 카드레이아웃에 적재를한다.
		centerPanel.add(cardP1, "card1");
		centerPanel.add(cardP2, "card2");
		centerPanel.add(cardP3, "card3");
		/*
		 * 
		 * //지정한카드를보여주것다 card.show(centerPanel, "card2"); card.first(centerPanel); //첫번째
		 * 보여주라 card.last(centerPanel); // 마지막꺼 보여주라 card.next(centerPanel); //마지막 -> 다음
		 * >처음
		 */

		// 위치크기 x y w h
		super.setBounds(500, 200, 300, 300);

		// 화면에 보이기
		super.setVisible(true);

		// 종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyMain_CardLayout();
	}

}