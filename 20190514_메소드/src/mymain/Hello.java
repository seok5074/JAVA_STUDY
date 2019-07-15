package mymain;

public class Hello {

	/*
	 * 단축키 주석 달기 -> Ctrl + shift + / 
	 * 주석 해제 -> Ctrl + shift + \ 
	 * 폰트 조절 -> Ctrl +
	 * shitf+ +(크게) -(작게)
	 * 
	 * 일괄적 이름 바꾸기: 선택 -> ctrl+1-> ctrl+2(이름변경하기) 
	 * 코드정렬 -> Ctrl + shitf + F
	 * 코드최적화 : Ctrl + shift + o
	 */
	public static void main(String[] args) {
		String myname = "홍길동";

		
		
		
		
		System.out.println(myname + "hi!!~hello~~");
		System.out.println(myname + "hi!!~hello~~");
		System.out.println(myname + "hi!!~hello~~");

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				continue;
			System.out.println();
		}
	}

}
