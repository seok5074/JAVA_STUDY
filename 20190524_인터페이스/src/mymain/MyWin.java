package mymain;

import java.awt.Frame;
import java.awt.event.WindowListener;

public class MyWin extends Frame{

	public MyWin() {
		super("������ �̺�Ʈ ����");
		
		//��ġ�� ũ������
		super.setBounds(200, 100, 300, 300);
		
		super.setVisible(true);
		
		
		WindowListener listener = new MyWindowEventListener();
		
		this.addWindowListener(listener);
		
		
		//������ �̺�Ʈ ���
		//���� �̺�Ʈ ��(event Delegation Model)
		//�̺�Ʈ�ҽ�.addXxxx�̺�Ʈ����Listener(�̺�Ʈ������ϴ� ó����ü); <=�ؼ�
		//						ó����ü�� windowListener�� implements�س��� ��ü�̾���Ѵ�.
		this.addWindowListener(null);
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyWin();
	}

}
