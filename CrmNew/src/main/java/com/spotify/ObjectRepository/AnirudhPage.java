package com.spotify.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnirudhPage {
WebDriver driver;
public AnirudhPage(WebDriver driver){
	this.driver =driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//div[@class='Vs3vb54BvRJCIjvRvKDI']/div")
private List<WebElement> viewsList;

@FindBy(xpath = "//div[text()='See more']")
private WebElement seeMoreLink;

public WebElement getSeeMoreLink() {
	return seeMoreLink;
}

public List<WebElement> getViewsList() {
	return viewsList;
}
@FindBy(xpath="//div[@data-testid='tracklist-row']/descendant::a/div")
private List<WebElement> songNames;
public WebDriver getDriver() {
	return driver;
}

public List<WebElement> getSongNames() {
	return songNames;
}
}
