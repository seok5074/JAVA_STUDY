package mymain;

import java.util.StringTokenizer;

public class MyMain_StringTokenizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sido = "���� ��� ��õ ���� �뱸 �λ� ���� ����";
		// token : ����(�и�����)�������� �и��� ������
		StringTokenizer st = new StringTokenizer(sido);
		int count = st.countTokens();
		System.out.println(count);
		
		  while(st.hasMoreTokens()) {//�и�����ū�� �ִ���
			  String token = st.nextToken();
			  System.out.println(token);
		  }
		  
		  String fruit ="���##��#����#����#����#������";
		  // 				 0  1  2  3    4    5    6  �̷��� �ν��̉��
		  // 												 ��Ȯ��������
		  // String fruit ="���##��#����#����#����#������";
		  //											�и����й���(delimeter)
		  StringTokenizer tt=new StringTokenizer(fruit,"#");
		  while(tt.hasMoreTokens()) {
			  //String token = tt.nextToken(); // �ٷ�����ص���
			  //System.out.println(token);
			  System.out.println(tt.nextToken()); // <-�̷���
		  }
		  
		  //string split() method�� �̿��� ���ڿ� �и�
		  
		  String [] fruit_array=fruit.split("#"); // ���ڿ��� �и����ȴ�.
		  //						  0     1     2      3      4       5
		  //String [] fruit_array= {"���","��","����","����","����","������"};
		  System.out.println("===split�� �̿��� ���ڿ��и�===");
		  for(int i=0;i<fruit_array.length;i++) {
			  System.out.printf("fruit_array[%d]:%s\n",i,fruit_array[i]);
		  }
		  
		  
		  
		  
		  System.out.println("---�迭����---");
		  //�迭
		  //�迭�� ���				0     1    2   3   4   
		  //						1	  2    3   4     5
		  String [] suja_array = {"�ϳ�","��","��","��","�ټ�"};
		  int lenth =suja_array.length;// �迭 ����� ����
		  System.out.println(lenth); // �迭����� ����
		  
		  for(int i=0;i<suja_array.length;i++) {// i=0 1 2 3 4
			  System.out.printf("suja_array[%d]:%s\n",i,suja_array[i]);
		  }
		  
		  
		  System.out.println(suja_array[2]);//�迭��� => �迭��[÷��]
		  System.out.println(suja_array[1]);
		  
		  //÷��			  0   1  2  3  4  5  6 7  8  9  10 11
		  int[] month_array= {31,28,31,30,31,30,31,31,30,31,30,31};
		  
		  int month =2;
		  System.out.printf("%d���� %d�ϱ��� �ֽ��ϴ�.\n",month,month_array[month-1]);
		  
		  
		 
		
		  
		  
	}	

}
