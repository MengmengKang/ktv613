package com.xch.server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

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
public class ManageSongs extends javax.swing.JFrame {
	private JButton jAddSongs;
	private JButton jDeleteSongs;
	private JButton jRefreshList;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JLabel jManageSongs;
	private JButton jExit;

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
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u6b4c\u66f2\u4fe1\u606f\u7ba1\u7406");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				jAddSongs = new JButton();
				getContentPane().add(jAddSongs);
				jAddSongs.setText("\u6dfb\u52a0\u6b4c\u66f2");
				jAddSongs.setBounds(57, 256, 104, 24);
				jAddSongs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jAddSongActionPerformed(evt);
					}

					private void jAddSongActionPerformed(ActionEvent evt) {
						//System.out.println("jAddSong.actionPerformed, event="+evt);
						//TODO add your code for jAddSong.actionPerformed
							AddSongs inst = new AddSongs();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
					}
			});
			}
			{
				jDeleteSongs = new JButton();
				getContentPane().add(jDeleteSongs);
				jDeleteSongs.setText("\u5220\u9664\u6b4c\u66f2");
				jDeleteSongs.setBounds(203, 256, 103, 24);
			}
			{
				jRefreshList = new JButton();
				getContentPane().add(jRefreshList);
				jRefreshList.setText("\u66f4\u65b0\u6b4c\u66f2\u8868");
				jRefreshList.setBounds(358, 256, 105, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(517, 256, 63, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);}
			});}
			{
				jManageSongs = new JLabel();
				getContentPane().add(jManageSongs);
				jManageSongs.setText("\u6b4c\u66f2\u4fe1\u606f\u7ba1\u7406");
				jManageSongs.setBounds(285, 7, 133, 49);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(57, 55, 523, 159);
				{
					TableModel jTable1Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "歌曲ID", "歌曲名","歌曲类型","歌曲字数","歌曲拼音","歌星","歌曲存储路径" });
					jTable1 = new JTable(){
						public boolean isCellEditable(int row,int col){return false;}
					};
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
				}
			}
			pack();
			this.setSize(657, 380);
			}catch (Exception e) {
		    //add your error handling code here
		}	
		}
		private void jExitActionPerformed(ActionEvent evt) {
			//System.out.println("jExit.actionPerformed, event="+evt);
			//TODO add your code for jExit.actionPerformed
			int response=JOptionPane.showConfirmDialog(null,
					"确定要退出歌曲信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
			if(response==0) this.dispose();
	}
		
		private void thisWindowClosing(WindowEvent evt) {
			//System.out.println("this.windowClosing, event="+evt);
			//TODO add your code for this.windowClosing
			 int response=JOptionPane.showConfirmDialog(null,
						"确定要退出歌曲信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
				if(response==0) this.dispose();
				else this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
		}

}