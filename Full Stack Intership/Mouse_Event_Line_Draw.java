/*
<APPLET CODE="Mouse_Event_Line_Draw.class"
					WIDTH="400" HEIGHT="300">

</APPLET>
*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Mouse_Event_Line_Draw extends Applet
               implements MouseListener,MouseMotionListener
{
		int X1=0, Y1=0,X2=0,Y2=0;

		public void init()
		{
			addMouseListener(this);
			addMouseMotionListener(this);
		}

		public void mousePressed(MouseEvent me)
		{
			X1 = me.getX();
			Y1 = me.getY();
		}

		public void mouseDragged(MouseEvent me)
		{
			X2 = me.getX();
			Y2 = me.getY();
			repaint();
		}

		public void paint(Graphics g)
		{
			g.drawLine(X1,Y1,X2,Y2);
		}

		public void mouseMoved(MouseEvent me){}

		public void mouseClicked(MouseEvent me){}

		public void mouseEntered(MouseEvent me){}

		public void mouseExited(MouseEvent me){}

		public void mouseReleased(MouseEvent me){}
}




