package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\commonData\\commondata.properties");
	Properties pObj = new Properties();
	pObj.load(fis);
	String url = pObj.getProperty("url");
	System.out.println(url);
	String browser = pObj.getProperty("browser");
	String username = pObj.getProperty("username");
	String password = pObj.getProperty("password");
	
	Random random =  new Random();
	int randomInt = random.nextInt(500);
	
	FileInputStream fis1 = new FileInputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\commonData\\testScriptdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sh = wb.getSheet("contact");
	Row row = sh.getRow(7);
	String orgName = row.getCell(2).toString()+randomInt;
	String contactLastName = row.getCell(3).getStringCellValue();
	wb.close();
	
	WebDriver driver = null;
	if(browser.equals("chrome"))
	{
		driver = new ChromeDriver();
	}
	else if(browser.equals("firefox")) {
		driver = new FirefoxDriver();
	}
	else if(browser.equals("edge")) {
		driver= new EdgeDriver();
	}
	else {
		driver = new ChromeDriver();
	}
	
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	driver.findElement(By.name("button")).click();
	//verify Header msg Expected result
	String actualheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(actualheader.contains(orgName)) {
		System.out.println(orgName +"  header is created====PASS");
	}
	else {
		System.out.println(orgName+" header is not created ====FAIL");
	}
	
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	driver.findElement(By.name("lastname")).sendKeys(contactLastName);
	driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
	
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	
	while(it.hasNext()) {
		String windowID = it.next();
		driver.switchTo().window(windowID);
		@Nullable
		String actUrl = driver.getCurrentUrl();
		if(actUrl.contains("module=Accounts")) {
			break;
		}
	}
	driver.findElement(By.name("search_text")).sendKeys(orgName);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	
	Set<String> set1 = driver.getWindowHandles();
	Iterator<String> it1 = set1.iterator();
	
	while(it1.hasNext()) {
		String windowID = it1.next();
		driver.switchTo().window(windowID);
		
		String actUrl = driver.getCurrentUrl();
		if(actUrl.contains("Contacts&action")) {
			break;
		}
	}
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//verify same last name entered in header
	String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(contactLastName)) {
			System.out.println(contactLastName +"is entered in the header==PASS==");
		}
		else {
			System.out.println(contactLastName+"is not entered into the header==FAIL==");
		}
		
		String actualOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actualOrgName.trim().equals(orgName)) {
			System.out.println(actualOrgName+" is entered into the org Table");
		}
		else {
			System.out.println(actualOrgName+" is  not entered into the org Table"); 
		}
		driver.quit();

}
}
