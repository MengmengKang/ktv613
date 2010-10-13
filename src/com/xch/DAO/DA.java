package com.xch.DAO;

import java.sql.*;

import com.xch.obj.AdminData;
import com.xch.obj.SongData;
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
			String sql="select userid from users order by userid";
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
	
	public static int getSongMaxID()
	{
		int MaxID = 1;
		try {
			open();
			String sql="select songid from songs order by songid";
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
	
	public static int getStarMaxID()
	{
		int MaxID = 1;
		try {
			open();
			String sql="select starid from stars order by starid";
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
			String sql="select username from users";
			ResultSet result=aStatement.executeQuery(sql);
			while(result.next()){
				if(result.getString(1).compareTo(username)==0)
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
	
	public static boolean loginUser(UserData user)
	{
		boolean flag = false;
		try {
			open();
			String sql="select username,password from users";
			ResultSet result=aStatement.executeQuery(sql);
			while(result.next()){
				//System.out.println("s "+result.getString(1)+" "+result.getString(2));
				//System.out.println("t "+user.getUserName()+" "+user.getPassWord());
				if(result.getString(1).compareTo(user.getUserName())==0&&
					result.getString(2).compareTo(user.getPassWord())==0)
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
	public static void addUserData(UserData user)
	{
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
	}
	public static void modifyUserData(UserData user)
	{
		try {
			open();				
			String sql="update users set ";
			sql=sql+"username='"+user.getUserName()+"',";
			sql=sql+"password='"+user.getPassWord()+"',";
			sql=sql+"realname='"+user.getRealName()+"',";
			sql=sql+"email='"+user.getEmail()+"',";
			sql=sql+"gender="+user.getGender()+",";
			sql=sql+"interest='"+user.getInterest()+"' ";
			sql=sql+"where userid="+user.getUserID();
			
			System.out.println(sql);
			
			aStatement.executeUpdate(sql);
			close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}	
	public static boolean checkAdmin(String admin)
	{
		boolean flag = false;
		try {
			open();
			String sql="select admin from admins";
			ResultSet result=aStatement.executeQuery(sql);
			while(result.next()){
				if(result.getString(1).compareTo(admin)==0)
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
	public static boolean loginAdmin(AdminData admin)
	{
		boolean flag = false;
		try {
			open();
			String sql="select * from admins";
			ResultSet result=aStatement.executeQuery(sql);
			while(result.next()){
				//System.out.println("s "+result.getString(1)+" "+result.getString(2));
				//System.out.println("t "+admin.getAdmin()+" "+admin.getPassWord());
				if(result.getString(1).compareTo(admin.getAdmin())==0&&
					result.getString(2).compareTo(admin.getPassWord())==0)
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
	public static void addAdminData(AdminData admin)
	{
		try {
			open();				
			String sql="insert admins values('"+admin.getAdmin()+"',";
			sql=sql+"'"+admin.getPassWord()+"')";
			
			System.out.println(sql);
			
			aStatement.executeUpdate(sql);
			close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public static String[][] orderByPinyin(String indata,int n)
	{
		String[][] res={};
		
		try{
			open();
			
			String sql="select * from songs,stars where (SoPinYin like '"+indata+
					"' OR SoPinYin like '%"+indata+
					"' OR SoPinYin like '"+indata+
					"%' OR SoPinYin like '%"+indata+
					"%') AND songs.StarID=stars.StarID";
			ResultSet result=aStatement.executeQuery(sql);
			result.last();    
			int row=result.getRow();
			result.beforeFirst();
			res=new String[row][n];
			int i=-1;
			while(result.next()){
				i++;
				String[] resLine =new String[n];
				//System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
				resLine[0]=result.getString(1);
				resLine[1]=result.getString(5);
				resLine[2]=result.getString(2);
				resLine[3]=result.getString(3);
				resLine[4]=result.getString(9);
				res[i]=resLine;		
			}
			
			close();
		} catch (Exception e) {
			System.out.println();
		}
		return res;		
	}
	public static String[][] orderBySongName(String indata,int n)
	{
		String[][] res={};
		
		try{
			open();
			
			String sql="select * from songs,stars where (SongName like '"+indata+
					"' OR SongName like '%"+indata+
					"' OR SongName like '"+indata+
					"%' OR SongName like '%"+indata+
					"%') AND songs.StarID=stars.StarID";
			ResultSet result=aStatement.executeQuery(sql);
			result.last();    
			int row=result.getRow();
			result.beforeFirst();
			res=new String[row][n];
			int i=-1;
			while(result.next()){
				i++;
				String[] resLine =new String[n];
				//System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
				resLine[0]=result.getString(1);
				resLine[1]=result.getString(5);
				resLine[2]=result.getString(2);
				resLine[3]=result.getString(3);
				resLine[4]=result.getString(9);
				res[i]=resLine;		
			}
			
			close();
		} catch (Exception e) {
			System.out.println();
		}
		return res;		
	}
	
	
	public static String[][] orderBySongNumber(int indata,int n)
	{
		String[][] res={};
		
		try{
			open();
			
			String sql="select * from songs,stars where SoNumber="+indata+
					" AND songs.StarID=stars.StarID";
			ResultSet result=aStatement.executeQuery(sql);
			result.last();    
			int row=result.getRow();
			result.beforeFirst();
			res=new String[row][n];
			int i=-1;
			while(result.next()){
				i++;
				String[] resLine =new String[n];
				//System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
				resLine[0]=result.getString(1);
				resLine[1]=result.getString(5);
				resLine[2]=result.getString(2);
				resLine[3]=result.getString(3);
				resLine[4]=result.getString(9);
				res[i]=resLine;		
			}
			
			close();
		} catch (Exception e) {
			System.out.println();
		}
		return res;		
	}
	public static String[][] orderByStar(String indata,int n)
	{
		String[][] res={};
		
		try{
			open();
			
			String sql="select * from songs,stars where (StarName like '"+indata+
					"' OR StarName like '%"+indata+
					"' OR StarName like '"+indata+
					"%' OR StarName like '%"+indata+
					"%') AND songs.StarID=stars.StarID";
			ResultSet result=aStatement.executeQuery(sql);
			result.last();    
			int row=result.getRow();
			result.beforeFirst();
			res=new String[row][n];
			int i=-1;
			while(result.next()){
				i++;
				String[] resLine =new String[n];
				//System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
				resLine[0]=result.getString(1);
				resLine[1]=result.getString(5);
				resLine[2]=result.getString(2);
				resLine[3]=result.getString(3);
				resLine[4]=result.getString(9);
				res[i]=resLine;		
			}
			
			close();
		} catch (Exception e) {
			System.out.println();
		}
		return res;		
	}	
	
	public static String getSongURL(int indata)
	{
		String res = null;
		
		try{
			open();
			
			String sql="select URL from songs where SongID="+indata;
			ResultSet result=aStatement.executeQuery(sql);
			result.next();
			res=result.getString(1);
			
			close();
		} catch (Exception e) {
			System.out.println();
		}
		return res;		
	}	
	
	public static void addSongData(SongData song)
	{
		try {
			open();				
			String sql="insert songs values("+song.getSongID()+",";
			sql=sql+"'"+song.getSongName()+"',";
			sql=sql+"'"+song.getSongType()+"',";
			sql=sql+song.getSoNumber()+",";
			sql=sql+"'"+song.getSoPinYin()+"',";
			sql=sql+song.getStarID()+",";
			sql=sql+"'"+song.getURL()+"')";
			
			System.out.println(sql);
			
			aStatement.executeUpdate(sql);
			close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public static void modifySongData(SongData song)
	{
		try {
			open();				
			String sql="update users set ";
			sql=sql+"songname='"+song.getSongName()+"',";
			sql=sql+"songtype='"+song.getSongType()+"',";
			sql=sql+"sonumber="+song.getSoNumber()+",";
			sql=sql+"sopinyin='"+song.getSoPinYin()+"',";
			sql=sql+"starid="+song.getStarID()+",";
			sql=sql+"url='"+song.getURL()+"' ";
			sql=sql+"where songid="+song.getSongID();
			
			System.out.println(sql);
			
			aStatement.executeUpdate(sql);
			close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}	
	public static void delSongData(SongData song)
	{
		try {
			open();				
			String sql="delete from admins where songid="+song.getSongID();
			
			System.out.println(sql);
			
			aStatement.executeUpdate(sql);
			close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	

	public static String[][] listAdmin()
	{
		String[][] res={};
		int n=1;
		try{
			open();
			
			String sql="select * from admins";
			ResultSet result=aStatement.executeQuery(sql);
			result.last();    
			int row=result.getRow();
			result.beforeFirst();
			res=new String[row][n];
			int i=-1;
			while(result.next()){
				i++;
				String[] resLine =new String[n];
				//System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
				resLine[0]=result.getString(1);
				res[i]=resLine;		
			}
			
			close();
		} catch (Exception e) {
			System.out.println();
		}
		return res;		
	}
	
	public static AdminData getAdmin(String admin)
	{
		AdminData res=new AdminData();
		try{
			open();
			
			String sql="select * from admins where admin='"+admin+"'";
			//System.out.println(sql);
			ResultSet result=aStatement.executeQuery(sql);
			result.next();
			res.setAdmin(result.getString(1));
			res.setPassWord(result.getString(2));

			close();
		} catch (Exception e) {
			System.out.println();
		}
		return res;		
	}
	
	public static void modifyAdmin(AdminData Admin)
	{
		try {
			open();				
			String sql="update admins set ";
			sql=sql+"Admin='"+Admin.getAdmin()+"',";
			sql=sql+"PassWord='"+Admin.getPassWord()+"'";
			
			//System.out.println(sql);
			
			aStatement.executeUpdate(sql);
			close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}	
	
	public static void delAdmin(String Admin)
	{
		try {
			open();				
			String sql="delete from admins where admin='"+Admin+"'";
			
			//System.out.println(sql);
			
			aStatement.executeUpdate(sql);
			close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}	
}


