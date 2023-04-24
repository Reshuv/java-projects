import java.awt.*;
import java.util.*;
import java.awt.event.*;

class AWT_Window_with_color
{
	public static void main(String args[])
	{
	    SampleFrame f1=new SampleFrame();
			f1.setTitle("Handle Mouse Events");
			f1.setSize(300, 200);
			f1.setLocation(100,100);
			f1.setVisible(true);
     }
}
class SampleFrame extends Frame implements MouseListener
{
	Random ra=new Random();

	SampleFrame()
    {
		addMouseListener(this);
   }

	public void mouseEntered(MouseEvent evtObj)
	{
 		int r=ra.nextInt(256);
		int g=ra.nextInt(256);
		int b=ra.nextInt(256);
   	  	setBackground(new Color(r,g,b));
 	}

	public void mouseExited(MouseEvent evtObj)
	{
 		int r=ra.nextInt(256);
		int g=ra.nextInt(256);
		int b=ra.nextInt(256);
   	  	setBackground(new Color(r,g,b));
	}
	public void mousePressed(MouseEvent me){}

	public void mouseReleased(MouseEvent me){}

	public void mouseClicked(MouseEvent me){}
}





