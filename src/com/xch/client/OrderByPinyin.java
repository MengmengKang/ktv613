                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      package com.xch.client;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      import java.awt.event.ActionEvent;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
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
public class OrderByPinyin extends javax.swing.JFrame {
	private JButton jSearch;
	private JTextField jPinyin;
	private JTable jResult;
	private JLabel jLabel1;
	
	private static String[] titles={"∏Ë«˙ID","∏Ë«˙∆¥“Ù", "∏Ë«˙√˚","∏Ë«˙¿‡–Õ","∏Ë ÷"};
	private JScrollPane jScrollPane1;
	private static int elems=5;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				OrderByPinyin inst = new OrderByPinyin();
				
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public OrderByPinyin() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u62fc\u97f3\u70b9\u6b4c");
			{
				jSearch = new JButton();
				getContentPane().add(jSearch);
				jSearch.setText("\u67e5\u627e");
				jSearch.setBounds(327, 22, 62, 24);
				jSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jSearchActionPerformed(evt);
					}
				});
			}
			{
				jPinyin = new JTextField();
				getContentPane().add(jPinyin);
				jPinyin.setBounds(170, 22, 79, 24);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8bf7\u8f93\u5165\u62fc\u97f3");
				jLabel1.setBounds(97, 25, 72, 17);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(38, 54, 483, 197);
				{
					TableModel jResultModel = 
						new DefaultTableModel(
								new String[][] {},titles);
					jResult = new JTable()
					{
						public boolean isCellEditable(int row,int col){return false;}
					};
					jScrollPane1.setViewportView(jResult);
					jScrollPane1.s
					jResult.setModel(jResultModel);
					jResult.setBounds(12, 60, 157, 191);
					jResult.setDragEnabled(true);
					jResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				}
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
		String pinyin=jPinyin.getText();
		String[][] res=DA.orderByPinyin(pinyin,elems);
		TableModel jResultModel = 
			new DefaultTableModel(res,titles);
		jResult.setModel(jResultModel);
	}

}
