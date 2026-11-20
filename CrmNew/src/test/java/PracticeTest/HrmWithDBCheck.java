package PracticeTest;



import java.sql.Connection;
import java.sql.DriverManager;
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

public class HrmWithDBCheck {
	
	public static void main(String[] args) throws SQLException {
		ChromeOptions options = new ChromeOptions();

        // Create a map to store Chrome preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        // Apply the preferences to ChromeOptions
        options.setExperimentalOption("prefs", prefs);
		
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		Statement stmt = conn.createStatement();
		Random r = new Random();
		
		String name="abc"+r.nextInt();
		int result = stmt.executeUpdate("insert into project values('NH_PROJ_1612','sefsf','17/11/2026','"+name+"','Created',0);");
		conn.close();
		
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
		Select search = new Select(driver.findElement(By.xpath("//div[@class='col-sm-6']/select[@class=\"form-control\"]")));
		search.selectByIndex(1);
		driver.findElement(By.xpath("//input[@placeholder='Search by Project Name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Search by Project Name']")).sendKeys(name);
		
		if(driver.findElement(By.xpath("//table[@class='table table-striped table-hover']/descendant::td[2]")).isDisplayed()) {
			String actname=driver.findElement(By.xpath("//table[@class='table table-striped table-hover']/descendant::td[2]")).getText();
			if(actname.equals(name)) {
				System.out.println("created project "+name+" is displayed");
			}else {
				System.out.println("created project "+name+" is not displayed");
			}
		}
	}

}