package myutil;

public interface Channel {
	//상수 채널에 쓸수있는 범위설정
	int MIN=0;
	int MAX=100;
	
	void channelup();
	void channeldown();
	void setChannel(int channel);
	
	

}
