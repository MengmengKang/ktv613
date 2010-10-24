package com.xch.client;

public class SongList
{
	static int num;
	static String[] songName;
	static String[] songURL;
	
	public static void newList()
	{
		num=0;
		songName=new String[1111];
		songURL=new String[1111];
	}
	
	public static void addSong(String name,String URL)
	{
		songName[num]=name;
		songURL[num]=URL;
		num++;
	}
	
	public static String getSongURL()
	{
		if(num<=0)
			return "ERROR";
		else
		{
			String res=songURL[0];
			for(int i=1;i<num;i++)
			{
				songURL[i-1]=songURL[i];
				songName[i-1]=songName[i];
			}
			num--;
			return res;
		}
	}
	
	public static String[] getSongList()
	{
		String[] res=new String[num];
		for(int i=0;i<num;i++)
			res[i]=songName[i];
		return res;
	}
}