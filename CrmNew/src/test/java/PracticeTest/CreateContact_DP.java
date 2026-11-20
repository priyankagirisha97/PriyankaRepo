package PracticeTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP {
@Test(dataProvider = "getData")
public void createContactTest(String firstName, String lastName, long phoneNumber) {
	System.out.println(firstName + lastName+ phoneNumber);
}

@DataProvider
public Object[][] getData(){
	Object[][] objArr = new Object[3][3];
	objArr[0][0]="Arun";
	objArr[0][1]="S";
	objArr[0][2]=6374339896l;
	
	objArr[1][0]="VIMAL";
	objArr[1][1]="S";
	objArr[1][2]=9999999212l;
	
	objArr[2][0]="Raj";
	objArr[2][1]="v";
	objArr[2][2]=9900887596l;
	
	return objArr;
	
}
}
