package PracticeTest;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
@Listeners(com.comcast.crm.listenerutility.ListenerImplementation.class)
public class Demo extends BaseClass {
@Test
public void demo() {
	UtilityClassObject.getTest().log(Status.INFO,"demo test script execution");
	Assert.fail();
}
}
