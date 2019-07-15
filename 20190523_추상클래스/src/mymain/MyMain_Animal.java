package mymain;


import myutil.Animal;
import myutil.cat;
import myutil.dog;
import myutil.pig;

public class MyMain_Animal {

	static void master(Animal[] ani) {
		for (Animal an : ani) {
			an.먹어라();
			an.울어라();
		}
	}
	static void 먹어라(Animal [] ani) {
		for(Animal an: ani) {
			an.먹어라();
		}
	}
	static void 울어라(Animal [] ani) {
		for(Animal an: ani) {
			an.울어라();
		}
	}

	public static void main(String[] args) {
		Animal[] ani = new Animal[3];
		ani[0] = new dog();
		ani[1] = new cat();
		ani[2] = new pig();
		//Animal [] ani = {new dog(),new cat(),new pig()}; 
		
		System.out.println("먹는다");
		먹어라(ani);
		System.out.println("운다");
		울어라(ani);
			
			
		/*
		 * if (who.equals("dog")) { an.먹어라(); an.울어라(); } 
		 * else if (who.equals("cat")) { an1.먹어라(); an1.울어라(); } 
		 * else if (who.equals("pig")) { an2.먹어라(); an2.울어라(); }
		 */
	}

}
