package com.xch.client;

import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;




public class Player implements WindowListener{
	static Config config;
	static JFrame mainFrame;
	static VideoPanel videoPanel;
	JPanel controlBar;
	static PlayerProgressBar progressBar;
	static String [] cmd ;
	static Process proc ;
	static Thread t1;
	static Thread t2;
	static String mplayerPath="player/mplayer.exe";//mplayer程序路径
	static String mediaPath="lib\\test4.mpg";//播放文件路径
	static int length=0;//视频长度
	static int videoWidth;//视频宽
	static int videoHeight;//视频高
	static float rate=1.2f;//宽高比
	static int playOffset=0;//当前播放时间
	int volume=100;//音量

	//播放器状态
	static boolean isPlay=false;
	static boolean isPause=false;

	public static void video() { 
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		//实例化一个播放器
		Player player=new Player();

		mainFrame=new JFrame();
		mainFrame.setBounds(850,80,380,400);
		mainFrame.setAlwaysOnTop(true);
		mainFrame.setUndecorated(true);
		mainFrame.addWindowListener(player);
		Container cp=mainFrame.getContentPane();
		cp.setLayout(new MigLayout("insets 0 0 0 0"));

		//添加播放器视频面板
		cp.add(player.getVideoPanel(),"width :2000:,height :2000:,wrap");
		//添加播放器控制面板
		cp.add(player.getControlBar(),"");

		mainFrame.setVisible(true);
	}

