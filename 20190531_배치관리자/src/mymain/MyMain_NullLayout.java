package mymain;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyMain_NullLayout extends JFrame {

	public MyMain_NullLayout() {
		super("NullLayout"); // ���� �ۼ�

		
		
		//��ġ�������
		this.setLayout(null);
		
		//�̸�:
		JLabel jlb_name = new JLabel("�̸�: ");
		
		this.add(jlb_name);
		//��ġ + ũ�� ����
		jlb_name.setBounds(10, 10, 60, 30);
		//�Է� ��Ʈ��(1��¥��)
		JTextField jtf_name = new JTextField();
		jtf_name.setBounds(50, 10, 100, 30);
		this.add(jtf_name);
		
		
		//�ڱ�Ұ�
		//�������Է�
		JTextArea jta_intro = new JTextArea();
		
		JScrollPane jsp =new JScrollPane(jta_intro);
		
		jta_intro.setBounds(10, 50 , 200,  60);
		this.add(jsp);
		
		//���
		JLabel jlb_hobby = new JLabel("���");
		jlb_hobby.setBounds(10, 120, 60, 30);
		this.add(jlb_hobby);
		
		JCheckBox jcb_hobby1 = new JCheckBox("�");
		jcb_hobby1.setBounds(70, 120, 80, 30);
		this.add(jcb_hobby1);

		JCheckBox jcb_hobby2 = new JCheckBox("����");
		jcb_hobby2.setBounds(150, 120, 80, 30);
		this.add(jcb_hobby2);

		JCheckBox jcb_hobby3 = new JCheckBox("��ȭ");
		jcb_hobby3.setBounds(230, 120, 80, 30);
		this.add(jcb_hobby3);
		
		//�����ڽ� ()
		JLabel jlb_gender = new JLabel("���� :");
		jlb_gender.setBounds(10, 160, 60, 30);
		this.add(jlb_gender);
		//�����ϳ��� �����Ҽ��ְ��ҷ���
		JRadioButton jrb_man = new JRadioButton("����");
		jrb_man.setBounds(70, 160, 80, 30);
		this.add(jrb_man);
		
		JRadioButton jrb_female = new JRadioButton("����");
		jrb_female.setBounds(150,160, 80, 30);
		this.add(jrb_female);		
		//������ư�߿� �ϳ��� �����Ҽ��ְ��ϴ� ��ɼ�����
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb_man);
		bg.add(jrb_female);
		
		//�޺��ڽ�
		JLabel jlb_blood = new JLabel("������");
		jlb_blood.setBounds(10, 200, 60, 30);
		this.add(jlb_blood);
		String [] blood_array = {"A��","AB��","B��","O��"};
		JComboBox<String> jcb_blood =new JComboBox<String>(blood_array);
		jcb_blood.setBounds(70, 200, 80, 30);
		this.add(jcb_blood);
		
		
		//��ġũ��		 x     y    w   h
		super.setBounds(500, 200, 500, 300);

		//ȭ�鿡 ���̱�
		super.setVisible(true);

		//�����ڵ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyMain_NullLayout();
	}

}