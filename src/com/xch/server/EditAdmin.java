package com.xch.server;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import com.xch.client.MD5;
import com.xch.obj.AdminData;
import com.xch.DAO.DA;


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
public class EditAdmin extends javax.swing.JFrame {
	private JButton jExit;
	private JButton jAdd;
	private JPasswordField jPassword;
	private JLabel jPasswordLable2;
	private JPasswordField jPasswordEnsure;
	private JLabel jManageAdmin;
	private JLabel jPasswordLable1;
	private JTextField jAdmin;
	private JLabel jAdminID;
	private AdminData admin;

	/**
	* Auto-generated main method to display this JFrame
	*/
	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ManageAdmin inst = new ManageAdmin();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	*/
	
	public EditAdmin(String indata) {
		super();
		admin=DA.getAdmin(indata);
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
				jAdd = new JButton();
				getContentPane().add(jAdd);
				jAdd.setText("\u4fee\u6539");
				jAdd.setBounds(87, 205, 67, 24);
				jAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jAddActionPerformed(evt);
					}
				});
			}

			{
				jAdminID = new JLabel();
				getContentPane().add(jAdminID);
				jAdminID.setText("\u7ba1\u7406\u5458\u8d26\u53f7");
				jAdminID.setBounds(58, 66, 84, 17);
			}
			{
				jAdmin = new JTextField();
				getContentPane().add(jAdmin);
				jAdmin.setText(admin.getAdmin());
				jAdmin.setEditable(false);
				jAdmin.setBounds(149, 63, 99, 24);
			}
			{
				jPasswordLable1 = new JLabel();
				getContentPane().add(jPasswordLable1);
				jPasswordLable1.setText("\u5bc6\u7801");
				jPasswordLable1.setBounds(58, 109, 57, 17);
			}
			{
				jPassword = new JPasswordField();
				getContentPane().add(jPassword);
				jPassword.setBounds(149, 106, 99, 24);
			}
			{
				jPasswordLable2 = new JLabel();
				getContentPane().add(jPasswordLable2);
				jPasswordLable2.setText("\u786e\u8ba4\u5bc6\u7801");
				jPasswordLable2.setBounds(58, 152, 66, 17);
			}
			{
				jPasswordEnsure = new JPasswordField();
				getContentPane().add(jPasswordEnsure);
				jPasswordEnsure.setBounds(149, 149, 99, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(229, 205, 68, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);}
			});}
			{
				jManageAdmin = new JLabel();
				getContentPane().add(jManageAdmin);
				jManageAdmin.setText("\u7ba1\u7406\u5458\u4fe1\u606f\u7ba1\u7406");
				jManageAdmin.setBounds(142, 17, 147, 29);
							}
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
		
		private void thisWindowClosing(WindowEvent evt) {
			//System.out.println("this.windowClosing, event="+evt);
			//TODO add your code for this.windowClosing
			int response=JOptionPane.showConfirmDialog(null,
					"确定要退出管理员信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
			if(response==0) this.dispose();
			else this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
		}
		
		private void jAddActionPerformed(ActionEvent evt) {
			//System.out.println("jAdd.actionPerformed, event="+evt);
			//TODO add your code for jAdd.actionPerformed
			if(jPassword.getPassword().length==0||jPasswordEnsure.getPassword().length==0)
			{
				JOptionPane.showMessageDialog(null, "密码不能为空！");
				jPassword.setText("");
				jPasswordEnsure.setText("");
				return;
			}
			if(jPassword.getPassword().toString().equals(jPasswordEnsure.getPassword().toString()))
			{
				JOptionPane.showMessageDialog(null, "两次密码输入不匹配，请重新输入！");
				jPassword.setText("");
				jPasswordEnsure.setText("");
				return;
			}
			String password=new String(jPassword.getPassword());
			System.out.println(password);
			MD5 md5=new MD5(password);
			admin.setPassWord(md5.get());
			
			DA.modifyAdmin(admin);
			JOptionPane.showMessageDialog(null, "修改成功！");
		}

}
