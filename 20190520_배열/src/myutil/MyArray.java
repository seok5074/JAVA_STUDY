package myutil;

// service ��ü
public class MyArray {

	//�迭�� ����Ұ��� 0���� ����
	public static void clearArray(int [] mr) {
		
		for(int i=0;i<mr.length;i++) {
			mr[i] = 0;
		}
	}
	
	//�迭�� ��Ұ��� 1���� ������� ����
	public static void setArray(int [] mr) {
		
		for(int i=0;i<mr.length;i++) {
			mr[i] = i + 1;
		}
	}
	
	//�迭�� ��Ұ��� ��� => [ 1 2 3 4 ]
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
	
	//���ϴ� ������ ä���
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
	
	//�������� : ��������(ascending)
	public static void array_sort_asc(int [] mr) {
		
		for(int i=0;i<mr.length-1;i++) {
			for(int k=i+1;k<mr.length;k++) {
				// mr[i]: ���ذ�
				if(mr[i] > mr[k]) { //�տ����� ũ�� ��ȯ�ض�
					int im = mr[i];
					mr[i] = mr[k];
					mr[k] = im;
				}
			}
		}
	}

	//�������� : ��������(descending)
	public static void array_sort_desc(int [] mr) {
		
		for(int i=0;i<mr.length-1;i++) {
			for(int k=i+1;k<mr.length;k++) {
				// mr[i]: ���ذ�
				if(mr[i] < mr[k]) { //�ڿ����� ũ�� ��ȯ�ض�
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
	




