package tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ResultsWriter {
	
	public static void writeResults(String path, String results, long time,boolean writeResults) throws IOException {
		System.out.println("start writing results");
		File f = new File(path);
		if(!f.exists()) {
			f.createNewFile();
		}
		System.out.println("+++++++++++++++++++++++++++++");
		FileReader fr= new FileReader(f);
		
		String line = null;
		
		BufferedReader r= new BufferedReader(fr);
		
		while((line=r.readLine())!=null) {
			System.out.println(line);
		}
		
		System.out.println("+++++++++++++++++++++++++++++");
		FileWriter fw = new FileWriter(f,true);
		BufferedWriter writer = new BufferedWriter(fw);
		if(writeResults) {
			writer.write(results);
		}	
		
		writer.newLine();
		writer.append("Time result: " + time);
		
		System.out.println("end");
		
		writer.close();
		fw.close();
	}


}
