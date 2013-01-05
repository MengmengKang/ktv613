package com.xch.client;

import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class Player implements WindowListener
{
    // static Config config;
    static JFrame mainFrame;

    static VideoPanel videoPanel;

    JPanel controlBar;

    static PlayerProgressBar progressBar;

    static String[] cmd;

    static Process proc;

    static Thread t1;

    static Thread t2;

    static String mplayerPath = "player/mplayer.exe";// mplayer����·��

    static String mediaPath = "lib\\test4.mpg";// �����ļ�·��

    static int length = 0;// ��Ƶ����

    static int videoWidth;// ��Ƶ��

    static int videoHeight;// ��Ƶ��

    static float rate = 1.2f;// ��߱�

    static int playOffset = 0;// ��ǰ����ʱ��

    static boolean nextSong = false;

    static String nextURL;

    int volume = 100;// ����

    // ������״̬
    static boolean isPlay = false;

    static boolean isPause = false;

    public static void video()
    {
        /*
         * try { UIManager.setLookAndFeel(new NimbusLookAndFeel()); } catch
         * (UnsupportedLookAndFeelException e) { e.printStackTrace(); }
         */
        // ʵ����һ��������
        final Player player = new Player();
        MainFrame.playing = true;
        mainFrame = new JFrame();
        final int screenWidth = java.awt.Toolkit.getDefaultToolkit()
                .getScreenSize().width;
        mainFrame.setBounds(screenWidth - 380, 80, 380, 400);
        mainFrame.setAlwaysOnTop(true);
        mainFrame.setUndecorated(true);
        mainFrame.addWindowListener(player);
        final Container cp = mainFrame.getContentPane();
        cp.setLayout(new MigLayout("insets 0 0 0 0"));

        // ��Ӳ�������Ƶ���
        cp.add(player.getVideoPanel(), "width :2000:,height :2000:,wrap");
        // ��Ӳ������������
        cp.add(player.getControlBar(), "");

        mainFrame.setVisible(true);
    }

    Player()
    {
        // loadConfig();
        videoPanel = new VideoPanel(this);
        controlBar = new JPanel();
        controlBar.setLayout(new MigLayout());
        progressBar = new PlayerProgressBar(this);
        controlBar.add(progressBar, "width :2000:,span,wrap");
        final JPanel p2 = new JPanel();
        p2.setLayout(new MigLayout("insets 0 0 0 0,align center"));
        controlBar.add(p2, "width :2000:,span,wrap");
        // ˢ�²��Ž�����ʾ

        final Thread setProgressDelay = new Thread()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    SwingUtilities.invokeLater(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            if (progressBar != null)
                            {
                                if (mediaPath != null)
                                {
                                    progressBar.setTime(playOffset, length);
                                }
                            }
                        }
                    });
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (final InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

            }
        };
        setProgressDelay.start();
    }

    // �����ļ�
    static void play(final String path)
    {
        stop();
        mediaPath = path;
        isPlay = true;
        // ����������,����ѡ����ο�mplayer�ĵ�
        cmd = new String[]
        { mplayerPath,// mplayer·��
                "-vo", "directx",// ��Ƶ����
                "-identify", // �������
                "-slave", // slaveģʽ����
                "-wid", String.valueOf(videoPanel.getWid()),// ��Ƶ���ڵ�window
                                                            // handle
                "-colorkey", "0x030303",// ��Ƶ���ڵı���ɫ
                "-osdlevel", String.valueOf(1),// osd��ʽ
                path // �����ļ�·��
        };
        try
        {
            proc = Runtime.getRuntime().exec(cmd);
        }
        catch (final IOException e1)
        {
            e1.printStackTrace();
            return;
        }

        // ��ȡ������mplayer�������Ϣ
        final InputStream is1 = proc.getErrorStream();
        final InputStream is2 = proc.getInputStream();
        final Runnable errorReader = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    final BufferedReader lReader = new BufferedReader(
                            new InputStreamReader(is1));
                    for (String l = lReader.readLine(); l != null; l = lReader
                            .readLine())
                    {
                        // System.out.println("ERROR "+l);
                    }
                }
                catch (final Throwable t)
                {
                    t.printStackTrace();
                }
            }
        };

        final Runnable standReader = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    final BufferedReader lReader = new BufferedReader(
                            new InputStreamReader(is2));
                    String l = "";
                    while ((l = lReader.readLine()) != null)
                    {
                        System.out.println(l);
                        if (l.length() >= 10)
                        {
                            final String s2 = l.substring(0, 9);
                            if (s2.equals("ID_LENGTH"))
                            {
                                final int index = l.indexOf(".");
                                final String s1 = l.substring(10, index);
                                length = Integer.valueOf(s1);
                            }
                        }
                        // ��������ʱ��
                        if (l.length() > 70 && l.startsWith("A:"))
                        {
                            isPlay = true;
                            final int index = l.indexOf(".");
                            final String s3 = l.substring(2, index);
                            int index2 = 0;
                            while (true)
                            {
                                final int index3 = s3.indexOf(" ", index2);
                                if (index3 != -1)
                                {
                                    index2 = index3 + 1;
                                }
                                else
                                {
                                    break;
                                }
                            }
                            final String s4 = s3.substring(index2);
                            playOffset = Integer.valueOf(s4);
                        }

                        if (l.length() >= 15)
                        {
                            final String s4 = l.substring(0, 15);
                            // ������Ƶ���
                            if (s4.equals("ID_VIDEO_HEIGHT"))
                            {
                                final String s1 = l.substring(16);
                                videoHeight = Integer.valueOf(s1);
                                rate = (float) videoWidth / (float) videoHeight;
                                videoPanel.doLayout();
                            }
                        }
                        if (l.length() >= 14)
                        {
                            final String s3 = l.substring(0, 14);
                            // ������Ƶ�߶�
                            if (s3.equals("ID_VIDEO_WIDTH"))
                            {
                                final String s1 = l.substring(15);
                                videoWidth = Integer.valueOf(s1);
                            }
                        }

                        if (l.startsWith("ID_LENGTH"))
                        {
                            final int index = l.indexOf("=");
                            // ������Ƶ����
                            if (index > 0)
                            {
                                final String value = l.substring(index + 1);
                                final float intvalue = Float.valueOf(value);
                                length = (int) intvalue;
                                System.out.printf("��������=" + length);
                            }
                        }

                        if (l.startsWith("ID_EXIT=EOF"))
                        {
                            // playComplete();
                            final String URL = SongList.getSongURL();
                            if (URL.compareTo("ERROR") != 0)
                            {
                                nextURL = URL;
                                nextSong = true;
                                // play(URL);
                            }

                        }

                    }
                }
                catch (final Throwable t)
                {
                    t.printStackTrace();
                }
            }
        };

        t1 = new Thread(errorReader);
        t2 = new Thread(standReader);
        t1.start();
        t2.start();

        // ����mplayer�˳�
        final Thread waitThread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    proc.waitFor();
                    t1.interrupt();
                    t2.interrupt();
                    playComplete();
                    if (nextSong)
                    {
                        nextSong = false;
                        Bottom.refreshSongList();
                        play(nextURL);
                    }
                }
                catch (final InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        };
        waitThread.start();
    }

    // ����ʱ��
    static void seekto(final int value)
    {
        if (isPlay)
        {
            isPause = false;
            if (proc != null & isPlay)
            {
                final PrintStream s = new PrintStream(proc.getOutputStream());
                final String command = "seek " + value + " 2\n";
                System.out.println(command);
                s.print(command);
                s.flush();
            }
        }
    }

    // ��������
    static void setVolume(final int vol)
    {
        if (proc != null)
        {
            if (!isPause)
            {
                final PrintStream s = new PrintStream(proc.getOutputStream());
                s.print("volume " + vol + " 1\n");
                s.flush();
            }
        }
    }

    static// ֹͣ
    void stop()
    {

        if (proc != null)
        {
            proc.destroy();
        }

        playOffset = 0;
        isPause = false;
        progressBar.setValue(0);
    }

    // ��ͣ
    static void pause()
    {
        if (proc != null)
        {
            final PrintStream s = new PrintStream(proc.getOutputStream());
            s.print("pause\n");
            s.flush();
            isPause = !isPause;
        }

    }

    // ���Ž���
    static void playComplete()
    {
        isPlay = false;
        isPause = false;
        playOffset = 0;
    }

    Container getVideoPanel()
    {
        return videoPanel;
    }

    Container getControlBar()
    {
        return controlBar;
    }

    // �˳�����
    static void exit()
    {
        if (proc != null)
        {
            proc.destroy();
        }
        // saveConfig();
        // System.exit(0);
        // exit();
        MainFrame.playing = false;
        mainFrame.dispose();
    }

    /*
     * //�������� void loadConfig(){ FileInputStream bytetIn; try { bytetIn = new
     * FileInputStream(new File("config3.ob")); ObjectInputStream Iner = new
     * ObjectInputStream(bytetIn); Object ob=Iner.readObject(); Iner.close();
     * config=(Config)ob; } catch (Exception e) { //e.printStackTrace();
     * config=new Config(); } mediaPath=config.lastPlayPath; }
     * 
     * //�������� static void saveConfig(){
     * config.playerBound=mainFrame.getBounds(); config.lastPlayPath=mediaPath;
     * File file = new File("config3.ob"); if(!file.exists()){ try {
     * file.createNewFile(); } catch (IOException e1) { e1.printStackTrace(); }
     * } try { FileOutputStream bytetOut; bytetOut = new FileOutputStream(file);
     * ObjectOutputStream outer = new ObjectOutputStream(bytetOut);
     * outer.writeObject(config); outer.flush(); outer.close(); } catch
     * (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e)
     * { e.printStackTrace(); } }
     */
    @Override
    public void windowActivated(final WindowEvent e)
    {

    }

    @Override
    public void windowClosed(final WindowEvent e)
    {

    }

    @Override
    public void windowClosing(final WindowEvent e)
    {
        exit();
    }

    @Override
    public void windowDeactivated(final WindowEvent e)
    {

    }

    @Override
    public void windowDeiconified(final WindowEvent e)
    {

    }

    @Override
    public void windowIconified(final WindowEvent e)
    {

    }

    @Override
    public void windowOpened(final WindowEvent e)
    {

    }

    public static void setAccompany()
    {
        if (proc != null)
        {
            final PrintStream s = new PrintStream(proc.getOutputStream());
            s.print("af_add pan=1:-1:1\n");
            s.flush();
        }
    }

    public static void setOriginal()
    {
        if (proc != null)
        {
            final PrintStream s = new PrintStream(proc.getOutputStream());
            s.print("af_clr\n");
            s.flush();
        }
    }

    public static void addPlay(final String name, final String URL)
    {
        SongList.addSong(name, URL);
        Bottom.refreshSongList();
        if (!isPlay)
        {
            final String url = SongList.getSongURL();
            play(url);
        }
    }

    public static void setTime(final int i)
    {
        progressBar.setValue(i);
        seekto(0);
    }

    public static String nextSong()
    {
        final String URL = SongList.getSongURL();
        if (URL.compareTo("ERROR") == 0)
        {
            return URL;
        }
        t1.interrupt();
        t2.interrupt();
        stop();
        return URL;
    }

}
