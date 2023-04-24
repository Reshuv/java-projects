/*
<html>
	<applet code="Frame_Multicolor_change.class"
	height=200 width=320>
 	</applet>
</html> */

import java.applet.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Frame_Multicolor_Random extends Applet
																implements MouseListener
{
	Frame f;

	Random ra=new Random();

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
 		int r=ra.nextInt(256);
        System.out.println("R= "+r);

 		int g=ra.nextInt(256);
        System.out.println("G= "+g);

		int b=ra.nextInt(256);
		System.out.println("B= "+b);

   	  	f.setBackground(new Color(r,g,b));
}

public void mouseExited(MouseEvent e)
{
		int r=ra.nextInt(256);
		int g=ra.nextInt(256);
		int b=ra.nextInt(256);
   	  	f.setBackground(new Color(r,g,b));
}

public void mousePressed(MouseEvent me){}

public void mouseReleased(MouseEvent me){}

public void mouseClicked(MouseEvent me){}
}
