package ocr_concepttest.cloudMersive;


import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.*;
import com.cloudmersive.client.model.ImageToLinesWithLocationResult;
import com.cloudmersive.client.model.ImageToTextResponse;
import com.cloudmersive.client.model.OcrLineElement;

import java.io.File;

import javax.sound.sampled.Line;

import com.cloudmersive.client.ImageOcrApi;

public class TestApp {
	//demora mucho
	public static void main(String[] args) {
		// Import classes:
		
		String apiKey ="b0f0a7cb-11eb-4276-81fa-243cfd187fe3";
		String filePath = "C:\\Users\\esneider.velandia\\Downloads\\OCR_Test\\pruebaavantel.pdf";


		ApiClient defaultClient = Configuration.getDefaultApiClient();
		defaultClient.setConnectTimeout(1000000);
		defaultClient.setReadTimeout(1000000);
		// Configure API key authorization: Apikey
		ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("Apikey");
		Apikey.setApiKey(apiKey);
		// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
		//Apikey.setApiKeyPrefix("Token");

		ImageOcrApi apiInstance = new ImageOcrApi();
		File imageFile = new File(filePath); // File | Image file to perform OCR on.  Common file formats such as PNG, JPEG are supported.
		String language = "SPA"; // String | Optional, language of the input document, default is English (ENG).  Possible values are ENG (English), ARA (Arabic), ZHO (Chinese - Simplified), ZHO-HANT (Chinese - Traditional), ASM (Assamese), AFR (Afrikaans), AMH (Amharic), AZE (Azerbaijani), AZE-CYRL (Azerbaijani - Cyrillic), BEL (Belarusian), BEN (Bengali), BOD (Tibetan), BOS (Bosnian), BUL (Bulgarian), CAT (Catalan; Valencian), CEB (Cebuano), CES (Czech), CHR (Cherokee), CYM (Welsh), DAN (Danish), DEU (German), DZO (Dzongkha), ELL (Greek), ENM (Archaic/Middle English), EPO (Esperanto), EST (Estonian), EUS (Basque), FAS (Persian), FIN (Finnish), FRA (French), FRK (Frankish), FRM (Middle-French), GLE (Irish), GLG (Galician), GRC (Ancient Greek), HAT (Hatian), HEB (Hebrew), HIN (Hindi), HRV (Croatian), HUN (Hungarian), IKU (Inuktitut), IND (Indonesian), ISL (Icelandic), ITA (Italian), ITA-OLD (Old - Italian), JAV (Javanese), JPN (Japanese), KAN (Kannada), KAT (Georgian), KAT-OLD (Old-Georgian), KAZ (Kazakh), KHM (Central Khmer), KIR (Kirghiz), KOR (Korean), KUR (Kurdish), LAO (Lao), LAT (Latin), LAV (Latvian), LIT (Lithuanian), MAL (Malayalam), MAR (Marathi), MKD (Macedonian), MLT (Maltese), MSA (Malay), MYA (Burmese), NEP (Nepali), NLD (Dutch), NOR (Norwegian), ORI (Oriya), PAN (Panjabi), POL (Polish), POR (Portuguese), PUS (Pushto), RON (Romanian), RUS (Russian), SAN (Sanskrit), SIN (Sinhala), SLK (Slovak), SLV (Slovenian), SPA (Spanish), SPA-OLD (Old Spanish), SQI (Albanian), SRP (Serbian), SRP-LAT (Latin Serbian), SWA (Swahili), SWE (Swedish), SYR (Syriac), TAM (Tamil), TEL (Telugu), TGK (Tajik), TGL (Tagalog), THA (Thai), TIR (Tigrinya), TUR (Turkish), UIG (Uighur), UKR (Ukrainian), URD (Urdu), UZB (Uzbek), UZB-CYR (Cyrillic Uzbek), VIE (Vietnamese), YID (Yiddish)
		String preprocessing = "Auto"; // String | Optional, preprocessing mode, default is 'Auto'.  Possible values are None (no preprocessing of the image), and Auto (automatic image enhancement of the image before OCR is applied; this is recommended).
		try {
			//System.out.println(apiInstance.imageOcrPhotoToText(imageFile, language));
			ImageToLinesWithLocationResult result = apiInstance.imageOcrImageLinesWithLocation(imageFile, language, preprocessing);
			System.out.println("----------------------");
			for(OcrLineElement element: result.getLines()){
				System.out.println(element.getLineText());
			}
		    //System.out.println(result);
		} catch (ApiException e) {
		    System.err.println("Exception when calling ImageOcrApi#imageOcrPost");
		    e.printStackTrace();
		}

	}

}
