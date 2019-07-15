package myutil;

public class Tv implements RemoteCon {

	boolean bOn; // 커져있나
	boolean bsoundoff;
	int volume = 10; // 볼륨상태
	int channel = 6; // 채널상태

	@Override
	public void volumeup() {
		volume++;
		if (volume > Volume.MAX) {
			volume = Volume.MAX;
		}
		display();
	}

	@Override
	public void volumedown() {
		volume--;
		if (volume < Volume.MIN) {
			volume = Volume.MIN;
		}
		display();
	}

	@Override
	public void volumeZero() {
		bsoundoff =!bsoundoff;
		display();
	}

	@Override
	public void channelup() {
		channel++;
		if (channel > Channel.MAX)
			channel = Channel.MAX;
		display();
	}

	@Override
	public void channeldown() {
		channel--;
		if (channel < Channel.MIN)
			channel = Channel.MIN;
		display();
	}

	@Override
	public void setChannel(int cha) {
		channel = cha;
		if (cha > 100) {
			System.out.println("잘못된 채널입력");
		} else
			cha = channel;
		display();
	}

	@Override
	public void onOff() {
		// toggle방식
		bOn = !bOn;

		display();
	}

	public static void main(String[] args) {

	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("-------------------------");
		if (bOn == false) {
			System.out.println("--TV상태 : OFF--");
		} else {
			System.out.println("==TV상태 : on==");
			System.out.printf("==채널 : %d==\n", channel);
			if(bsoundoff)
				System.out.println("==볼륨 :음소거==");
			else
				System.out.printf("==볼륨 : %d==\n", volume);

		}
		System.out.println("-------------------------");
	}

	@Override
	public void easteregg() {
		if (channel == 9) {
			System.out.println("easter_egg");
		}

	}


}
