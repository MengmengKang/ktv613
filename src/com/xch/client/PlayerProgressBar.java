package com.xch.client;

import java.awt.event.MouseEvent;

import javax.swing.JProgressBar;

public class PlayerProgressBar extends JProgressBar
{
    private static final long serialVersionUID = -972301782528385389L;

    int maxNum = 9000;

    PlayerProgressBar progressBar;

    int x1 = 0;

    int x2 = 0;

    Player player;

    PlayerProgressBar(final Player player)
    {
        super();
        this.player = player;
        progressBar = this;
        setMaximum(maxNum);
        addMouseListener(new java.awt.event.MouseListener()
        {

            @Override
            public void mouseClicked(final MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(final MouseEvent e)
            {

            }

            @Override
            public void mouseExited(final MouseEvent e)
            {

            }

            @Override
            public void mousePressed(final MouseEvent e)
            {

            }

            @Override
            @SuppressWarnings("static-access")
            public void mouseReleased(final MouseEvent e)
            {
                final double sel = (double) e.getX()
                        / (double) progressBar.getWidth()
                        * progressBar.getMaximum();
                System.out.println("seek to " + sel + " isPlay="
                        + player.isPlay);
                progressBar.setValue((int) sel);
                final int length = player.length;
                final int ds = (int) (sel / progressBar.getMaximum() * length);
                player.playOffset = ds;
                // System.out.println("ds ="+ds);
                player.seekto(ds);
                // player.pause();
            }

        });

    }

    void setTime(final int time, final int length)
    {
        final double sel = time / (double) length * getMaximum();
        progressBar.setValue((int) sel);
    }
    /*
     * public static void main(String[] args){ //new PlayerProgressBar();
     * 
     * }
     */
}
