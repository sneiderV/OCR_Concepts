package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CreateFileWithJSON {

	public static void main(String[] args) throws IOException {
		File f = new File("test.json");
		FileReader reader = new FileReader (f);
		BufferedReader bf = new BufferedReader (reader);
		String line = null;
		String json = "";
		while((line=bf.readLine())!=null) {
			json += line +"\n\r";
		}
		
		System.out.println(json);
		
		

	}

}
