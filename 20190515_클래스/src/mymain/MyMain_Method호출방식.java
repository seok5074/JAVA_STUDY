package mymain;

class TestMethod{
	//call by name : 이름만 이용해서 호출
	public void title() {
		System.out.println("---메소드호출 연습---");
	}
	//call by value : 이름과 값을 전달해서 호출
	public int puls(int a, int b) {
		return a+b;
	}
	//call by reference : 이름+참조값을 전달해서 호출
	public void title(String My_title2) {
		System.out.printf(My_title2);
		
	}
	
}


public class MyMain_Method호출방식 {

	public static void main(String[] args) {
		TestMethod tm =new TestMethod();//객체 생성 
		tm.title();
		
		String My_title= new String("---내가 지정한 타이틀---");
		tm.title(My_title);
	}
}
