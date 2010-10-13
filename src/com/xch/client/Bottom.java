package com.xch.client;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bottom extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton original;
	private JButton suspend;
	private JButton volumePlus;
	private JButton volumeMinus;
	private JButton changeSong;
	private JButton stop;
	private JButton playAgain;
	private JButton returnHome;
	private JButton indexPage;
	private JButton quit;
	private int volume;

	public Bottom(){
		//this.setBounds(0, 765, 1280, 35);
    	this.setLayout(new GridLayout(1,10));
    	original = new JButton("Ô­³ª");
    	suspend = new JButton("ÔÝÍ£");
    	volumePlus = new JButton("ÒôÁ¿+");
    	volumeMinus = new JButton("ÒôÁ¿-");
    	changeSong = new JButton("ÇÐ¸è");
    	stop = new JButton("Í£Ö¹");
    	playAgain = new JButton("ÖØ²¥");
    	returnHome = new JButton("·µ»Ø");
    	indexPage = new JButton("Ö÷Ò³");
    	quit = new JButton("ÍË³ö");
    	volume = 100;
    	this.add(original);
    	this.add(suspend);
    	this.add(volumePlus);
    	this.add(volumeMinus);
    	this.add(changeSong);
    	this.add(stop);
    	this.add(playAgain);
    	this.add(returnHome);
    	this.add(indexPage);
    	this.add(quit);
    	suspend.addActionListener(this);
    	quit.addActionListener(this);
    	returnHome.addActionListener(this);
    	volumePlus.addActionListener(this);
    	volumeMinus.addActionListener(this);
    	stop.addActionListener(this);
    	quit.addActionListener(this);
    	
    	this.setUndecorated(true);
    	this.setLocation(300, 500);
    	this.setSize(765, 35);
    	this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==quit){
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
		/*
		if(e.getSource()==returnHome){
			if(SongPinyin.frame!=null)
            SongPinyin.frame.dispose();
		}
		*/
		if(e.getSource()==stop){
			Player.stop();
		}
	}
	/*
	public static void main(String[] args)
	{
		new Bottom();
		Player.video();
		Player.play("lib\\test4.mpg");
	}
	*/
}
