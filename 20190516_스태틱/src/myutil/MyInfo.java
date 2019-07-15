package myutil;

import java.util.Calendar;

public class MyInfo {
	int year;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	//���̱��ϱ�
	public int getAge() {
		Calendar c= Calendar.getInstance();
		int current_year =c.get(Calendar.YEAR);
		int age =current_year-this.year+1;
		return age;
	}
	//�챸�ϱ�
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
	public boolean isYoon() {
		return this.year %4==0 || this.year%400==0 && this.year%100!=0;
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
}

