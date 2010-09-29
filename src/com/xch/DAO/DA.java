package com.xch.DAO;

import java.sql.*;

import com.xch.obj.UserData;

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

public class DA {
	static String DB="ktv613";
	static String ID="root";
	static String PW="czx";
	static String CONNECT="jdbc:mysql://localhost:3306/"+DB+"?useUnicode=true&characterEncoding=utf8";
	
	static Connection aConnection;
	static Statement aStatement;
	
	public static void open()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			aConnection = DriverManager.getConnection(CONNECT,ID,PW);
			aStatement= aConnection.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public static void close()
	{
		try {
			aStatement.close();
			aConnection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
		
	public static int getUserMaxID()
	{
		int MaxID = 1;
		try {
			open();
			String sql="select * from users order by userid";
			ResultSet result=aStatement.executeQuery(sql);
			while(result.next()){
				if(result.getInt(1)!=MaxID) break;
				MaxID++;
			}
			close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return MaxID;
	}
	
	public static boolean checkUserName(String username)
	{
		boolean flag = false;
		try {
			open();
			String sql="select * from users";
			ResultSet result=aStatement.executeQuery(sql);
			while(result.next()){
				if(result.getString(2).compareTo(username)==0)
				{
					flag = true;
					break;
				}
			}
			close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return flag;
	
	}	
	public static int addUserData(UserData user)
	{
		int MaxID = 0;
		try {
			open();				
			String sql="insert users values("+user.getUserID()+",";
			sql=sql+"'"+user.getUserName()+"',";
			sql=sql+"'"+user.getPassWord()+"',";
			sql=sql+"'"+user.getRealName()+"',";
			sql=sql+"'"+user.getEmail()+"',";
			sql=sql+user.getGender()+",";
			sql=sql+"'"+user.getInterest()+"')";
			
			System.out.println(sql);
			
			aStatement.executeUpdate(sql);
			close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return MaxID;
	}
	
	
}

