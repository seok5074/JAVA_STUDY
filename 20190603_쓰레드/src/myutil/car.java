package myutil;

import java.util.ArrayList;
import java.util.List;

public class car {
	private List<String> carList = null;

	public car() {
		carList = new ArrayList<String>();
	}



public String getCar() {
	String carName =null;
	switch((int)(Math.random()*3)) {
		case 0 : carName ="SM5";break;
		case 1 : carName ="�ű׳ʽ�";break;
		case 2 : carName ="ī����";break;
	}
	return carName;
}
public synchronized String pop() {
	String carName=null;
	if(carList.size()==0) {
		try {
			System.out.println("���� �����ϴ�. �����Ҷ����� ��ٸ�����");
			this.wait();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	carName =(String)carList.remove(carList.size()-1);
	System.out.println("�մ��� ���� �簬���ϴ�.");
	return carName;
	}

public synchronized void push(String car) {
	
	carList.add(car);
	System.out.printf("�����������ϴ�. ���̸��� -> %s\n",car);
	if(carList.size()==5) {
		this.notify();
	}
	
}
}