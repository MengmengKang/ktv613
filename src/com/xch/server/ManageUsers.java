package com.xch.server;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class ManageUsers extends javax.swing.JFrame {
	private static final JButton eGViewUsers = null;
	private JButton RefreshMessage;
	private JButton jViewUsers;
	private JButton jRefreshMessage;
	private JButton jDeleteUsers;
	private JTable jUserID;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ManageUsers inst = new ManageUsers();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ManageUsers() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				RefreshMessage = new JButton();
				getContentPane().add(jRefreshMessage);
				RefreshMessage.setText("\u66f4\u65b0\u7528\u6237\u4fe1\u606f");
				RefreshMessage.setBounds(243, 196, 86, 24);
			}
			{
				TableModel jUserIDModel = 
					new DefaultTableModel(
							new String[][]  {{ "UseID", "UseName" }} ,
							new String[] { "Column 1", "Column 2" });
				jUserID = new JTable();
				getContentPane().add(jUserID);
				jUserID.setModel(jUserIDModel);
				jUserID.setBounds(30, 42, 164, 178);
			}
			{
				jViewUsers = new JButton();
				getContentPane().add(jViewUsers);
				jViewUsers.setText("\u67e5\u770b\u7528\u6237\u4fe1\u606f");
				jViewUsers.setBounds(243, 42, 86, 24);
			}
			{
				jDeleteUsers = new JButton();
				getContentPane().add(jDeleteUsers);
				jDeleteUsers.setText("\u5220\u9664\u7528\u6237\u4fe1\u606f");
				jDeleteUsers.setBounds(243, 116, 86, 24);
			}
			{
				jRefreshMessage = new JButton();
				getContentPane().add(jRefreshMessage);
				jRefreshMessage.setText("\u66f4\u65b0\u7528\u6237\u4fe1\u606f");
				jRefreshMessage.setBounds(243, 189, 86, 24);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
}

