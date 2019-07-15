package myutil;


public class MyArrayList<T> {

	T[] data = null;

	public void add(T newVal) {
		// 배열 추가

		if (data == null) {
			data = (T[])new Object[1];
			data[0] = newVal;
			return;
		}
		// 기존갯수 + 1생성
		T[] im = (T[])new Object[size() + 1];

		// 기존데이터복사
		for (int i = 0; i < size(); i++) {
			im[i] = data[i];
		}
		// 마지막칸 newVal
		im[size()] = newVal;

		// 임시데이터
		// im데이터를 data에 넣는다
		data = im;
	} // 내부에서 던져진 예외를 위임
		// 해당메소드를 사용하는 사용자에게 처리를 위임

	public T get(int index) throws Exception {
		// 유효성체크
		if (index < 0 || index >= this.size()) {
			String message = String.format("첨자는 0~%d까지 사용가능 : 사용 index는 %d", size() - 1, index);
			// 던져진 예외 발생
			throw new Exception(message);
		}
		return data[index];
	}

	// 내부에서 벌어진일을 위임해라.
	public void remove(int index) throws Exception {
		if(index <0 || index >= this.size()) {
			String message = String.format("첨자는 0~%d까지 사용가능 : 사용 index는 %d"
											,size()-1,index);
			//던져진 예외 발생
			throw new Exception(message);
		}
		//데이터가 1개남았을경우
		if(size()==1) {
			data=null;
			return;
		}
		//2개이상있을때
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
			String message = String.format("첨자는 0~%d까지 사용가능 : 사용 index는 %d", size() - 1, index);
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
