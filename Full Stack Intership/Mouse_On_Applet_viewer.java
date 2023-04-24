/*
	<applet code=
	"Mouse_On_Applet_viewer.class"
	height=200 width=320>

 	</applet>
*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Mouse_On_Applet_viewer	extends Applet
									implements MouseMotionListener
{
	int X=0, Y=0;

	public void init()
	{
		addMouseMotionListener(this);
    }
	public void mouseMoved(MouseEvent me)
	{
		X = me.getX();
		Y = me.getY();
		repaint();
	}

	public void paint(Graphics g)
	{
	//	g.drawString("Mouse at " +X + ", " + Y, 50, 160);
		g.drawString("Mouse at " +X + ", " + Y, X, Y);
	}
	public void mouseDragged(MouseEvent me){}
}












