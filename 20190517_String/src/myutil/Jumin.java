package myutil;

import java.util.Calendar;

public class Jumin {

	String jumin_no;
	
	int year;//����⵵
	

	public int getYear() {
		return year;
	}

	public String getJumin_no() {
		return jumin_no;
	}

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
		//            01234567890123 <= index   
		//jumin_no = "901212-1234567";
		//                                start, start+count                                          
		String str_year = jumin_no.substring(0, 0+2);// "90"
		//     String => int����ȯ : "90" => 90
		int    im_year  = Integer.parseInt(str_year);
		
		//�����ڸ� ���� 1�� ������
		char gender = jumin_no.charAt(7);
		if(gender=='1' || gender=='2' || gender=='5' || gender=='6')
			im_year = im_year + 1900;
		else
			im_year = im_year + 2000;
		//����⵵�����ϴ� ������ �ִ´�
		this.year = im_year;
		
	}
	
	//��ȿ�� �˻�
	public boolean isValid() {
		//            01234567890123 <= index   
		//jumin_no = "901212-1234567";
		//            234567 892345  <=  
		//��ȿ�� üũ
		int sum = 0;
		// char������ ����=>���ڷ� �ٲٱ�: '0':48  '1':49  '2': 50
		// ex)    '2'-'0' => 50-48=>2
		// ���ں�ȯ���
		//int su  = jumin_no.charAt(0)-'0';
		//int su = Integer.parseInt(jumin_no.substring(0, 0+1)); //"9"
		
		//���1
		/*
		sum = sum + (jumin_no.charAt(0)-'0')*2;
		sum = sum + (jumin_no.charAt(1)-'0')*3;
		sum = sum + (jumin_no.charAt(2)-'0')*4;
		sum = sum + (jumin_no.charAt(3)-'0')*5;
		sum = sum + (jumin_no.charAt(4)-'0')*6;
		sum = sum + (jumin_no.charAt(5)-'0')*7;
		sum = sum + (jumin_no.charAt(7)-'0')*8;
		sum = sum + (jumin_no.charAt(8)-'0')*9;
		sum = sum + (jumin_no.charAt(9)-'0')*2;
		sum = sum + (jumin_no.charAt(10)-'0')*3;
		sum = sum + (jumin_no.charAt(11)-'0')*4;
		sum = sum + (jumin_no.charAt(12)-'0')*5;
		*/
		//���2
		int check_su = 2;
		for(int i=0;i<=12;i++) {
			if(i==6)continue;
			sum = sum + (jumin_no.charAt(i)-'0')*check_su;
			check_su++;
			if(check_su>9)check_su=2;
		}
		
		sum = sum % 11;
		sum = 11 - sum;
		sum = sum % 10;
		
		//System.out.println("sum=" + sum);
		
		//�ֹι�ȣ�� ������ ����
		int last_no = jumin_no.charAt(13)-'0';
		
		return (sum==last_no);
	}
	
	//��������ڵ�
	public String getLocal() {
		
		//	          01234567890123 <= index   
		//jumin_no = "901212-1234567";
		String str_local = jumin_no.substring(8,8+2);
		int local = Integer.parseInt(str_local);
		 
		if(local>=0 && local<=8)return "����";
		else if(local>=9 && local<=12)return "�λ�";
		else if(local>=13 && local<=15)return "��õ";
		else if(local>=16 && local<=25)return "��⵵";

		
		return "";
	}
	
	
	//�������ϱ�
	public String getSeason() {
		//      	  01234567890123 <= index   
		//jumin_no = "901212-1234567";
		String str_month = jumin_no.substring(2,2+2);
		int    month = Integer.parseInt(str_month);
		switch(month/3) //<=���ذ� (��/3) ���� ������ üũ
		{
			case 1 : return "��";   // month: 3  4  5�ϰ��
			case 2 : return "����"; // month: 6  7  8�ϰ��
			case 3 : return "����"; // month: 9 10 11�ϰ��
		}
		
		return "�ܿ�";
	}
	
	//�������ϱ�
	public String getSex() {
		//�����ڸ� ���� 1�� ������
		char gender = jumin_no.charAt(7);
		/*
		                  1900     2000 
		  ������ ����       1       3 
		         ����       2       4
		  
		  �ܱ��� ����       5       7  
		         ����       6       8 
		 */
		if(gender=='1' || gender=='3' || gender=='5' || gender=='7')
			return "����";
		
		return "����";
	}
	
	//���̱��ϱ�
	public int getAge() {
		Calendar c = Calendar.getInstance();
		int current_year = c.get(Calendar.YEAR);
		int age = current_year - this.year + 1;
		return age;
	}
	
	//�챸�ϱ�
	public String getTti() {
		
		//return;      �ڽ��� ȣ���Ѱ����� �����ض�
		//return ��;   �ڽ��� ȣ���Ѱ����� ���� ���� �����ض�.
		
		// �� �� �� �� �� �� �� �� �� �� �� ��
		// 4  5  6  7  8  9  10 11  0  1  2  3
		
		// ����⵵%12=>0~11
		switch(this.year%12)
		{
			case  0: return "������";
			case  1: return "��";
			case  2: return "��";
			case  3: return "����";
			case  4: return "��";
			case  5: return "��";
			case  6: return "ȣ����";
			case  7: return "�䳢";
			case  8: return "��";
			case  9: return "��";
			case 10: return "��";
			case 11: return "��";
		}
		return "";
	}
	
    
	//���⿩��
	public boolean isYoon() {
		
		return (year%400==0  || (year%4==0 && year%100!=0));
	}
	
	public String getGanji() {
		String gan="";
		String ji="";
		
		//10��
		// �� �� �� �� �� �� �� �� �� ��
		// 4  5  6  7  8  9   0  1  2  3  <= ����⵵%10
		switch(year%10)
		{
			case 0 : gan = "��";break;
			case 1 : gan = "��";break;
			case 2 : gan = "��";break;
			case 3 : gan = "��";break;
			case 4 : gan = "��";break;
			case 5 : gan = "��";break;
			case 6 : gan = "��";break;
			case 7 : gan = "��";break;
			case 8 : gan = "��";break;
			case 9 : gan = "��";break;
		}
		//12��
		// �� �� �� �� �� �� �� �� �� �� �� ��
	    // 4  5  6  7  8  9  10 11  0  1  2  3 <= ����⵵%12
		switch(year%12)
		{
			case  0:ji="��";break;
			case  1:ji="��";break;
			case  2:ji="��";break;
			case  3:ji="��";break;
			case  4:ji="��";break;
			case  5:ji="��";break;
			case  6:ji="��";break;
			case  7:ji="��";break;
			case  8:ji="��";break;
			case  9:ji="��";break;
			case 10:ji="��";break;
			case 11:ji="��";break;
		}

		//System.out.printf("%s%s��",gan,ji);//������
		//return gan+ji+"��";
		return String.format("%s%s��", gan,ji); //�ش������� ���� String���� ����
		
	}
	
	
	
	
}
