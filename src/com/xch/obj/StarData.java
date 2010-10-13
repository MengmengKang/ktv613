package com.xch.obj;

public class StarData {
	private int StarID;
	private String StarName;
	private int Gender;   //0ÎªÅ®£¬1ÎªÄÐ
	private String ComeFrom;
	private String Team;
	
	public void setStarID(int indata)
	{
		this.StarID=indata;
	}
	public void setStarName(String indata)
	{
		this.StarName=indata;
	}
	public void setGender(int indata)
	{
		this.Gender=indata;
	}
	public void setComeFrom(String indata)
	{
		this.ComeFrom=indata;
	}
	public void setTeam(String indata)
	{
		this.Team=indata;
	}
	
	public int getStarID()
	{
		return this.StarID;
	}
	public String getStarName()
	{
		return this.StarName;
	}
	public int getGender()
	{
		return this.Gender;
	}
	public String getComeFrom()
	{
		return this.ComeFrom;
	}
	public String getTeam()
	{
		return this.Team;
	}

}
