package com.xch.server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.xch.DAO.DA;
import com.xch.client.MD5;
import com.xch.obj.UserData;


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
public class EditUsers extends javax.swing.JFrame {
	private JButton jConfirm;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextField jUserID;
	private JLabel jLabel8;
	private JTextField jInterest;
	private JTextField jEmail;
	private JTextField jRealName;
	private JPasswordField jPassWordRepeat;
	private JPasswordField jPassWord;
	private JTextField jUserName;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JLabel jViewStars;
	private JComboBox jComboBox1;
	private JButton jExit;
	private UserData user;

	/**
	* Auto-generated main method to display this JFrame
	*/
	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EditUsers inst = new EditUsers();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	*/
	
	public EditUsers(int indata) {
		super();
		user=DA.getUser(indata);
		initGUI();
	}
	
	private void initGUI() {
		try {
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u4fee\u6539\u7528\u6237\u4fe1\u606f");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(100, 315, 74, 24);
				jConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jConfirmActionPerformed(evt);
					}
				});
			}
			
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] {  "女", "男"});
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setSelectedIndex(user.getGender());
				jComboBox1.setBounds(242, 175, 65, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(287, 314, 81, 24);
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
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u7528\u6237\u540d");
				jLabel1.setBounds(120, 57, 79, 15);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801");
				jLabel2.setBounds(120, 90, 70, 15);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u5bc6\u7801\u786e\u8ba4");
				jLabel3.setBounds(120, 119, 79, 15);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u771f\u5b9e\u59d3\u540d");
				jLabel4.setBounds(120, 151, 79, 15);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u6027\u522b");
				jLabel5.setBounds(120, 180, 70, 15);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u7535\u5b50\u90ae\u7bb1");
				jLabel6.setBounds(120, 209, 79, 15);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("\u559c\u6b22\u7684\u6b4c");
				jLabel7.setBounds(120, 242, 79, 15);
			}
			{
				jUserName = new JTextField();
				getContentPane().add(jUserName);
				jUserName.setText(user.getUserName());
				jUserName.setEditable(false);
				jUserName.setBounds(242, 54, 96, 22);
			}
			{
				jPassWord = new JPasswordField();
				getContentPane().add(jPassWord);
				jPassWord.setBounds(242, 87, 96, 22);
			}
			{
				jPassWordRepeat = new JPasswordField();
				getContentPane().add(jPassWordRepeat);
				jPassWordRepeat.setBounds(242, 116, 96, 22);
			}
			{
				jRealName = new JTextField();
				getContentPane().add(jRealName);
				jRealName.setText(user.getRealName());
				jRealName.setBounds(242, 148, 96, 22);
			}
			{
				jEmail = new JTextField();
				getContentPane().add(jEmail);
				jEmail.setText(user.getEmail());
				jEmail.setBounds(242, 206, 96, 22);
			}
			{
				jInterest = new JTextField();
				getContentPane().add(jInterest);
				jInterest.setText(user.getInterest());
				jInterest.setBounds(242, 239, 96, 22);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("\u7528\u6237ID");
				jLabel8.setBounds(120, 269, 79, 17);
			}
			{
				jUserID = new JTextField();
				getContentPane().add(jUserID);
				jUserID.setText(String.valueOf(user.getUserID()));
				jUserID.setEditable(false);
				jUserID.setBounds(242, 266, 96, 24);
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
			int response=JOptionPane.showConfirmDialog(null,
					"确定要退出修改用户信息界面吗？", "警告", JOptionPane.YES_NO_OPTION);
			if(response==0) this.dispose();
	}
		
		private void thisWindowClosing(WindowEvent evt) {
			//System.out.println("this.windowClosing, event="+evt);
			//TODO add your code for this.windowClosing
			 int response=JOptionPane.showConfirmDialog(null,
						"确定要退出修改明用户信息界面吗？", "警告", JOptionPane.YES_NO_OPTION);
				if(response==0) this.dispose();
				else this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
		}
		
		private void jConfirmActionPerformed(ActionEvent evt) {
			//System.out.println("jConfirm.actionPerformed, event="+evt);
			//TODO add your code for jConfirm.actionPerformed
			String password=new String(jPassWord.getPassword());
			String passwordRepeat=new String(jPassWordRepeat.getPassword());
			if(password.equals(passwordRepeat)==false)
			{
				JOptionPane.showMessageDialog(null, "两次密码输入不匹配，请重新输入！");
				jPassWord.setText("");
				jPassWordRepeat.setText("");
				return;
			}
			System.out.println(password);
			MD5 md5=new MD5(password);
			if(password.length()!=0) user.setPassWord(md5.get());
			user.setEmail(jEmail.getText());
			user.setRealName(jRealName.getText());
			user.setInterest(jInterest.getText());
			user.setGender(jComboBox1.getSelectedIndex());
			DA.modifyUser(user);
			JOptionPane.showMessageDialog(null, "用户信息修改成功！");
		}

}

