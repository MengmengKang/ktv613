package com.xch.client;

import java.awt.event.MouseEvent;

import javax.swing.JProgressBar;

public class PlayerProgressBar extends JProgressBar{
	private static final long serialVersionUID = -972301782528385389L;
	int maxNum=9000;
	PlayerProgressBar progressBar;
	int x1=0;
	int x2=0;
	Player player;
	PlayerProgressBar(final Player player){
		super();
		this.player=player;
		progressBar=this;
		setMaximum(maxNum);
		addMouseListener(new java.awt.event.MouseListener() {

			public void mouseClicked(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseExited(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {

			}

			@SuppressWarnings("static-access")
			public void mouseReleased(MouseEvent e) {
				double sel = ((double) e.getX()/ ((double) progressBar.getWidth()) * progressBar.getMaximum());
				System.out.println("seek to "+sel+" isPlay="+player.isPlay);
				progressBar.setValue((int) sel);
				int length=player.length;
				int ds = (int) (sel / progressBar.getMaximum() * length);
				player.playOffset=ds;
				//System.out.println("ds ="+ds);
				player.seekto(ds);
				//player.pause();
			}

		});

	}

	void setTime(int time,int length){
		double sel=(time / (double) length)* getMaximum();
		progressBar.setValue((int) sel);
	}
/*
public static void main(String[] args){
	//new PlayerProgressBar();
	
}
*/
}
