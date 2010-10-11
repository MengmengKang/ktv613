                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      package com.xch.client;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      import java.awt.event.ActionEvent;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.xch.DAO.DA;
import com.xch.obj.SongData;


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
public class OrderByStar extends javax.swing.JFrame {
	private JButton jSearch;
	private JButton jReturn;
	private JTextField jStar;
	private JTable jResult;
	private JLabel jLabel1;
	
	private static String[] titles={"歌曲ID","歌曲拼音", "歌曲名","歌曲类型","歌手"};
	private JScrollPane jScrollPane1;
	private JButton jOrder;
	private static int elems=5;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				OrderByStar inst = new OrderByStar();
				
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public OrderByStar() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u6b4c\u661f\u70b9\u6b4c");
			{
				jSearch = new JButton();
				getContentPane().add(jSearch);
				jSearch.setText("\u67e5\u627e");
				jSearch.setBounds(260, 22, 62, 24);
				jSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jSearchActionPerformed(evt);
					}
				});
			}
			{
				jStar = new JTextField();
				getContentPane().add(jStar);
				jStar.setBounds(145, 22, 79, 24);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8bf7\u8f93\u5165\u6b4c\u661f\u540d");
				jLabel1.setBounds(35, 25, 85, 17);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(23, 57, 525, 214);
				{
					TableModel jResultModel = 
						new DefaultTableModel(
								new String[][] {},titles);
					jResult = new JTable()
					{
						public boolean isCellEditable(int row,int col){return false;}
					};
					jScrollPane1.setViewportView(jResult);
					jResult.setModel(jResultModel);
					jResult.setBounds(12, 60, 157, 191);
					jResult.setDragEnabled(true);
					jResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				}
			}
			{
				jOrder = new JButton();
				getContentPane().add(jOrder);
				jOrder.setText("\u70b9\u6b4c");
				jOrder.setBounds(358, 22, 72, 24);
				jOrder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jOrderActionPerformed(evt);
					}
				});
			}
			{
				jReturn = new JButton();
				getContentPane().add(jReturn);
				jReturn.setText("\u8fd4\u56de");
				jReturn.setBounds(463, 23, 72, 24);
				jReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jReturnActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(582, 321);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jSearchActionPerformed(ActionEvent evt) {
		//System.out.println("jSearch.actionPerformed, event="+evt);
		//TODO add your code for jSearch.actionPerformed
		String Star=jStar.getText();
		String[][] res=DA.orderByStar(Star,elems);
		TableModel jResultModel = 
			new DefaultTableModel(res,titles);
		jResult.setModel(jResultModel);
	}
	
	private void jOrderActionPerformed(ActionEvent evt) {
		//System.out.println("jOrder.actionPerformed, event="+evt);
		//TODO add your code for jOrder.actionPerformed
		int row=jResult.getSelectedRow();
		if(row<0)	
			JOptionPane.showMessageDialog(null, "您还没用选中任何一行");
		else
		{
			JOptionPane.showMessageDialog(null, "您选中了第"+(row+1)+"行" +
					"\n歌曲ID："+jResult.getValueAt(row, 0)+
					"\n歌名："+jResult.getValueAt(row, 2)+
					"\n歌手："+jResult.getValueAt(row, 4));
			
		}
	}
	
	private void jReturnActionPerformed(ActionEvent evt) {
		//System.out.println("jReturn.actionPerformed, event="+evt);
		//TODO add your code for jReturn.actionPerformed\
		this.dispose();
		MainFrame inst = new MainFrame();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

}
