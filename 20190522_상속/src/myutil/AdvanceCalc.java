package myutil;

//									¡é»ó¼Ó
public class AdvanceCalc extends BaseCalc{

	public int hap(int n) {
		int sum=0;
		for(int i=1;i<=n;i++) {
			//sum =+i; // -> sum =sum+i;
			sum =this.puls(sum,i);
			//sum 
		}
		return sum;
	}
	//n's m½Â
	public int pow(int n, int m) {
		int res=1;
		for(int i=0;i<m;i++) {
			res *=n; // res= res *n;
		}
		return res;
	}
	
}
