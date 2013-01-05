package com.xch.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.a
 */
public class Manage extends javax.swing.JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JButton jManageUser;

    private JLabel jMainManage;

    private JButton jExit;

    private JButton jManageAdmin;

    private JButton jManageSong;

    private JButton jManageStar;

    /**
     * Auto-generated main method to display this JFrame
     */
    /*
     * public static void main(String[] args) { SwingUtilities.invokeLater(new
     * Runnable() { public void run() { Manage inst = new Manage();
     * inst.setLocationRelativeTo(null); inst.setVisible(true); } }); }
     */
    public Manage()
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
            setTitle("\u4e3b\u7ba1\u7406\u754c\u9762");
            addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(final WindowEvent evt)
                {
                    thisWindowClosing(evt);
                }
            });
            {
                jManageUser = new JButton();
                getContentPane().add(jManageUser);
                jManageUser.setText("\u7528\u6237\u4fe1\u606f\u7ba1\u7406");
                jManageUser.setBounds(117, 107, 143, 40);
                jManageUser.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jManageUsersActionPerformed(evt);
                    }
                });
                {
                    jManageStar = new JButton();
                    getContentPane().add(jManageStar);
                    jManageStar.setText("\u660e\u661f\u4fe1\u606f\u7ba1\u7406");
                    jManageStar.setBounds(117, 163, 143, 40);
                    jManageStar.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(final ActionEvent evt)
                        {
                            jManageStarActionPerformed(evt);
                        }
                    });
                }
                {
                    jManageSong = new JButton();
                    getContentPane().add(jManageSong);
                    jManageSong.setText("\u6b4c\u66f2\u4fe1\u606f\u7ba1\u7406");
                    jManageSong.setBounds(117, 227, 143, 40);
                    jManageSong.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(final ActionEvent evt)
                        {
                            jManageSongActionPerformed(evt);
                        }
                    });
                }
                {
                    jManageAdmin = new JButton();
                    getContentPane().add(jManageAdmin);
                    jManageAdmin
                            .setText("\u7ba1\u7406\u5458\u4fe1\u606f\u7ba1\u7406");
                    jManageAdmin.setBounds(117, 44, 143, 40);
                    jManageAdmin.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(final ActionEvent evt)
                        {
                            jMainAdminActionPerformed(evt);
                        }
                    });
                }
                {
                    jExit = new JButton();
                    getContentPane().add(jExit);
                    jExit.setText("\u9000\u51fa\u7ba1\u7406\u5458\u7cfb\u7edf");
                    jExit.setBounds(117, 288, 143, 39);
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
                    jMainManage = new JLabel();
                    getContentPane().add(jMainManage);
                    jMainManage.setText("\u4e3b\u7ba1\u7406\u754c\u9762");
                    jMainManage.setBounds(158, 15, 142, 17);
                }
                pack();
                this.setSize(400, 392);
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
                "确定要退出主管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
            System.exit(0);
        }
    }

    private void jMainAdminActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jMainAdmin.actionPerformed, event="+evt);
        // TODO add your code for jMainAdmin.actionPerformed
        final ManageAdmin inst = new ManageAdmin();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

    private void jManageUsersActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jManageUsers.actionPerformed, event="+evt);
        // TODO add your code for jManageUsers.actionPerformed
        final ManageUsers inst = new ManageUsers();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

    private void jManageSongActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jManageSong.actionPerformed, event="+evt);
        // TODO add your code for jManageSong.actionPerformed
        final ManageSongs inst = new ManageSongs();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

    private void jManageStarActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jManageStar.actionPerformed, event="+evt);
        // TODO add your code for jManageStar.actionPerformed
        final ManageStars inst = new ManageStars();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);

    }

    private void thisWindowClosing(final WindowEvent evt)
    {
        // System.out.println("this.windowClosing, event="+evt);
        // TODO add your code for this.windowClosing
        final int response = JOptionPane.showConfirmDialog(null,
                "确定要退出主管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
            System.exit(0);
        }
        else
        {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

}
