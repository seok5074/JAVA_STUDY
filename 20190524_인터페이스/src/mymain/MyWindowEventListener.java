package mymain;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//												window�����ɾ� �������� ��κ� Listener�̴�.
public class MyWindowEventListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosing");
		System.exit(0); // <- java����޼ҵ�
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		//�Ҹ��̺�Ʈ ��������.
		System.out.println("windowClosed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("windowIconified");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeiconified");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowActivated");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeactivated");
		
	}

	
	
	
}
