package mymain;


import myutil.Channel;
import myutil.RemoteCon;
import myutil.Tv;
import myutil.Volume;
import myutil.easter_egg;

public class MyMain_TV {
	
	
	public static void main(String[] args) throws Exception {
		
		// 인터페이스 = 객체생성
		// 사용설명서	설계서
		RemoteCon remotecon = new Tv();
		
		//while(true) { 잘작동되는지 확인
		//power click
		//Thread.sleep(3000);
		//}
		remotecon.onOff();
//		for(int i =0;i<101;i++)
		
		remotecon.volumeup(); //볼륨올리기
		//리모콘으로부터 볼륨제어기능하는거만 가져오겠다
		remotecon.volumedown(); //볼륨내리기
		
		remotecon.volumeZero(); // 음소거 처음명령
		remotecon.volumeZero(); // 음소거 해제명령
		
		remotecon.volumeup();
		//리모콘으로부터 채널제어기능하는거만 가져오겠다
		
		Channel channel = remotecon;
		channel.channelup();
		channel.setChannel(9);
		easter_egg east = remotecon;
		east.easteregg();
		/*
		 * channel.channeldown();
		 * channel.setChannel(9);
		 */
		
		System.out.println(channel instanceof Volume);
		//이타입을 포함하고있나 확인명령어
		
		while (true) {
			remotecon.volumeZero();
			Thread.sleep(3000);
		}
	}

}
