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
		this.UserID=indata;
	}
	public void setUserName(String indata)
	{
		this.UserName=indata;
	}
	
	public void setPassword(String indata)
	{
		this.Password=indata;
	}
	public void setRealName(String indata)
	{
		this.RealName=indata;
	}
	public void setEmail(String indata)
	{
		this.Email=indata;
	}
	public void setGender(int indata)
	{
		this.Gender=indata;
	}
	public void setInterest(String indata)
	{
		this.Interest=indata;
	}
	
	public int getUserID()
	{
		return this.UserID;
	}
	
	public String getUserName()
	{
		return this.UserName;
	}
	
	public String getPassword()
	{
		return this.Password;
	}
	public String getRealName()
	{
		return this.RealName;
	}
	public String getEmail()
	{
		return this.Email;
	}
	public int getGender()
	{
		return this.Gender;
	}
	public String getInterest()
	{
		return this.Interest;
	}
}
