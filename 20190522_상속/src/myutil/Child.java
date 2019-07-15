package myutil;

public class Child extends Parent {
	
	int c_money;
	
	public Child() {
		// TODO Auto-generated constructor stub
		super(); //생략되면 묵시적으로 아버지(parnet) 생성자를 호출
		c_money = 10;
	}
	public Child(int c_money) {
		super();//생략되면 묵시적으로 아버지 생성자를 호출
				//super(); Parent() call
		this.c_money=c_money;
	}

	public Child(int c_money,int p_money) {
		super(p_money);
		this.c_money = c_money;	
	}
	public void display() {
		System.out.println("====================================");
		System.out.printf("아버지가 주신돈 : %d\n",super.p_money);
		System.out.printf("내가번돈 : %d\n",this.c_money);
		System.out.println("====================================");

	}
	
	
}
