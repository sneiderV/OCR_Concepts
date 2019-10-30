package tests;

import java.util.Date;

public class StevenTimer {
	private Date startDate;
	private Date finalDate;

	public StevenTimer() {

	}

	public void start() {
		startDate = new Date();
	}

	public void finish() {
		finalDate = new Date();
	}

	public long compare() {
		long diff = finalDate.getTime() - startDate.getTime();
		return diff / 1000 % 6;

	}

}