	Player(){
		//loadConfig();
		videoPanel=new VideoPanel(this);
		controlBar=new JPanel();
		controlBar.setLayout(new MigLayout());
		progressBar=new PlayerProgressBar(this);
		controlBar.add(progressBar,"width :2000:,span,wrap");
		JPanel p2=new JPanel();
		p2.setLayout(new MigLayout("insets 0 0 0 0,align center"));
		controlBar.add(p2,"width :2000:,span,wrap");
		//刷新播放进度显示
		Thread setProgressDelay = new Thread() {
			public void run() {
				while (true) {
					SwingUtilities.invokeLater(new Runnable(){
						public void run() {
							if (progressBar != null) {
								if(mediaPath!=null){
									progressBar.setTime(playOffset, length);
								}
							}
						}
					});
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		};
		setProgressDelay.start();
	}

	//播放文件
	static void play(String path){
		stop();
		mediaPath=path;
		isPlay=true;
		//调用命令行,更多选项请参考mplayer文档
		cmd = new String[] {
				mplayerPath,//mplayer路径
				"-vo","directx",//视频驱动				
				"-identify", //输出详情
				"-slave", //slave模式播放
				"-wid",String.valueOf(videoPanel.getWid()),//视频窗口的window handle
				"-colorkey", "0x030303",//视频窗口的背景色
				"-osdlevel", String.valueOf(1),//osd样式
				path //播放文件路径
		};
		try {
			proc = Runtime.getRuntime().exec(cmd);
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}

		//读取并解析mplayer的输出信息
		final InputStream is1 = proc.getErrorStream();
		final InputStream is2 = proc.getInputStream();
		final Runnable errorReader = new Runnable() {
			public void run() {
				try {
					final BufferedReader lReader = new BufferedReader(new InputStreamReader(is1));
					for (String l = lReader.readLine(); l != null ; l = lReader.readLine()) {
						//System.out.println("ERROR "+l);
					}
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		};


		final Runnable standReader = new Runnable() {
			public void run() {
				try {
					final BufferedReader lReader = new BufferedReader(new InputStreamReader(is2));
					String l="";
					while ((l=lReader.readLine())!=null) {
						if (l.length() >= 10) {
							String s2 = l.substring(0, 9);
							if (s2.equals("ID_LENGTH")) {
								int index = l.indexOf(".");
								String s1 = l.substring(10,index);
								length = Integer.valueOf(s1);
							}
						}
						//解析播放时间
						if(l.length()>70&&l.startsWith("A:")){
							int index = l.indexOf(".");
							String s3 = l.substring(2, index);
							int index2 = 0;
							while (true) {
								int index3 = s3.indexOf(" ", index2);
								if (index3 != -1) {
									index2 = index3 + 1;
								} else {
									break;
								}
							}
							String s4 = s3.substring(index2);
							playOffset = Integer.valueOf(s4);
						}
						if (l.length() >= 15) {
							String s4 = l.substring(0, 15);
							//解析视频宽度
							if (s4.equals("ID_VIDEO_HEIGHT")) {
								String s1 = l.substring(16);
								videoHeight = Integer.valueOf(s1);
								rate = (float) videoWidth/ (float) videoHeight;
								videoPanel.doLayout();
							}
						}
						if (l.length() >= 14) {
							String s3 = l.substring(0, 14);
							//解析视频高度
							if (s3.equals("ID_VIDEO_WIDTH")) {
								String s1 = l.substring(15);
								videoWidth = Integer.valueOf(s1);
							}
						}

						if (l.startsWith("ID_LENGTH")) {
							int index = l.indexOf("=");
							//解析视频长度
							if (index > 0) {
								String value = l.substring(index + 1);
								float intvalue=Float.valueOf(value);
								length=(int)intvalue;
							}
						}
					}
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		};

		t1 = new Thread(errorReader);
		t2 = new Thread(standReader);
		t1.start();
		t2.start();

		//监视mplayer退出
		Thread waitThread=new Thread (){
			public void run(){
				try {
					proc.waitFor();
					t1.interrupt();
					t2.interrupt();
					playComplete();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		};
		waitThread.start();
	}

	//搜索时间
	static void seekto(int value) {
		if(isPlay){
			isPause=false;
			if (proc != null&isPlay) {
				PrintStream s = new PrintStream(proc.getOutputStream());
				String command = "seek " + value + " 2\n";
				s.print(command);
				s.flush();
			}
		}
	}

	//设置音量
	static void setVolume(int vol) {
		if (proc != null) {
			if (!isPause) {
				PrintStream s = new PrintStream(proc.getOutputStream());
				s.print("volume " + vol + " 1\n");
				s.flush();
			}
		}
	}

	static //停止
	void stop(){
		if(proc!=null){
			proc.destroy();
		}
		playOffset=0;
		isPause=false;
		progressBar.setValue(0);
	}

	//暂停
	static void pause(){
		if (proc != null) {
			PrintStream s = new PrintStream(proc.getOutputStream());
			s.print("pause\n");
			s.flush();
			isPause=!isPause;
		}

	}

	//播放结束
	static void playComplete(){
		isPlay=false;
		isPause=false;
		playOffset=0;
	}

	Container getVideoPanel(){
		return videoPanel;
	}

	Container getControlBar(){
		return controlBar;
	}

	//退出程序
	static void exit(){
		if(proc!=null){
			proc.destroy();
		}
		//saveConfig();
		//System.exit(0);
		//exit();
		mainFrame.dispose();
		
	}
/*
	//加载配置
	void loadConfig(){
		FileInputStream bytetIn;
		try {
			bytetIn = new FileInputStream(new File("config3.ob"));
			ObjectInputStream Iner = new ObjectInputStream(bytetIn);
			Object ob=Iner.readObject();
			Iner.close();
			config=(Config)ob;
		} catch (Exception e) {
			//e.printStackTrace();
			config=new Config();
		}
		mediaPath=config.lastPlayPath;
	}

	//保存配置
	static void saveConfig(){
		config.playerBound=mainFrame.getBounds();
		config.lastPlayPath=mediaPath;
		File file = new File("config3.ob");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			FileOutputStream bytetOut;
			bytetOut = new FileOutputStream(file);
			ObjectOutputStream outer = new ObjectOutputStream(bytetOut);
			outer.writeObject(config);
			outer.flush();
			outer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
*/
	public void windowActivated(WindowEvent e) {

	}

	public void windowClosed(WindowEvent e) {

	}

	public void windowClosing(WindowEvent e) {
		exit();
	}

	public void windowDeactivated(WindowEvent e) {

	}

	public void windowDeiconified(WindowEvent e) {

	}

	public void windowIconified(WindowEvent e) {

	}

	public void windowOpened(WindowEvent e) {

	}

	public static void setAccompany() {
		// TODO Auto-generated method stub
		if (proc != null)
		{
			//System.out.println("伴唱");
			PrintStream s = new PrintStream(proc.getOutputStream());
			s.print("af_add pan=1:-1:1\n");
			//s.print("get_audio_samples\n");
			s.flush();
		}
	}

	public static void setOriginal() {
		// TODO Auto-generated method stub
		if (proc != null) {
			//System.out.println("原唱");
			PrintStream s = new PrintStream(proc.getOutputStream());
			s.print("af_clr\n");
			//s.print("get_audio_samples\n");
			s.flush();
		}		
	}

	public static void setTime(int i) {
		// TODO Auto-generated method stub
		progressBar.setValue(i);
		seekto(0);
	}

}
