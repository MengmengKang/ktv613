package com.xch.server;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
public class AddSongs extends javax.swing.JFrame {
	private JLabel jAddSongs;
	private JButton jConfirm;
	private JButton jCancel;
	private JTextField jSongName;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddSongs inst = new AddSongs();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AddSongs() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jAddSongs = new JLabel();
				getContentPane().add(jAddSongs);
				jAddSongs.setText("\u6dfb\u52a0\u6b4c\u66f2");
				jAddSongs.setBounds(26, 45, 74, 17);
			}
			{
				jSongName = new JTextField();
				getContentPane().add(jSongName);
				jSongName.setBounds(118, 42, 216, 24);
			}
			{
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(74, 153, 95, 24);
			}
			{
				jCancel = new JButton();
				getContentPane().add(jCancel);
				jCancel.setText("\u53d6\u6d88");
				jCancel.setBounds(225, 153, 109, 24);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
