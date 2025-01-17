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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.xch.DAO.DA;
import com.xch.obj.StarData;

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
public class AddStars extends javax.swing.JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JButton jConfirm;

    private JLabel jLabel4;

    private JTextField jStTeam;

    private JTextField jStComeFrom;

    private JTextField jStarName;

    private JLabel jLabel3;

    private JLabel jLabel2;

    private JLabel jLabel1;

    private JLabel jAddStar;

    private JComboBox jComboBox1;

    private JButton jExit;

    private StarData star;

    /**
     * Auto-generated main method to display this JFrame
     */
    /*
     * public static void main(String[] args) { SwingUtilities.invokeLater(new
     * Runnable() { public void run() { AddStars inst = new AddStars();
     * inst.setLocationRelativeTo(null); inst.setVisible(true); } }); }
     */
    public AddStars()
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
            setTitle("\u6dfb\u52a0\u660e\u661f\u4fe1\u606f");
            addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(final WindowEvent evt)
                {
                    thisWindowClosing(evt);
                }
            });
            {
                jConfirm = new JButton();
                getContentPane().add(jConfirm);
                jConfirm.setText("\u786e\u8ba4");
                jConfirm.setBounds(70, 202, 84, 24);
                jConfirm.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jConfirmActionPerformed(evt);
                    }
                });
            }

            {
                final ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
                        new String[]
                        { "女", "男" });
                jComboBox1 = new JComboBox();
                getContentPane().add(jComboBox1);
                jComboBox1.setModel(jComboBox1Model);
                jComboBox1.setBounds(186, 75, 56, 24);
            }
            {
                jExit = new JButton();
                getContentPane().add(jExit);
                jExit.setText("\u9000\u51fa");
                jExit.setBounds(234, 202, 97, 24);
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
                jAddStar = new JLabel();
                getContentPane().add(jAddStar);
                jAddStar.setText("\u6dfb\u52a0\u660e\u661f\u4fe1\u606f");
                jAddStar.setBounds(154, 5, 166, 23);
            }
            {
                jLabel1 = new JLabel();
                getContentPane().add(jLabel1);
                jLabel1.setText("\u660e\u661f\u59d3\u540d");
                jLabel1.setBounds(82, 43, 72, 15);
            }
            {
                jLabel2 = new JLabel();
                getContentPane().add(jLabel2);
                jLabel2.setText("\u6027\u522b");
                jLabel2.setBounds(82, 80, 72, 15);
            }
            {
                jLabel3 = new JLabel();
                getContentPane().add(jLabel3);
                jLabel3.setText("\u6e2f\u53f0\u6216\u5185\u5730");
                jLabel3.setBounds(82, 118, 72, 15);
            }
            {
                jLabel4 = new JLabel();
                getContentPane().add(jLabel4);
                jLabel4.setText("\u660e\u661f\u7ec4\u5408");
                jLabel4.setBounds(82, 155, 72, 15);
            }
            {
                jStarName = new JTextField();
                getContentPane().add(jStarName);
                jStarName.setBounds(186, 40, 93, 22);
            }
            {
                jStComeFrom = new JTextField();
                getContentPane().add(jStComeFrom);
                jStComeFrom.setBounds(186, 115, 93, 22);
            }
            {
                jStTeam = new JTextField();
                getContentPane().add(jStTeam);
                jStTeam.setBounds(186, 152, 93, 22);
            }
            pack();
            setSize(400, 300);
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
                "确定要退出添加明星界面吗？", "警告", JOptionPane.YES_NO_OPTION);
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
                "确定要退出添加明星界面吗？", "警告", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
        }
        else
        {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }

    }

    private void jConfirmActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jConfirm.actionPerformed, event="+evt);
        // TODO add your code for jConfirm.actionPerformed
        if (jStarName.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "明星姓名不能为空！");
            return;
        }
        if (DA.checkStarName(jStarName.getText()))
        {
            JOptionPane.showMessageDialog(null, "明星姓名不能重复！");
            return;
        }
        if (jStarName.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "明星姓名不能为空！");
            return;
        }

        if (jStComeFrom.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "“港台或内地”不能为空！");
            return;
        }
        if (jStTeam.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "明星组合不能为空！");
            return;
        }
        star = new StarData();
        star.setStarID(DA.getStarMaxID());
        star.setStarName(jStarName.getText());
        star.setGender(jComboBox1.getSelectedIndex());
        star.setComeFrom(jStComeFrom.getText());
        star.setTeam(jStTeam.getText());
        DA.addStar(star);
        JOptionPane.showMessageDialog(null, "明星信息添加成功！");
    }

}
