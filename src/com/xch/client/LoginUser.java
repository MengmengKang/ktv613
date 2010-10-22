package com.xch.client;
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
import javax.swing.SwingUtilities;

import com.xch.DAO.DA;
import com.xch.client.Register;
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
public class LoginUser extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton jExit;
	private JLabel jLabel3;
	private JButton jLogin;
	private JButton jRegister;
	private JPasswordField jPassword;
	private JTextField jUserName;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginUser inst = new LoginUser();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public LoginUser() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u7528\u6237\u767b\u5f55");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u7528\u6237\u540d");
				jLabel1.setBounds(65, 67, 54, 17);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801");
				jLabel2.setBounds(65, 101, 54, 17);
			}
			{
				jUserName = new JTextField();
				getContentPane().add(jUserName);
				jUserName.setBounds(131, 63, 121, 24);
			}
			{
				jLogin = new JButton();
				getContentPane().add(jLogin);
				jLogin.setText("\u767b\u5f55");
				jLogin.setBounds(97, 158, 61, 24);
				jLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jLoginActionPerformed(evt);
					}
				});
			}
			{
				jRegister = new JButton();
				getContentPane().add(jRegister);
				jRegister.setText("\u6ce8\u518c");
				jRegister.setBounds(282, 89, 69, 24);
				jRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRegisterActionPerformed(evt);
					}
				});
			}
			{
				jPassword = new JPasswordField();
				getContentPane().add(jPassword);
				jPassword.setBounds(131, 97, 121, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(221, 158, 61, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);
					}
				});
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u6ca1\u6709\u7528\u6237\u540d\uff1f");
				jLabel3.setBounds(282, 68, 84, 15);
			}
			pack();
			this.setSize(386, 260);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jRegisterActionPerformed(ActionEvent evt) {
		//System.out.println("jRegister.actionPerformed, event="+evt);
		//TODO add your code for jRegister.actionPerformed
		Register inst = new Register();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	private void jLoginActionPerformed(ActionEvent evt) {
		//System.out.println("jLogin.actionPerformed, event="+evt);
		//TODO add your code for jLogin.actionPerformed
		UserData user=new UserData();
		if(jUserName.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		String password=new String(jPassword.getPassword());
		MD5 md5=new MD5(password);
		//System.out.println(password);
		user.setUserName(jUserName.getText());
		user.setPassWord(md5.get());
		
		if (DA.loginUser(user))
		{
			this.dispose();
			MainFrame inst = new MainFrame();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
			//Player.video();
			//Player.play();
			//new Bottom();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "用户名或密码错误");
		}
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		//System.out.println("this.windowClosing, event="+evt);
		//TODO add your code for this.windowClosing
		int response=JOptionPane.showConfirmDialog(null,
				"确定要退出KTV智能点播系统吗？", "警告", JOptionPane.YES_NO_OPTION);
		if(response==0) this.dispose();
		else this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
	}
	
	private void jExitActionPerformed(ActionEvent evt) {
		//System.out.println("jExit.actionPerformed, event="+evt);
		//TODO add your code for jExit.actionPerformed
		int response=JOptionPane.showConfirmDialog(null,
				"确定要退出KTV智能点播系统吗？", "警告", JOptionPane.YES_NO_OPTION);
		if(response==0) this.dispose();
	}

}
