package myutil;

public class pig extends Animal {

	@Override
	public void 먹어라() {
		System.out.print("먹을사료는 : ");
		System.out.println("돼지사료");
	}

	@Override
	public void 울어라() {
		System.out.print("우는방법은 : ");
		System.out.println("꿀꿀");
	}

}
