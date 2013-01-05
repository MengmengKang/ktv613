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
public class EditStars extends javax.swing.JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JButton jConfirm;

    private JLabel jViewStars;

    private JLabel jLabel4;

    private JLabel jLabel5;

    private JTextField jStarID;

    private JTextField jStTeam;

    private JTextField jStComeFrom;

    private JTextField jStarName;

    private JLabel jLabel3;

    private JLabel jLabel2;

    private JLabel jLabel1;

    private JComboBox jComboBox1;

    private JButton jExit;

    private final StarData star;

    /**
     * Auto-generated main method to display this JFrame
     */
    /*
     * public static void main(String[] args) { SwingUtilities.invokeLater(new
     * Runnable() { public void run() { EditStars inst = new EditStars(1);
     * inst.setLocationRelativeTo(null); inst.setVisible(true); } }); }
     */

    public EditStars(final int indata)
    {
        super();
        star = DA.getStar(indata);
        initGUI();
    }

    private void initGUI()
    {
        try
        {
            // setResizable(false);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);
            setTitle("\u4fee\u6539\u660e\u661f\u4fe1\u606f");
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
                jConfirm.setBounds(62, 225, 88, 24);
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
                jComboBox1.setModel(jComboBox1Model);
                getContentPane().add(jComboBox1);
                jComboBox1.setSelectedIndex(star.getGender());
                jComboBox1.setBounds(194, 74, 52, 24);
            }
            {
                jExit = new JButton();
                getContentPane().add(jExit);
                jExit.setText("\u9000\u51fa");
                jExit.setBounds(228, 225, 85, 24);
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
                jViewStars = new JLabel();
                getContentPane().add(jViewStars);
                jViewStars.setText("\u4fee\u6539\u660e\u661f\u4fe1\u606f");
                jViewStars.setBounds(153, 23, 131, 17);
            }
            {
                jLabel1 = new JLabel();
                getContentPane().add(jLabel1);
                jLabel1.setText("\u660e\u661f\u59d3\u540d");
                jLabel1.setBounds(92, 46, 76, 15);
            }
            {
                jLabel2 = new JLabel();
                getContentPane().add(jLabel2);
                jLabel2.setText("\u6027\u522b");
                jLabel2.setBounds(92, 79, 76, 15);
            }
            {
                jLabel3 = new JLabel();
                getContentPane().add(jLabel3);
                jLabel3.setText("\u6e2f\u53f0\u6216\u5185\u5730");
                jLabel3.setBounds(92, 114, 84, 15);
            }
            {
                jLabel4 = new JLabel();
                getContentPane().add(jLabel4);
                jLabel4.setText("\u660e\u661f\u7ec4\u5408");
                jLabel4.setBounds(92, 147, 76, 15);
            }
            {
                jStarName = new JTextField();
                jStarName.setText(star.getStarName());
                getContentPane().add(jStarName);
                jStarName.setBounds(194, 46, 97, 22);
            }
            {
                jStComeFrom = new JTextField();
                getContentPane().add(jStComeFrom);
                jStComeFrom.setText(star.getComeFrom());
                jStComeFrom.setBounds(194, 111, 97, 22);
            }
            {
                jStTeam = new JTextField();
                getContentPane().add(jStTeam);
                jStTeam.setText(star.getTeam());
                jStTeam.setBounds(194, 144, 97, 22);
            }
            {
                jLabel5 = new JLabel();
                getContentPane().add(jLabel5);
                jLabel5.setText("\u6b4c\u661fID");
                jLabel5.setBounds(92, 179, 84, 17);
            }
            {
                jStarID = new JTextField();
                getContentPane().add(jStarID);
                jStarID.setText(String.valueOf(star.getStarID()));
                jStarID.setBounds(194, 176, 97, 24);
                jStarID.setEditable(false);
            }
            pack();
            this.setSize(400, 315);
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
                "确定要退出修改明星信息界面吗？", "警告", JOptionPane.YES_NO_OPTION);
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
                "确定要退出修改明星信息界面吗？", "警告", JOptionPane.YES_NO_OPTION);
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
        star.setStarName(jStarName.getText());
        star.setGender(jComboBox1.getSelectedIndex());
        star.setComeFrom(jStComeFrom.getText());
        star.setTeam(jStTeam.getText());
        DA.modifyStar(star);
        JOptionPane.showMessageDialog(null, "明星信息修改成功！");
    }

}
