package myutil;

public class Save {
	
	String name; // �����ڸ�
	int save_money; // �����
	
	//���������� ���������ִ�.
	public static double rate; //����
	
	
	public Save() {
		
	}

	public Save(String name, int save_money) {
		super();
		this.name = name;
		this.save_money = save_money;
	}
	public void display() {
		
		System.out.printf("�̸�: %10s   �����: %10d ����: %.2f ����: %10d\n",
							name,save_money,rate,(int)(save_money*rate));
	}
	
	
}
