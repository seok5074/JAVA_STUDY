package myutil;

public class MyArray2 {

	//���� ������� �ִ� ���
	//										�� �����̸� �ٲ㵵�ȴ�.
	public static void setArray(int [][] mm2) {
		//					int [][] mm2=mm; �� ����.
		int su =1;
		for(int i=0;i<mm2.length;i++) { // �ุŭ����
			for(int k=0;k<mm2[i].length;k++) {
				
				mm2[i][k]=su++;
			}
		}
	}
	// ���ϴ°����� ä���� ���
	public static void fill(int [][] mm, int val) {
		for(int i=0;i<mm.length;i++) {
			for(int k=0;k<mm[i].length;k++) {
				mm[i][k]=val;
			}
		}
	}
	
	//���
	public static void display(int [][] mm) {

		for(int i=0;i<mm.length;i++) { // ��÷��
			for(int k=0;k<mm[i].length;k++) { //��÷��
				System.out.printf("%3d",mm[i][k]);
			}
			System.out.println();//�ٹٲ�
		}
	}
}