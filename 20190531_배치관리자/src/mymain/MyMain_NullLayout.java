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
		super("NullLayout"); // 제목 작성

		
		
		//배치방법해제
		this.setLayout(null);
		
		//이름:
		JLabel jlb_name = new JLabel("이름: ");
		
		this.add(jlb_name);
		//위치 + 크기 지정
		jlb_name.setBounds(10, 10, 60, 30);
		//입력 컨트롤(1줄짜리)
		JTextField jtf_name = new JTextField();
		jtf_name.setBounds(50, 10, 100, 30);
		this.add(jtf_name);
		
		
		//자기소개
		//여러줄입력
		JTextArea jta_intro = new JTextArea();
		
		JScrollPane jsp =new JScrollPane(jta_intro);
		
		jta_intro.setBounds(10, 50 , 200,  60);
		this.add(jsp);
		
		//취미
		JLabel jlb_hobby = new JLabel("취미");
		jlb_hobby.setBounds(10, 120, 60, 30);
		this.add(jlb_hobby);
		
		JCheckBox jcb_hobby1 = new JCheckBox("운동");
		jcb_hobby1.setBounds(70, 120, 80, 30);
		this.add(jcb_hobby1);

		JCheckBox jcb_hobby2 = new JCheckBox("낚시");
		jcb_hobby2.setBounds(150, 120, 80, 30);
		this.add(jcb_hobby2);

		JCheckBox jcb_hobby3 = new JCheckBox("영화");
		jcb_hobby3.setBounds(230, 120, 80, 30);
		this.add(jcb_hobby3);
		
		//라디오박스 ()
		JLabel jlb_gender = new JLabel("성별 :");
		jlb_gender.setBounds(10, 160, 60, 30);
		this.add(jlb_gender);
		//둘중하나만 선택할수있게할려면
		JRadioButton jrb_man = new JRadioButton("남자");
		jrb_man.setBounds(70, 160, 80, 30);
		this.add(jrb_man);
		
		JRadioButton jrb_female = new JRadioButton("여자");
		jrb_female.setBounds(150,160, 80, 30);
		this.add(jrb_female);		
		//라디오버튼중에 하나만 선택할수있게하는 명령설정법
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb_man);
		bg.add(jrb_female);
		
		//콤보박스
		JLabel jlb_blood = new JLabel("혈액형");
		jlb_blood.setBounds(10, 200, 60, 30);
		this.add(jlb_blood);
		String [] blood_array = {"A형","AB형","B형","O형"};
		JComboBox<String> jcb_blood =new JComboBox<String>(blood_array);
		jcb_blood.setBounds(70, 200, 80, 30);
		this.add(jcb_blood);
		
		
		//위치크기		 x     y    w   h
		super.setBounds(500, 200, 500, 300);

		//화면에 보이기
		super.setVisible(true);

		//종료코드
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyMain_NullLayout();
	}

}