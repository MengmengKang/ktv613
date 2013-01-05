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

    static String mplayerPath = "player/mplayer.exe";// mplayer程序路径

    static String mediaPath = "lib\\test4.mpg";// 播放文件路径

    static int length = 0;// 视频长度

    static int videoWidth;// 视频宽

    static int videoHeight;// 视频高

    static float rate = 1.2f;// 宽高比

    static int playOffset = 0;// 当前播放时间

    static boolean nextSong = false;

    static String nextURL;

    int volume = 100;// 音量

    // 播放器状态
    static boolean isPlay = false;

    static boolean isPause = false;

    public static void video()
    {
        /*
         * try { UIManager.setLookAndFeel(new NimbusLookAndFeel()); } catch
         * (UnsupportedLookAndFeelException e) { e.printStackTrace(); }
         */
        // 实例化一个播放器
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

        // 添加播放器视频面板
        cp.add(player.getVideoPanel(), "width :2000:,height :2000:,wrap");
        // 添加播放器控制面板
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
        // 刷新播放进度显示

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

    // 播放文件
    static void play(final String path)
    {
        stop();
        mediaPath = path;
        isPlay = true;
        // 调用命令行,更多选项请参考mplayer文档
        cmd = new String[]
        { mplayerPath,// mplayer路径
                "-vo", "directx",// 视频驱动
                "-identify", // 输出详情
                "-slave", // slave模式播放
                "-wid", String.valueOf(videoPanel.getWid()),// 视频窗口的window
                                                            // handle
                "-colorkey", "0x030303",// 视频窗口的背景色
                "-osdlevel", String.valueOf(1),// osd样式
                path // 播放文件路径
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

        // 读取并解析mplayer的输出信息
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
                        // 解析播放时间
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
                            // 解析视频宽度
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
                            // 解析视频高度
                            if (s3.equals("ID_VIDEO_WIDTH"))
                            {
                                final String s1 = l.substring(15);
                                videoWidth = Integer.valueOf(s1);
                            }
                        }

                        if (l.startsWith("ID_LENGTH"))
                        {
                            final int index = l.indexOf("=");
                            // 解析视频长度
                            if (index > 0)
                            {
                                final String value = l.substring(index + 1);
                                final float intvalue = Float.valueOf(value);
                                length = (int) intvalue;
                                System.out.printf("歌曲长度=" + length);
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

        // 监视mplayer退出
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

    // 搜索时间
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

    // 设置音量
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

    static// 停止
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

    // 暂停
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

    // 播放结束
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

    // 退出程序
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
     * //加载配置 void loadConfig(){ FileInputStream bytetIn; try { bytetIn = new
     * FileInputStream(new File("config3.ob")); ObjectInputStream Iner = new
     * ObjectInputStream(bytetIn); Object ob=Iner.readObject(); Iner.close();
     * config=(Config)ob; } catch (Exception e) { //e.printStackTrace();
     * config=new Config(); } mediaPath=config.lastPlayPath; }
     * 
     * //保存配置 static void saveConfig(){
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
