package myutil;

public class MyInfo {
	
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
		//			 01234567890123 <- index
		//jumin_no ="901212-1234567";
		//								start, start+count
		String str_year= jumin_no.substring(0,2); //90������
		int im_year = Integer.parseInt(str_year);
		//�����ڸ� ���� 1�� ������
		char gender = jumin_no.charAt(7);
		if(gender=='1' || gender=='1' || gender=='5' || gender=='6')
			im_year = im_year+1900;
		else
			im_year = im_year+2000;
		//����⵵�����ϴ� ������ �ִ´�.
		year=im_year;
	}
	public String getSex() {
		String gender1 = jumin_no.substring(7);
		if(gender1=="1" || gender1=="1" || 
				gender1=="5" || gender1=="6")
			gender1="��";
		else
			gender1="��";
		return gender1;		
		
	}
	
	public String getTti() {
		// return : �ڽ��� ȣ���Ѱ����� �����ض�
		// return : �� �ڽ��� ȣ���Ѱ����� ��������� ����
		switch(this.year%12)
		{
			case 0 : return "������";
			case 1 : return "��";
			case 2 : return "��";
			case 3 : return  "����";
			case 4 : return "��";
			case 5 : return "��";
			case 6 : return "ȣ����";
			case 7 : return "�䳢";
			case 8 : return "��";
			case 9 :  return "��";
			case 10 : return "��";
			case 11 : return "��";
		}
		return "";
	}
	public String getGangji() {
		String gan="";
		String ji="";
		switch(year%10)
		{
			case 4:gan="��"; break;
			case 5:gan="��"; break;
			case 6:gan="��"; break;
			case 7:gan="��"; break;
			case 8:gan="��"; break;
			case 9:gan="��"; break;
			case 0:gan="��"; break;
			case 1:gan="��"; break;
			case 2:gan="��"; break;
			case 3:gan="��"; break;
		}
		switch(year%12)
		{
			case 4:ji="��"; break;
			case 5:ji="��"; break;
			case 6:ji="��"; break;
			case 7:ji="��"; break;
			case 8:ji="��"; break;
			case 9:ji="��"; break;
			case 10:ji="��"; break;
			case 11:ji="��"; break;
			case 0:ji="��"; break;
			case 1:ji="��"; break;
			case 2:ji="��"; break;
			case 3:ji="��"; break;
		}		
		return String.format("%s%s��", gan,ji);// static ������ Ȱ���� return Ȱ��
		//�ش������� ���� string���� ����
	}
	public int getAge() {
		int age=2019-this.year+1;
		
		return age;
	}
}





/*
 * String str_month= jumin_no.substring(2,4); int im_month =
 * Integer.parseInt(str_month);
 */