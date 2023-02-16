package com.bridgelabz.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/customer_service", "root",
					"Shiva@12");
			if(con != null) {
			System.out.println("Connection established successfully......");
		    } 
			Statement stmt = con.createStatement();
			stmt.execute("insert into customers (customer_id,customer_name,mobile_number) values(1,'Preeti', 9876569812);");
			stmt.execute("insert into customers (customer_id,customer_name,mobile_number) values(2,'Shruti', 8667890972);");
			
			ResultSet result = stmt.executeQuery("select * from customers where customer_id = 2 ;");
			
			while(result.next()) {
				System.out.println("customer_id: "+ result.getInt(1));
				System.out.println("customer_name: "+ result.getString(2));
				System.out.println("mobile_number: "+result.getBigDecimal(3));
			}
		}
		
	    catch (Exception e) {	
			System.out.println("Unable connect! \nRe-try in sometime.... ");
			e.printStackTrace();
		}	
	}
}
