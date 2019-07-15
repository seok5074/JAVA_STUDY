package myutil;

// service 객체
public class MyArray {

	//배열의 모든요소값을 0으로 셋팅
	public static void clearArray(int [] mr) {
		
		for(int i=0;i<mr.length;i++) {
			mr[i] = 0;
		}
	}
	
	//배열의 요소값을 1부터 순서대로 셋팅
	public static void setArray(int [] mr) {
		
		for(int i=0;i<mr.length;i++) {
			mr[i] = i + 1;
		}
	}
	
	//배열의 요소값을 출력 => [ 1 2 3 4 ]
	public static void displayArray(int [] mr) {
        
		System.out.print("[");
		for(int i=0;i<mr.length;i++) {
			System.out.printf("%3d",mr[i]);
		}
	    System.out.println(" ]"); 
	}
	
	public static void displayArray(String [] sr) {
        
		System.out.print("[");
		for(int i=0;i<sr.length;i++) {
			System.out.printf("%5s ",sr[i]);
		}
	    System.out.println(" ]"); 
	}
	
	//원하는 값으로 채우기
	public static void fill(int [] mr,int val) {
		for(int i=0;i<mr.length;i++) {
			mr[i] = val;
		}
	}
	
	public static void fill(int [] mr,int start,int end,int val) {
		for(int i=0;i<mr.length;i++) {
			if(i>=start && i<=end)
			   mr[i] = val;
		}
	}
	
	//선택정렬 : 오름차순(ascending)
	public static void array_sort_asc(int [] mr) {
		
		for(int i=0;i<mr.length-1;i++) {
			for(int k=i+1;k<mr.length;k++) {
				// mr[i]: 기준값
				if(mr[i] > mr[k]) { //앞에수가 크면 교환해라
					int im = mr[i];
					mr[i] = mr[k];
					mr[k] = im;
				}
			}
		}
	}

	//선택정렬 : 내림차순(descending)
	public static void array_sort_desc(int [] mr) {
		
		for(int i=0;i<mr.length-1;i++) {
			for(int k=i+1;k<mr.length;k++) {
				// mr[i]: 기준값
				if(mr[i] < mr[k]) { //뒤에수가 크면 교환해라
					int im = mr[i];
					mr[i] = mr[k];
					mr[k] = im;
				}
			}
		}
	}
	
	public static void array_sort_asc(int [] mr,int start ,int end ) {
		for(int i=start;i<mr.length-1;i++) {
			for(int k=i+1;k<end;k++) {
				if(mr[i] > mr[k]) { 
					int im = mr[i];
					mr[i] = mr[k];
					mr[k] = im;
				}
			}
		}
	}
	public static void array_sort_desc(int [] mr,int start ,int end ) {
		for(int i=start;i<mr.length-1;i++) {
			for(int k=i+1;k<end;k++) {
				if(mr[i] < mr[k]) { 
					int im = mr[i];
					mr[i] = mr[k];
					mr[k] = im;
				}
			}
		}
	
	}
}
	




