package com.xch.obj;

public class SongData
{
    private int SongID;

    private String SongName;

    private String SongType;

    private int SoNumber;

    private String SoPinYin;

    private int StarID;

    private String StarName;

    private String url;

    public void setSongID(final int indata)
    {
        SongID = indata;
    }

    public void setSongName(final String indata)
    {
        SongName = indata;
    }

    public void setSongType(final String indata)
    {
        SongType = indata;
    }

    public void setSoNumber(final int indata)
    {
        SoNumber = indata;
    }

    public void setSoPinYin(final String indata)
    {
        SoPinYin = indata;
    }

    public void setStarID(final int indata)
    {
        StarID = indata;
    }

    public void setStarName(final String indata)
    {
        StarName = indata;
    }

    public void setURL(final String indata)
    {
        url = indata;
    }

    public int getSongID()
    {
        return SongID;
    }

    public String getSongName()
    {
        return SongName;
    }

    public String getSongType()
    {
        return SongType;
    }

    public int getSoNumber()
    {
        return SoNumber;
    }

    public String getSoPinYin()
    {
        return SoPinYin;
    }

    public int getStarID()
    {
        return StarID;
    }

    public String getStarName()
    {
        return StarName;
    }

    public String getURL()
    {
        return url;
    }
}
