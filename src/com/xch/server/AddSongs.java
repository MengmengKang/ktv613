package com.xch.server;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
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
	private JLabel jAddSong;
	private JTextField jTextField3;
	private JLabel jSongPinyin;
	private JTextField jTextField2;
	private JLabel jSongNumber;
	private JTextField jTextField1;
	private JLabel jSongType;
	private JLabel jLabel1;
	private JButton jExit;
	private JTextField jSongName;

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
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jSongName = new JTextField();
				getContentPane().add(jSongName);
				jSongName.setBounds(144, 42, 190, 24);
				jSongName.setBounds(118, 42, 216, 24);
			}
			{
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(70, 222, 95, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(228, 222, 100, 24);
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
				jSongType = new JLabel();
				getContentPane().add(jSongType);
				jSongType.setText("\u6b4c\u66f2\u7c7b\u578b");
				jSongType.setBounds(33, 87, 82, 17);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(118, 84, 216, 24);
			}
			{
				jSongNumber = new JLabel();
				getContentPane().add(jSongNumber);
				jSongNumber.setText("\u6b4c\u540d\u5b57\u6570");
				jSongNumber.setBounds(33, 133, 82, 17);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(118, 133, 216, 24);
			}
			{
				jSongPinyin = new JLabel();
				getContentPane().add(jSongPinyin);
				jSongPinyin.setText("\u62fc\u97f3\u6b4c\u540d");
				jSongPinyin.setBounds(33, 181, 82, 17);
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setBounds(118, 178, 216, 24);
			}
			{
				jAddSong = new JLabel();
				getContentPane().add(jAddSong);
				jAddSong.setText("\u6dfb\u52a0\u6b4c\u66f2");
				jAddSong.setBounds(156, 12, 97, 22);
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
			this.dispose();
	}

}
