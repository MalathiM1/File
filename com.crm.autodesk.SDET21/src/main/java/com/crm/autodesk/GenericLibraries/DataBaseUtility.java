package com.crm.autodesk.GenericLibraries;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/* this class contains generic methods to read database
 * @author malathi
 */

public class DataBaseUtility {
	Connection con=null;
	ResultSet result = null;
	Driver driverRef;
	/* Connection with database is established
	 * throws throwable
	 * 
	 * 
	 */
	
	public void connectToDB() throws Throwable
	{
		
		
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet","root","root");
		
		
		
	}
	/*
	 * DB connection is closed
	 * @throw throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	/* 
	 * This method returns the data wrt to column index
	 * @parameter query
	 * @param Columnindex
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromDB(String query, int columnindex) throws Throwable
	{
		String value = null;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			value = result.getString(columnindex);
			
		}
		return value;
	}
	/*
	 * get data from DB and verify
	 * @parameter query
	 * @param Columnindex
	 * @return
	 * @throws SQLException 
	 */
	public String getDataFromDB(String query, int columnName, String expData) throws Throwable
	{
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnName).equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData+"data verified in database");
			return expData;
		}
		else
		{
			System.out.println(expData+"data not verified");
			return expData;
		}
	
	}
	

}
