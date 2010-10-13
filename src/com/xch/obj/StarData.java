package com.xch.obj;

public class StarData {
	private int StarID;
	private String StarName;
	private int Gender;   //0ÎªÅ®£¬1ÎªÄÐ
	private String StConFrom;
	private String StTeam;
	
	public void getStarID(int indata)
	{
		this.StarID=indata;
	}
	public void getStarName(String indata)
	{
		this.StarName=indata;
	}
	public void getGender(int indata)
	{
		this.Gender=indata;
	}
	public void getStConFrom(String indata)
	{
		this.StConFrom=indata;
	}
	public void getStTeam(String indata)
	{
		this.StTeam=indata;
	}
	
	public int setStarID()
	{
		return this.StarID;
	}
	public String setStarName()
	{
		return this.StarName;
	}
	public int setGender()
	{
		return this.Gender;
	}
	public String setStConFrom()
	{
		return this.StConFrom;
	}
	public String setStTeam()
	{
		return this.StTeam;
	}

}
