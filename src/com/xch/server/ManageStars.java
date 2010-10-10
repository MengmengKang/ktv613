package com.xch.server;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListModel;

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
public class ManageStars extends javax.swing.JFrame {
	private JButton jEditMessage;
	private JButton jDeleteStars;
	private JButton jAddStars;
	private JList jStarsNames;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ManageStars inst = new ManageStars();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ManageStars() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jEditMessage = new JButton();
				getContentPane().add(jEditMessage);
				jEditMessage.setText("\u660e\u661f\u4fe1\u606f\u4fee\u6539");
				jEditMessage.setBounds(243, 50, 86, 24);
			}
			{
				ListModel jStarsNamesModel = 
					new DefaultComboBoxModel(
							new String[] { "StarName1", "StarName2","StarName3" ,"..."});
				jStarsNames = new JList();
				getContentPane().add(jStarsNames);
				jStarsNames.setModel(jStarsNamesModel);
				jStarsNames.setBounds(39, 52, 159, 161);
			}
			{
				jAddStars = new JButton();
				getContentPane().add(jAddStars);
				jAddStars.setText("\u6dfb\u52a0\u660e\u661f\u4fe1\u606f");
				jAddStars.setBounds(243, 119, 86, 24);
			}
			{
				jDeleteStars = new JButton();
				getContentPane().add(jDeleteStars);
				jDeleteStars.setText("\u5220\u9664\u660e\u661f\u4fe1\u606f");
				jDeleteStars.setBounds(243, 189, 86, 24);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
