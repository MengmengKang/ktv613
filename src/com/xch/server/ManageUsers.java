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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

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
public class ManageUsers extends javax.swing.JFrame {
	private static final JButton eGViewUsers = null;
	private JButton RefreshMessage;
	private JButton jViewUsers;
	private JScrollPane jScrollPane1;
	private JTable jUser;
	private JLabel jManageUsers;
	private JButton jExit;
	private JButton jRefreshMessage;
	private JButton jDeleteUsers;
	private static String[] titles={"�û�ID", "�û���","��ʵ����","�����ʼ�","�Ա�","ϲ���ĸ�"};
	/**
	* Auto-generated main method to display this JFrame
	*/
	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ManageUsers inst = new ManageUsers();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	*/
	public ManageUsers() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u7528\u6237\u4fe1\u606f\u7ba1\u7406");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});

			{
				jViewUsers = new JButton();
				getContentPane().add(jViewUsers);
				jViewUsers.setText("\u4fee\u6539\u7528\u6237\u4fe1\u606f");
				jViewUsers.setBounds(42, 244, 126, 24);
				jViewUsers.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jViewUsersActionPerformed(evt);
					}

					private void jViewUsersActionPerformed(ActionEvent evt) {
						//System.out.println("jViewUsers.actionPerformed, event="+evt);
						//TODO add your code for jViewUsers.actionPerformed
						int row=jUser.getSelectedRow();		
						if(row<0)
						{
							JOptionPane.showMessageDialog(null, "����û��ѡ���κ�һ��");
							return ;
						}
						int userid=Integer.parseInt(jUser.getValueAt(row, 0).toString());
						EditUsers inst = new EditUsers(userid);
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}
			});
			{
				jDeleteUsers = new JButton();
				getContentPane().add(jDeleteUsers);
				jDeleteUsers.setText("\u5220\u9664\u7528\u6237\u4fe1\u606f");
				jDeleteUsers.setBounds(197, 244, 130, 24);
				jDeleteUsers.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jDeleteUsersActionPerformed(evt);
					}
				});
			}
			{
				jRefreshMessage = new JButton();
				getContentPane().add(jRefreshMessage);
				jRefreshMessage.setText("\u66f4\u65b0\u7528\u6237\u4fe1\u606f");
				jRefreshMessage.setBounds(358, 244, 130, 24);
				jRefreshMessage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRefreshMessageActionPerformed(evt);
					}
				});
			}
			{
				jExit = new JButton();
				getContentPane().add(jExit);
				jExit.setText("\u9000\u51fa");
				jExit.setBounds(523, 244, 62, 24);
				jExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jExitActionPerformed(evt);}
			});}
			{
				jManageUsers = new JLabel();
				getContentPane().add(jManageUsers);
				jManageUsers.setText("\u7528\u6237\u4fe1\u606f\u7ba1\u7406");
				jManageUsers.setBounds(273, 22, 202, 17);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(23, 51, 582, 181);
				{
					String[][] res=DA.listUser();
					TableModel jUserModel = 
						new DefaultTableModel(res,titles);
					jUser = new JTable(){
						public boolean isCellEditable(int row,int col){return false;}
					};
					jScrollPane1.setViewportView(jUser);
					jUser.setModel(jUserModel);
					jUser.setBounds(232, 68, 140, 73);
					//jUser.setPreferredSize(new java.awt.Dimension(489, 142));
					jUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				}
			}
			pack();
			setSize(653, 363);
			}}catch (Exception e) {
		    //add your error handling code here
		}	
		}
		private void jExitActionPerformed(ActionEvent evt) {
			//System.out.println("jExit.actionPerformed, event="+evt);
			//TODO add your code for jExit.actionPerformed
			int response=JOptionPane.showConfirmDialog(null,
					"ȷ��Ҫ�˳��û���Ϣ���������", "����", JOptionPane.YES_NO_OPTION);
			if(response==0) this.dispose();
	}
		
		private void thisWindowClosing(WindowEvent evt) {
			//System.out.println("this.windowClosing, event="+evt);
			//TODO add your code for this.windowClosing
			 int response=JOptionPane.showConfirmDialog(null,
						"ȷ��Ҫ�˳��û���Ϣ���������", "����", JOptionPane.YES_NO_OPTION);
				if(response==0) this.dispose();
				else this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
		}
		
		private void jDeleteUsersActionPerformed(ActionEvent evt) {
			//System.out.println("jDeleteUsers.actionPerformed, event="+evt);
			//TODO add your code for jDeleteUsers.actionPerformed
			int row=jUser.getSelectedRow();		
			if(row<0)
			{
				JOptionPane.showMessageDialog(null, "����û��ѡ���κ�һ��");
				return ;
			}
			int response=JOptionPane.showConfirmDialog(null,
					"ȷ��Ҫɾ���û�"+jUser.getValueAt(row,1)+"�������Ϣ��", "����", JOptionPane.YES_NO_OPTION);
			if(response==0) 
			{
				DA.delUser(Integer.parseInt(jUser.getValueAt(row,0).toString()));
				String[][] res=DA.listUser();
				TableModel jStarsNamesModel = 
					new DefaultTableModel(res,titles);
				jUser.setModel(jStarsNamesModel);
			}
		}
		
		private void jRefreshMessageActionPerformed(ActionEvent evt) {
			//System.out.println("jRefreshMessage.actionPerformed, event="+evt);
			//TODO add your code for jRefreshMessage.actionPerformed
			String[][] res=DA.listUser();
			TableModel jStarsNamesModel = 
				new DefaultTableModel(res,titles);
			jUser.setModel(jStarsNamesModel);
		}

}