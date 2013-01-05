package com.xch.client;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;

/*
 * º∆À„ ”∆µŒª÷√
 */

class VideoLayout implements LayoutManager
{
    Player player;

    VideoLayout(final Player pl)
    {
        player = pl;
    }

    @Override
    public void addLayoutComponent(final String name, final Component comp)
    {

    }

    @Override
    public void layoutContainer(final Container c)
    {
        final int count = c.getComponentCount();
        for (int i = 0; i < count; i++)
        {
            final Component m = c.getComponent(i);
            if (m.getName().equals("canvas"))
            {
                final Canvas canvas = (Canvas) m;
                setCanvas(c, canvas);
            }
        }
    }

    @Override
    public Dimension minimumLayoutSize(final Container parent)
    {
        return new Dimension(100, 100);
    }

    @Override
    public Dimension preferredLayoutSize(final Container parent)
    {
        return new Dimension(100, 100);
    }

    @Override
    public void removeLayoutComponent(final Component comp)
    {

    }

    @SuppressWarnings("static-access")
    void setCanvas(final Container c, final Canvas canvas)
    {
        float cx, cy = 0, cw, ch;
        final Container cp = c;
        ch = cp.getBounds().height;
        cw = ch * player.rate;
        cx = (cp.getBounds().width - cw) / 2;
        if (cw > cp.getBounds().width)
        {
            cx = 0;
            cw = cp.getBounds().width;
            ch = cw / player.rate;
        }
        cy = (cp.getBounds().height - ch) / 2;
        final Rectangle rec = new Rectangle((int) cx, (int) cy, (int) cw,
                (int) ch + 1);
        canvas.setBounds(rec);
    }

}