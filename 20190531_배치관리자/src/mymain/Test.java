package mymain;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test extends JFrame {

	public Test() {
		super("사원등록"); // 제목 작성

		
		
		this.setLayout(null);
		 
		JLabel name= new JLabel("성                 명");
		name.setBounds(10, 10, 80, 30);
		this.add(name);
		
		JTextField j_name = new JTextField();
		j_name.setBounds(100, 10, 80, 30);
		this.add(j_name);
		
		JLabel gender =new JLabel("성   별");
		gender.setBounds(180, 10, 100, 30);
		this.add(gender);
		JRadioButton jrb_man = new JRadioButton("남");
		jrb_man.setBounds(220, 10, 40, 30);
		this.add(jrb_man);
		
		JRadioButton jrb_female = new JRadioButton("여");
		jrb_female.setBounds(260,10, 40, 30);
		this.add(jrb_female);		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb_man);
		bg.add(jrb_female);
		
		JLabel num =new JLabel("주민등록번호");
		num.setBounds(10, 50, 80, 30);
		this.add(num);
		JLabel ki =new JLabel("-");
		ki.setBounds(195, 50, 30, 30);
		this.add(ki);
		
		JTextField num1 = new JTextField();
		num1.setBounds(100, 50, 90, 30);
		this.add(num1);
		
		JTextField num2 = new JTextField();
		num2.setBounds(210, 50, 90, 30);
		this.add(num2);
		
		JLabel addr =new JLabel("주                 소");
		addr.setBounds(10, 90, 100, 30);
		this.add(addr);
		
		JTextField addr1 =new JTextField();
		addr1.setBounds(100, 90, 240, 30);
		this.add(addr1);
		
		JLabel bu =new JLabel("부      서      명");
		bu.setBounds(10, 130, 90, 30);
		this.add(bu);
		
		String [] bu_array = {"기획부","영업부","수리부","법무부","총획부","개발부","사설부","인사부"};
		JComboBox<String> bu_arr = new JComboBox<String>(bu_array);
		bu_arr.setBounds(100, 130, 80, 30);
		this.add(bu_arr);
		
		JLabel hob =new JLabel("취                 미");
		hob.setBounds(10, 170, 90, 30);
		this.add(hob);
		
		JCheckBox jcb_hobby1 = new JCheckBox("운동");
		jcb_hobby1.setBounds(90, 170, 59, 30);
		this.add(jcb_hobby1);
		
		JCheckBox jcb_hobby2 = new JCheckBox("음악감상");
		jcb_hobby2.setBounds(145, 170, 80, 30);
		this.add(jcb_hobby2);

		JCheckBox jcb_hobby3 = new JCheckBox("영화");
		jcb_hobby3.setBounds(228, 170, 59, 30);
		this.add(jcb_hobby3);

		JCheckBox jcb_hobby4 = new JCheckBox("낚시");
		jcb_hobby4.setBounds(284, 170, 60, 30);
		this.add(jcb_hobby4);
		
		JLabel intro =new JLabel("자   기   소  개");
		intro.setBounds(10, 200, 80, 30);
		this.add(intro);
		
		JTextArea  jta_intro = new JTextArea();
		
		JScrollPane jsp = new JScrollPane(jta_intro);
		
		jsp.setBounds(10, 230, 320, 120);
		this.add(jsp);
		
		JButton save = new JButton("저장");
		save.setBounds(110, 360, 60, 30);
		this.add(save);
		JButton exit = new JButton("종료");
		exit.setBounds(180, 360, 60, 30);
		this.add(exit);
		if(exit.equals(exit))
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		//위치크기		 x     y    w   h
		super.setBounds(300, 200, 350, 420);

		//화면에 보이기
		super.setVisible(true);

		super.setResizable(false);

		//종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {

		new Test();
	}

}