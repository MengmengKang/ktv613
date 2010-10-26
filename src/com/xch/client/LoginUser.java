package com.xch.client;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
			
			setBak();
			Container c = getContentPane(); //获取JFrame面板
			c.setBounds(28, -29, 792, 566);
			JPanel jp = new JPanel();      //创建个JPanel
			jp.setOpaque(false);           //把JPanel设置为透明 这样就不会遮住后面的背景  这样你就能在JPanel随意加组件了
			c.add(jp); 
			{
				jLabel3 = new JLabel();
				c.add(jLabel3);
				jLabel3.setText("\u6ca1\u6709\u7528\u6237\u540d\uff1f");
				jLabel3.setBounds(650, 278, 84, 15);
			}
			{
				jRegister = new JButton();
				c.add(jRegister);
				jRegister.setText("\u6ce8\u518c");
				jRegister.setBounds(650, 299, 69, 24);
				jRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRegisterActionPerformed(evt);
					}
				});
			}
			{
				jUserName = new JTextField();
				c.add(jUserName);
				jUserName.setBounds(369, 273, 121, 24);
			}
			{
				jPassword = new JPasswordField();
				c.add(jPassword);
				jPassword.setBounds(369, 333, 121, 24);
			}
			{
				jExit = new JButton();
				c.add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(420, 395, 61, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);
					}
				});
			}
			{
				jLogin = new JButton();
				c.add(jLogin);
				jLogin.setText("\u767b\u5f55");
				jLogin.setBounds(301, 395, 61, 24);
				jLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jLoginActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				c.add(jLabel1);
				jLabel1.setText("\u7528\u6237\u540d");
				jLabel1.setBounds(277, 277, 54, 17);
			}
			{
				jLabel2 = new JLabel();
				c.add(jLabel2);
				jLabel2.setText("\u5bc6\u7801");
				jLabel2.setBounds(277, 337, 54, 17);
			}
			this.setTitle("\u7528\u6237\u767b\u5f55");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			pack();
			this.setSize(800, 600);
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
			SongList.newList();
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
	public void setBak(){ 
		  ((JPanel)this.getContentPane()).setOpaque(false);
		   ImageIcon img = new ImageIcon("img/Loading04.jpg"); 
		   JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
		   background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 
		  } 
}
