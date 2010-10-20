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
	static String mplayerPath="player/mplayer.exe";//mplayer����·��
	static String mediaPath="lib\\test4.mpg";//�����ļ�·��
	static int length=0;//��Ƶ����
	static int videoWidth;//��Ƶ��
	static int videoHeight;//��Ƶ��
	static float rate=1.2f;//��߱�
	static int playOffset=0;//��ǰ����ʱ��
	int volume=100;//����

	//������״̬
	static boolean isPlay=false;
	static boolean isPause=false;

	public static void video() { 
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		//ʵ����һ��������
		Player player=new Player();

		mainFrame=new JFrame();
		mainFrame.setBounds(850,80,380,400);
		mainFrame.setAlwaysOnTop(true);
		mainFrame.setUndecorated(true);
		mainFrame.addWindowListener(player);
		Container cp=mainFrame.getContentPane();
		cp.setLayout(new MigLayout("insets 0 0 0 0"));

		//��Ӳ�������Ƶ���
		cp.add(player.getVideoPanel(),"width :2000:,height :2000:,wrap");
		//��Ӳ������������
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
		//ˢ�²��Ž�����ʾ
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

	//�����ļ�
	static void play(String path){
		stop();
		mediaPath=path;
		isPlay=true;
		//����������,����ѡ����ο�mplayer�ĵ�
		cmd = new String[] {
				mplayerPath,//mplayer·��
				"-vo","directx",//��Ƶ����				
				"-identify", //�������
				"-slave", //slaveģʽ����
				"-wid",String.valueOf(videoPanel.getWid()),//��Ƶ���ڵ�window handle
				"-colorkey", "0x030303",//��Ƶ���ڵı���ɫ
				"-osdlevel", String.valueOf(1),//osd��ʽ
				path //�����ļ�·��
		};
		try {
			proc = Runtime.getRuntime().exec(cmd);
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}

		//��ȡ������mplayer�������Ϣ
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
						//��������ʱ��
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
							//������Ƶ���
							if (s4.equals("ID_VIDEO_HEIGHT")) {
								String s1 = l.substring(16);
								videoHeight = Integer.valueOf(s1);
								rate = (float) videoWidth/ (float) videoHeight;
								videoPanel.doLayout();
							}
						}
						if (l.length() >= 14) {
							String s3 = l.substring(0, 14);
							//������Ƶ�߶�
							if (s3.equals("ID_VIDEO_WIDTH")) {
								String s1 = l.substring(15);
								videoWidth = Integer.valueOf(s1);
							}
						}

						if (l.startsWith("ID_LENGTH")) {
							int index = l.indexOf("=");
							//������Ƶ����
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

		//����mplayer�˳�
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

	//����ʱ��
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

	//��������
	static void setVolume(int vol) {
		if (proc != null) {
			if (!isPause) {
				PrintStream s = new PrintStream(proc.getOutputStream());
				s.print("volume " + vol + " 1\n");
				s.flush();
			}
		}
	}

	static //ֹͣ
	void stop(){
		if(proc!=null){
			proc.destroy();
		}
		playOffset=0;
		isPause=false;
		progressBar.setValue(0);
	}

	//��ͣ
	static void pause(){
		if (proc != null) {
			PrintStream s = new PrintStream(proc.getOutputStream());
			s.print("pause\n");
			s.flush();
			isPause=!isPause;
		}

	}

	//���Ž���
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

	//�˳�����
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
	//��������
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

	//��������
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
			//System.out.println("�鳪");
			PrintStream s = new PrintStream(proc.getOutputStream());
			s.print("af_add pan=1:-1:1\n");
			//s.print("get_audio_samples\n");
			s.flush();
		}
	}

	public static void setOriginal() {
		// TODO Auto-generated method stub
		if (proc != null) {
			//System.out.println("ԭ��");
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
