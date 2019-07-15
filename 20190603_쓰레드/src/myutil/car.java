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
		case 1 : carName ="매그너스";break;
		case 2 : carName ="카렌스";break;
	}
	return carName;
}
public synchronized String pop() {
	String carName=null;
	if(carList.size()==0) {
		try {
			System.out.println("차가 없습니다. 생산할때까지 기다리세요");
			this.wait();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	carName =(String)carList.remove(carList.size()-1);
	System.out.println("손님이 차를 사갔습니다.");
	return carName;
	}

public synchronized void push(String car) {
	
	carList.add(car);
	System.out.printf("차가만들어졋습니다. 차이름은 -> %s\n",car);
	if(carList.size()==5) {
		this.notify();
	}
	
}
}