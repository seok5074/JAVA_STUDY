package mymain;

public class String�Һ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count =0;
		// heap�� �������� �޸𸮰� �߻�
		String msg = ++count + "little ,"+ 
					 ++count + "little ,"+
					 ++count + "little indian";
		System.out.println(msg);
		
		// �ذ��� 1
		count=0;
		StringBuffer sb= new StringBuffer(32);
		//�տ������� ä����ϸ�ȴ�.
		sb.append(++count);
		sb.append("little, ");
		sb.append(++count);
		sb.append("little, ");
		sb.append(++count);
		sb.append("little indian");

		msg = sb.toString(); // stirng buffer �� ������ string���� ����
		System.out.println(msg);
		
		
		//�ذ���2)
		count=0;
		msg = String.format("%dlittle, %dlittle, %dlittle indian",
							++count, ++count, ++count);
		System.out.println(msg);
		
		//			01234567890 <= index(÷��) string���� ÷�ڰ�����
		String st = "Kwon Sun Ae";
		
		
		String s11="aaa";
		msg= s11.replace("aa","b");
		System.out.println(msg);
	}

}
