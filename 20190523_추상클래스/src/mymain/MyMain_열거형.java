package mymain;

public class MyMain_������ {
	//�������
	public static final int LEFT	= 1;
	public static final int UP 	= 2;
	public static final int RIGHT = 4;
	public static final int DOWN 	= 8;
	
	enum Direction{
		LEFT,UP,RIGHT,DOWN;
	}
	public static void main(String[] args) {
		Direction direction =Direction.LEFT;
		
		if(direction == Direction.LEFT) {
			System.out.println("--left �������� �̵��Ѵ�.--");
		}else if(direction == Direction.RIGHT) {
			System.out.println("--right �������� �̵��Ѵ�.--");
		}
		//final����� ������ ��� Ȱ�� ����
		int bang = LEFT;
        if(bang==LEFT) {
        	System.out.println("--left �������� �̵��մϴ�--");
        }
        
		
	}

}
