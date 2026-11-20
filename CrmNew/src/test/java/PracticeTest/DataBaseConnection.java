package PracticeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseConnection {
	
	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery("select * from project");
		while(result.next()) {
			System.out.println("id :"+result.getString(1));
			System.out.println("created By :"+result.getString(2));
		}
		
		conn.close();
	}

}