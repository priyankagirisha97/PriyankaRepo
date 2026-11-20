package com.comcast.crm.documentstest;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepository.CreatingNewDocumentPage;
import com.comcast.crm.ObjectRepository.DocumentsPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.basetest.BaseClass;

@Listeners(com.comcast.crm.listenerutility.ListenerImplementation.class)
public class CreateDocumentTest extends BaseClass{
	@Test
	public void createDocumentTest() throws Throwable {
		String docName = eLib.getDataFromExcel("documents", 1, 2)+jLib.getRandomNumber();
		String groupName = eLib.getDataFromExcel("documents", 1, 3);
		String notes = eLib.getDataFromExcel("documents", 1, 4);
		System.out.println(docName+groupName+notes);
		HomePage hp = new HomePage(driver);
		hp.getDocumentsLink().click();
		DocumentsPage dp=new DocumentsPage(driver);
		dp.getDocPlusLink().click();
		CreatingNewDocumentPage cndp= new CreatingNewDocumentPage(driver);
		cndp.getTitleTxt().sendKeys(docName);
		cndp.getGroupRadioBtn().click();
		WebElement group = cndp.getAssignedToGroupDD();
		select(group, groupName);
		switchToframe(driver, cndp.getNotesFrame());
		cndp.getNotesTxtBox().sendKeys(notes);
		
		switchToDefaultContent(driver);
		//Assert.fail();
		cndp.getSaveBtn().click();
	}
}
