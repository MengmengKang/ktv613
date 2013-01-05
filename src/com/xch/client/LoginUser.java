package com.xch.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import com.xch.DAO.DA;
import com.xch.obj.UserData;

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
public class LoginUser extends javax.swing.JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JLabel jLabel1;

    private JLabel jLabel2;

    private JButton jExit;

    private JLabel jLabel3;

    private JButton jLogin;

    private JButton jRegister;

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
            // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
                final LoginUser inst = new LoginUser();
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }

    public LoginUser()
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
            final Container c = getContentPane(); // ��ȡJFrame���
            c.setBounds(28, -29, 792, 566);
            final JPanel jp = new JPanel(); // ������JPanel
            jp.setOpaque(false); // ��JPanel����Ϊ͸�� �����Ͳ�����ס����ı��� �����������JPanel����������
            c.add(jp);
            {
                jLabel3 = new JLabel();
                c.add(jLabel3);
                jLabel3.setText("\u6ca1\u6709\u7528\u6237\u540d\uff1f");
                jLabel3.setBounds(650, 278, 84, 15);
                jLabel3.setForeground(Color.RED);
            }

            {
                jUserName = new JTextField();
                c.add(jUserName);
                jUserName.setBounds(369, 273, 121, 24);
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
                jPassword = new JPasswordField();
                c.add(jPassword);
                jPassword.setBounds(369, 333, 121, 24);
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
                jExit = new JButton();
                c.add(jExit);
                jExit.setText("\u9000\u51fa");
                jExit.setBounds(420, 395, 61, 24);
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
                jLogin = new JButton();
                c.add(jLogin);
                jLogin.setText("\u767b\u5f55");
                jLogin.setBounds(301, 395, 61, 24);
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
                jLabel1 = new JLabel();
                c.add(jLabel1);
                jLabel1.setText("\u7528\u6237\u540d");
                jLabel1.setBounds(277, 277, 54, 17);
            }
            {
                jLabel2 = new JLabel();
                c.add(jLabel2);
                jLabel2.setText("\u5bc6\u7801");
                jLabel2.setBounds(277, 337, 54, 17);
            }
            {
                jRegister = new JButton();
                c.add(jRegister);
                jRegister.setText("\u6ce8\u518c");
                jRegister.setBounds(650, 299, 69, 24);
                jRegister.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(final ActionEvent evt)
                    {
                        jRegisterActionPerformed(evt);
                    }
                });
            }
            setTitle("\u7528\u6237\u767b\u5f55");
            addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(final WindowEvent evt)
                {
                    thisWindowClosing(evt);
                }
            });

            final ArrayList<Component> list = new ArrayList<Component>();

            list.add(jUserName);
            list.add(jPassword);
            list.add(jLogin);
            list.add(jExit);
            list.add(jRegister);
            final ArrayList comList = list;
            final FocusTraversalPolicy policy = new FocusTraversalPolicy()
            {
                @Override
                public Component getFirstComponent(
                        final Container focusCycleRoot)
                {
                    return (Component) comList.get(0);
                }

                @Override
                public Component getLastComponent(final Container focusCycleRoot)
                {
                    return (Component) comList.get(comList.size() - 1);
                }

                @Override
                public Component getComponentAfter(
                        final Container focusCycleRoot,
                        final Component aComponent)
                {
                    final int index = comList.indexOf(aComponent);
                    return (Component) comList
                            .get((index + 1) % comList.size());
                }

                @Override
                public Component getComponentBefore(
                        final Container focusCycleRoot,
                        final Component aComponent)
                {
                    final int index = comList.indexOf(aComponent);
                    return (Component) comList.get((index - 1 + comList.size())
                            % comList.size());
                }

                @Override
                public Component getDefaultComponent(
                        final Container focusCycleRoot)
                {
                    return (Component) comList.get(0);
                }
            };
            setFocusTraversalPolicy(policy);
            pack();
            setSize(800, 600);

        }
        catch (final Exception e)
        {
            // add your error handling code here
            e.printStackTrace();
        }
    }

    private void jRegisterActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jRegister.actionPerformed, event="+evt);
        // TODO add your code for jRegister.actionPerformed
        final Register inst = new Register();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

    private void jLoginActionPerformed()
    {
        // System.out.println("jLogin.actionPerformed, event="+evt);
        // TODO add your code for jLogin.actionPerformed
        final UserData user = new UserData();
        if (jUserName.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
            return;
        }
        final String password = new String(jPassword.getPassword());
        if (password.length() == 0)
        {
            JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
            return;
        }
        final MD5 md5 = new MD5(password);
        // System.out.println(password);
        user.setUserName(jUserName.getText());
        user.setPassWord(md5.get());

        if (DA.loginUser(user))
        {
            dispose();
            SongList.newList();
            final MainFrame inst = new MainFrame();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
            // Player.video();
            // Player.play();
            // new Bottom();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "�û������������");
        }
    }

    private void thisWindowClosing(final WindowEvent evt)
    {
        // System.out.println("this.windowClosing, event="+evt);
        // TODO add your code for this.windowClosing
        final int response = JOptionPane.showConfirmDialog(null,
                "ȷ��Ҫ�˳�KTV���ܵ㲥ϵͳ��", "����", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
        }
        else
        {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    private void jExitActionPerformed(final ActionEvent evt)
    {
        // System.out.println("jExit.actionPerformed, event="+evt);
        // TODO add your code for jExit.actionPerformed
        final int response = JOptionPane.showConfirmDialog(null,
                "ȷ��Ҫ�˳�KTV���ܵ㲥ϵͳ��", "����", JOptionPane.YES_NO_OPTION);
        if (response == 0)
        {
            dispose();
        }
    }

    public void setBak()
    {
        ((JPanel) getContentPane()).setOpaque(false);
        final ImageIcon img = new ImageIcon("img/Loading04.jpg");
        final JLabel background = new JLabel(img);
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
}
