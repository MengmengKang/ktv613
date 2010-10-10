package com.xch.server;
import java.awt.BorderLayout;
import javax.swing.JButton;
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
public class ManageAdmin extends javax.swing.JFrame {
	private JTable jAdminMessage;
	private JButton jExit;
	private JButton jConfirm;
	private JButton jDelete;
	private JButton jCorrect;
	private JButton jAdd;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ManageAdmin inst = new ManageAdmin();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ManageAdmin() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				TableModel jAdminMessageModel = 
					new DefaultTableModel(
							new String[][] { { "ID", "Password","Name", }, { "", "","","" } },
							new String[] { "Column 1", "Column 2","Column 3","Column 4" });
				jAdminMessage = new JTable();
				getContentPane().add(jAdminMessage);
				jAdminMessage.setModel(jAdminMessageModel);
				jAdminMessage.setBounds(31, 34, 317, 35);
			}
			{
				jAdd = new JButton();
				getContentPane().add(jAdd);
				jAdd.setText("\u6dfb\u52a0");
				jAdd.setBounds(31, 104, 67, 24);
			}
			{
				jCorrect = new JButton();
				getContentPane().add(jCorrect);
				jCorrect.setText("\u4fee\u6539");
				jCorrect.setBounds(158, 104, 66, 24);
			}
			{
				jDelete = new JButton();
				getContentPane().add(jDelete);
				jDelete.setText("\u5220\u9664");
				jDelete.setBounds(279, 104, 69, 24);
			}
			{
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(96, 178, 62, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(224, 178, 68, 24);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
