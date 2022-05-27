package com.vtiger.practiceTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseConnectionTest 

{
	public static void main(String[] args) throws SQLException
	{
		//Step 1 : Create object for implementation class
		
		Driver driver = new Driver();
		
		//Step 2 : Register Driver with JDBC
		DriverManager.registerDriver(driver);
		
		//Establish the connection or set the connection		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		//Step 4 : Create Statement 		
		Statement statement = connection.createStatement();
		
		//Step 5: Execute Query 
		ResultSet result = statement.executeQuery("select * from sdet33;");
		
		//Step 6: Validate
		while(result.next())
		{
			System.out.println(result.getString(2)+" "+result.getString("address"));
		}
		
		//Step 7: close the connection
		connection.close();		
		
	}
}
