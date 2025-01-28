package com.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;


public class CreateDataBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Rohithkumar@1111");
			Statement stmt=con.createStatement();
			String sq1="CREATE DATABASE WIPROTRAINING";
			stmt.executeUpdate(sq1);
			System.out.println("Database created successfully...");
		} catch(Exception e) {
			
		}

	}

}
