package com.xch.client;
import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URLClassLoader;
import javax.swing.DefaultComboBoxModel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Bottom extends JFrame implements ActionListener{
		
	private JButton suspend;
	private JButton volumePlus;
	private JButton volumeMinus;
	private JScrollPane jScrollPane1;
	private JLabel jLabel1;
	private static JList jSongList;
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
    	//this.setLayout(new GridLayout(1,11));
		this.setLayout(new FlowLayout());
		{
			jLabel1 = new JLabel();
			getContentPane().add(jLabel1);
			jLabel1.setText("\u5f53\u524d\u64ad\u653e\u5217\u8868\uff1a");
		}
		{
			{
				jSongList = new JList();
				//jSongList.setVisibleRowCount(7);
				jSongList.setAutoscrolls(true);
				//jScrollPane1.setViewportView(jSongList);
				refreshSongList();
				//jSongList.setPreferredSize(new java.awt.Dimension(187, 132));
			}
			jScrollPane1 = new JScrollPane(jSongList);
			//getContentPane().add(jScrollPane1);
			jScrollPane1.setPreferredSize(new java.awt.Dimension(187, 132));
		}
    	accompany = new JButton("°é³ª");
    	suspend = new JButton("ÔÝÍ£");
    	BorderLayout suspendLayout = new BorderLayout();
    	suspend.setLayout(suspendLayout);
    	//ImageIcon img = new ImageIcon("img/volumePlus.jpg");
    	volumePlus = new JButton("ÒôÁ¿+");
    	
    	//volumePlus.setIcon(getImage("img\\volumePlus"));
    	volumeMinus = new JButton("ÒôÁ¿-");
    	changeSong = new JButton("ÇÐ¸è");
    	playAgain = new JButton("ÖØ²¥");
    	stop = new JButton("Í£Ö¹");
    	quit = new JButton("ÍË³ö");
    	//returnHome = new JButton("·µ»Ø");
    	//indexPage = new JButton("Ö÷Ò³");
    	
    	volume = 100;
    	this.add(jScrollPane1);
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
    	this.setLocation(900, 480);
    	this.setSize(240, 240);
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
			if(suspend.getText()=="²¥·Å"){
				Player.pause();
				suspend.setText("ÔÝÍ£");
			}
			else{
				Player.pause();
				suspend.setText("²¥·Å");
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
			if(accompany.getText()=="°é³ª"){
				Player.setAccompany();
				accompany.setText("Ô­³ª");
			}
			else{
				Player.setOriginal();
				accompany.setText("°é³ª");
			}
		}
		if(e.getSource()==stop){
			Player.stop();
		}
		if(e.getSource()==changeSong){
			String res=Player.nextSong();
			if(res.compareTo("ERROR")!=0)
			{
				refreshSongList();
				Player.play(res);
			}
		}
	}
	
	public static void refreshSongList()
	{
		String[] res=SongList.getSongList();
		ListModel jSongListModel = 
			new DefaultComboBoxModel(res);
		jSongList.setModel(jSongListModel);
	}
}
