package ocr_concepttest.asprise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.asprise.ocr.Ocr;

public class TestApp {

	public static void main(String[] args) {
		//images only
		Ocr.setUp(); // one time setup
		Ocr ocr = new Ocr(); // create a new OCR engine
		ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
		String s = ocr.recognize(new File[] {new File("C:\\Users\\Asesoftware\\Desktop\\certicámara\\ocr-test\\images\\hoja de vida.pdf")},
		  Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT,Ocr.LANGUAGE_SPA); // PLAINTEXT | XML | PDF | RTF
		System.out.println("Result: " + s);
		ocr.stopEngine(); 
		

	}
	
	public static void writeResult(String outputFile, String text) throws IOException {
		
		FileOutputStream out = new FileOutputStream(outputFile);

		try {
			byte[] data = new byte[1024];
			int count;
			out.write(text.getBytes());
		} finally {
			out.close();
		}
	}

}
