package com.xch.client;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

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
public class MainFrame extends javax.swing.JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JButton jOrderByPinyin;

    private JButton jExit;

    private JButton jOrderBySongNumber;

    private JButton jOrderByStar;

    private JButton jOrderBySongName;

    public static boolean playing = false;

    /**
     * Auto-generated main method to display this JFrame
     */
    /*
     * public static void main(String[] args) { SwingUtilities.invokeLater(new
     * Runnable() { public void run() { MainFrame inst = new MainFrame();
     * inst.setLocationRelativeTo(null); inst.setVisible(true); } }); }
     */
    public MainFrame()
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

            setBak();
            final Container c = getContentPane(); // 获取JFrame面板
            c.setBounds(28, -29, 792, 566);
            final JPanel jp = new JPanel(); // 创建个JPanel
            jp.setOpaque(false); // 把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
            c.add(jp);
            {
                jExit = new JButton();
                c.add(jExit);
                jExit.setText("\u9000\u51fa");
                jExit.setBounds(334, 491, 103, 29);
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
                jOrderBySongName = new JButton();
                c.add(jOrderBySongName);
                jOrderBySongName.setText("\u6b4c\u540d\u70b9\u6b4c");
                jOrderBySongName.setBounds(480, 66, 200, 100);
                jOrderBySongName.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jOrderBySongNameActionPerformed(evt);
                    }
                });
            }
            {
                jOrderByPinyin = new JButton();
                c.add(jOrderByPinyin);
                jOrderByPinyin.setText("\u62fc\u97f3\u70b9\u6b4c");
                jOrderByPinyin.setBounds(93, 66, 200, 100);
                jOrderByPinyin.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jOrderByPinyinActionPerformed(evt);
                    }
                });
            }
            {
                jOrderBySongNumber = new JButton();
                c.add(jOrderBySongNumber);
                jOrderBySongNumber.setText("\u5b57\u6570\u70b9\u6b4c");
                jOrderBySongNumber.setBounds(480, 265, 200, 100);
                jOrderBySongNumber.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jOrderBySongNumberActionPerformed(evt);
                    }
                });
            }
            {
                jOrderByStar = new JButton();
                c.add(jOrderByStar);
                jOrderByStar.setText("\u6b4c\u661f\u70b9\u6b4c");
                jOrderByStar.setBounds(93, 265, 200, 100);
                jOrderByStar.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jOrderByStarActionPerformed(evt);
                    }
                });
            }

            setTitle("\u70b9\u6b4c\u754c\u9762");
            addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(final WindowEvent evt)
                {
                    thisWindowClosing(evt);
                }
            });
            pack();
            this.setSize(800, 600);
        }
        catch (final Exception e)
        {
            // add your error handling code here
            e.printStackTrace();
        }
    }

    private void jOrderByPinyinActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jOrderByPinyin.actionPerformed, event="+evt);
        // TODO add your code for jOrderByPinyin.actionPerformed
        dispose();
        final OrderByPinyin inst = new OrderByPinyin();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

    private void jOrderBySongNameActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jOrderBySongName.actionPerformed, event="+evt);
        // TODO add your code for jOrderBySongName.actionPerformed
        dispose();
        final OrderBySongName inst = new OrderBySongName();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

    private void jOrderByStarActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jOrderByStar.actionPerformed, event="+evt);
        // TODO add your code for jOrderByStar.actionPerformed
        dispose();
        final OrderByStar inst = new OrderByStar();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

    private void jOrderBySongNumberActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jOrderBySongNumber.actionPerformed, event="+evt);
        // TODO add your code for jOrderBySongNumber.actionPerformed
        dispose();
        final OrderBySongNumber inst = new OrderBySongNumber();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

    private void jExitActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jExit.actionPerformed, event="+evt);
        // TODO add your code for jExit.actionPerformed
        final int response = JOptionPane.showConfirmDialog(null,
                "确定要退出KTV智能点播系统吗？", "警告", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
            Player.exit();
            System.exit(0);
        }
    }

    private void thisWindowClosing(final WindowEvent evt)
    {
        // System.out.println("this.windowClosing, event="+evt);
        // TODO add your code for this.windowClosing
        final int response = JOptionPane.showConfirmDialog(null,
                "确定要退出KTV智能点播系统吗？", "警告", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
            Player.exit();
            System.exit(0);
        }
        else
        {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    public void setBak()
    {
        ((JPanel) getContentPane()).setOpaque(false);
        final ImageIcon img = new ImageIcon("img/Loading03.jpg");
        final JLabel background = new JLabel(img);
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
}
