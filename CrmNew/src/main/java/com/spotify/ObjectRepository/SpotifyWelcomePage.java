package com.spotify.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpotifyWelcomePage {
	WebDriver driver;
@FindBy(xpath = "//span[text()='Log in']")
private WebElement loginBtn;



public SpotifyWelcomePage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
public WebElement getLoginBtn() {
	return loginBtn;
}



}
