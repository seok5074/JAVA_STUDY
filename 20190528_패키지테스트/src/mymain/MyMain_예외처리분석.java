package mymain;

public class MyMain_����ó���м� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=10,b=1,c;
		int [] ar = {1,2,3};
		
		try {
			//					�� ������ ��������
			if(b==0) 
				throw new ArithmeticException("0���� ������������..");
				
			c=a/b;
				
			int index=0;
				
			
			if(index>=ar.length) 
				throw new ArrayIndexOutOfBoundsException("�迭���ʰ�"+index);
			//�迭
			ar[index] =10;
			
			//String str = null; //java.lang.NullPointerException �ɸ���.
			String str = "sss";
			int len =str.length(); //���̱���
			
			int n=Integer.parseInt("abc");
			
					
			//	�� �̸������� �������� �ٲ��.
		}//catch(Exception e){}  ������ ���Ѿ��Ѵ�.
		
		catch(ArithmeticException e) {
			//System.out.println(e.getMessage());
			//���ܰ� ������ ��� ����� ���
			System.out.println("==1==");
			e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException e) {// �ۼ������� �߿��ϴ�.
			System.out.println("--2--");
			e.printStackTrace();
		}catch(Exception e){//�ؿ������մ�. ������ ���ܴ� �̸�ɾ ó���ض�
			System.out.println("--3--");
			e.printStackTrace();
			
		}

	}

}
