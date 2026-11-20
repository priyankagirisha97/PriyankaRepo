package PracticeTest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class HrmWithWebpageandCheckDb {

	public static void main(String[] args) throws SQLException, InterruptedException {
		 ChromeOptions options = new ChromeOptions();

	        // Create a map to store Chrome preferences
	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("credentials_enable_service", false);
	        prefs.put("profile.password_manager_enabled", false);
	        prefs.put("profile.password_manager_leak_detection", false);

	        // Apply the preferences to ChromeOptions
	        options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.29.4:8091/");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).clear();
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.name("projectName")).clear();
		Random r = new Random();
		String name = "dfg"+r.nextInt();
		driver.findElement(By.name("projectName")).sendKeys(name);
		driver.findElement(By.name("createdBy")).clear();
		driver.findElement(By.name("createdBy")).sendKeys("Rahul");
		Select status = new Select(driver.findElement(By.xpath("//label[text()='Project Status* ']/following-sibling::select[@name='status']")));
		status.selectByIndex(1);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
		//database
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		Statement stmt = conn.createStatement();
	
		ResultSet result = stmt.executeQuery("select * from project where project_name='"+name+"'");
		
		boolean flag=false;
		while(result.next()) {
			flag=true;
		}
		if(flag==true) {
			System.out.println("The project "+name+" is created successfully😊😊😊");
		}else {
			System.out.println("The project "+name+"is not created😒😒😒");
		}
		
		conn.close();
	}
}