package com.xch.obj;

public class SongData {
	private int SongID;
	private String SongName;
	private String SongType;
	private int SoNumber;
	private String SoPinYin;
	private int StarID;
	
	public void setSongID(int indata)
	{
		this.SongID=indata;
	}
	public void setSongName(String indata)
	{
		this.SongName=indata;
	}
	public void setSongType(String indata)
	{
		this.SongType=indata;
	}
	public void setSoNumber(int indata)
	{
		this.SoNumber=indata;
	}
	public void setSoPinYin(String indata)
	{
		this.SoPinYin=indata;
	}
	public void setStarID(int indata)
	{
		this.StarID=indata;
	}
	
	public int getSongID()
	{
		return this.SongID;
	}
	public String getSongName()
	{
		return this.SongName;
	}
	public String getSongType()
	{
		return this.SongType;
	}
	public int getSoNumber()
	{
		return this.SoNumber;
	}
	public String getSoPinYin()
	{
		return this.SoPinYin;
	}
	public int getStarID()
	{
		return this.StarID;
	}

}
