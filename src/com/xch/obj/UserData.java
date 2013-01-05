package com.xch.obj;

public class UserData
{
    private int UserID;

    private String UserName;

    private String PassWord;

    private String RealName;

    private String Email;

    private int Gender; // 0Ϊ�У�1ΪŮ

    private String Interest;

    public void setUserID(final int indata)
    {
        UserID = indata;
    }

    public void setUserName(final String indata)
    {
        UserName = indata;
    }

    public void setPassWord(final String indata)
    {
        PassWord = indata;
    }

    public void setRealName(final String indata)
    {
        RealName = indata;
    }

    public void setEmail(final String indata)
    {
        Email = indata;
    }

    public void setGender(final int indata)
    {
        Gender = indata;
    }

    public void setInterest(final String indata)
    {
        Interest = indata;
    }

    public int getUserID()
    {
        return UserID;
    }

    public String getUserName()
    {
        return UserName;
    }

    public String getPassWord()
    {
        return PassWord;
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
