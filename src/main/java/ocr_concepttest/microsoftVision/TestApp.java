package ocr_concepttest.microsoftVision;

import java.io.File;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import tests.PDFtoJPGConverter;
import tests.ResultsWriter;
import tests.StevenTimer;

public class TestApp {

	public static void main(String[] args) {
		StevenTimer timer = new StevenTimer();
		timer.start();
		String subscriptionKey = "a2efb169081148a285c1df610c9d01ea";
		//UBICACIÓN ARCHIVO A LEER 		
		String filePath = "C:\\Users\\esneider.velandia\\Downloads\\OCR_Test\\pruebaavantel.pdf";
		//CARPETA TEMPORAL PARA GUARDAR IMÁGENES QUE VIENEN DE ARCHIVO PDF
		String resultsPath= "C:\\Users\\esneider.velandia\\Downloads\\OCR_Test\\Microsoft\\";
		
		//UBICACIÓN RESULTADOS		
		String fileResults = "C:\\Users\\esneider.velandia\\Downloads\\OCR_Test\\Microsoft\\result.txt";

		HttpClient httpclient = HttpClients.createDefault();

		try {
			String result = "";
			File f = new File(filePath);
			List<File> files = PDFtoJPGConverter.convertPdfToImage(f, resultsPath);
			
			URIBuilder builder = new URIBuilder("https://eastus.api.cognitive.microsoft.com/vision/v2.0/ocr?language=en&detectOrientation=false");

			builder.setParameter("language", "en");
			builder.setParameter("detectOrientation", "false");

			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);
			request.setHeader("Content-Type", "application/octet-stream");
			request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);
			for (File file : files) {
				
				System.out.println(file.getAbsolutePath());
				FileEntity reqEntity = new FileEntity(file);

				request.setEntity(reqEntity);

				HttpResponse response = httpclient.execute(request);
				HttpEntity entity = response.getEntity();
				
				if (entity != null) {
					result += EntityUtils.toString(entity);

				}
			}
			
			
			timer.finish();
			System.out.println(result);
			ResultsWriter.writeResults(fileResults, result, timer.compare(), true);
			System.out.println("time......"+timer.compare());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
