package cheng.xch.obj;

public class user {
	private int UserID;
	private String UserName;
	private String Password;
	private String RealName;
	private String Email;
	private int Gender;
	private String Interest;
	//DateFormat Birthday;
	void setUserID(int indata)
	{
		UserID=indata;
	}
	void setUserName(String indata)
	{
		UserName=indata;
	}
	
	void setPassword(String indata)
	{
		Password=indata;
	}
	void setRealName(String indata)
	{
		RealName=indata;
	}
	void setEmail(String indata)
	{
		Email=indata;
	}
	void setGender(int indata)
	{
		Gender=indata;
	}
	void setInterest(String indata)
	{
		Interest=indata;
	}
	
	int getUserID()
	{
		return UserID;
	}
	
	String getUserName()
	{
		return UserName;
	}
	
	String getPassword()
	{
		return Password;
	}
	String getRealName()
	{
		return RealName;
	}
	String getEmail()
	{
		return Email;
	}
	int getGender()
	{
		return Gender;
	}
	String getInterest()
	{
		return Interest;
	}
}
