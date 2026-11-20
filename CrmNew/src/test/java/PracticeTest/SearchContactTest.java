package PracticeTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.basetest.BaseClass;
/**
 * test class for contact module
 * @author Arunachalam
 */
public class SearchContactTest extends BaseClass {
	/**
	 * Scenario: login()==> navigateContact==>createContact()==>verify
	 */
@Test
public void searchcontacttest() {
	/* Step 1: login to application */
	LoginPage lLib = new LoginPage(driver);
	lLib.loginToapp("url", "username", "password");
}
}
