package myutil;

public class Parent {
	int p_money;
	public Parent() {
		super();
		p_money=100;
	}
	public Parent(int p_money) {
		super(); //첫번째 문장에 써야한다.
		this.p_money = p_money;
	}
}
