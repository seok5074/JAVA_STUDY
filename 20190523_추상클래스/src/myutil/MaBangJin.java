package myutil;

public class MaBangJin {

	int chasu;
	int [][] ma_array;
	
	public void setChasu(int chasu) {
		this.chasu = chasu;
		
		
		//마방진생성
		make_mabangjin();
	}

	private void make_mabangjin() {
		// TODO Auto-generated method stub
		ma_array = new int[chasu][chasu];
		//ㅊ채우기
		int row =0;
		int col=chasu/2; //중앙첨자
		int su =1;
		ma_array[row][col] = su++; //중앙에 1의값을 채운다
		
		for(int i=0;i<chasu*chasu-1;i++) {
			//1.윗쪽대각이동
			row--;
			col++;
			//2.위/오른쪽 모두 벗어나면 이동전 바로 밑으로 이동
			if(row<0 && col>=chasu) {
				row +=2; //아래로 2칸내리기
				col--;// 앞으로1칸
			}
			//3.위로 벗어나면 맨아래 이동
			else if(row <0) {
				row =chasu-1;
			}
			//4.오른쪽으로 벗어나면 맨앞으로 이동
			else if(col>=chasu) {
				col=0;
			}
			//5.값이 이미 채워져 있으면 이동전 바로 밑으로 이동
			if(ma_array[row][col]!=0) {
				row+=2;
				col--;
			}
			//6. 값을채운다
			ma_array[row][col]=su++;
		}
		
		
	}
	
public void display() {
		
		int row_sum=0;//행합계
		int [] col_sum =new int[chasu];
		for(int i=0;i<chasu;i++) {//행
			row_sum = 0;
			for(int k=0;k<chasu;k++) {//열
				System.out.printf("%4d", ma_array[i][k]);
				row_sum += ma_array[i][k];//1줄의 컬럼의 누적합
				
				col_sum[k] += ma_array[i][k];
			}
			System.out.printf("  (%d)", row_sum);// 각열값의 합계
			System.out.println();//줄바꾸기
		}
		for(int i=0;i<chasu;i++) {
			System.out.printf(" %4d",col_sum[i]);
		}
		System.out.println();
	}
	//줄바꾸기전에 합계출력하기
	
}
