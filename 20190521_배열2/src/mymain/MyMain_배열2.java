package mymain;

import myutil.MyArray2;

public class MyMain_배열2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] mm =new int[3][4];
		MyArray2.setArray(mm);//순서대로 값을 부여한다.
		MyArray2.display(mm);
		
		System.out.println("7로채우라");
		MyArray2.fill(mm, 7);
		MyArray2.display(mm);
		
		//가변길이배열(열의길이가 가변적)
		int [][] mm2=new int[3][];
		
		mm2[0]=new int[2];
		mm2[1]=new int[3];
		mm2[2]=new int[4];
		
		System.out.println("가변길이 배열");
		MyArray2.setArray(mm2);
		MyArray2.display(mm2);
		
	}

}
