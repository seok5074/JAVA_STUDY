package mymain;

public class MyMain_열거형 {
	//상수선언
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
			System.out.println("--left 방향으로 이동한다.--");
		}else if(direction == Direction.RIGHT) {
			System.out.println("--right 방향으로 이동한다.--");
		}
		//final상수로 선언한 상수 활용 예시
		int bang = LEFT;
        if(bang==LEFT) {
        	System.out.println("--left 방향으로 이동합니다--");
        }
        
		
	}

}
