package com.xch.client;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import com.xch.obj.UserData;
import com.xch.DAO.DA;
import com.xch.client.MD5;



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
	private JTextField jUserName;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JButton jCancel;
	private JButton jConfirm;
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
			this.setTitle("\u6ce8\u518c\u65b0\u7528\u6237");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("* \u7528\u6237\u540d");
				jLabel1.setBounds(74, 33, 80, 15);
			}
			{
				jUserName = new JTextField();
				getContentPane().add(jUserName);
				jUserName.setBounds(158, 29, 70, 22);
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
							new String[] { "男", "女" });
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
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(106, 244, 60, 22);
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
				jCancel.setBounds(205, 244, 61, 22);
				jCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jCancelActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(385, 324);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jConfirmActionPerformed(ActionEvent evt) {
		//System.out.println("jConfirm.actionPerformed, event="+evt);
		//TODO add your code for jConfirm.actionPerformed
		UserData user=new UserData();
		if(jUserName.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(DA.checkUserName(jUserName.getText()))
		{
			JOptionPane.showMessageDialog(null, "用户名已经被使用！");
			return;
		}
		if(jPassword.getPassword().length==0||jPasswordRepeat.getPassword().length==0)
		{
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			jPassword.setText("");
			jPasswordRepeat.setText("");
			return;
		}
		if(jPassword.getPassword().toString().equals(jPasswordRepeat.getPassword().toString()))
		{
			JOptionPane.showMessageDialog(null, "两次密码输入不匹配，请重新输入！");
			jPassword.setText("");
			jPasswordRepeat.setText("");
			return;
		}
		MD5 md5=new MD5(jPassword.getPassword().toString());
		user.setUserID(DA.getUserMaxID());
		user.setUserName(jUserName.getText());
		user.setPassWord(md5.get());
		user.setEmail(jEmail.getText());
		user.setGender(jGender.getSelectedIndex());
		user.setRealName(jRealName.getText());
		user.setInterest(jInterest.getText());
		
		DA.addUserData(user);
		JOptionPane.showMessageDialog(null, "注册成功！");
		register.this.dispose();
	}
	
	private void jCancelActionPerformed(ActionEvent evt) {
		//System.out.println("jCancel.actionPerformed, event="+evt);
		//TODO add your code for jCancel.actionPerformed
		register.this.dispose();
	}

}
