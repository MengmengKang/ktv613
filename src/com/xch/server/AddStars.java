package com.xch.server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

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
	private JButton jConfirm;
	private JLabel jSex;
	private JLabel jAddStar;
	private JLabel jStTeam;
	private JLabel jStComeFrom;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JComboBox jComboBox1;
	private JTextField jTextField1;
	private JLabel jStarName;
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
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u6dfb\u52a0\u660e\u661f\u4fe1\u606f");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(70, 202, 84, 24);
			}
			
			{
				jStarName = new JLabel();
				getContentPane().add(jStarName);
				jStarName.setText("\u660e\u661f\u59d3\u540d");
				jStarName.setBounds(82, 42, 80, 17);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(186, 39, 93, 24);
			}
			{
				jSex = new JLabel();
				getContentPane().add(jSex);
				jSex.setText("\u6027\u522b");
				jSex.setBounds(82, 79, 48, 17);
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "男", "女" });
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(186, 75, 56, 24);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(186, 114, 93, 24);
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setBounds(186, 151, 93, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(234, 202, 97, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);
					}
				});}
			{
				jStComeFrom = new JLabel();
				getContentPane().add(jStComeFrom);
				jStComeFrom.setText("\u6e2f\u53f0\u6216\u5185\u5730");
				jStComeFrom.setBounds(82, 117, 86, 17);
			}
			{
				jStTeam = new JLabel();
				getContentPane().add(jStTeam);
				jStTeam.setText("\u660e\u661f\u7ec4\u5408");
				jStTeam.setBounds(82, 154, 80, 17);
			}
			{
				jAddStar = new JLabel();
				getContentPane().add(jAddStar);
				jAddStar.setText("\u6dfb\u52a0\u660e\u661f\u4fe1\u606f");
				jAddStar.setBounds(154, 5, 166, 23);
			}
			pack();
			setSize(400, 300);
		}catch (Exception e) {
		    //add your error handling code here
		}	
		}
		private void jExitActionPerformed(ActionEvent evt) {
			//System.out.println("jExit.actionPerformed, event="+evt);
			//TODO add your code for jExit.actionPerformed
			int response=JOptionPane.showConfirmDialog(null,
					"确定要退出添加明星界面吗？", "警告", JOptionPane.YES_NO_OPTION);
			if(response==0) this.dispose();
	}
		

		private void thisWindowClosing(WindowEvent evt) {
			//System.out.println("this.windowClosing, event="+evt);
			//TODO add your code for this.windowClosing
			int response=JOptionPane.showConfirmDialog(null,
					"确定要退出添加明星界面吗？", "警告", JOptionPane.YES_NO_OPTION);
			if(response==0) this.dispose();
			else this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			
		}

}
