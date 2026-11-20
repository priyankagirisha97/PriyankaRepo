package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.spotify.ObjectRepository.HomePageSpotify;
import com.spotify.ObjectRepository.SpotifyWelcomeBackPage;
import com.spotify.ObjectRepository.SpotifyWelcomePage;

public class BaseClassSpotify extends WebDriverUtility{
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public   WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	@BeforeSuite
	public void configBS() throws Throwable {
		dbLib.getDbConnection();
		System.out.println("==Connect to database, Report config===");
		
	}

	@BeforeClass
	public void configBC() throws Throwable {
		
		String browser = fLib.getDataFromPropertiesFile("browser");
	System.out.println(browser);
		if(browser.equals("chrome")){
			driver = new ChromeDriver();	
		}
		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		System.out.println("==Launch the Browser==");
	}
	
	@BeforeMethod
	public void coufigBM() throws Throwable {
		waitForPageToLoad(driver);
		maximizePage(driver);
		String url = fLib.getDataFromPropertiesFile("spotifyUrl");
		String phNo = fLib.getDataFromPropertiesFile("phoneNumber");
		driver.get(url);
		SpotifyWelcomePage swp = new SpotifyWelcomePage(driver);
		swp.getLoginBtn().click();
		SpotifyWelcomeBackPage swbp = new SpotifyWelcomeBackPage(driver);
	    swbp.getPhNumBtn().click();
	    swbp.getPhTxt().sendKeys(phNo);
	    swbp.getContinueBtn().click();
	    Thread.sleep(10000);
	
	}
	
	@AfterMethod
	public void configAM() throws Throwable{
		HomePageSpotify hps = new HomePageSpotify(driver);
		hps.getAdminBtn().click();
		Thread.sleep(2000);
		hps.getLogOutBtn().click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void configAC() {
		driver.quit();
		System.out.println("==close The BROWSER");
	}

	@AfterSuite
	public void configAS() throws Throwable {
		System.out.println("==close DB , Report backUp==");
		dbLib.closeDbConnection();
		
	}
}
