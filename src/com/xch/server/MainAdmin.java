package com.xch.server;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

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
public class MainAdmin extends javax.swing.JFrame {
	private JList jMainAdmin;
	private JLabel jLabel1;
	private JButton jExit;
	private JButton jEdit;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainAdmin inst = new MainAdmin();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainAdmin() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u7ba1\u7406\u5458\u4fe1\u606f\u7ba1\u7406");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				ListModel jMainAdminModel = 
					new DefaultComboBoxModel(
							new String[] { "Admin1", "Admin2","..." });
				jMainAdmin = new JList();
				getContentPane().add(jMainAdmin);
				jMainAdmin.setModel(jMainAdminModel);
				jMainAdmin.setBounds(134, 48, 115, 142);
			}
			{
				jEdit = new JButton();
				getContentPane().add(jEdit);
				jEdit.setText("\u7f16\u8f91");
				jEdit.setBounds(88, 206, 78, 22);
				jEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jManageAdminActionPerformed(evt);
					}
					});
			}
	
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u7ba1\u7406\u5458\u4fe1\u606f\u7ba1\u7406");
				jLabel1.setBounds(146, 12, 84, 15);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(228, 206, 76, 22);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);}
			});}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
		}
		}
		private void jExitActionPerformed(ActionEvent evt) {
			//System.out.println("jExit.actionPerformed, event="+evt);
			//TODO add your code for jExit.actionPerformed
			int response=JOptionPane.showConfirmDialog(null,
					"确定要退出管理员信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
			if(response==0) this.dispose();
		}
			private void jManageAdminActionPerformed(ActionEvent evt){
				//System.out.println("jManageAdmin.actionPerformed, event="+evt);
				//TODO add your code for jManageAdmin.actionPerformed
				ManageAdmin inst = new ManageAdmin();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
	}
			
			private void thisWindowClosing(WindowEvent evt) {
				//System.out.println("this.windowClosing, event="+evt);
				//TODO add your code for this.windowClosing
				int response=JOptionPane.showConfirmDialog(null,
						"确定要退出管理员信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
				if(response==0) this.dispose();
				else this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
			}

}
