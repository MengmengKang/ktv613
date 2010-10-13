package com.xch.server;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class AddSongs extends javax.swing.JFrame {
	private JButton jConfirm;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextField jSoPinyin;
	private JTextField jSoNumber;
	private JTextField jSongType;
	private JTextField jSongName;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JButton jChooseSong;
	private JTextField jURL;
	private JLabel jAddSong;
	private JLabel jLabel1;
	private JButton jExit;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddSongs inst = new AddSongs();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AddSongs() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u6dfb\u52a0\u6b4c\u66f2");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(54, 255, 95, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(234, 255, 100, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);}
			});}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u6b4c\u66f2\u540d\u79f0");
				jLabel1.setBounds(33, 45, 82, 17);
			}
			
			{
				jAddSong = new JLabel();
				getContentPane().add(jAddSong);
				jAddSong.setText("\u6dfb\u52a0\u6b4c\u66f2");
				jAddSong.setBounds(156, 12, 97, 22);
			}
			{
				jURL = new JTextField();
				getContentPane().add(jURL);
				jURL.setBounds(115, 220, 180, 22);
			}
			{
				jChooseSong = new JButton();
				getContentPane().add(jChooseSong);
				jChooseSong.setText("...");
				jChooseSong.setBounds(304, 220, 32, 22);
				jChooseSong.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jChooseSongActionPerformed(evt);
					}
				});

			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u6b4c\u66f2\u7c7b\u578b");
				jLabel2.setBounds(33, 88, 67, 15);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u6b4c\u540d\u5b57\u6570");
				jLabel3.setBounds(33, 137, 67, 15);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u62fc\u97f3\u6b4c\u540d");
				jLabel4.setBounds(33, 180, 73, 15);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u6b4c\u66f2\u5b58\u50a8\u8def\u5f84");
				jLabel5.setBounds(33, 223, 82, 15);
			}
			{
				jSongName = new JTextField();
				getContentPane().add(jSongName);
				jSongName.setBounds(115, 43, 221, 22);
			}
			{
				jSongType = new JTextField();
				getContentPane().add(jSongType);
				jSongType.setBounds(115, 85, 221, 22);
			}
			{
				jSoNumber = new JTextField();
				getContentPane().add(jSoNumber);
				jSoNumber.setBounds(115, 137, 221, 22);
			}
			{
				jSoPinyin = new JTextField();
				getContentPane().add(jSoPinyin);
				jSoPinyin.setBounds(115, 177, 221, 22);
			}
			pack();
			this.setSize(400, 329);
		} catch (Exception e) {
		    //add your error handling code here
		}	
		}
		private void jExitActionPerformed(ActionEvent evt) {
			//System.out.println("jExit.actionPerformed, event="+evt);
			//TODO add your code for jExit.actionPerformed
			int response=JOptionPane.showConfirmDialog(null,
					"确定要退出添加歌曲界面吗？", "警告", JOptionPane.YES_NO_OPTION);
			if(response==0) this.dispose();
	}
		
		private void thisWindowClosing(WindowEvent evt) {
			//System.out.println("this.windowClosing, event="+evt);
			//TODO add your code for this.windowClosing
		    int response=JOptionPane.showConfirmDialog(null,
					"确定要退出添加歌曲界面吗？", "警告", JOptionPane.YES_NO_OPTION);
			if(response==0) this.dispose();
			else this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
		}
		
		private void jChooseSongActionPerformed(ActionEvent evt) {
			//System.out.println("jChooseSong.actionPerformed, event="+evt);
			//TODO add your code for jChooseSong.actionPerformed
			ChooseSong inst = new ChooseSong();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		}

}
