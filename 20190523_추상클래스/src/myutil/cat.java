package myutil;

public class cat extends Animal {

	@Override
	public void 먹어라() {
		System.out.print("먹을사료는 : ");
		System.out.println("고양이사료");
	}

	@Override
	public void 울어라() {
		System.out.print("우는방법은 : ");
		System.out.println("냐옹");
	}

}
