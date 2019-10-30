package ocr_concepttest.docparser;

import java.io.File;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.cloudmersive.client.invoker.JSON;

public class TestApp {

	public static void main(String[] args) {

		String apikey = "ea115a71c03d839fb459f4fda659152611154a97";
		String filePath = "C:\\Users\\Asesoftware\\Desktop\\certicámara\\ocr-test\\images\\hv.JPG";
		HttpClient httpclient = HttpClients.createDefault();

		try {
			URIBuilder builder = new URIBuilder("https://api.docparser.com/v1/document/upload/qjazrxhkbeut");

			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);
			request.addHeader("api_key", apikey);

			HttpEntity reqEntity = MultipartEntityBuilder.create()
					.addBinaryBody("file", new File(filePath), ContentType.MULTIPART_FORM_DATA, "hv.JPG")

					.build();

			request.setEntity(reqEntity);
			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {

				JSONParser parser = new JSONParser();
				String result1 = EntityUtils.toString(entity);

				JSONObject json = (JSONObject) parser.parse(result1);

				System.out.println(result1);

				URIBuilder builder2 = new URIBuilder(
						"https://api.docparser.com/v1/results/qjazrxhkbeut/" + json.get("id"));

				URI uri2 = builder2.build();
				HttpGet request2 = new HttpGet(uri2);
				request2.addHeader("api_key", apikey);
				String fileResult = "";
				boolean result2 = false;
				while (!result2 ) {
					
					HttpResponse response2 = httpclient.execute(request2);
					HttpEntity entity2 = response2.getEntity();
					String r2 = EntityUtils.toString(entity2);
					//JSONObject json2 = (JSONObject) parser.parse(r2);
					result2 = !r2.contains("\"error\"");
					
					if(result2) {
						
						fileResult = r2;
					}else{
						System.out.println("No results yet");
					}
					Thread.sleep(1000);
				}
				System.out.println("Final: ");
				System.out.println(fileResult);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
		}

	}

}
