package com.xch.server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
				jConfirm.setBounds(73, 205, 74, 24);
			}
			
			{
				jUserID = new JLabel();
				getContentPane().add(jUserID);
				jUserID.setText("\u7528\u6237\u540d");
				jUserID.setBounds(105, 22, 55, 17);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(200, 19, 96, 24);
			}
			{
				jPassword = new JLabel();
				getContentPane().add(jPassword);
				jPassword.setText("\u5bc6\u7801");
				jPassword.setBounds(105, 52, 55, 17);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(200, 49, 96, 24);
			}
			{
				jRealName = new JLabel();
				getContentPane().add(jRealName);
				jRealName.setText("\u771f\u5b9e\u59d3\u540d");
				jRealName.setBounds(105, 81, 70, 17);
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setBounds(200, 78, 96, 24);
			}
			{
				jEmail = new JLabel();
				getContentPane().add(jEmail);
				jEmail.setText("\u7535\u5b50\u90ae\u7bb1");
				jEmail.setBounds(105, 141, 79, 17);
			}
			{
				jTextField4 = new JTextField();
				getContentPane().add(jTextField4);
				jTextField4.setBounds(202, 138, 94, 24);
			}
			{
				jHobby = new JLabel();
				getContentPane().add(jHobby);
				jHobby.setText("\u5174\u8da3");
				jHobby.setBounds(105, 170, 55, 17);
			}
			{
				jTextField5 = new JTextField();
				getContentPane().add(jTextField5);
				jTextField5.setBounds(202, 167, 94, 24);
			}
			{
				jSex = new JLabel();
				getContentPane().add(jSex);
				jSex.setText("\u6027\u522b");
				jSex.setBounds(105, 110, 55, 17);
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "ÄÐ", "Å®" });
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(202, 108, 65, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(236, 205, 81, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);}
			});}
			pack();
			setSize(400, 300);
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

