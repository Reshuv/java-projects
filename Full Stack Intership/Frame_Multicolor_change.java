/*
<html>
	<applet code="Frame_Multicolor_change.class"
	height=200 width=320>
 	</applet>
</html> */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Frame_Multicolor_change
  extends Applet implements MouseListener
{
	Frame f;

	int i=10;

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
		i++;
 		int r=100*i%256;
		int g=200*i%256;
		int b=300*i%256;
   	  	f.setBackground(new Color(r,g,b));
}

public void mouseExited(MouseEvent e)
{
		i++;
		int r=200*i%256;
		int g=150*i%256;
		int b=120*i%256;
   	  	f.setBackground(new Color(r,g,b));
}

public void mousePressed
											(MouseEvent me){}

public void mouseReleased
											(MouseEvent me){}

public void mouseClicked
											(MouseEvent me){}

}
