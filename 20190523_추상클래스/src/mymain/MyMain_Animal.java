package mymain;


import myutil.Animal;
import myutil.cat;
import myutil.dog;
import myutil.pig;

public class MyMain_Animal {

	static void master(Animal[] ani) {
		for (Animal an : ani) {
			an.�Ծ��();
			an.����();
		}
	}
	static void �Ծ��(Animal [] ani) {
		for(Animal an: ani) {
			an.�Ծ��();
		}
	}
	static void ����(Animal [] ani) {
		for(Animal an: ani) {
			an.����();
		}
	}

	public static void main(String[] args) {
		Animal[] ani = new Animal[3];
		ani[0] = new dog();
		ani[1] = new cat();
		ani[2] = new pig();
		//Animal [] ani = {new dog(),new cat(),new pig()}; 
		
		System.out.println("�Դ´�");
		�Ծ��(ani);
		System.out.println("���");
		����(ani);
			
			
		/*
		 * if (who.equals("dog")) { an.�Ծ��(); an.����(); } 
		 * else if (who.equals("cat")) { an1.�Ծ��(); an1.����(); } 
		 * else if (who.equals("pig")) { an2.�Ծ��(); an2.����(); }
		 */
	}

}
