package myutil;

public class Tv implements RemoteCon {

	boolean bOn; // Ŀ���ֳ�
	boolean bsoundoff;
	int volume = 10; // ��������
	int channel = 6; // ä�λ���

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
			System.out.println("�߸��� ä���Է�");
		} else
			cha = channel;
		display();
	}

	@Override
	public void onOff() {
		// toggle���
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
			System.out.println("--TV���� : OFF--");
		} else {
			System.out.println("==TV���� : on==");
			System.out.printf("==ä�� : %d==\n", channel);
			if(bsoundoff)
				System.out.println("==���� :���Ұ�==");
			else
				System.out.printf("==���� : %d==\n", volume);

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
