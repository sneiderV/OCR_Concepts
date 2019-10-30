package tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PDFtoJPGConverter {

	public static List<File> convertPdfToImage(File file, String destination) throws Exception {

		// String destination =
		// "C:\\Users\\Asesoftware\\Desktop\\certicámara\\ocr-test\\images\\hv.JPG";
		File destinationFile = new File(destination);

		if (!destinationFile.exists()) {
			destinationFile.mkdir();
			System.out.println("DESTINATION FOLDER CREATED -> " + destinationFile.getAbsolutePath());
		} else if (destinationFile.exists()) {
			System.out.println("DESTINATION FOLDER ALLREADY CREATED!!!");
		} else {
			System.out.println("DESTINATION FOLDER NOT CREATED!!!");
		}

		if (file.exists()) {
			PDDocument doc = PDDocument.load(file);
			PDFRenderer renderer = new PDFRenderer(doc);
			List<File> fileList = new ArrayList<File>();

			String fileName = file.getName().replace(".pdf", "");
			System.out.println("CONVERTER START.....");

			for (int i = 0; i < doc.getNumberOfPages(); i++) {
				// default image files path: original file path
				// if necessary, file.getParent() + "/" => another path
				File fileTemp = new File(destination + fileName + "_" + i + ".jpg"); // jpg or png
				BufferedImage image = renderer.renderImageWithDPI(i, 200);
				// 200 is sample dots per inch.
				// if necessary, change 200 into another integer.
				ImageIO.write(image, "JPEG", fileTemp); // JPEG or PNG
				fileList.add(fileTemp);
			}
			doc.close();
			System.out.println("CONVERTER STOPTED.....");
			System.out.println("IMAGE SAVED AT -> " + destinationFile.getAbsolutePath());
			return fileList;
		} else {
			System.err.println(file.getName() + " FILE DOES NOT EXIST");
		}
		return null;
	}

	public static void main(String[] args) {

		try {

			String destination = "C:\\Users\\Asesoftware\\Desktop\\certicámara\\ocr-test\\images\\pdf\\";
			String sourcePathWithFileName = "C:\\Users\\Asesoftware\\Desktop\\certicámara\\ocr-test\\images\\hoja de vida.pdf";

			PDFtoJPGConverter converter = new PDFtoJPGConverter();
			// Scanner sc = new Scanner(System.in);
			// System.out.print("Enter your destination folder where save image \n");
			// Destination = D:/PPL/;
			// String destination = sc.nextLine();

			// System.out.print("Enter your selected pdf files name with source folder \n");
			// String sourcePathWithFileName = sc.nextLine();
			// Source Path = D:/PDF/ant.pdf,D:/PDF/abc.pdf,D:/PDF/xyz.pdf
			if (sourcePathWithFileName != null || sourcePathWithFileName != "") {
				String[] files = sourcePathWithFileName.split(",");
				for (String file : files) {
					File pdf = new File(file);
					System.out.print("FILE:>> " + pdf);
					converter.convertPdfToImage(pdf, destination);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
