package myutil;


public class MyArrayList<T> {

	T[] data = null;

	public void add(T newVal) {
		// �迭 �߰�

		if (data == null) {
			data = (T[])new Object[1];
			data[0] = newVal;
			return;
		}
		// �������� + 1����
		T[] im = (T[])new Object[size() + 1];

		// ���������ͺ���
		for (int i = 0; i < size(); i++) {
			im[i] = data[i];
		}
		// ������ĭ newVal
		im[size()] = newVal;

		// �ӽõ�����
		// im�����͸� data�� �ִ´�
		data = im;
	} // ���ο��� ������ ���ܸ� ����
		// �ش�޼ҵ带 ����ϴ� ����ڿ��� ó���� ����

	public T get(int index) throws Exception {
		// ��ȿ��üũ
		if (index < 0 || index >= this.size()) {
			String message = String.format("÷�ڴ� 0~%d���� ��밡�� : ��� index�� %d", size() - 1, index);
			// ������ ���� �߻�
			throw new Exception(message);
		}
		return data[index];
	}

	// ���ο��� ���������� �����ض�.
	public void remove(int index) throws Exception {
		if(index <0 || index >= this.size()) {
			String message = String.format("÷�ڴ� 0~%d���� ��밡�� : ��� index�� %d"
											,size()-1,index);
			//������ ���� �߻�
			throw new Exception(message);
		}
		//�����Ͱ� 1�����������
		if(size()==1) {
			data=null;
			return;
		}
		//2���̻�������
		T [] im = (T[])new Object[size()-1];
		for(int i=0;i<im.length;i++) {
			if(i<index)
				im[i]=data[i];
			else
				im[i]=data[i+1];
		}
		data =im;
	}
	
	public void insert(int index,T newVal)throws Exception{
		if (index < 0 || index >= this.size()) {
			String message = String.format("÷�ڴ� 0~%d���� ��밡�� : ��� index�� %d", size() - 1, index);
			throw new Exception(message);
		}
		T [] im = (T[])new Object[size()+1];
		for(int i=0;i<im.length;i++) {
			if(i<index)
				im[i]=data[i];
			else
				im[i]=data[index];
		}
		im[index]=newVal;
		data =im;
	}
	
	public int size() {
		return data == null ? 0 : data.length;
	}

}
