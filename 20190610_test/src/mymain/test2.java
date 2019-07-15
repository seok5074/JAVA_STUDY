package mymain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class test2 {

	public static void main(String[] args) throws Exception {

		String fileName = "C:\\jAVA\\test.txt";

		try {

			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName));
			
			fw.write("holy moly");
			fw.write("wowowow\n");
			fw.flush();
			fw.close();

			BufferedReader fr = new BufferedReader(new FileReader(fileName));

			String ch = fr.readLine();

			System.out.printf("%s", ch);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
