package com.xch.login;

import com.xch.login.MD5;

public class testMD5 {
		
	public static void main(String[] args)
	{
		MD5 tm = new MD5("hello");
		System.out.println(tm.get());
	}
}
