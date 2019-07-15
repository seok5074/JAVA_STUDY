package mymain;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWin2 extends JFrame {

	// <- here : member����κ�...Inner class
	private void setTitleChange(String title) {
		this.setTitle(title);
	}
	
	
	class MyButtonEventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("--�ѱ��� : �ȳ��ϼ���!!--");
			//frame title ���� : ����Ŭ���������� �ܺ�Ŭ������ ������� ����Ҽ��ִ�.
			setTitleChange("�ѱ��� : �ȳ��ϼ���");
		}
		
	}
	
	
	public MyWin2() {
		super(""); // ���� �ۼ�
		
		//JButton  :swing ��ü		��ư����
		//or Button:awt ��ü
		
		JButton jbt_kor = new JButton("�ѱ��� �λ縻");
		JButton jbt_jap = new JButton("�Ϻ��� �λ縻");
		JButton jbt_chi = new JButton("�߱��� �λ縻");
		JButton jbt_eng = new JButton("��  �� �λ縻");


		
		//������ ��ư JFrame ����
		
		  this.add(jbt_kor); 
		  this.add(jbt_jap); 
		  this.add(jbt_chi); 
		  this.add(jbt_eng);
		 

		//������ ����
		this.setLayout(new GridLayout(4,1));
		
		// ��ġ����
		/*
		 * this.add(jbt_kor,"East"); 
		 * this.add(jbt_jap,"North");
		 * this.add(jbt_chi,"South"); 
		 * this.add(jbt_eng,"West");
		 */
		
		
		//�̺�Ʈ���
		//ActionListener�� ����ϴ� ������Ʈ(��Ʈ��) : JButton.JMenuItem.JTimer
		ActionListener listener = new MyButtonEventHandler();
		
		//�̺�Ʈ�ҽ�.addActionListener(ó����ü);
		jbt_kor.addActionListener(listener);
		
		
		//
		int a; // ��������(local variable)
		//��ư�̺�Ʈ ó����ü(���ó���Ŭ����)
		class MyButtonEventHandler2 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("--�Ϻ��� : ����˪���--");
				setTitleChange("�Ϻ��� : ����˪���");	
			}
		}
		//�Ϻ��� �λ縻 ��ư Ŭ���� �̺�Ʈ ���
		/*ActionListener listener_jap=new
		 *MyButtonEventHandler2(); jbt_jap.addActionListener(listener_jap);*/
		//������ؼ�����
		jbt_jap.addActionListener(new MyButtonEventHandler2());
		
		//�߱����λ縻 ��ưŬ���� ó���� ��ü ����(�͸� ���� Ŭ����)
		ActionListener listener_chi =new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("--�߱��� : nihao--");
				setTitleChange("�߱��� : nihao");		
			}
		};
		jbt_chi.addActionListener(listener_chi);

		
		//�����λ縻 ��ưŬ���� �̺�Ʈ ó��
		jbt_eng.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("--��  �� : Hello--");
				setTitleChange("��  �� : Hello");		
			}
		});
		
		
		//��ġũ��		 x     y    w   h
		super.setBounds(500, 200, 300, 300);

		//ȭ�鿡 ���̱�
		super.setVisible(true);

		//�����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyWin2();
	}

}