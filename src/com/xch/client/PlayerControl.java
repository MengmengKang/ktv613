package com.xch.client;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import com.xch.client.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import com.xch.DAO.DA;

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
public class PlayerControl extends javax.swing.JFrame {
	private JButton jPlay;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PlayerControl inst = new PlayerControl();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PlayerControl() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPlay = new JButton();
				getContentPane().add(jPlay);
				jPlay.setText("\u64ad\u653e");
				jPlay.setBounds(135, 74, 78, 26);
				jPlay.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jPlayActionPerformed(evt);
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
	
	private void jPlayActionPerformed(ActionEvent evt) {
		//System.out.println("jPlay.actionPerformed, event="+evt);
		//TODO add your code for jPlay.actionPerformed
		//new Player("lib\\test4.mpg").start();
		new MplayerDemo("lib\\test4.mpg");
	}

}
