package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	WebDriver driver;
	public OpportunitiesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "potentialname")
	private WebElement opportunitiesTextField;
	
	@FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img[@title='Select']")
	private WebElement relatedToPlusIcn;
	
	@FindBy(xpath="//input[@value='U']")
	private WebElement userRadioBtn;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupRadioBtn;
	
	@FindBy(name = "assigned_user_id")
	private WebElement assignedToUserDD;
	
	@FindBy(name = "assigned_group_id")
	private WebElement assignedToGroupDD;
	
	@FindBy(name="closingdate")
	private WebElement expCloseDate;
	
	@FindBy(name="sales_stage")
	private WebElement salesStageDD;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOpportunitiesTextField() {
		return opportunitiesTextField;
	}

	public WebElement getRelatedToPlusIcn() {
		return relatedToPlusIcn;
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

	public WebElement getExpCloseDate() {
		return expCloseDate;
	}

	public WebElement getSalesStageDD() {
		return salesStageDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getLeadsourceDD() {
		return leadsourceDD;
	}

	public WebElement getDescriptionTextField() {
		return descriptionTextField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	@FindBy(name="opportunity_type")
	private WebElement typeDD;
	
	@FindBy(name="leadsource")
	private WebElement leadsourceDD;
	
	@FindBy(name="leadsource")
	private WebElement descriptionTextField;
	
	@FindBy(xpath = "//input[ @name='button' and @title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[ @name='button' and @title='Cancel [Alt+X]']")
	private WebElement cancelBtn;
	
	
}
