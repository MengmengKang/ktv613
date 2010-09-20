package com.xch.db;

import java.sql.*;
import java.util.Scanner;

import com.xch.obj.User;

public class dbConnect {
	public static void addUser(User user)
	{
		Scanner aS=new Scanner(System.in);
		Connection aConnection;
		Statement aStatement;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			aConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ktv613?useUnicode=true&characterEncoding=utf8","root","czx");  
			aStatement= aConnection.createStatement();
			String sql="drop table if exists admins";
			aStatement.executeUpdate(sql);
			sql="create table admins(Admin varchar(50),Password varchar(50))";
			aStatement.executeUpdate(sql);
		
			System.out.println("Please Input User ID:");
			sql="insert admins values('"+aS.next();
			System.out.println("Please Input User Password:");
			sql=sql+"','"+aS.next()+"')";
			aStatement.executeUpdate(sql);
			
			sql="select * from admins";
			ResultSet result=aStatement.executeQuery(sql);
			System.out.println("ID	Password");
			while(result.next()){
				System.out.println(result.getString(1)+"	"+result.getString(2));		
			}
			aStatement.close();
			aConnection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	

	}
}


