package com.xch.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class Player extends Thread{
	private static final String MPLAYER_PATH = "player/mplayer.exe";
	private String[] cmd;
	public static boolean isPlay;
	public Process proc;
	OutputStream os;
    BufferedWriter bw;
    
	public Player(final String path){
		//stop();
		//mediaPath=path;
		//isPlay=true;
		//button_Play.setText("Pause");
		
		cmd = new String[] {
				MPLAYER_PATH,
				path
		};
		try {
			proc = Runtime.getRuntime().exec(cmd);
			isPlay=true;
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		os=proc.getOutputStream();
		bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	
	public static void main(String[] args) {
		new Player("lib\\test4.mpg");
	}
	
	public void Pause() throws IOException
	{     
		bw.write("pause\n");
		bw.flush();
		isPlay=!isPlay;
	}
	
	public void Mute() throws IOException
	{
		bw.write("mute\n");
		bw.flush();
	}
	public void Vup() throws IOException
	{
		bw.write("volume 5\n");
		bw.flush();
	}
	public void Vdown() throws IOException
	{
		bw.write("volume -5\n");
		bw.flush();
	}
	public void RePlay() throws IOException
	{
		bw.write("seek 0 1\n");
		bw.flush();
	}
	public void Next() throws IOException
	{
		bw.write("seek 100 1\n\n");
		bw.flush();
	
	}
	public void Append(String name) throws IOException 
	{
		bw.write("loadfile " + name + " 1\n");
		bw.flush();
	}
	public void exit(){
		if(proc!=null){
			proc.destroy();
		}
		//saveConfig();
		System.exit(0);
	}
}
