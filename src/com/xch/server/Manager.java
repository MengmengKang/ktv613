package com.xch.server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

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
public class Manager extends javax.swing.JFrame {
	private JButton jManageUser;
	private JButton jExit;
	private JButton jManageAdmin;
	private JButton jManageSong;
	private JButton jManageStar;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Manager inst = new Manager();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Manager() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jManageUser = new JButton();
				getContentPane().add(jManageUser);
				jManageUser.setText("\u7528\u6237\u4fe1\u606f\u7ba1\u7406");
				jManageUser.setBounds(117, 87, 143, 40);
				jManageUser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jManageUsersActionPerformed(evt);
					}
			});
			{
				jManageStar = new JButton();
				getContentPane().add(jManageStar);
				jManageStar.setText("\u660e\u661f\u4fe1\u606f\u7ba1\u7406");
				jManageStar.setBounds(117, 146, 143, 40);
				jManageStar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jManageStarActionPerformed(evt);
					}
				});
			}
			{
				jManageSong = new JButton();
				getContentPane().add(jManageSong);
				jManageSong.setText("\u6b4c\u66f2\u4fe1\u606f\u7ba1\u7406");
				jManageSong.setBounds(117, 206, 143, 40);
				jManageSong.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jManageSongActionPerformed(evt);
					}
				});
			}
			{
				jManageAdmin = new JButton();
				getContentPane().add(jManageAdmin);
				jManageAdmin.setText("\u7ba1\u7406\u5458\u4fe1\u606f\u7ba1\u7406");
				jManageAdmin.setBounds(117, 22,143, 40);
				jManageAdmin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jManageAdminActionPerformed(evt);
					}
					});
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa\u7ba1\u7406\u5458\u7cfb\u7edf");
				jExit.setBounds(121, 268, 139, 39);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);}
			});}
			pack();
			setSize(400, 363);
			}}catch (Exception e) {
		    //add your error handling code here
		}	
		}
		private void jExitActionPerformed(ActionEvent evt) {
			//System.out.println("jExit.actionPerformed, event="+evt);
			//TODO add your code for jExit.actionPerformed
			this.dispose();
	}


	private void jManageAdminActionPerformed(ActionEvent evt){
		//System.out.println("jManageAdmin.actionPerformed, event="+evt);
		//TODO add your code for jManageAdmin.actionPerformed
		ManageAdmin inst = new ManageAdmin();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	private void jManageUsersActionPerformed(ActionEvent evt){
		//System.out.println("jManageUsers.actionPerformed, event="+evt);
		//TODO add your code for jManageUsers.actionPerformed
		ManageUsers inst = new ManageUsers();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	private void jManageSongActionPerformed(ActionEvent evt) {
		//System.out.println("jManageSong.actionPerformed, event="+evt);
		//TODO add your code for jManageSong.actionPerformed
			ManageSongs inst = new ManageSongs();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
	}
	
	private void jManageStarActionPerformed(ActionEvent evt) {
		//System.out.println("jManageStar.actionPerformed, event="+evt);
		//TODO add your code for jManageStar.actionPerformed
		ManageStars inst = new ManageStars();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

}
