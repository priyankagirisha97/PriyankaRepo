package com.spotify.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageSpotify {
	WebDriver driver;
	public HomePageSpotify(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Music']")
	private WebElement musicBtn;
	//@FindBy(xpath = "//input[@type='search']")
	//private WebElement searchTxt;
	
	@FindBy(xpath = "//input[@data-testid='search-input']")
	private WebElement searchTxt;
	
	@FindBy(xpath = "//button[@data-testid='search-icon']")
	private WebElement searchIcon;
	
	public WebElement getSearchIcon() {
		return searchIcon;
	}
	@FindBy(xpath = "//span[@data-testid ='username-first-letter']")
	private WebElement adminBtn;
	
	@FindBy(xpath = "//span[text()='Log out']")
	private WebElement logOutBtn;
	
	@FindBy(xpath = "//div/div/div/div/p/span[text()='Yuvan Shankar Raja']")
	private WebElement yuvanLink;
	
	public WebElement getYuvanLink() {
		return yuvanLink;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	@FindBy(xpath = "//div[@id='onetrust-close-btn-container']/button[@aria-label='Close']")
	private WebElement close;
	public WebElement getClose() {
		return close;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAdminBtn() {
		return adminBtn;
	}
@FindBy(xpath = "//span[text()='Profile' and @data-encore-id]")
private WebElement profile;
	public WebElement getProfile() {
	return profile;
}

	public WebElement getSearchTxt() {
		return searchTxt;
	}
	@FindBy(xpath = "//div[@class='bqrd0cICXSoGyGkKQaJS' and contains(.,'With A.R. Rahman, Anirudh Ravichander, Bombay Jayashri and more')]")
	private WebElement karthik;
	@FindBy(xpath = "//a[@title='AR Rahman - Tamil Hits - 1990-2010']")
	private WebElement arRahman;
	
	public WebElement getKarthik() {
		return karthik;
	}

	public WebElement getMusicBtn() {
		return musicBtn;
	}

	public WebElement getArRahman() {
		return arRahman;
	}
	
}
