package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewDocumentPage {
	WebDriver driver;
	public CreatingNewDocumentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
}
	@FindBy(xpath = "//input[@name='notes_title']")
	private WebElement titleTxt;
	
	@FindBy(xpath = "//iframe[contains(@title,'Rich')]")
	private WebElement notesFrame;
	
	@FindBy(xpath = "//body[contains(@class,'cke_show_borders')]")
	private WebElement notesTxtBox;
	
	public WebElement getTitleTxt() {
		return titleTxt;
	}

	

	public WebDriver getDriver() {
		return driver;
	}



	public WebElement getNotesFrame() {
		return notesFrame;
	}



	public WebElement getNotesTxtBox() {
		return notesTxtBox;
	}



	public WebElement getUserRadioBtn() {
		return userRadioBtn;
	}

	public WebElement getGroupRadioBtn() {
		return groupRadioBtn;
	}

	public WebElement getAssignedToUserDD() {
		return assignedToUserDD;
	}

	public WebElement getAssignedToGroupDD() {
		return assignedToGroupDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	@FindBy(xpath="//input[@value='U']")
	private WebElement userRadioBtn;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupRadioBtn;
	
	@FindBy(name = "assigned_user_id")
	private WebElement assignedToUserDD;
	
	@FindBy(name = "assigned_group_id")
	private WebElement assignedToGroupDD;
	
	@FindBy(xpath = "//input[ @name='button' and @title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[ @name='button' and @title='Cancel [Alt+X]']")
	private WebElement cancelBtn;
}
