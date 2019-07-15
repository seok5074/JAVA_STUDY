package mymain;

import java.util.Arrays;

import myutil.MyArray;

public class MyMain_배열1_응용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//			0  1 2 3   4  5   6
		int [] mr ={11,5,2,3 , 1, 33, 22};
		//정렬 : 오름차순(작->큰) 내림차순(큰->작)
		
		System.out.println("---before sort---");
		MyArray.displayArray(mr);
		//기존 Arrays 를 이용
		//Arrays.sort()
		/*
		 * Arrays.sort(mr); // 오름차순 System.out.println("---afrter sort---");
		 * MyArray.displayArray(mr);
		 * 
		 * //선택정렬
		 * 
		 * MyArray.array_sort_asc(mr); System.out.println("---afrter sort(asc)---");
		 * MyArray.displayArray(mr);
		 * 
		 * MyArray.array_sort_desc(mr); System.out.println("---afrter sort(desc)---");
		 * MyArray.displayArray(mr);
		 * 
		 * 
		 * MyArray.array_sort_asc(mr,2,4); System.out.println("---wow---");
		 * MyArray.displayArray(mr);
		 */
		MyArray.array_sort_asc(mr,2,5);
		System.out.println("---asc---");
		MyArray.displayArray(mr);
		
		mr = new int[] {11,5,2,3 , 1, 33, 22};
		MyArray.array_sort_desc(mr,0,2);
		System.out.println("---desc---");
		MyArray.displayArray(mr);
		
	}

}
