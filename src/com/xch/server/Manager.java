package com.xch.server;
import javax.swing.JButton;

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
public class Manager extends javax.swing.JFrame {
	private JButton jManageUser;
	private JButton jManageSong;
	private JButton jManageStar;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Manager inst = new Manager();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Manager() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jManageUser = new JButton();
				getContentPane().add(jManageUser);
				jManageUser.setText("\u7528\u6237\u4fe1\u606f\u7ba1\u7406");
				jManageUser.setBounds(51, 28, 86, 22);
			}
			{
				jManageStar = new JButton();
				getContentPane().add(jManageStar);
				jManageStar.setText("\u660e\u661f\u4fe1\u606f\u7ba1\u7406");
				jManageStar.setBounds(51, 71, 86, 22);
			}
			{
				jManageSong = new JButton();
				getContentPane().add(jManageSong);
				jManageSong.setText("\u6b4c\u66f2\u4fe1\u606f\u7ba1\u7406");
				jManageSong.setBounds(51, 123, 86, 22);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
