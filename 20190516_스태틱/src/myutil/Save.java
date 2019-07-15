package myutil;

public class Save {
	
	String name; // 저축자명
	int save_money; // 저축액
	
	//접근제한이 있을수도있다.
	public static double rate; //이율
	
	
	public Save() {
		
	}

	public Save(String name, int save_money) {
		super();
		this.name = name;
		this.save_money = save_money;
	}
	public void display() {
		
		System.out.printf("이름: %10s   저축액: %10d 이율: %.2f 이자: %10d\n",
							name,save_money,rate,(int)(save_money*rate));
	}
	
	
}
