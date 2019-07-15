package myutil;

public class MaBangJin {

	int chasu;
	int [][] ma_array;
	
	public void setChasu(int chasu) {
		this.chasu = chasu;
		
		
		//����������
		make_mabangjin();
	}

	private void make_mabangjin() {
		// TODO Auto-generated method stub
		ma_array = new int[chasu][chasu];
		//��ä���
		int row =0;
		int col=chasu/2; //�߾�÷��
		int su =1;
		ma_array[row][col] = su++; //�߾ӿ� 1�ǰ��� ä���
		
		for(int i=0;i<chasu*chasu-1;i++) {
			//1.���ʴ밢�̵�
			row--;
			col++;
			//2.��/������ ��� ����� �̵��� �ٷ� ������ �̵�
			if(row<0 && col>=chasu) {
				row +=2; //�Ʒ��� 2ĭ������
				col--;// ������1ĭ
			}
			//3.���� ����� �ǾƷ� �̵�
			else if(row <0) {
				row =chasu-1;
			}
			//4.���������� ����� �Ǿ����� �̵�
			else if(col>=chasu) {
				col=0;
			}
			//5.���� �̹� ä���� ������ �̵��� �ٷ� ������ �̵�
			if(ma_array[row][col]!=0) {
				row+=2;
				col--;
			}
			//6. ����ä���
			ma_array[row][col]=su++;
		}
		
		
	}
	
public void display() {
		
		int row_sum=0;//���հ�
		int [] col_sum =new int[chasu];
		for(int i=0;i<chasu;i++) {//��
			row_sum = 0;
			for(int k=0;k<chasu;k++) {//��
				System.out.printf("%4d", ma_array[i][k]);
				row_sum += ma_array[i][k];//1���� �÷��� ������
				
				col_sum[k] += ma_array[i][k];
			}
			System.out.printf("  (%d)", row_sum);// �������� �հ�
			System.out.println();//�ٹٲٱ�
		}
		for(int i=0;i<chasu;i++) {
			System.out.printf(" %4d",col_sum[i]);
		}
		System.out.println();
	}
	//�ٹٲٱ����� �հ�����ϱ�
	
}
