package com.Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class JDBC_Prakash
{

	public static void main(String[] args) throws SQLException 
	{
		Scanner scanner=new Scanner(System.in) ;

		try {

			System.out.println("enter Employee Name ");
			String name= scanner.nextLine();

			Random random=new Random();
			int age=  random.nextInt(99);
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Prakash", "root", "root");



			Statement state=con.createStatement();
			String query=   "select * from employee ;";

			ResultSet res=state.executeQuery(query);


			boolean flag=false;

			while(res.next()) {
				String tname=res.getString(1);
				//   System.out.println(tname);
				if (tname.equalsIgnoreCase(name)) {
					System.err.println("name already present into database ");
					flag=true;
					break;
				}
			}   


			if (flag==false) {
				Statement state2=con.createStatement();
				String query2=  "insert into employee values('"+name+"',"+age+");";

				int res2=  state2.executeUpdate(query2);
				if (res2>=1) {
					System.out.println("data inserted successfully ");
				}
			}    

		} catch (Exception e) {
			// TODO: handle exception
		}
		scanner.close();
	}
}
