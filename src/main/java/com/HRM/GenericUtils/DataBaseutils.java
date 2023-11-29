package com.HRM.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseutils 
{
	
	Connection con=null;
	
	public void connectDB() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DB_Username, IpathConstants.DB_Password);
	}
	
	public String executeAndGetdata(int colData, String expData, String query ) throws Throwable
	{
		Statement state = con.createStatement();
		//String query = "select * from student_info;";
		ResultSet result =  state.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String actual = result.getString(colData);
			if(actual.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println("Project Created Successfully");
			return expData;
		}
		else
		{
			System.out.println("Project is not created");
			return "";
		}
	}
	
	public void disConnectDB() throws Throwable
	{
		con.close();
	}
	
	
}
