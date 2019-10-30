/**
 * 
 */
package ocr_concepttest.abbyy.com.abbyy.ocrsdk;

/**
 * Barcode recognition settings.
 * 
 * For all possible parameters see
 * https://ocrsdk.com/documentation/apireference/processBarcodeField/
 */
public class BarcodeSettings {

	public String asUrlParams() {
		return "barcodeType=" + barcodeType;
	}

	public String getType() {
		return barcodeType;
	}

	public void setType(String newType) {
		barcodeType = newType;
	}

	private String barcodeType = "autodetect";
}