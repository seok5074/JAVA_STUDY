package vo;

import java.util.Comparator;

public class PersonComp implements Comparator<PersonVo> {

	public static final int SORT_FIELD_NAME = 1;
	public static final int SORT_FIELD_AGE = 2;
	public static final int SORT_FIELD_ADDR=3;
	// SORT ���
	public static final int SORT_METHOD_ASC = 4;
	public static final int SORT_METHOD_DESC = 5;


	// �⺻ �ʱⰪ
	int sort_field = SORT_FIELD_NAME;
	int sort_method = SORT_METHOD_ASC;
	
	public int getSort_field() {
		return sort_field;
	}

	public void setSort_field(int sort_field) {
		this.sort_field = sort_field;
	}

	public int getSort_method() {
		return sort_method;
	}

	public void setSort_method(int sort_method) {
		this.sort_method = sort_method;
	}
	

	@Override
	public int compare(PersonVo o1, PersonVo o2) {
		// TODO Auto-generated method stub
		int res = 0;
		// sort �����ʵ�


		if(sort_field ==SORT_FIELD_NAME) {
			// �̸�������
			// ��������
			// "ABC".compareTo("abc")
			if (o1.getName().compareTo(o2.getName()) > 0)
				res = 1;
			else if (o1.getName().compareTo(o2.getName()) < 0)
				res = -1;
		}else if(sort_field==SORT_FIELD_AGE) {
			// ���̼�����
			// ��������(asc)
			if (o1.getAge() > o2.getAge())
				res = 1;
			else if (o1.getAge() < o2.getAge())
				res = -1;
		}
		else if(sort_field==SORT_FIELD_ADDR) {
			if (o1.getAddr().compareTo( o2.getAddr())>0)
				res = 1;
			else if (o1.getAddr().compareTo( o2.getAddr())<0)
				res = -1;
		}
		
		//��������
		if(sort_method==SORT_METHOD_DESC) {
			res = -res;
		}
		

		return res;
	}

}
