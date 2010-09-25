package com.xch.db;

import java.sql.*;
import java.util.Scanner;

import com.xch.obj.UserData;

public class dbConnect {
	public static String DB="ktv613";
	public static String ID="root";
	public static String PW="";
	
	public static int getUserMaxID()
	{
		Scanner aS=new Scanner(System.in);
		Connection aConnection;
		Statement aStatement;
		System.out.println("test 0");
		int MaxID = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			aConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB+"?useUnicode=true&characterEncoding=utf8",ID,PW);
			
			aStatement= aConnection.createStatement();
			/*
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
			*/
			System.out.println("test 1");
			String sql="select * from users";
			ResultSet result=aStatement.executeQuery(sql);
			while(result.next()){
				System.out.println("test 2");
				if(result.getInt(1)>MaxID)
					MaxID=result.getInt(1);
				//System.out.println(result.getInt(1)+"	"+result.getString(2));		
			}
			
			aStatement.close();
			aConnection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return MaxID;
	

	}
	
	public static boolean checkUserName(String username)
	{
		Scanner aS=new Scanner(System.in);
		Connection aConnection;
		Statement aStatement;
		System.out.println("test 0");
		boolean flag = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			aConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB+"?useUnicode=true&characterEncoding=utf8",ID,PW);
			
			aStatement= aConnection.createStatement();
	
			System.out.println("test 1");
			String sql="select * from users";
			ResultSet result=aStatement.executeQuery(sql);
			while(result.next()){
				System.out.println("test 2");
				if(result.getString(2).compareTo(username)==0)
				{
					flag = true;
					break;
				}
				//System.out.println(result.getInt(1)+"	"+result.getString(2));		
			}
			
			aStatement.close();
			aConnection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return flag;
	

	}
	public static int addUserData(UserData user)
	{
		Scanner aS=new Scanner(System.in);
		Connection aConnection;
		Statement aStatement;
		System.out.println("test 0");
		int MaxID = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			aConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB+"?useUnicode=true&characterEncoding=utf8",ID,PW);
			
			aStatement= aConnection.createStatement();
				
			String sql = "insert users values("+user.getUserID()+",";
			sql=sql+"'"+user.getUserName()+"',";
			sql=sql+"'"+user.getPassword()+"',";
			sql=sql+"'"+user.getRealName()+"',";
			sql=sql+"'"+user.getEmail()+"',";
			sql=sql+user.getGender()+",";
			sql=sql+"'"+user.getInterest()+"')";
			
			System.out.println(sql);
			aStatement.executeUpdate(sql);
			
			aStatement.close();
			aConnection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return MaxID;
	

	}
}


