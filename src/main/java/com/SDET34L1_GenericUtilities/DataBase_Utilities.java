package com.SDET34L1_GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

public class DataBase_Utilities {
	
	static Connection connection;
	static Statement statement;
	/**
	 *This method is used to connect to the Database
	 * @param DB_Url
	 * @param DB_Username
	 * @param DB_Password
	 * @throws SQLException 
	 */
	public static void openDBConnection(String DB_Url, String DB_Username, String DB_Password) throws SQLException
	{
		Driver driver = new Driver();				
		DriverManager.registerDriver(driver);
	    connection = DriverManager.getConnection(DB_Url,DB_Username,DB_Password);
	    statement  = connection.createStatement();
	}
	
	/**
	 * This method is used to fetch data from database/ to do the DQL actions on database
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> getDataFromDataBase(String query, String columnName) throws SQLException 
	{
		ArrayList<String> list = new ArrayList<>();
		ResultSet result = statement.executeQuery(query);
		while(result.next())
		{
			list.add(result.getString(columnName));
		}
		return list;
	}
	
	/**
	 * This method is used to validate the Data whether it is present or not
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public static boolean validateDatainDatabase(String query, String columnName,String expectedData) throws SQLException
	{
		ArrayList<String> list = getDataFromDataBase(query,columnName);
		boolean flag = false;
		for(String actualData:list)
		{
			if(actualData.equalsIgnoreCase(expectedData))
			{
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * This method is used to store/modify/insert/delete the data in database/to do the DML and DDL actions on database
	 * @param query
	 * @throws SQLException
	 */
	public static void setDataInDataBase(String query) throws SQLException
	{
		int result = statement.executeUpdate(query);
		if(result>=1)
		{
			System.out.println("Data entered/modified successfully");
		}
	}
	
	/**
	 * This method is used to close the Database connection
	 */
	public static void closeDBConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("while closing the database connection we got the exception");
		}
	}	
}