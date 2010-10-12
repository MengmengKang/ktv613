package com.xch.client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;

import javax.swing.JOptionPane;
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
public class MainFrame extends javax.swing.JFrame {
	private JButton jOrderByPinyin;
	private JButton jExit;
	private JButton jOrderBySongNumber;
	private JButton jOrderByStar;
	private JButton jOrderBySongName;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u70b9\u6b4c\u754c\u9762");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				jOrderByPinyin = new JButton();
				getContentPane().add(jOrderByPinyin);
				jOrderByPinyin.setText("\u62fc\u97f3\u70b9\u6b4c");
				jOrderByPinyin.setBounds(43, 29, 93, 46);
				jOrderByPinyin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jOrderByPinyinActionPerformed(evt);
					}
				});
			}
			{
				jOrderBySongName = new JButton();
				getContentPane().add(jOrderBySongName);
				jOrderBySongName.setText("\u6b4c\u540d\u70b9\u6b4c");
				jOrderBySongName.setBounds(173, 29, 93, 46);
				jOrderBySongName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jOrderBySongNameActionPerformed(evt);
					}
				});
			}
			{
				jOrderByStar = new JButton();
				getContentPane().add(jOrderByStar);
				jOrderByStar.setText("\u6b4c\u661f\u70b9\u6b4c");
				jOrderByStar.setBounds(43, 106, 93, 46);
				jOrderByStar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jOrderByStarActionPerformed(evt);
					}
				});
			}
			{
				jOrderBySongNumber = new JButton();
				getContentPane().add(jOrderBySongNumber);
				jOrderBySongNumber.setText("\u5b57\u6570\u70b9\u6b4c");
				jOrderBySongNumber.setBounds(173, 106, 93, 46);
				jOrderBySongNumber.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jOrderBySongNumberActionPerformed(evt);
					}
				});
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(103, 182, 103, 29);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(333, 266);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jOrderByPinyinActionPerformed(ActionEvent evt) {
		//System.out.println("jOrderByPinyin.actionPerformed, event="+evt);
		//TODO add your code for jOrderByPinyin.actionPerformed
		this.dispose();
		OrderByPinyin inst = new OrderByPinyin();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	private void jOrderBySongNameActionPerformed(ActionEvent evt) {
		//System.out.println("jOrderBySongName.actionPerformed, event="+evt);
		//TODO add your code for jOrderBySongName.actionPerformed
		this.dispose();
		OrderBySongName inst = new OrderBySongName();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	private void jOrderByStarActionPerformed(ActionEvent evt) {
		//System.out.println("jOrderByStar.actionPerformed, event="+evt);
		//TODO add your code for jOrderByStar.actionPerformed
		this.dispose();
		OrderByStar inst = new OrderByStar();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	private void jOrderBySongNumberActionPerformed(ActionEvent evt) {
		//System.out.println("jOrderBySongNumber.actionPerformed, event="+evt);
		//TODO add your code for jOrderBySongNumber.actionPerformed
		this.dispose();
		OrderBySongNumber inst = new OrderBySongNumber();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	private void jExitActionPerformed(ActionEvent evt) {
		//System.out.println("jExit.actionPerformed, event="+evt);
		//TODO add your code for jExit.actionPerformed
		int response=JOptionPane.showConfirmDialog(null,
				"确定要退出KTV智能点播系统吗？", "警告", JOptionPane.YES_NO_OPTION);
		if(response==0) this.dispose();
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		//System.out.println("this.windowClosing, event="+evt);
		//TODO add your code for this.windowClosing
		int response=JOptionPane.showConfirmDialog(null,
				"确定要退出KTV智能点播系统吗？", "警告", JOptionPane.YES_NO_OPTION);
		if(response==0) this.dispose();
		else this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
	}

}
