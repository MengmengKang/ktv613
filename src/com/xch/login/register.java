package com.xch.login;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
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
public class register extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JTextField jUserId;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JButton jCancel;
	private JButton jConfirm;
	private JLabel jLabel8;
	private JLabel jLabel11;
	private JComboBox jDay;
	private JLabel jLabel10;
	private JComboBox jMonth;
	private JLabel jLabel9;
	private JComboBox jYear;
	private JTextField jInterest;
	private JLabel jLabel7;
	private JComboBox jGender;
	private JLabel jLabel6;
	private JTextField jEmail;
	private JLabel jLabel5;
	private JTextField jRealName;
	private JPasswordField jPasswordRepeat;
	private JPasswordField jPassword;
	private JLabel jLabel3;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				register inst = new register();
				inst.setTitle("×¢²áÓÃ»§");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				
				
			}
		});
	}
	
	public register() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("* \u7528\u6237\u540d");
				jLabel1.setBounds(74, 33, 80, 15);
			}
			{
				jUserId = new JTextField();
				getContentPane().add(jUserId);
				jUserId.setBounds(158, 29, 70, 22);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("* \u5bc6\u7801");
				jLabel2.setBounds(74, 60, 80, 15);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("* \u786e\u8ba4\u5bc6\u7801");
				jLabel3.setBounds(74, 87, 80, 15);
			}
			{
				jPassword = new JPasswordField();
				getContentPane().add(jPassword);
				jPassword.setBounds(158, 56, 70, 22);
			}
			{
				jPasswordRepeat = new JPasswordField();
				getContentPane().add(jPasswordRepeat);
				jPasswordRepeat.setBounds(158, 83, 70, 22);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u771f\u5b9e\u59d3\u540d");
				jLabel4.setBounds(74, 114, 80, 15);
			}
			{
				jRealName = new JTextField();
				getContentPane().add(jRealName);
				jRealName.setBounds(158, 110, 70, 22);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u7535\u5b50\u90ae\u7bb1");
				jLabel5.setBounds(74, 141, 80, 15);
			}
			{
				jEmail = new JTextField();
				getContentPane().add(jEmail);
				jEmail.setBounds(158, 137, 139, 22);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u6027\u522b");
				jLabel6.setBounds(74, 168, 80, 15);
			}
			{
				ComboBoxModel jGenderModel = 
					new DefaultComboBoxModel(
							new String[] { "ÄÐ", "Å®" });
				jGender = new JComboBox();
				getContentPane().add(jGender);
				jGender.setModel(jGenderModel);
				jGender.setBounds(158, 164, 39, 22);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("\u5174\u8da3");
				jLabel7.setBounds(74, 195, 80, 15);
			}
			{
				jInterest = new JTextField();
				getContentPane().add(jInterest);
				jInterest.setBounds(158, 191, 139, 22);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("\u751f\u65e5");
				jLabel8.setBounds(74, 222, 80, 15);
			}
			{
				ComboBoxModel jYearModel = 
					new DefaultComboBoxModel(
							new String[] { "1989", "1990" });
				jYear = new JComboBox();
				getContentPane().add(jYear);
				jYear.setModel(jYearModel);
				jYear.setBounds(158, 218, 61, 22);
			}
			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9);
				jLabel9.setText("\u5e74");
				jLabel9.setBounds(225, 222, 17, 15);
			}
			{
				ComboBoxModel jMonthModel = 
					new DefaultComboBoxModel(
							new String[] { "1", "2","3","4","5","6","7","8","9","10","11","12" });
				jMonth = new JComboBox();
				getContentPane().add(jMonth);
				jMonth.setModel(jMonthModel);
				jMonth.setBounds(242, 218, 41, 22);
			}
			{
				jLabel10 = new JLabel();
				getContentPane().add(jLabel10);
				jLabel10.setText("\u6708");
				jLabel10.setBounds(289, 222, 14, 15);
			}
			{
				ComboBoxModel jDayModel = 
					new DefaultComboBoxModel(
							new String[] { "1", "2","3","4","5","6","7","8","9","10", 
									"11", "12","13","14","15","16","17","18","19","20", 
									"21", "22","23","24","25","26","27","28","29","30","31" });
				jDay = new JComboBox();
				getContentPane().add(jDay);
				jDay.setModel(jDayModel);
				jDay.setBounds(303, 218, 44, 22);
			}
			{
				jLabel11 = new JLabel();
				getContentPane().add(jLabel11);
				jLabel11.setText("\u65e5");
				jLabel11.setBounds(353, 222, 19, 15);
			}
			{
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(112, 258, 60, 22);
				jConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jConfirmActionPerformed(evt);
					}
				});
			}
			{
				jCancel = new JButton();
				getContentPane().add(jCancel);
				jCancel.setText("\u53d6\u6d88");
				jCancel.setBounds(205, 258, 61, 22);
			}
			pack();
			this.setSize(419, 334);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jConfirmActionPerformed(ActionEvent evt) {
		System.out.println("jConfirm.actionPerformed, event="+evt);
		//TODO add your code for jConfirm.actionPerformed
		
	}

}
