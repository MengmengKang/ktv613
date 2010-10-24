package com.xch.client;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Bottom extends JFrame implements ActionListener{
		
	private JButton suspend;
	private JButton volumePlus;
	private JButton volumeMinus;
	private JButton changeSong;
	private JButton stop;
	private JButton playAgain;
	private JButton quit;
	private JButton accompany;
	//private JButton original;	
	private int volume;
	//static private int num=0;
	
	public Bottom(){
		/*
		num++;
		System.out.println(num);
		if(num>1) 
		{
			num=1;
			dispose();
			return;
		}
		*/
		//System.out.println("num<=1");
		//this.setBounds(0, 765, 1280, 35);
    	this.setLayout(new GridLayout(1,11));
    	//original = new JButton("ԭ��");
    	accompany = new JButton("�鳪");
    	suspend = new JButton("��ͣ");
    	//ImageIcon img = new ImageIcon("img/volumePlus.jpg");
    	volumePlus = new JButton("����+");
    	
    	//volumePlus.setIcon(getImage("img\\volumePlus"));
    	volumeMinus = new JButton("����-");
    	changeSong = new JButton("�и�");
    	playAgain = new JButton("�ز�");
    	stop = new JButton("ֹͣ");
    	quit = new JButton("�˳�");
    	//returnHome = new JButton("����");
    	//indexPage = new JButton("��ҳ");
    	
    	volume = 100;
       	this.add(accompany);
    	this.add(suspend);
    	this.add(volumePlus);
    	this.add(volumeMinus);
    	this.add(changeSong);
    	this.add(playAgain);
    	this.add(stop);
    	this.add(quit);
    	//this.add(returnHome);
    	//this.add(indexPage);
    	
    	accompany.addActionListener(this);
    	suspend.addActionListener(this);
    	quit.addActionListener(this);
    	playAgain.addActionListener(this);
    	volumePlus.addActionListener(this);
    	volumeMinus.addActionListener(this);
    	changeSong.addActionListener(this);
    	stop.addActionListener(this);
    	quit.addActionListener(this);
     	
    	this.setUndecorated(true);
    	this.setLocation(300, 500);
    	this.setSize(770, 35);
    	this.setVisible(true);
    	this.setAlwaysOnTop(true);
	}



	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==quit){
			//num--;
			Player.exit();
			this.dispose();
		}
		if(e.getSource()==suspend){
			if(suspend.getText()=="����"){
				Player.pause();
				suspend.setText("��ͣ");
			}
			else{
				Player.pause();
				suspend.setText("����");
			}
		}
		if(e.getSource()==volumeMinus){
			if(volume>=5){
			volume = volume-5;
			Player.setVolume(volume);
			}
		}
		if(e.getSource()==volumePlus){
			if(volume<=95){
				volume = volume+5;
				Player.setVolume(volume);
			}
		}
		if(e.getSource()==playAgain)
		{
			Player.setTime(0);
		}
		if(e.getSource()==accompany)
		{
			if(accompany.getText()=="�鳪"){
				Player.setAccompany();
				accompany.setText("ԭ��");
			}
			else{
				Player.setOriginal();
				accompany.setText("�鳪");
			}
		}
		if(e.getSource()==stop){
			Player.stop();
		}
		if(e.getSource()==changeSong){
			String res=Player.nextSong();
			if(res.compareTo("ERROR")!=0)
				Player.play(res);
		}
	}
}
