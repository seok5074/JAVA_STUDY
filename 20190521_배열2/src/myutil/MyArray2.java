package myutil;

public class MyArray2 {

	//값을 순서대로 넣는 기능
	//										↓ 변수이름 바꿔도된다.
	public static void setArray(int [][] mm2) {
		//					int [][] mm2=mm; 과 같다.
		int su =1;
		for(int i=0;i<mm2.length;i++) { // 행만큼돈다
			for(int k=0;k<mm2[i].length;k++) {
				
				mm2[i][k]=su++;
			}
		}
	}
	// 원하는값으로 채워서 출력
	public static void fill(int [][] mm, int val) {
		for(int i=0;i<mm.length;i++) {
			for(int k=0;k<mm[i].length;k++) {
				mm[i][k]=val;
			}
		}
	}
	
	//출력
	public static void display(int [][] mm) {

		for(int i=0;i<mm.length;i++) { // 행첨자
			for(int k=0;k<mm[i].length;k++) { //열첨자
				System.out.printf("%3d",mm[i][k]);
			}
			System.out.println();//줄바뀌
		}
	}
}