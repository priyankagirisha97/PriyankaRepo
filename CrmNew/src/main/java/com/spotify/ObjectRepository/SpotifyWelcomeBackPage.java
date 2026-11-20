package com.spotify.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpotifyWelcomeBackPage {
	WebDriver driver;
	
	public SpotifyWelcomeBackPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(.,'Continue with phone number')]")
	private WebElement phNumBtn;

	
	@FindBy(id = "phoneNumber")
	private WebElement phTxt;
	
	@FindBy(xpath = "//span[text()='Continue']")
	private WebElement continueBtn;
	
	public WebElement getPhTxt() {
		return phTxt;
	}

	public WebElement getPhNumBtn() {
		return phNumBtn;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}
}
