package com.xch.obj;

public class UserData {
	private int UserID;
	private String UserName;
	private String Password;
	private String RealName;
	private String Email;
	private int Gender;    //0Ϊ�У�1ΪŮ
	private String Interest;

	public void setUserID(int indata)
	{
		UserID=indata;
	}
	public void setUserName(String indata)
	{
		UserName=indata;
	}
	
	public void setPassword(String indata)
	{
		Password=indata;
	}
	public void setRealName(String indata)
	{
		RealName=indata;
	}
	public void setEmail(String indata)
	{
		Email=indata;
	}
	public void setGender(int indata)
	{
		Gender=indata;
	}
	public void setInterest(String indata)
	{
		Interest=indata;
	}
	
	public int getUserID()
	{
		return UserID;
	}
	
	public String getUserName()
	{
		return UserName;
	}
	
	public String getPassword()
	{
		return Password;
	}
	public String getRealName()
	{
		return RealName;
	}
	public String getEmail()
	{
		return Email;
	}
	public int getGender()
	{
		return Gender;
	}
	public String getInterest()
	{
		return Interest;
	}
}
