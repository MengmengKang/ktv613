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
			}
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
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
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
