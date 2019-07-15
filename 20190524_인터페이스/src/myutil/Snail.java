/*package myutil;

public class Snail {

	int chasu;
	int[][] snail_array;

	public void setChasu(int chasu) {
		this.chasu = chasu;
		// ������ �����
		make_snail();
	}

	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int UP = 4;
	public static final int DOWN = 8;

	private void make_snail() {
		snail_array = new int[chasu][chasu];
		int row = 0;
		int col = -1;
		int diretion = RIGHT;

		// ä���
		for (int i = 0; i < chasu * chasu; i++) {
			if (diretion == RIGHT) {
				col++;
				if (col == chasu || snail_array[row][col] != 0)
					col--;
				diretion = DOWN;
				
				i--;
				continue;
			} else if (diretion == DOWN) {

				row++;
				if (row == chasu || snail_array[row][col] != 0)
					row--;
				diretion = LEFT;
				
				i--;
				continue;

			} else if (diretion == LEFT ) {
				col--;

				if (col<0 || snail_array[row][col]!=0)
					col++;
				diretion = UP;
				
				i--;
				continue;

			} else if (diretion == UP ) {
					row--;
				if (row<0 || snail_array[row][col]!=0)
					row++;
					diretion = RIGHT;
					
					i--;
					continue;

			}

			snail_array[row][col] = i + 1;
		}
	}

	public void display() {
		for (int i = 0; i < chasu; i++) {// ��
			for (int k = 0; k < chasu; k++) {
				System.out.printf("%4d", snail_array[i][k]);
			}
			System.out.println();
		}
	}

}
*/
package myutil;

public class Snail {

	int chasu;
	int [][] snail_array;

	public void setChasu(int chasu) {
		this.chasu = chasu;
		//������ �����
		make_snail3();
	}
	
	public static final int LEFT 	=  1;
	public static final int RIGHT 	=  2;
	public static final int UP 	=  4;
	public static final int DOWN 	=  8;
	
	private void make_snail() {
		// TODO Auto-generated method stub
		snail_array = new int[chasu][chasu];
		int row = 0;
		int col = -1;
		int direction =  RIGHT;
		//ä���
		for(int i=0;i<chasu*chasu;i++) {
			
			if(direction==RIGHT) {
				col++;
				if(col==chasu || snail_array[row][col]!=0) {
					col--;
					direction=DOWN;
					
					i--;
					continue;
				}
				
			}else if(direction==DOWN) {
				row++;
				if(row==chasu || snail_array[row][col]!=0) {
					row--;
					direction=LEFT;
					
					i--;
					continue;
				}
				
			}else if(direction==LEFT) {
				col--;
				if(col<0 || snail_array[row][col]!=0) {
					col++;
					direction=UP;
					
					i--;
					continue;
				}
				
			}else if(direction==UP) {
				row--;
				if(row<0 || snail_array[row][col]!=0) {
					row++;
					direction=RIGHT;
					
					i--;
					continue;
				}
			}
			
			snail_array[row][col] = i + 1;
		}
	}
		
	//ä���2	
	private void make_snail2() {
		// TODO Auto-generated method stub
		snail_array = new int[chasu][chasu];
		int row = 0;
		int col = -1;
		int sign =  1;
		int n = chasu;
		int su = 1;
		//ä���
		while(n>0) {
			for(int i=0;i<2*n-1;i++) {
				if(i<n)
					col = col + sign;
				else
					row = row + sign;
				snail_array[row][col]=su++;
			}
			sign = -sign;
			n--;
		}
	}
	//ä��� ���ʿ������� �ٱ������� ä��°�
	private void make_snail3() {
		// TODO Auto-generated method stub
		snail_array = new int[chasu][chasu];
		int row = 0;
		int col = -1;
		int sign =  1;
		int n = chasu;
		int su = chasu*chasu;
		//ä���
		while(n>0) {
			for(int i=0;i<2*n-1;i++) {
				if(i<n)
					col = col + sign;
				else
					row = row + sign;
				snail_array[row][col]=su--;
			}
			sign = -sign;
			n--;
		}
	}

	public void display() {
		
		for(int i=0;i<chasu;i++) {//��
			for(int k=0;k<chasu;k++) {//��
				System.out.printf("%4d", snail_array[i][k]);
			}
			
			System.out.println();//�ٹٲٱ�
		}
	}
	
	
}
