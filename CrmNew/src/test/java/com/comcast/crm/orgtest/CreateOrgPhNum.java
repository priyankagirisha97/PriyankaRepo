package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgPhNum {
public static void main(String[] args) throws Throwable, IOException {
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
	Sheet sh = wb.getSheet("org");
	Row row = sh.getRow(7);
	String orgName = row.getCell(2).toString()+randomInt;
	String phoneNumber = row.getCell(3).getStringCellValue();
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
	driver.findElement(By.id("phone")).sendKeys(phoneNumber);
	driver.findElement(By.name("button")).click();
	String actualHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	String actualPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
	if(actualHeader.contains(orgName)) {
		System.out.println(actualHeader+" is verified === PASS");
	}
	else {
		System.out.println(orgName+" is not  present === FAIL");
	}
	if(actualPhoneNumber.equals(phoneNumber)) {
		System.out.println(actualPhoneNumber+" is entered ===PASS");
	}
	else {
		System.out.println(phoneNumber+" is not entered ===FAIL");
	}
	
	Thread.sleep(2000);	
	Actions act  = new Actions(driver);
	WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
act.moveToElement(administrator).perform();
driver.findElement(By.linkText("Sign Out")).click();
	
	driver.quit();

}
}
