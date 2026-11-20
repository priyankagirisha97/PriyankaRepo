package com.spotify.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YuvanPage {
	WebDriver driver;
	public YuvanPage(WebDriver driver){
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@data-testid='title' and contains(.,'Yuvan All Songs')]")
	private WebElement yuvanAllSongLink;
	public WebElement getYuvanAllSongLink() {
		return yuvanAllSongLink;
	} 
}
