package com.xch.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.xch.DAO.DA;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ManageAdmin extends javax.swing.JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JTable jMainAdmin;

    private JLabel jLabel1;

    private JButton jExit;

    private JButton jDelAdmin;

    private JButton jAddAdmin;

    private JScrollPane jScrollPane1;

    private JButton jRefresh;

    private JButton jEdit;

    private static String[] titles =
    { "管理员用户" };

    /**
     * Auto-generated main method to display this JFrame
     */
    /*
     * public static void main(String[] args) { SwingUtilities.invokeLater(new
     * Runnable() { public void run() { ManageAdmin inst = new ManageAdmin();
     * inst.setLocationRelativeTo(null); inst.setVisible(true); } }); }
     */

    public ManageAdmin()
    {
        super();
        initGUI();
    }

    private void initGUI()
    {
        try
        {
            setResizable(false);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);
            setTitle("\u7ba1\u7406\u5458\u4fe1\u606f\u7ba1\u7406");
            addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(final WindowEvent evt)
                {
                    thisWindowClosing(evt);
                }
            });
            {
                jEdit = new JButton();
                getContentPane().add(jEdit);
                jEdit.setText("\u7f16\u8f91");
                jEdit.setBounds(110, 206, 78, 22);
                jEdit.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jManageAdminActionPerformed(evt);
                    }
                });
            }

            {
                jLabel1 = new JLabel();
                getContentPane().add(jLabel1);
                jLabel1.setText("\u7ba1\u7406\u5458\u4fe1\u606f\u7ba1\u7406");
                jLabel1.setBounds(206, 18, 84, 15);
            }
            {
                jExit = new JButton();
                getContentPane().add(jExit);
                jExit.setText("\u9000\u51fa");
                jExit.setBounds(401, 206, 76, 22);
                jExit.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jExitActionPerformed(evt);
                    }
                });
            }
            {
                jScrollPane1 = new JScrollPane();
                getContentPane().add(jScrollPane1);
                jScrollPane1.setBounds(158, 45, 171, 148);
                {

                    // ListModel jMainAdminModel =
                    // new DefaultComboBoxModel(
                    // new String[] { "Admin1", "Admin2","..." });
                    final String[][] res = DA.listAdmin();
                    jMainAdmin = new JTable()
                    {
                        /**
                         * 
                         */
                        private static final long serialVersionUID = 1L;

                        @Override
                        public boolean isCellEditable(final int row,
                                final int col)
                        {
                            return false;
                        }
                    };
                    final TableModel jResultModel = new DefaultTableModel(res,
                            titles);
                    jMainAdmin.setModel(jResultModel);
                    jScrollPane1.setViewportView(jMainAdmin);
                    jMainAdmin.setBounds(134, 48, 115, 142);
                    jMainAdmin.setDragEnabled(true);
                    jMainAdmin.getTableHeader().setReorderingAllowed(false);
                    jMainAdmin
                            .setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                }
            }
            {
                jDelAdmin = new JButton();
                getContentPane().add(jDelAdmin);
                jDelAdmin.setText("\u5220\u9664");
                jDelAdmin.setBounds(206, 206, 76, 22);
                jDelAdmin.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jDelAdminActionPerformed(evt);
                    }
                });
            }
            {
                jAddAdmin = new JButton();
                getContentPane().add(jAddAdmin);
                jAddAdmin.setText("\u6dfb\u52a0");
                jAddAdmin.setBounds(12, 206, 78, 22);
                jAddAdmin.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jAddAdminActionPerformed(evt);
                    }
                });
            }
            {
                jRefresh = new JButton();
                getContentPane().add(jRefresh);
                jRefresh.setText("\u5237\u65b0");
                jRefresh.setBounds(304, 205, 73, 24);
                jRefresh.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jRefreshActionPerformed(evt);
                    }
                });
            }
            pack();
            this.setSize(511, 315);
        }
        catch (final Exception e)
        {
            // add your error handling code here
        }
    }

    private void jExitActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jExit.actionPerformed, event="+evt);
        // TODO add your code for jExit.actionPerformed
        final int response = JOptionPane.showConfirmDialog(null,
                "确定要退出管理员信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
        }
    }

    private void jManageAdminActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jManageAdmin.actionPerformed, event="+evt);
        // TODO add your code for jManageAdmin.actionPerformed
        final int row = jMainAdmin.getSelectedRow();
        if (row < 0)
        {
            JOptionPane.showMessageDialog(null, "您还没用选中任何一行");
            return;
        }
        final String str = jMainAdmin.getValueAt(row, 0).toString();
        final EditAdmin inst = new EditAdmin(str);
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

    private void thisWindowClosing(final WindowEvent evt)
    {
        // System.out.println("this.windowClosing, event="+evt);
        // TODO add your code for this.windowClosing
        final int response = JOptionPane.showConfirmDialog(null,
                "确定要退出管理员信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
        }
        else
        {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    private void jDelAdminActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jDelAdmin.actionPerformed, event="+evt);
        // TODO add your code for jDelAdmin.actionPerformed
        final int row = jMainAdmin.getSelectedRow();
        if (row < 0)
        {
            JOptionPane.showMessageDialog(null, "您还没用选中任何一行");
            return;
        }
        final String str = jMainAdmin.getValueAt(row, 0).toString();
        final int response = JOptionPane.showConfirmDialog(null, "确定要删除管理员用户“"
                + str + "”吗？", "警告", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            DA.delAdmin(str);
            final String[][] res = DA.listAdmin();
            final TableModel jResultModel = new DefaultTableModel(res, titles);
            jMainAdmin.setModel(jResultModel);
        }
    }

    private void jAddAdminActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jAddAdmin.actionPerformed, event="+evt);
        // TODO add your code for jAddAdmin.actionPerformed
        final AddAdmin inst = new AddAdmin();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

    private void jRefreshActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jRefresh.actionPerformed, event="+evt);
        // TODO add your code for jRefresh.actionPerformed
        final String[][] res = DA.listAdmin();
        final TableModel jResultModel = new DefaultTableModel(res, titles);
        jMainAdmin.setModel(jResultModel);
    }

}
