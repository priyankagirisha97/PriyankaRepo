package com.spotify.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YuvanAllSongsPage {
	WebDriver driver;
	public YuvanAllSongsPage(WebDriver driver){
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='Ir5R1qQKIs8ekiBSh5I6']/a/div")
	private List<WebElement> yuvanSongNames;
	
	@FindBy(xpath = "//div[@class='Vs3vb54BvRJCIjvRvKDI']/span/a")
	private List<WebElement> albumNames;
	

	public List<WebElement> getYuvanSongNames() {
		return yuvanSongNames;
	}

	public List<WebElement> getAlbumNames() {
		return albumNames;
	}

	
}
