package ocr_concepttest.free_ocr_api;

import java.io.File;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestApp {

	public static void main(String[] args) {

		String apikey = "afffe56eb888957";
		String filePath = "C:\\Users\\Asesoftware\\Desktop\\certicámara\\ocr-test\\images\\hv.JPG";
		HttpClient httpclient = HttpClients.createDefault();

		try {
			URIBuilder builder = new URIBuilder("http://api.ocr.space/Parse/Image");

			//builder.setParameter("apikey", apikey);
			//builder.setParameter("isOverlayRequired", "true");

			// builder.setParameter("language", "unk");

			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);
			//request.addHeader("apikey", apikey);
			//request.setHeader("Content-Type", "multipart/form-data");

			// Request body
			// StringEntity reqEntity = new StringEntity("{body}");
			/*
			 * HttpEntity reqEntity = MultipartEntityBuilder .create()
			 * .addBinaryBody("Binary image data", new File(filePath)) .build();
			 */
			HttpEntity reqEntity = MultipartEntityBuilder.create()
					.addBinaryBody("file", new File(filePath), ContentType.MULTIPART_FORM_DATA,"hv.JPG")
					//.addBinaryBody("base64image", new File(filePath))
					.addTextBody("apikey", apikey)
					.addTextBody("isOverlayRequired", "true")
					.build();
			
			//FileEntity reqEntity = new FileEntity(new File(filePath));

			request.setEntity(reqEntity);
			

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				System.out.println(EntityUtils.toString(entity));
			}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}

	}

}
