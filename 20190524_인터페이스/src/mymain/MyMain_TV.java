package mymain;


import myutil.Channel;
import myutil.RemoteCon;
import myutil.Tv;
import myutil.Volume;
import myutil.easter_egg;

public class MyMain_TV {
	
	
	public static void main(String[] args) throws Exception {
		
		// �������̽� = ��ü����
		// ��뼳��	���輭
		RemoteCon remotecon = new Tv();
		
		//while(true) { ���۵��Ǵ��� Ȯ��
		//power click
		//Thread.sleep(3000);
		//}
		remotecon.onOff();
//		for(int i =0;i<101;i++)
		
		remotecon.volumeup(); //�����ø���
		//���������κ��� �����������ϴ°Ÿ� �������ڴ�
		remotecon.volumedown(); //����������
		
		remotecon.volumeZero(); // ���Ұ� ó�����
		remotecon.volumeZero(); // ���Ұ� �������
		
		remotecon.volumeup();
		//���������κ��� ä���������ϴ°Ÿ� �������ڴ�
		
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
		//��Ÿ���� �����ϰ��ֳ� Ȯ�θ�ɾ�
		
		while (true) {
			remotecon.volumeZero();
			Thread.sleep(3000);
		}
	}

}
