package com.xch.server;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

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
public class ManageAdmin extends javax.swing.JFrame {
	private JButton jExit;
	private JButton jDelete;
	private JButton jCorrect;
	private JButton jAdd;
	private JPasswordField jPasswordField1;
	private JLabel jEnsurePassword;
	private JPasswordField jPasswordField2;
	private JLabel jPassword;
	private JTextField jTextField1;
	private JLabel jAdminID;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ManageAdmin inst = new ManageAdmin();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ManageAdmin() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jAdd = new JButton();
				getContentPane().add(jAdd);
				jAdd.setText("\u6dfb\u52a0");
				jAdd.setBounds(0, 200, 67, 24);
			}
			{
				jCorrect = new JButton();
				getContentPane().add(jCorrect);
				jCorrect.setText("\u4fee\u6539");
				jCorrect.setBounds(107, 200, 66, 24);
			}
			{
				jDelete = new JButton();
				getContentPane().add(jDelete);
				jDelete.setText("\u5220\u9664");
				jDelete.setBounds(211, 200, 69, 24);
			}

			{
				jAdminID = new JLabel();
				getContentPane().add(jAdminID);
				jAdminID.setText("\u7ba1\u7406\u5458\u8d26\u53f7");
				jAdminID.setBounds(58, 34, 84, 17);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(149, 31, 99, 24);
			}
			{
				jPassword = new JLabel();
				getContentPane().add(jPassword);
				jPassword.setText("\u5bc6\u7801");
				jPassword.setBounds(58, 84, 57, 17);
			}
			{
				jPasswordField1 = new JPasswordField();
				getContentPane().add(jPasswordField1);
				jPasswordField1.setBounds(149, 77, 99, 24);
			}
			{
				jEnsurePassword = new JLabel();
				getContentPane().add(jEnsurePassword);
				jEnsurePassword.setText("\u786e\u8ba4\u5bc6\u7801");
				jEnsurePassword.setBounds(58, 121, 66, 17);
			}
			{
				jPasswordField2 = new JPasswordField();
				getContentPane().add(jPasswordField2);
				jPasswordField2.setBounds(149, 118, 99, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(316, 200, 68, 24);
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
			this.dispose();
	}

}
