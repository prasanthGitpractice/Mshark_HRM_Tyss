package com.Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest 
{

	public static void main(String[] args) throws Throwable 
	{
		Connection con=null;
		int result=0;
		int result2=0;

		try
		{
			// register Driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);

			// get connection for Database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52p", "root", "root");

			// Create statement
			Statement state = con.createStatement();
			String query = "insert into student_info values('amma','nanna',65),('Nanna','Amma',65);";
			String query2 = "delete from student_info where Sname='Nanna';";

			// Execute Update Query
			result = state.executeUpdate(query);
			result2 = state.executeUpdate(query2);
			
			if(result==2 && result2==1)
			{
				System.out.println("Data inserted Successfully");
			}
			
			else
			{
				System.err.println("data is not updated");
			}
		}
		catch(Exception e)
		{

		}
		finally
		{
			// Close database
			con.close();
		}


	}

}
