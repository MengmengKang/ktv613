package com.xch.server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
public class ViewStars extends javax.swing.JFrame {
	private JButton jConfirm;
	private JLabel jSex;
	private JLabel jViewStars;
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
				ViewStars inst = new ViewStars();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ViewStars() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jConfirm = new JButton();
				getContentPane().add(jConfirm);
				jConfirm.setText("\u786e\u8ba4");
				jConfirm.setBounds(62, 225, 88, 24);
			}
			
			{
				jStarName = new JLabel();
				getContentPane().add(jStarName);
				jStarName.setText("\u660e\u661f\u59d3\u540d");
				jStarName.setBounds(92, 68, 76, 17);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(194, 65, 97, 24);
			}
			{
				jSex = new JLabel();
				getContentPane().add(jSex);
				jSex.setText("\u6027\u522b");
				jSex.setBounds(92, 109, 46, 17);
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "ÄÐ", "Å®" });
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(194, 105, 52, 24);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(194, 141, 97, 24);
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setBounds(194, 180, 97, 24);
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(228, 225, 85, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);}
			});}
			{
				jStComeFrom = new JLabel();
				getContentPane().add(jStComeFrom);
				jStComeFrom.setText("\u6e2f\u53f0\u6216\u5185\u5730");
				jStComeFrom.setBounds(92, 144, 76, 17);
			}
			{
				jStTeam = new JLabel();
				getContentPane().add(jStTeam);
				jStTeam.setText("\u660e\u661f\u7ec4\u5408");
				jStTeam.setBounds(92, 183, 76, 17);
			}
			{
				jViewStars = new JLabel();
				getContentPane().add(jViewStars);
				jViewStars.setText("\u4fee\u6539\u660e\u661f\u4fe1\u606f");
				jViewStars.setBounds(153, 23, 131, 17);
			}
			pack();
			this.setSize(400, 315);
		}catch (Exception e) {
		    //add your error handling code here
		}	
		}
		private void jExitActionPerformed(ActionEvent evt) {
			//System.out.println("jExit.actionPerformed, event="+evt);
			//TODO add your code for jExit.actionPerformed
			this.dispose();
	}

}
