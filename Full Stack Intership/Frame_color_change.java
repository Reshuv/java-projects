/*
<html>
	<applet code="Frame_color_change.class"
	height=200 width=320>
 	</applet>
</html> */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Frame_color_change extends Applet
									   implements MouseListener
{
	Frame f;
	public void init()
	{
		f=new Frame();
		f.setTitle("Demo");
        f.setVisible(true);
		f.setSize(200,300);
		f.addMouseListener(this);
	 }

public void mouseEntered(MouseEvent e)
{
		f.setBackground(Color.RED);
}

public void mouseExited(MouseEvent e)
{
		f.setBackground(new Color(0,255,0));
}

public void mousePressed(MouseEvent me){}

public void mouseReleased(MouseEvent me){}

public void mouseClicked(MouseEvent me){}
}









