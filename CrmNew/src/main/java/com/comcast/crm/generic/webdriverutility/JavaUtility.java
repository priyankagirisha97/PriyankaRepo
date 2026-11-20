package com.comcast.crm.generic.webdriverutility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
public int getRandomNumber() {
	Random random = new Random();
	int randomNumber=random.nextInt(5000);
	return randomNumber;
}

public String getSystemDateYYYYMMDD() {
	Date dateObj = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	String date = sdf.format(dateObj);
	return date;
}
public String getSystemDateYYYYMMDDHHMMSS() {
	Date dateObj = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh-mm-ss");
	String date = sdf.format(dateObj);
	return date;
}


public String getRequiredDateYYYYMMDD(int days) {
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	Calendar cal = sdf.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String reqDate = sdf.format(cal.getTime());
	return reqDate;
}
}
 