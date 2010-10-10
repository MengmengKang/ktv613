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
public class ManageSongs extends javax.swing.JFrame {
	private JButton jAddSongs;
	private JButton jDeleteSongs;
	private JButton jRefreshList;
	private JList jSongList;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ManageSongs inst = new ManageSongs();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ManageSongs() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jAddSongs = new JButton();
				getContentPane().add(jAddSongs);
				jAddSongs.setText("\u6dfb\u52a0\u6b4c\u66f2");
				jAddSongs.setBounds(45, 199, 62, 24);
			}
			{
				jDeleteSongs = new JButton();
				getContentPane().add(jDeleteSongs);
				jDeleteSongs.setText("\u5220\u9664\u6b4c\u66f2");
				jDeleteSongs.setBounds(156, 199, 62, 24);
			}
			{
				jRefreshList = new JButton();
				getContentPane().add(jRefreshList);
				jRefreshList.setText("\u66f4\u65b0\u6b4c\u66f2\u8868");
				jRefreshList.setBounds(268, 199, 74, 24);
			}
			{
				ListModel jSongListModel = 
					new DefaultComboBoxModel(
							new String[] { "Song1", "Song2","Song3","..." });
				jSongList = new JList();
				getContentPane().add(jSongList);
				jSongList.setModel(jSongListModel);
				jSongList.setBounds(107, 18, 169, 169);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
