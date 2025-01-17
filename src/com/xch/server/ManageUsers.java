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
public class ManageUsers extends javax.swing.JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final JButton eGViewUsers = null;

    private JButton RefreshMessage;

    private JButton jViewUsers;

    private JScrollPane jScrollPane1;

    private JTable jUser;

    private JLabel jManageUsers;

    private JButton jExit;

    private JButton jRefreshMessage;

    private JButton jDeleteUsers;

    private static String[] titles =
    { "用户ID", "用户名", "真实姓名", "电子邮件", "性别", "喜欢的歌" };

    /**
     * Auto-generated main method to display this JFrame
     */
    /*
     * public static void main(String[] args) { SwingUtilities.invokeLater(new
     * Runnable() { public void run() { ManageUsers inst = new ManageUsers();
     * inst.setLocationRelativeTo(null); inst.setVisible(true); } }); }
     */
    public ManageUsers()
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
            setTitle("\u7528\u6237\u4fe1\u606f\u7ba1\u7406");
            addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(final WindowEvent evt)
                {
                    thisWindowClosing(evt);
                }
            });

            {
                jViewUsers = new JButton();
                getContentPane().add(jViewUsers);
                jViewUsers.setText("\u4fee\u6539\u7528\u6237\u4fe1\u606f");
                jViewUsers.setBounds(42, 244, 126, 24);
                jViewUsers.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jViewUsersActionPerformed(evt);
                    }

                    private void jViewUsersActionPerformed(final ActionEvent evt)
                    {
                        // System.out.println("jViewUsers.actionPerformed, event="+evt);
                        // TODO add your code for jViewUsers.actionPerformed
                        final int row = jUser.getSelectedRow();
                        if (row < 0)
                        {
                            JOptionPane.showMessageDialog(null, "您还没用选中任何一行");
                            return;
                        }
                        final int userid = Integer.parseInt(jUser.getValueAt(
                                row, 0).toString());
                        final EditUsers inst = new EditUsers(userid);
                        inst.setLocationRelativeTo(null);
                        inst.setVisible(true);
                    }
                });
                {
                    jDeleteUsers = new JButton();
                    getContentPane().add(jDeleteUsers);
                    jDeleteUsers
                            .setText("\u5220\u9664\u7528\u6237\u4fe1\u606f");
                    jDeleteUsers.setBounds(197, 244, 130, 24);
                    jDeleteUsers.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(final ActionEvent evt)
                        {
                            jDeleteUsersActionPerformed(evt);
                        }
                    });
                }
                {
                    jRefreshMessage = new JButton();
                    getContentPane().add(jRefreshMessage);
                    jRefreshMessage
                            .setText("\u66f4\u65b0\u7528\u6237\u4fe1\u606f");
                    jRefreshMessage.setBounds(358, 244, 130, 24);
                    jRefreshMessage.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(final ActionEvent evt)
                        {
                            jRefreshMessageActionPerformed(evt);
                        }
                    });
                }
                {
                    jExit = new JButton();
                    getContentPane().add(jExit);
                    jExit.setText("\u9000\u51fa");
                    jExit.setBounds(523, 244, 62, 24);
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
                    jManageUsers = new JLabel();
                    getContentPane().add(jManageUsers);
                    jManageUsers
                            .setText("\u7528\u6237\u4fe1\u606f\u7ba1\u7406");
                    jManageUsers.setBounds(273, 22, 202, 17);
                }
                {
                    jScrollPane1 = new JScrollPane();
                    getContentPane().add(jScrollPane1);
                    jScrollPane1.setBounds(23, 51, 582, 181);
                    {
                        final String[][] res = DA.listUser();
                        final TableModel jUserModel = new DefaultTableModel(
                                res, titles);
                        jUser = new JTable()
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
                        jScrollPane1.setViewportView(jUser);
                        jUser.setModel(jUserModel);
                        jUser.setBounds(232, 68, 140, 73);
                        jUser.setDragEnabled(true);
                        jUser.getTableHeader().setReorderingAllowed(false);
                        jUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    }
                }
                pack();
                setSize(653, 363);
            }
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
                "确定要退出用户信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
        }
    }

    private void thisWindowClosing(final WindowEvent evt)
    {
        // System.out.println("this.windowClosing, event="+evt);
        // TODO add your code for this.windowClosing
        final int response = JOptionPane.showConfirmDialog(null,
                "确定要退出用户信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
        }
        else
        {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    private void jDeleteUsersActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jDeleteUsers.actionPerformed, event="+evt);
        // TODO add your code for jDeleteUsers.actionPerformed
        final int row = jUser.getSelectedRow();
        if (row < 0)
        {
            JOptionPane.showMessageDialog(null, "您还没用选中任何一行");
            return;
        }
        final int response = JOptionPane.showConfirmDialog(null, "确定要删除用户"
                + jUser.getValueAt(row, 1) + "的相关信息吗？", "警告",
                JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            DA.delUser(Integer.parseInt(jUser.getValueAt(row, 0).toString()));
            final String[][] res = DA.listUser();
            final TableModel jStarsNamesModel = new DefaultTableModel(res,
                    titles);
            jUser.setModel(jStarsNamesModel);
        }
    }

    private void jRefreshMessageActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jRefreshMessage.actionPerformed, event="+evt);
        // TODO add your code for jRefreshMessage.actionPerformed
        final String[][] res = DA.listUser();
        final TableModel jStarsNamesModel = new DefaultTableModel(res, titles);
        jUser.setModel(jStarsNamesModel);
    }

}