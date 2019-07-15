package mymain;

import myutil.MyArray2;

public class MyMain_배열2문제 {

	static int[][] rotate_right_90(int[][] src) {
		// 배열복제
		int rows = src.length;
		int cols = src[0].length;
		int[][] dest = new int[rows][cols];
		
		
		for(int i=0;i<rows;i++) {
			for(int k=0;k<cols;k++) {
				dest[4-i][k] =src[k][i];
			}
		}
		return dest;
	}
	
	//왼쪽으로 90도 회전
	static int[][] rotate_left_90(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;
		int[][] dest = new int[rows][cols];
		
		
		for(int i=0;i<rows;i++) {
			for(int k=0;k<cols;k++) {
				dest[i][k] =src[4-k][i];
			}
		}
		return dest;
	}
	//좌우반전
	static int[][] flip_left_right(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;
		int[][] dest = new int[rows][cols];
		
		
		for(int i=0;i<rows;i++) {
			for(int k=0;k<cols;k++) {
				dest[i][4-k] =src[i][k];
			}
		}
		return dest;
	}
	//상하반전
	static int[][] flip_up_down(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;
		int[][] dest = new int[rows][cols];
		
		
		for(int i=0;i<rows;i++) {
			for(int k=0;k<cols;k++) {
				dest[i][k] =src[4-i][k];
			}
		}
		return dest;
		
	}
	//대각선반전
	static int[][] flip_diamond1(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;
		int[][] dest = new int[rows][cols];
		
		
		for(int i=0;i<rows;i++) {
			for(int k=0;k<cols;k++) {
				dest[k][4-i] =src[4-i][k];
			}
		}
		return dest;
	}
	static int[][] flip_diamond2(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;
		int[][] dest = new int[rows][cols];
		
		
		for(int i=0;i<rows;i++) {
			for(int k=0;k<cols;k++) {
				dest[k][i] =src[4-i][4-k];
			}
		}
		return dest;

	}
	static int[][] flip_diamond_cross(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;
		int[][] dest = new int[rows][cols];
		
		
		for(int i=0;i<rows;i++) {
			for(int k=0;k<cols;k++) {
				dest[i][k] =src[i][k];
			}
		}
		return dest;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//

		int[][] mm = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		System.out.println("원본데이터");
		MyArray2.display(mm);
		System.out.println("오른쪽 90도");
		int [][] dest = rotate_right_90(mm);
		MyArray2.display(dest);
		System.out.println("왼쪽 90도");
		int [][] dest1 = rotate_left_90(mm);
		MyArray2.display(dest1);
		System.out.println("좌우반전");
		int [][] dest2 = flip_left_right(mm);
		MyArray2.display(dest2);
		System.out.println("상하반전");
		int [][] dest3= flip_up_down(mm);
		MyArray2.display(dest3);
		System.out.println("대각선 반전1");
		int [][] dest4= flip_diamond1(mm);
		MyArray2.display(dest4);
		System.out.println("대각선 반전2");
		int [][] dest5= flip_diamond2(mm);
		MyArray2.display(dest5);
		System.out.println("대각선 반전3");
		int [][] dest6= flip_diamond_cross(mm);
		MyArray2.display(dest6);
		
		/*
		 * int [][] mm2 =new int[9][9]; MyArray2.setArray(mm2);
		 * System.out.println("원본"); MyArray2.display(mm2);
		 * System.out.println("대각선 반전2"); dest= flip_diamond2(mm2);
		 * MyArray2.display(dest);
		 */
		
	}

}
