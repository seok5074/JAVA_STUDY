package myutil;

public class Child extends Parent {
	
	int c_money;
	
	public Child() {
		// TODO Auto-generated constructor stub
		super(); //�����Ǹ� ���������� �ƹ���(parnet) �����ڸ� ȣ��
		c_money = 10;
	}
	public Child(int c_money) {
		super();//�����Ǹ� ���������� �ƹ��� �����ڸ� ȣ��
				//super(); Parent() call
		this.c_money=c_money;
	}

	public Child(int c_money,int p_money) {
		super(p_money);
		this.c_money = c_money;	
	}
	public void display() {
		System.out.println("====================================");
		System.out.printf("�ƹ����� �ֽŵ� : %d\n",super.p_money);
		System.out.printf("�������� : %d\n",this.c_money);
		System.out.println("====================================");

	}
	
	
}
