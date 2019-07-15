package mymain;

import myutil.Child;

public class MyMain_super {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//생성하는방법.
		Child c1 = new Child(); // 1. 기본생성자로생성
		c1.display();
		
		Child c2 =new Child(50); // 값 초기화
		c2.display();
		
		// parent 값을 먼저초기화하고 child 값을 초기화한다.
		Child c3 =new Child(100,1000); // 두개의값을 초기화
		c3.display();
		
		
	}

}
