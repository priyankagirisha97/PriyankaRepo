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
import org.openqa.selenium.support.ui.Select;

public class CreateOrgIndustryType {
	public static void main(String[] args) throws Throwable  {
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
		Row row = sh.getRow(4);
		String orgName = row.getCell(2).toString()+randomInt;
	      String industry = sh.getRow(4).getCell(3).toString();
	     String type = sh.getRow(4).getCell(4).toString();
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
		WebElement selIndustry = driver.findElement(By.name("industry"));
		WebElement selType = driver.findElement(By.name("accounttype"));
		Select sel1= new Select(selIndustry);
		sel1.selectByValue(industry);
		Select sel2= new Select(selType);
		sel2.selectByValue(type);
		driver.findElement(By.name("button")).click();
		String actualIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		String actualType = driver.findElement(By.id("dtlview_Type")).getText();
		if(industry.equals(actualIndustry)) {
			System.out.println(actualIndustry+" is selected");
		}
		else {
			System.out.println(actualIndustry+" is not selected");
		}
		
		if(type.equals(actualType)) {
			System.out.println(actualType+" is selected");
		}
		else {
			System.out.println(actualType+"is not selected");
		}
		Thread.sleep(2000);
		Actions act  = new Actions(driver);
		
		
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	act.moveToElement(administrator).perform();
	driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
}
}