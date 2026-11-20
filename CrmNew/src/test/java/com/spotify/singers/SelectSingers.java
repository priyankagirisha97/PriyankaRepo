package com.spotify.singers;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClassSpotify;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.spotify.ObjectRepository.AnirudhPage;
import com.spotify.ObjectRepository.HomePageSpotify;
import com.spotify.ObjectRepository.ProfilePage;
import com.spotify.ObjectRepository.SpotifyWelcomeBackPage;
import com.spotify.ObjectRepository.SpotifyWelcomePage;
import com.spotify.ObjectRepository.YuvanAllSongsPage;
import com.spotify.ObjectRepository.YuvanPage;

@Listeners(com.comcast.crm.listenerutility.ListenerImplementation.class)

public class SelectSingers extends BaseClassSpotify {
	
@Test
public void demo1() {
	System.out.println("Spotify demo executed");
}
	@Test public void spotifyTestAnirudh() throws Throwable {
	

HomePageSpotify hps = new HomePageSpotify(driver);
//hps.getClose().click();
WebDriverUtility wLib = new WebDriverUtility();
Thread.sleep(2000);
wLib.waitforElementPresent(driver, hps.getAdminBtn());
hps.getAdminBtn().click();
wLib.waitforElementPresent(driver, hps.getProfile());
hps.getProfile().click();
ProfilePage pp = new ProfilePage(driver);
pp.getAnirudh().click();

AnirudhPage ap = new AnirudhPage(driver);
//ap.getSeeMoreLink().click();
List<WebElement> names = ap.getSongNames();
System.out.println("Number of Songs : "+names.size());
for(int i = 0; i<names.size(); i++) {
	
	ExcelUtility eLib=new ExcelUtility();
	eLib.setDataIntoExcel("Sheet1", i, 0,names.get(i).getText());
	System.out.println(i+" song entered");
	System.out.println(names.get(i).getText());
	
}

List<WebElement> viewsList = ap.getViewsList();

for(int i =0; i<viewsList.size();i++ ) {
	
	
ExcelUtility eLib = new ExcelUtility();
eLib.setDataIntoExcel("Sheet1", i, 1,viewsList.get(i).getText());
System.out.println(i+" views entered");
System.out.println(viewsList.get(i).getText());
}


}
	
	@Test
	public void spotifyYuvan() throws Throwable {
		
	HomePageSpotify hps = new HomePageSpotify(driver);
	hps.getSearchTxt().sendKeys("yuvan shankar raja");
	actionEnter(driver);
	YuvanPage yp = new YuvanPage(driver);
	yp.getYuvanAllSongLink().click();
	YuvanAllSongsPage yasp = new YuvanAllSongsPage(driver);
	List<WebElement> yuvansongNames = yasp.getYuvanSongNames();
	List<WebElement> yuvanAlbumNames=yasp.getAlbumNames();
	waitforAllElementsToBePresent(driver, yuvansongNames);
	waitforAllElementsToBePresent(driver, yuvanAlbumNames);
	
for(int i =0; i<9;i++ ) {
		mouseMoveToElement(driver, yuvanAlbumNames.get(i));
		waitforElementPresent(driver, yuvanAlbumNames.get(i));
		ExcelUtility eLib = new ExcelUtility();
		eLib.setDataIntoExcel("Sheet1", i, 2,yuvanAlbumNames.get(i).getText());
		System.out.println(i+" yuvan album  entered");
		System.out.println(yuvanAlbumNames.get(i).getText());
		}

	for(int i =0; i<9;i++ ) {
		mouseMoveToElement(driver, yuvansongNames.get(i));
		waitforElementPresent(driver, yuvansongNames.get(i));
		ExcelUtility eLib = new ExcelUtility();
		eLib.setDataIntoExcel("Sheet1", i, 3,yuvansongNames.get(i).getText());
		System.out.println(i+" yuvan song  entered");
		System.out.println(yuvansongNames.get(i).getText());
		}
	

	//hps.getYuvanLink().click();
	
	}
}