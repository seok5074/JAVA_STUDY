package myutil;

public class produce implements Runnable{
	private car car;
	public produce(car car) {
		this.car=car;
	}
	@Override
	public void run() {
		String carName=null;
		for(int i=0;i<20;i++) {
			carName =car.getCar();
			car.push(carName);
			try {
				Thread.sleep((int)(Math.random()*200));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
