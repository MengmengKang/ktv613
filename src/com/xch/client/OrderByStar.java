                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      package com.xch.client;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      import java.awt.Color;
import java.awt.event.ActionEvent;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      import java.awt.event.ActionListener;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      import java.awt.event.WindowAdapter;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				OrderByStar inst = new OrderByStar();
				
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	*/
	public OrderByStar() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setBak();
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u6b4c\u661f\u70b9\u6b4c");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
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
				jLabel1.setBounds(23, 26, 85, 17);
				jLabel1.setForeground(Color.RED);
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
					jResult.getTableHeader().setReorderingAllowed(false);
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
		{
			JOptionPane.showMessageDialog(null, "您还没用选中任何一行");
			return ;
		}
		int SongID=Integer.parseInt(jResult.getValueAt(row, 0).toString());
		String url=DA.getSongURL(SongID);
		String name=jResult.getValueAt(row, 2).toString()+"（"+
					jResult.getValueAt(row, 4)+"）";
		
		System.out.println(url);
		
		if(MainFrame.playing) Player.addPlay(name,url);
		else {
			Player.video();
			String str=SongList.getSongURL();
			if(str.compareTo("ERROR")==0)
				Player.play(url);
			else {
				Player.addPlay(name, url);
				Player.play(str);
			}
			new Bottom();
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
	
	private void thisWindowClosing(WindowEvent evt) {
		//System.out.println("this.windowClosing, event="+evt);
		//TODO add your code for this.windowClosing
		int response=JOptionPane.showConfirmDialog(null,
				"确定要退出KTV智能点播系统吗？", "警告", JOptionPane.YES_NO_OPTION);
		if(response==0) this.dispose();
		else this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
	}
	public void setBak(){ 
		  ((JPanel)this.getContentPane()).setOpaque(false);
		   ImageIcon img = new ImageIcon("img/p4.jpg"); 
		   JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
		   background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 
		  }
}
