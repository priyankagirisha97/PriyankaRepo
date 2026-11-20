package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
public static ThreadLocal<ExtentTest> ttest = new ThreadLocal<ExtentTest>();
public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

public static ExtentTest getTest() {
	return ttest.get();
}

public static void setTest(ExtentTest actTest) {
	ttest.set(actTest);
}

public static WebDriver getDriver() {
	return tdriver.get();
}

public static void setDriver(WebDriver actDriver) {
	tdriver.set(actDriver)   ;
}
}
