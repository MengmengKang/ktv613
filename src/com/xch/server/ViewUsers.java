package com.xch.server;
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
public class ViewUsers extends javax.swing.JFrame {
	private JTable jUsersMessage;
	private JButton jConfirm;
	private JButton jExit;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ViewUsers inst = new ViewUsers();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ViewUsers() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				TableModel jUsersMessageModel = 
					new DefaultTableModel(
							new String[][] { { "ID", "Password","Name","Sex","Age" }, { "", "","" } },
							new String[] { "Column 1", "Column 2" ,"Column 3","Column 4","Column5"});
				jUsersMessage = new JTable();
				getContentPane().add(jUsersMessage);
				jUsersMessage.setModel(jUsersMessageModel);
				jUsersMessage.setBounds(26, 21, 346, 64);
			}
			{
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(97, 136, 65, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(218, 136, 63, 24);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
