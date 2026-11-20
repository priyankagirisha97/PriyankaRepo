package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContact {
public static void main(String[] args) throws Throwable {
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
	String lastName = wb.getSheet("contact").getRow(1).getCell(2).getStringCellValue()+ randomInt;
	wb.close();
	WebDriver driver;
	if(browser.equals("chrome")){
		driver = new ChromeDriver();	
	}
	else if (browser.equals("edge")) {
		driver = new EdgeDriver();
	}
	else if(browser.equals("firefox")) {
		driver= new FirefoxDriver();
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
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(lastName);
	driver.findElement(By.name("button")).click();
	String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
	//verify same last name entered in header
	if(header.contains(lastName)) {
		System.out.println(lastName +"is entered in the header==PASS==");
	}
	else {
		System.out.println(lastName+"is not entered into the header==FAIL==");
	}
	
	if(actualLastName.equals(lastName))
		System.out.println(actualLastName+ "is entered in the table==PASS==");
	else
		System.out.println(actualLastName+" is not entered in the table==FAIL==");
	Thread.sleep(2000);	
	Actions act  = new Actions(driver);
	WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
act.moveToElement(administrator).perform();
driver.findElement(By.linkText("Sign Out")).click();
	
	driver.quit();
}
}
