package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class CreateOrgTest {
public static void main(String[] args) throws Throwable {
	
	FileUtility file = new FileUtility();
	String url = file.getDataFromPropertiesFile("url");
	String browser = file.getDataFromPropertiesFile("browser");
	String username = file.getDataFromPropertiesFile("username");
	String password = file.getDataFromPropertiesFile("password");
	
	Random random =  new Random();
	int randomInt = random.nextInt(500);
	
	
	ExcelUtility excel = new ExcelUtility();
	String orgName = excel.getDataFromExcel("org", 1, 2)+randomInt;
	
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
			//verify Header orgName info Expected Result
	String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
	if(actualOrgName.equals(orgName)) {
		System.out.println(actualOrgName+" is entered into the org Table");
	}
	else {
		System.out.println(actualOrgName+" is  not entered into the org Table"); 
	}
	Thread.sleep(2000);	
	Actions act  = new Actions(driver);
	WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
act.moveToElement(administrator).perform();
driver.findElement(By.linkText("Sign Out")).click();
	
	driver.quit();
}
}
