package mymain;

public class MyMain_예외처리분석 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=10,b=1,c;
		int [] ar = {1,2,3};
		
		try {
			//					↓ 오류문 지정가능
			if(b==0) 
				throw new ArithmeticException("0으로 나누지말랬지..");
				
			c=a/b;
				
			int index=0;
				
			
			if(index>=ar.length) 
				throw new ArrayIndexOutOfBoundsException("배열을초과"+index);
			//배열
			ar[index] =10;
			
			//String str = null; //java.lang.NullPointerException 걸린다.
			String str = "sss";
			int len =str.length(); //길이구현
			
			int n=Integer.parseInt("abc");
			
					
			//	↓ 이름을따라서 오류문도 바뀐다.
		}//catch(Exception e){}  순서를 지켜야한다.
		
		catch(ArithmeticException e) {
			//System.out.println(e.getMessage());
			//예외가 나오는 경우 경고문을 출력
			System.out.println("==1==");
			e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException e) {// 작성순서도 중요하다.
			System.out.println("--2--");
			e.printStackTrace();
		}catch(Exception e){//밑에쓸수잇다. 나머지 예외는 이명령어가 처리해라
			System.out.println("--3--");
			e.printStackTrace();
			
		}

	}

}
