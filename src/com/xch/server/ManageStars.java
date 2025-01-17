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
public class ManageStars extends javax.swing.JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JButton jEditMessage;

    private JScrollPane jScrollPane1;

    private JButton jRefresh;

    private JLabel jManageStars;

    private JButton jExit;

    private JButton jDeleteStars;

    private JButton jAddStars;

    private JTable jStarsNames;

    private static String[] titles =
    { "明星ID", "明星姓名", "性别", "港台或内地", "明星组合" };

    /**
     * Auto-generated main method to display this JFrame
     */
    /*
     * public static void main(String[] args) { SwingUtilities.invokeLater(new
     * Runnable() { public void run() { ManageStars inst = new ManageStars();
     * inst.setLocationRelativeTo(null); inst.setVisible(true); } }); }
     */
    public ManageStars()
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
            setTitle("\u660e\u661f\u4fe1\u606f\u7ba1\u7406");
            addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(final WindowEvent evt)
                {
                    thisWindowClosing(evt);
                }
            });
            {
                jEditMessage = new JButton();
                getContentPane().add(jEditMessage);
                jEditMessage.setText("\u660e\u661f\u4fe1\u606f\u4fee\u6539");
                jEditMessage.setBounds(178, 232, 128, 24);
                jEditMessage.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jEditMessageActionPerformed(evt);
                    }

                    private void jViewStarsActionPerformed(final ActionEvent evt)
                    {
                        // System.out.println("jViewStars.actionPerformed, event="+evt);
                        // TODO add your code for jViewStars.actionPerformed
                        final ManageStars inst = new ManageStars();
                        inst.setLocationRelativeTo(null);
                        inst.setVisible(true);
                    }
                });
                {
                    jAddStars = new JButton();
                    getContentPane().add(jAddStars);
                    jAddStars.setText("\u6dfb\u52a0\u660e\u661f\u4fe1\u606f");
                    jAddStars.setBounds(39, 231, 134, 24);
                    jAddStars.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(final ActionEvent evt)
                        {
                            jAddStarsActionPerformed(evt);
                        }

                        private void jAddStarsActionPerformed(
                                final ActionEvent evt)
                        {
                            // System.out.println("jAddStars.actionPerformed, event="+evt);
                            // TODO add your code for jAddStars.actionPerformed
                            final AddStars inst = new AddStars();
                            inst.setLocationRelativeTo(null);
                            inst.setVisible(true);
                        }
                    });
                    {
                        jDeleteStars = new JButton();
                        getContentPane().add(jDeleteStars);
                        jDeleteStars
                                .setText("\u5220\u9664\u660e\u661f\u4fe1\u606f");
                        jDeleteStars.setBounds(311, 232, 134, 24);
                        jDeleteStars.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(final ActionEvent evt)
                            {
                                jDeleteStarsActionPerformed(evt);
                            }
                        });
                    }
                    {
                        jExit = new JButton();
                        getContentPane().add(jExit);
                        jExit.setText("\u9000\u51fa");
                        jExit.setBounds(578, 232, 62, 24);
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
                        jManageStars = new JLabel();
                        getContentPane().add(jManageStars);
                        jManageStars
                                .setText("\u660e\u661f\u4fe1\u606f\u7ba1\u7406");
                        jManageStars.setBounds(301, 25, 198, 17);
                    }
                    {
                        jRefresh = new JButton();
                        getContentPane().add(jRefresh);
                        jRefresh.setText("\u66f4\u65b0\u660e\u661f\u4fe1\u606f");
                        jRefresh.setBounds(450, 233, 123, 22);
                        jRefresh.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(final ActionEvent evt)
                            {
                                jRefreshActionPerformed(evt);
                            }
                        });
                    }
                    {
                        jScrollPane1 = new JScrollPane();
                        getContentPane().add(jScrollPane1);
                        jScrollPane1.setBounds(40, 50, 600, 170);
                        {
                            final String[][] res = DA.listStar();
                            jStarsNames = new JTable()
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
                            jScrollPane1.setViewportView(jStarsNames);
                            final TableModel jStarsNamesModel = new DefaultTableModel(
                                    res, titles);
                            jStarsNames.setModel(jStarsNamesModel);
                            jStarsNames.setBounds(73, 121, 601, 122);
                            jStarsNames.setDragEnabled(true);
                            jStarsNames.getTableHeader().setReorderingAllowed(
                                    false);
                            jStarsNames
                                    .setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        }
                    }
                    pack();
                    this.setSize(700, 349);
                }
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
                "确定要退出明星信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
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
                "确定要退出明星信息管理界面吗？", "警告", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
        }
        else
        {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    private void jEditMessageActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jEditMessage.actionPerformed, event="+evt);
        // TODO add your code for jEditMessage.actionPerformed
        final int row = jStarsNames.getSelectedRow();
        if (row < 0)
        {
            JOptionPane.showMessageDialog(null, "您还没用选中任何一行");
            return;
        }
        final int starid = Integer.parseInt(jStarsNames.getValueAt(row, 0)
                .toString());
        final EditStars inst = new EditStars(starid);
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

    private void jRefreshActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jRefresh.actionPerformed, event="+evt);
        // TODO add your code for jRefresh.actionPerformed
        final String[][] res = DA.listStar();
        final TableModel jStarsNamesModel = new DefaultTableModel(res, titles);
        jStarsNames.setModel(jStarsNamesModel);
    }

    private void jDeleteStarsActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jDeleteStars.actionPerformed, event="+evt);
        // TODO add your code for jDeleteStars.actionPerformed
        final int row = jStarsNames.getSelectedRow();
        if (row < 0)
        {
            JOptionPane.showMessageDialog(null, "您还没用选中任何一行");
            return;
        }
        final int response = JOptionPane.showConfirmDialog(null, "确定要删除歌星"
                + jStarsNames.getValueAt(row, 1)
                + "的相关信息吗？\n该歌星的所有歌曲信息将会一并被删除！！！", "警告",
                JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            DA.delStar(Integer.parseInt(jStarsNames.getValueAt(row, 0)
                    .toString()));
            final String[][] res = DA.listStar();
            final TableModel jStarsNamesModel = new DefaultTableModel(res,
                    titles);
            jStarsNames.setModel(jStarsNamesModel);
        }
    }

}