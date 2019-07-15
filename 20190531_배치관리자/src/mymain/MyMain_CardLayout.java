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

	// ī�带�������г�
	JPanel centerPanel;

	CardLayout card = new CardLayout();

	public MyMain_CardLayout() {
		super("CardLayout"); // ���� �ۼ�

		// ���(North)��ġ ��ġ
		// JPanel������ + Layout����
		// JPanel ��ġ�� �ٷ� ��������
		JPanel northPanel = new JPanel(new GridLayout(1, 3));
		this.add(northPanel, "North");

		JButton jbt_card1 = new JButton("card 1");
		JButton jbt_card2 = new JButton("card 2");
		JButton jbt_card3 = new JButton("card 3");

		northPanel.add(jbt_card1);
		northPanel.add(jbt_card2);
		northPanel.add(jbt_card3);

		// ��ư�̺�Ʈ ó��
		ActionListener listener = new ActionListener() {

			@Override // �͸�ü
			public void actionPerformed(ActionEvent e) {
				Object evt_bt = e.getSource();
				// �̺�Ʈ�� �߻���Ų ��Ʈ������
				if (evt_bt == jbt_card1) {
					card.show(centerPanel, "card1");
				} else if (evt_bt == jbt_card2) {
					card.show(centerPanel, "card2");
				} else if (evt_bt == jbt_card3) {
					card.show(centerPanel, "card3");

				}
			}
		};

		// �̺�Ʈ�ҽ� -> �̺�Ʈ�� �߻���Ų ��Ʈ��
		// �̺�Ʈ�ҽ�.addActionlistener(ó����ü)
		jbt_card1.addActionListener(listener);
		jbt_card2.addActionListener(listener);
		jbt_card3.addActionListener(listener);

		// �߾�(center)�� ��ġ
		centerPanel = new JPanel();
		centerPanel.setLayout(card); // centerpanel�� ��ġ����� cardlayout
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

		// ī�巹�̾ƿ��� ���縦�Ѵ�.
		centerPanel.add(cardP1, "card1");
		centerPanel.add(cardP2, "card2");
		centerPanel.add(cardP3, "card3");
		/*
		 * 
		 * //������ī�带�����ְʹ� card.show(centerPanel, "card2"); card.first(centerPanel); //ù��°
		 * �����ֶ� card.last(centerPanel); // �������� �����ֶ� card.next(centerPanel); //������ -> ����
		 * >ó��
		 */

		// ��ġũ�� x y w h
		super.setBounds(500, 200, 300, 300);

		// ȭ�鿡 ���̱�
		super.setVisible(true);

		// �����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyMain_CardLayout();
	}

}