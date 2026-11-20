package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
public void waitForPageToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}

public void maximizePage(WebDriver driver) {
	driver.manage().window().maximize();
}
public void waitforElementPresent(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

public void waitforAllElementsToBePresent(WebDriver driver, List<WebElement> element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElements(element));
}

public void switchToTabOnUrl(WebDriver driver, String partialUrl) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext()) {
		String windowID = it.next();
		driver.switchTo().window(windowID);
		
		String actUrl = driver.getCurrentUrl();
		if(actUrl.contains(partialUrl)) {
			break;
		}
	}
}

public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext()) {
		String windowID = it.next();
		driver.switchTo().window(windowID);
		
		String actTitle = driver.getTitle();
		if(actTitle.contains(partialTitle)) {
			break;
		}
	}
}
public void switchToAlertAndAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}

public void switchToAlertAndCancel(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
public void switchToframe(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}
public void switchToframe(WebDriver driver,String nameID) {
	driver.switchTo().frame(nameID);
}
public void switchToframe(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}

public void switchToDefaultContent(WebDriver driver) {
	driver.switchTo().defaultContent();
	
	
	
}
public void select(WebElement element, int index) {
	Select sel = new Select(element);
	sel.selectByIndex(index);
}

public void select(WebElement element, String text) {
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}

public void mouseMoveToElement(WebDriver driver,WebElement element ) {
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
}
public void mouseDoubleClick(WebDriver driver,WebElement element ) {
	Actions act = new Actions(driver);
	act.doubleClick(element).perform();
}

public void actionEnter(WebDriver driver ) {
	Actions act = new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
}

}
