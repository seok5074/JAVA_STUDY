package myutil;

public class customer implements Runnable{
	private car car;
	public customer (car car) {
		this.car=car;
	}
	public void run() {
		String carName =null;
		for(int i=0;i<20;i++) {
			carName =car.pop();
			try {
				Thread.sleep((int)(Math.random()*200));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
