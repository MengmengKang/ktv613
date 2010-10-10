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
public class AddStars extends javax.swing.JFrame {
	private JTable jStarMessage;
	private JButton jConfirm;
	private JButton jExit;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddStars inst = new AddStars();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AddStars() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				TableModel jStarMessageModel = 
					new DefaultTableModel(
							new String[][] { { "One", "Two" }, { "Three", "Four" } },
							new String[] { "Column 1", "Column 2" });
				jStarMessage = new JTable();
				getContentPane().add(jStarMessage);
				jStarMessage.setModel(jStarMessageModel);
				jStarMessage.setBounds(41, 27, 317, 39);
			}
			{
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(70, 163, 84, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(236, 163, 97, 24);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
