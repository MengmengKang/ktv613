package com.xch.client;
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
import com.xch.client.Register;
import com.xch.obj.AdminData;
import com.xch.obj.UserData;
import com.xch.server.Manager;


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
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u7528\u6237\u767b\u5f55");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u7528\u6237\u540d");
				jLabel1.setBounds(91, 67, 54, 17);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801");
				jLabel2.setBounds(91, 101, 54, 17);
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
				jRegister = new JButton();
				getContentPane().add(jRegister);
				jRegister.setText("\u6ce8\u518c");
				jRegister.setBounds(203, 159, 61, 24);
				jRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRegisterActionPerformed(evt);
					}
				});
			}
			{
				jPassword = new JPasswordField();
				getContentPane().add(jPassword);
				jPassword.setBounds(157, 98, 121, 24);
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
		UserData admin=new UserData();
		user.setUserName(jUserName.getText());
		user.setPassWord(md5.get());
		
		if (DA.loginUser(user))
		{
			this.dispose();
			MainFrame inst = new MainFrame();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "用户名或密码错误");
		}
	}

}
