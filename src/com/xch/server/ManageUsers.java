package com.xch.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class ManageUsers extends javax.swing.JFrame {
	private static final JButton eGViewUsers = null;
	private JButton RefreshMessage;
	private JButton jViewUsers;
	private JList jUsers;
	private JLabel jManageUsers;
	private JButton jExit;
	private JButton jRefreshMessage;
	private JButton jDeleteUsers;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ManageUsers inst = new ManageUsers();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ManageUsers() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u7528\u6237\u4fe1\u606f\u7ba1\u7406");

			{
				jViewUsers = new JButton();
				getContentPane().add(jViewUsers);
				jViewUsers.setText("\u67e5\u770b\u7528\u6237\u4fe1\u606f");
				jViewUsers.setBounds(42, 244, 126, 24);
				jViewUsers.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jViewUsersActionPerformed(evt);
					}

					private void jViewUsersActionPerformed(ActionEvent evt) {
						//System.out.println("jViewUsers.actionPerformed, event="+evt);
						//TODO add your code for jViewUsers.actionPerformed
							ViewUsers inst = new ViewUsers();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
					}
			});
			{
				jDeleteUsers = new JButton();
				getContentPane().add(jDeleteUsers);
				jDeleteUsers.setText("\u5220\u9664\u7528\u6237\u4fe1\u606f");
				jDeleteUsers.setBounds(197, 244, 130, 24);
			}
			{
				jRefreshMessage = new JButton();
				getContentPane().add(jRefreshMessage);
				jRefreshMessage.setText("\u66f4\u65b0\u7528\u6237\u4fe1\u606f");
				jRefreshMessage.setBounds(358, 244, 130, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(523, 244, 62, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);}
			});}
			{
				jManageUsers = new JLabel();
				getContentPane().add(jManageUsers);
				jManageUsers.setText("\u7528\u6237\u4fe1\u606f\u7ba1\u7406");
				jManageUsers.setBounds(273, 22, 202, 17);
			}
			{
				ListModel jUsersModel = 
					new DefaultComboBoxModel(
							new String[] { "User 1", "User 2","..." });
				jUsers = new JList();
				getContentPane().add(jUsers);
				jUsers.setModel(jUsersModel);
				jUsers.setBounds(225, 66, 172, 124);
			}
			pack();
			setSize(653, 363);
			}}catch (Exception e) {
		    //add your error handling code here
		}	
		}
		private void jExitActionPerformed(ActionEvent evt) {
			//System.out.println("jExit.actionPerformed, event="+evt);
			//TODO add your code for jExit.actionPerformed
			this.dispose();
	}

}