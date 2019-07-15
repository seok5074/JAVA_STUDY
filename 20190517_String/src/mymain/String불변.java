package mymain;

public class String불변 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count =0;
		// heap에 버려지는 메모리가 발생
		String msg = ++count + "little ,"+ 
					 ++count + "little ,"+
					 ++count + "little indian";
		System.out.println(msg);
		
		// 해결방법 1
		count=0;
		StringBuffer sb= new StringBuffer(32);
		//앞에서부터 채우기하면된다.
		sb.append(++count);
		sb.append("little, ");
		sb.append(++count);
		sb.append("little, ");
		sb.append(++count);
		sb.append("little indian");

		msg = sb.toString(); // stirng buffer 의 내용을 string으로 추출
		System.out.println(msg);
		
		
		//해결방법2)
		count=0;
		msg = String.format("%dlittle, %dlittle, %dlittle indian",
							++count, ++count, ++count);
		System.out.println(msg);
		
		//			01234567890 <= index(첨자) string에는 첨자가존재
		String st = "Kwon Sun Ae";
		
		
		String s11="aaa";
		msg= s11.replace("aa","b");
		System.out.println(msg);
	}

}
