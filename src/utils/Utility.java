package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Utility {
	public  String sCurrentDate = "";
	public  String sCurrentDateHour ="";
	public static String sCurrentDateTime = "";
	public static String sCurrentDateTimeForEmail = "";
	public static String sCurrentDateTimeSec = "";
	public static String sGetCurrentProPath = System.getProperty("user.dir");
	public static boolean bIsMethodExecutedOk = true;
	// public static boolean bSetEnable = isbIsMethodExecutedOk();
	public static boolean bSetEnable = true;
	public static String sCaptureSSPath = "";
	
	public void utility () {
		currentDate();
		currentDateNHour();
		currentDateTime();
	}
	

	public static boolean isbIsMethodExecutedOk() {
		return bIsMethodExecutedOk;
	}

	public void setbIsMethodExecutedOk(boolean bIsMethodExecutedOk) {
		if (bIsMethodExecutedOk) {
			this.bIsMethodExecutedOk = true;
		} else {
			this.bIsMethodExecutedOk = false;
		}
		// this.bIsMethodExecutedOk = bIsMethodExecutedOk;
	}
	
	public void currentDate() {
		SimpleDateFormat formatterHour = new SimpleDateFormat("dd_MM_yyyy");
		Date dateHour = new Date();
		System.out.println("Formated Date & Hour:" + formatterHour.format(dateHour));
		sCurrentDate = formatterHour.format(dateHour).toString();
		// System.out.println(sCurrentDateHour);
	}

	public void currentDateNHour() {
		SimpleDateFormat formatterHour = new SimpleDateFormat("dd_MM_yyyy_HH");
		Date dateHour = new Date();
		System.out.println("Formated Date & Hour:" + formatterHour.format(dateHour));
		sCurrentDateHour = formatterHour.format(dateHour).toString();
		// System.out.println(sCurrentDateHour);
	}

	public void currentDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
		Date date = new Date();
		System.out.println("Formated Date & Time:" + formatter.format(date));
		sCurrentDateTime = formatter.format(date).toString();
	}
	
	public void currentDateTimeSec() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_SSS");
		Date date = new Date();
		System.out.println("Formated Date & Time:" + formatter.format(date));
		sCurrentDateTimeSec = formatter.format(date).toString();
	}

	public void printCurrentMethodName(String sCurrentMethod) {
		System.out.println("Current Method name:" + sCurrentMethod);
	}

	public String returnCurrentDateNHour() {
		SimpleDateFormat formatterHour = new SimpleDateFormat("dd_MM_yyyy_HH");
		Date dateHour = new Date();
		System.out.println("Formated Date & Hour:" + formatterHour.format(dateHour));
		sCurrentDateHour = formatterHour.format(dateHour).toString();
		// System.out.println(sCurrentDateHour);

		return sCurrentDateHour;
	}
	
	public static String returnCurrentDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
		Date date = new Date();
		System.out.println("Formated Date & Time:" + formatter.format(date));
		sCurrentDateTime = formatter.format(date).toString();

		return sCurrentDateTime;
	}

	public String returnSSTakenSuccussMsg(boolean bIsSuccess) {
		String sMsg = "Screen shot taken succesfully";
		if (bIsSuccess) {
			sMsg = "Success :" + sMsg;
		} else {
			sMsg = "Failed :" + sMsg;
		}
		return sMsg;
	}

	public String returnDateTimeAsWholeNum() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY/MM/dd HH:mm");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));

		sCurrentDateTimeForEmail = now.toString().replaceAll("-", "").replaceAll(":", "").replaceAll("T", "");
		sCurrentDateTimeForEmail = sCurrentDateTimeForEmail.substring(2, 12).toString().trim();
		System.out.println("returnDateTimeAsWholeNum: " + sCurrentDateTimeForEmail);
		return sCurrentDateTimeForEmail;
	}

}