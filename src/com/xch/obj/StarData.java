package com.xch.obj;

public class StarData
{
    private int StarID;

    private String StarName;

    private int Gender; // 0ÎªÅ®£¬1ÎªÄÐ

    private String ComeFrom;

    private String Team;

    public void setStarID(final int indata)
    {
        StarID = indata;
    }

    public void setStarName(final String indata)
    {
        StarName = indata;
    }

    public void setGender(final int indata)
    {
        Gender = indata;
    }

    public void setComeFrom(final String indata)
    {
        ComeFrom = indata;
    }

    public void setTeam(final String indata)
    {
        Team = indata;
    }

    public int getStarID()
    {
        return StarID;
    }

    public String getStarName()
    {
        return StarName;
    }

    public int getGender()
    {
        return Gender;
    }

    public String getComeFrom()
    {
        return ComeFrom;
    }

    public String getTeam()
    {
        return Team;
    }

}
