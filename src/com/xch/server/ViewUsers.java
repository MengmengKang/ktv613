package com.xch.server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class ViewUsers extends javax.swing.JFrame {
	private JButton jConfirm;
	private JLabel jViewStars;
	private JPasswordField jPasswordField1;
	private JLabel jEnsurePassword;
	private JComboBox jComboBox1;
	private JLabel jEmail;
	private JLabel jSex;
	private JTextField jTextField5;
	private JLabel jHobby;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JLabel jRealName;
	private JTextField jTextField2;
	private JLabel jPassword;
	private JTextField jTextField1;
	private JLabel jUserID;
	private JButton jExit;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ViewUsers inst = new ViewUsers();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ViewUsers() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(101, 290, 74, 24);
			}
			
			{
				jUserID = new JLabel();
				getContentPane().add(jUserID);
				jUserID.setText("\u7528\u6237\u540d");
				jUserID.setBounds(120, 56, 55, 17);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(242, 53, 96, 24);
			}
			{
				jPassword = new JLabel();
				getContentPane().add(jPassword);
				jPassword.setText("\u5bc6\u7801");
				jPassword.setBounds(120, 89, 55, 17);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(242, 86, 96, 24);
			}
			{
				jRealName = new JLabel();
				getContentPane().add(jRealName);
				jRealName.setText("\u771f\u5b9e\u59d3\u540d");
				jRealName.setBounds(120, 150, 70, 17);
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setBounds(242, 147, 96, 24);
			}
			{
				jEmail = new JLabel();
				getContentPane().add(jEmail);
				jEmail.setText("\u7535\u5b50\u90ae\u7bb1");
				jEmail.setBounds(120, 208, 79, 17);
			}
			{
				jTextField4 = new JTextField();
				getContentPane().add(jTextField4);
				jTextField4.setBounds(242, 205, 96, 24);
			}
			{
				jHobby = new JLabel();
				getContentPane().add(jHobby);
				jHobby.setText("\u5174\u8da3");
				jHobby.setBounds(120, 241, 55, 17);
			}
			{
				jTextField5 = new JTextField();
				getContentPane().add(jTextField5);
				jTextField5.setBounds(242, 238, 96, 24);
			}
			{
				jSex = new JLabel();
				getContentPane().add(jSex);
				jSex.setText("\u6027\u522b");
				jSex.setBounds(120, 179, 55, 17);
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "ÄÐ", "Å®" });
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(242, 175, 65, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(287, 290, 81, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);}
			});}
			{
				jViewStars = new JLabel();
				getContentPane().add(jViewStars);
				jViewStars.setText("\u4fee\u6539\u7528\u6237\u4fe1\u606f");
				jViewStars.setBounds(190, 22, 164, 17);
			}
			{
				jEnsurePassword = new JLabel();
				getContentPane().add(jEnsurePassword);
				jEnsurePassword.setText("\u5bc6\u7801\u786e\u8ba4");
				jEnsurePassword.setBounds(120, 118, 79, 17);
			}
			{
				jPasswordField1 = new JPasswordField();
				getContentPane().add(jPasswordField1);
				jPasswordField1.setBounds(242, 115, 96, 24);
			}
			pack();
			this.setSize(475, 396);
		}catch (Exception e) {
		    //add your error handling code here
		}	
		}
		private void jExitActionPerformed(ActionEvent evt) {
			//System.out.println("jExit.actionPerformed, event="+evt);
			//TODO add your code for jExit.actionPerformed
			this.dispose();
	}

}

