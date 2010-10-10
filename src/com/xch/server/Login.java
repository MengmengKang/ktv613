package com.xch.server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.xch.DAO.DA;
import com.xch.client.MD5;
import com.xch.client.Register;
import com.xch.obj.AdminData;
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
public class Login extends javax.swing.JFrame {
	private JLabel jLabel2;
	private JButton jLogin;
	private JButton jExit;
	private JLabel jManagerID;
	private JPasswordField jPassword;
	private JTextField jUserName;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login inst = new Login();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Login() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u7ba1\u7406\u5458\u767b\u5f55");
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801");
				jLabel2.setBounds(73, 101, 54, 17);
			}
			{
				jUserName = new JTextField();
				getContentPane().add(jUserName);
				jUserName.setBounds(157, 64, 121, 24);
			}
			{
				jLogin = new JButton();
				getContentPane().add(jLogin);
				jLogin.setText("\u767b\u5f55");
				jLogin.setBounds(109, 159, 61, 24);
				jLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jLoginActionPerformed(evt);
					}
				});

			}
			{
				jPassword = new JPasswordField();
				getContentPane().add(jPassword);
				jPassword.setBounds(157, 98, 121, 24);
			}
			{
				jManagerID = new JLabel();
				getContentPane().add(jManagerID);
				jManagerID.setText("\u7ba1\u7406\u5458\u8d26\u6237");
				jManagerID.setBounds(73, 67, 72, 17);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(211, 159, 67, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);
					}
				});}
			this.setSize(386, 260);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jLoginActionPerformed(ActionEvent evt) {
		//System.out.println("jLogin.actionPerformed, event="+evt);
		//TODO add your code for jLogin.actionPerformed
		AdminData user=new AdminData();
		if(jUserName.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		String password=new String(jPassword.getPassword());
		MD5 md5=new MD5(password);
		//System.out.println(password);
		AdminData admin=new AdminData();
		admin.setAdmin(jUserName.getText());
		admin.setPassWord(md5.get());
		
		if (DA.loginAdmin(admin))
		{
			this.dispose();
			Manager inst = new Manager();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "用户名或密码错误");
		}
	}
	private void jExitActionPerformed(ActionEvent evt) {
		//System.out.println("jExit.actionPerformed, event="+evt);
		//TODO add your code for jExit.actionPerformed
		this.dispose();
	}
}


