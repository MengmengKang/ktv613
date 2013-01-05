package com.xch.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import com.xch.DAO.DA;
import com.xch.client.MD5;
import com.xch.obj.AdminData;

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
public class LoginAdmin extends javax.swing.JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JLabel jLabel2;

    private JButton jLogin;

    private JButton jExit;

    private JLabel jManagerID;

    private JPasswordField jPassword;

    private JTextField jUserName;

    /**
     * Auto-generated main method to display this JFrame
     */
    public static void main(final String[] args)
    {
        DA.readConfig();
        try
        {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }
        catch (final UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                final LoginAdmin inst = new LoginAdmin();
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }

    public LoginAdmin()
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
            setTitle("\u7ba1\u7406\u5458\u767b\u5f55");
            addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(final WindowEvent evt)
                {
                    thisWindowClosing(evt);
                }
            });
            {
                jLabel2 = new JLabel();
                getContentPane().add(jLabel2);
                jLabel2.setText("\u5bc6\u7801");
                jLabel2.setBounds(73, 101, 54, 17);
            }
            {
                jUserName = new JTextField();
                getContentPane().add(jUserName);
                jUserName.setBounds(157, 64, 121, 24);
                jUserName.addKeyListener(new KeyAdapter()
                {
                    @Override
                    public void keyPressed(final KeyEvent e)
                    {
                        if (KeyEvent.VK_ENTER == e.getKeyCode())
                        {
                            jLoginActionPerformed();
                        }
                    }
                });
            }
            {
                jLogin = new JButton();
                getContentPane().add(jLogin);
                jLogin.setText("\u767b\u5f55");
                jLogin.setBounds(109, 159, 61, 24);
                jLogin.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jLoginActionPerformed();
                    }
                });

            }
            {
                jPassword = new JPasswordField();
                getContentPane().add(jPassword);
                jPassword.setBounds(157, 98, 121, 24);
                jPassword.addKeyListener(new KeyAdapter()
                {
                    @Override
                    public void keyPressed(final KeyEvent e)
                    {
                        if (KeyEvent.VK_ENTER == e.getKeyCode())
                        {
                            jLoginActionPerformed();
                        }
                    }
                });
            }
            {
                jManagerID = new JLabel();
                getContentPane().add(jManagerID);
                jManagerID.setText("\u7ba1\u7406\u5458\u8d26\u6237");
                jManagerID.setBounds(73, 67, 72, 17);
            }
            {
                jExit = new JButton();
                getContentPane().add(jExit);
                jExit.setText("\u9000\u51fa");
                jExit.setBounds(211, 159, 67, 24);
                jExit.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jExitActionPerformed(evt);
                    }
                });
            }
            this.setSize(386, 260);
        }
        catch (final Exception e)
        {
            // add your error handling code here
            e.printStackTrace();
        }
    }

    private void jLoginActionPerformed()
    {
        // System.out.println("jLogin.actionPerformed, event="+evt);
        // TODO add your code for jLogin.actionPerformed
        final AdminData user = new AdminData();
        if (jUserName.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "用户名不能为空！");
            return;
        }
        final String password = new String(jPassword.getPassword());
        if (password.length() == 0)
        {
            JOptionPane.showMessageDialog(null, "密码不能为空！");
            return;
        }
        final MD5 md5 = new MD5(password);
        // System.out.println(password);
        final AdminData admin = new AdminData();
        admin.setAdmin(jUserName.getText());
        admin.setPassWord(md5.get());

        if (DA.loginAdmin(admin))
        {
            dispose();
            final Manage inst = new Manage();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "用户名或密码错误");
        }
    }

    private void jExitActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jExit.actionPerformed, event="+evt);
        // TODO add your code for jExit.actionPerformed
        final int response = JOptionPane.showConfirmDialog(null,
                "确定要退出管理员登录界面吗？", "警告", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
            System.exit(0);
        }
    }

    private void thisWindowClosing(final WindowEvent evt)
    {
        // System.out.println("this.windowClosing, event="+evt);
        // TODO add your code for this.windowClosing
        final int response = JOptionPane.showConfirmDialog(null,
                "确定要退出管理员登录界面吗？", "警告", JOptionPane.YES_NO_OPTION);
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
