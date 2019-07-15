package myutil;

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
	public String getSex() {
		char gender = jumin_no.charAt(7);
		if(gender=='1' || gender=='3')
			return "����";
		return "����";		
	}
	public String getLocal() {
		String str_year = jumin_no.substring(8, 10);
		int    local  = Integer.parseInt(str_year);
		switch(local) {
			case 0:return "����";
			case 1:return "���";
			case 2:return "����";
			case 3:return "�泲";
			case 4:return "����";
			case 5:return "���";
			case 6:return "�泲";
		}
		/*
		 * if(local>=0 && local<=8)return "����"; else if(local >=9 && local<=12) return
		 * "���";
		 */
		return "���ֵ�";
	}
	public String getSeason() {
		String str_year = jumin_no.substring(2, 4);
		int    season  = Integer.parseInt(str_year);
		switch (season/3) {
			case 1:return "��"; // month /3 = 3 4 5 ���
			case 2:return "����"; // month /3 = 6 7 8 ���
			case 3:return "����"; // month /3 = 9 10 11 ���
		}
		return "�ܿ�";
	}
	
	public String getTti() {
		
		// return : �ڽ��� ȣ���Ѱ����� �����ض�
		// return : �� �ڽ��� ȣ���Ѱ����� ��������� ����
		
		String [] tti_array= { "������",
							   "��",
							   "��",
							   "����",
							   "��",
							   "��",
							   "ȣ����",
							   "�䳢",
							   "��",
							   "��",
							   "��",
							   "��"
							   };
		return tti_array[year%12];  // �迭���̿��� �����
		
	}
	public String getGangji() {
		//�迭ó����
		//10�� : year%10
		String[] gan_array= {"��","��","��","��","��","��","��","��"
							,"��","��"};
		//12�� : year%12
		String[] ji_array= {"��","��","��","��","��","��","��","��"
							,"��","��","��","��"};
		String gan =gan_array[year%10]; //10����1����
		String ji =ji_array[year%12];  //12����1����
		return String.format("%s%s��", gan,ji);// static ������ Ȱ���� return Ȱ��
		//�ش������� ���� string���� ����
	}
	public String getGanji2() {
		String gan_str ="����Ӱ谩����������";
		String ji_str ="�������������ι��������";
		
		return String.format("%c%c��", gan_str.charAt(year%10),ji_str.charAt(year%12));
	}
	public boolean isValid() {
		//		              01234567890123 <= index   
		//		  jumin_no = "901212-1234567";
		//					  234567 892345 <=����ɰ�
		// ��ȿ���˻�
		int sum=0;
		// char������ ���� => ���ڷιٲٱ�
		// ex) '2'-'0' => 50-48=2 0�ǹ��ڸ�����ȴ�.
		//���ں�ȯ���
		//int su =jumin_no.charAt(0)-'0';
		//int su1 =Integer.parseInt(jumin_no.substring(0,0+1)); //"9"
		//�⺻ ��ġ�
		/*
		 * sum =sum+(jumin_no.charAt(0)-'0')*2; sum =sum+(jumin_no.charAt(1)-'0')*3; sum
		 * =sum+(jumin_no.charAt(2)-'0')*4; sum =sum+(jumin_no.charAt(3)-'0')*5; sum
		 * =sum+(jumin_no.charAt(4)-'0')*6; sum =sum+(jumin_no.charAt(5)-'0')*7; sum
		 * =sum+(jumin_no.charAt(7)-'0')*8; sum =sum+(jumin_no.charAt(8)-'0')*9; sum
		 * =sum+(jumin_no.charAt(9)-'0')*2; sum =sum+(jumin_no.charAt(10)-'0')*3; sum
		 * =sum+(jumin_no.charAt(11)-'0')*4; sum =sum+(jumin_no.charAt(12)-'0')*5;
		 */
	
		//for�����ġ�
		/*
		int check_su=2;
		for(int i= 0;i<=12;i++) {
			if(i==6)continue; //6�̸� 6�������ϰ� 7���� ������ �����ϴ°�
				sum =sum+(jumin_no.charAt(i)-'0')*check_su;
				check_su++;
				if(check_su>9)check_su=2;
			
		}
		*/
		// ���3
		//
//        01234567890123 <= index   
//		  jumin_no = "901212-1234567";
//					  2345670892345
	//					   0 1 2 3 4 5 6 7 8 9 0 1 2
		int [] check_su = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		for(int i=0;i<=12;i++)
			sum =sum+(jumin_no.charAt(i)-'0')*check_su[i];
		
		sum =sum%11;
		sum=11-sum;
		sum =sum%10;
		
		//System.out.printf("sum= \n" + sum);
		//�ֹι�ȣ�� ����������
		int last_no =jumin_no.charAt(13)-'0';
		
		
		return (sum==last_no);
	}
	
	public int getAge() {
		int age = 2019 - this.year + 1;
		return age;
	}


	
	
	
	
}
