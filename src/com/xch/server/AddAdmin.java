package com.xch.server;
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
import com.xch.client.MD5;
import com.xch.obj.AdminData;


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
public class AddAdmin extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JPasswordField jPassWordRepeat;
	private JLabel jLabel4;
	private JButton jConfirm;
	private JButton jExit;
	private JPasswordField jPassWord;
	private JTextField jAdmin;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddAdmin inst = new AddAdmin();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AddAdmin() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u6dfb\u52a0\u7ba1\u7406\u5458");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u7ba1\u7406\u5458\u8d26\u6237");
				jLabel1.setBounds(68, 69, 84, 15);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801");
				jLabel2.setBounds(68, 104, 84, 15);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u91cd\u590d\u5bc6\u7801");
				jLabel3.setBounds(68, 140, 84, 15);
			}
			{
				jAdmin = new JTextField();
				getContentPane().add(jAdmin);
				jAdmin.setBounds(164, 66, 131, 22);
			}
			{
				jPassWord = new JPasswordField();
				getContentPane().add(jPassWord);
				jPassWord.setBounds(164, 101, 131, 22);
			}
			{
				jPassWordRepeat = new JPasswordField();
				getContentPane().add(jPassWordRepeat);
				jPassWordRepeat.setBounds(164, 137, 131, 22);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u6dfb\u52a0\u7ba1\u7406\u5458");
				jLabel4.setBounds(152, 25, 216, 15);
			}
			{
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(80, 198, 74, 22);
				jConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jConfirmActionPerformed(evt);
					}
				});
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(220, 198, 75, 22);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);
					}
				});
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jExitActionPerformed(ActionEvent evt) {
		System.out.println("jExit.actionPerformed, event="+evt);
		//TODO add your code for jExit.actionPerformed
		int response=JOptionPane.showConfirmDialog(null,
				"确定要退出添加管理员界面吗？", "警告", JOptionPane.YES_NO_OPTION);
		if(response==0) this.dispose();
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		System.out.println("this.windowClosing, event="+evt);
		//TODO add your code for this.windowClosing
		int response=JOptionPane.showConfirmDialog(null,
				"确定要退出添加管理员界面吗？", "警告", JOptionPane.YES_NO_OPTION);
		if(response==0) this.dispose();
		else this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
	}
	
	private void jConfirmActionPerformed(ActionEvent evt) {
		//System.out.println("jConfirm.actionPerformed, event="+evt);
		//TODO add your code for jConfirm.actionPerformed
		if(jAdmin.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(DA.checkAdmin(jAdmin.getText()))
		{
			JOptionPane.showMessageDialog(null, "用户名已经被使用！");
			return;
		}
		if(jPassWord.getPassword().length==0||jPassWordRepeat.getPassword().length==0)
		{
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			jPassWord.setText("");
			jPassWordRepeat.setText("");
			return;
		}
		String password=new String(jPassWord.getPassword());
		String passwordRepeat=new String(jPassWordRepeat.getPassword());
		//System.out.println(password+" "+passwordRepeat);
		if(password.equals(passwordRepeat)==false)
		{
			JOptionPane.showMessageDialog(null, "两次密码输入不匹配，请重新输入！");
			jPassWord.setText("");
			jPassWordRepeat.setText("");
			return;
		}
		
		MD5 md5=new MD5(password);
		AdminData admin = new AdminData();
		admin.setAdmin(jAdmin.getText());
		admin.setPassWord(md5.get());
		
		DA.addAdmin(admin);
		JOptionPane.showMessageDialog(null, "注册成功！");
		this.dispose();
	}

}
