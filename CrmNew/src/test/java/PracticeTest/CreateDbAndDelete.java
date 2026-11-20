package PracticeTest;

import java.sql.ResultSet;

import org.testng.annotations.Test;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;

public class CreateDbAndDelete {
	DataBaseUtility dbLib = new DataBaseUtility();
	
@Test
public void m1() throws Throwable {
	dbLib.getDbConnection();
	ResultSet set = dbLib.executeSelectQuery("select* from projects;");
	boolean flag =false;
	while(set.next()) {
		if(set.getString("project_name").equals("google")) {
			System.out.println("google is created");
			flag = true;
			break;
		}
	}
	if(flag==false)
		System.out.println("google not created");
	
}
}
