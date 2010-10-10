package com.xch.client;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MplayerDemo extends WindowAdapter {
    private static final String mplayerPath =
"player\\mplayer.exe";
	JFrame frame;

    private static final String[] flags = {"-slave", 
		"-playlist",
		""
	};

    private static final String[] mediaPath = {
		"lib\\test4.mpg"
    };

    private static final String space = " ";

    Process playerPrc;

    Thread mplayerThread;

    static BufferedReader stdout, stderr;

    static Vector<String> outputLines;
    
	private boolean paused = false;
	private boolean outputAllowed = false;
	
    public Action pauseToggleAction = new AbstractAction("||") {

        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            PrintStream s = new PrintStream(playerPrc.getOutputStream());
            s.print("pause\n");
			paused = !paused;
            s.flush();
        }

    };
	
    public Action quitAction = new AbstractAction("quit") {

        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            PrintStream s = new PrintStream(playerPrc.getOutputStream());
            s.print("quit\n");
            s.flush();
			System.exit(0);
        }

    };
	
    public Action randomPositionAction = new AbstractAction("random") {

        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            PrintStream s = new PrintStream(playerPrc.getOutputStream());
			int randomPercent =
Float.valueOf(""+Math.floor(Math.random()*100)).intValue();
			String command = "seek "+randomPercent+" 1\n";
			System.out.print(command);
			s.print(command);
            s.flush();
        }
    };
	
    public Action timelengthAction = new AbstractAction("test") {

        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            PrintStream s = new PrintStream(playerPrc.getOutputStream());
			String command = "speed_incr 1\n";
			s.print(command);
            s.flush();
        }
    };
	
    public Action pcdoneAction = new AbstractAction("%") {

        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            PrintStream s = new PrintStream(playerPrc.getOutputStream());
			String command = "get_percent_pos\n";
			s.print(command);
            s.flush();
        }
    };
	
    public Action muteToggleAction = new AbstractAction("Mute") {

        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            PrintStream s = new PrintStream(playerPrc.getOutputStream());
            if (paused) {
				s.print("pausing mute\n");
            }
            else {
				s.print("mute\n");
            }
            s.flush();
        }

    };

    public MplayerDemo() {
        //final String cmd = mplayerPath + space + flags[0] + space + mediaPath[0];
		String[] cmd = new String[] {
				mplayerPath,
				flags[0],
				mediaPath[0]
		};
        showGUI();

        try {
        	System.out.println("test 1");
            playerPrc = Runtime.getRuntime().exec(cmd);
            System.out.println("test 2");
            
            //StringBuffer sb = new StringBuffer();
            //StringBuffer s2 = new StringBuffer();
            InputStream is = playerPrc.getInputStream();
            stdout = new BufferedReader(new InputStreamReader(is));
            //is = playerPrc.getErrorStream();
            //stderr = new BufferedReader(new InputStreamReader(is));
            outputLines = new Vector<String>();
            Thread stdoutThread = new Thread() {
                public void run() {
                    try {
                        int l;
                        String line;
                        for (l = 0; (line = stdout.readLine()) != null;) {
                            if (line.length() > 0) {
                                l++;
                                outputLines.addElement(line);
								if (line.matches("Starting playback...")) {
									outputAllowed = true;
								}
                            }
                            System.out.print(outputAllowed ? line +"\n": ".");
                        }
                        System.out.println("\nRead " + l
                                + " lines from stdout.");
                        stdout.close();
                        for (Object o: outputLines) {
                            System.out.println(o);
                        }
                    } catch (IOException ie) {
                        System.out.println("IO exception on stdout: " + ie);
                    }
					//TODO
					windowClosing(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            };
            stdoutThread.start();

            System.out.println("About to waitfor");
            try {
                playerPrc.waitFor();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Done.");
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Dean! Exec failed. Exiting");
            System.exit(0);
        }
    }

    private void showGUI() {
        frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.setLayout(new FlowLayout());
        frame.add(new JButton(pauseToggleAction));
		frame.add(new JButton(muteToggleAction));
		frame.add(new JButton(randomPositionAction));
		frame.add(new JButton(timelengthAction));
		frame.add(new JButton(pcdoneAction));

		frame.addWindowListener(this);
        frame.pack();
        frame.setVisible(true);
    }

    public class Reminder {
        Timer timer;

        public Reminder(int seconds) {
            timer = new Timer();
            timer.schedule(new RemindTask(), seconds * 1000);
        }

        class RemindTask extends TimerTask {
            public void run() {
                // System.out.println("Time's up!");
                timer.cancel(); // Terminate the timer thread
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MplayerDemo();
    }

	@Override
	public void windowClosing(WindowEvent e) {
		quitAction.actionPerformed(new ActionEvent(this, 0, null));
	}
}

