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
	private JButton jRefresh;
	private JLabel jManageStars;
	private JButton jExit;
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
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u660e\u661f\u4fe1\u606f\u7ba1\u7406");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				jEditMessage = new JButton();
				getContentPane().add(jEditMessage);
				jEditMessage.setText("\u660e\u661f\u4fe1\u606f\u4fee\u6539");
				jEditMessage.setBounds(39, 232, 128, 24);
				jEditMessage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jViewStarsActionPerformed(evt);
					}

					private void jViewStarsActionPerformed(ActionEvent evt) {
						//System.out.println("jViewStars.actionPerformed, event="+evt);
						//TODO add your code for jViewStars.actionPerformed
							ViewStars inst = new ViewStars();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
					}
			});
			{
				ListModel jStarsNamesModel = 
					new DefaultComboBoxModel(
							new String[] { "StarName1", "StarName2","StarName3" ,"..."});
				jStarsNames = new JList();
				getContentPane().add(jStarsNames);
				jStarsNames.setModel(jStarsNamesModel);
				jStarsNames.setBounds(39, 73, 601, 122);
			}
			{
				jAddStars = new JButton();
				getContentPane().add(jAddStars);
				jAddStars.setText("\u6dfb\u52a0\u660e\u661f\u4fe1\u606f");
				jAddStars.setBounds(172, 232, 134, 24);
				jAddStars.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jAddStarsActionPerformed(evt);
					}

					private void jAddStarsActionPerformed(ActionEvent evt) {
						//System.out.println("jAddStars.actionPerformed, event="+evt);
						//TODO add your code for jAddStars.actionPerformed
							AddStars inst = new AddStars();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
					}
			});
			{
				jDeleteStars = new JButton();
				getContentPane().add(jDeleteStars);
				jDeleteStars.setText("\u5220\u9664\u660e\u661f\u4fe1\u606f");
				jDeleteStars.setBounds(311, 232, 134, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(578, 232, 62, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);}
			});}
			{
				jManageStars = new JLabel();
				getContentPane().add(jManageStars);
				jManageStars.setText("\u660e\u661f\u4fe1\u606f\u7ba1\u7406");
				jManageStars.setBounds(301, 25, 198, 17);
			}
			{
				jRefresh = new JButton();
				getContentPane().add(jRefresh);
				jRefresh.setText("\u66f4\u65b0\u660e\u661f\u4fe1\u606f");
				jRefresh.setBounds(450, 233, 123, 22);
			}
			pack();
			this.setSize(700, 349);
			}}}catch (Exception e) {
		    //add your error handling code here
		}	
		}
		private void jExitActionPerformed(ActionEvent evt) {
			//System.out.println("jExit.actionPerformed, event="+evt);
			//TODO add your code for jExit.actionPerformed
			int response=JOptionPane.showConfirmDialog(null,
					"确定要退出明星信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
			if(response==0) this.dispose();
	}
		
		private void thisWindowClosing(WindowEvent evt) {
			//System.out.println("this.windowClosing, event="+evt);
			//TODO add your code for this.windowClosing
			 int response=JOptionPane.showConfirmDialog(null,
						"确定要退出明星信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
				if(response==0) this.dispose();
				else this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
		}

}