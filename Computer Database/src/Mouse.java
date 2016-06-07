import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Mouse implements MouseListener, MouseMotionListener{
	DataGUI gui=new DataGUI();
	int x=0,y=0;
	public void mouseDragged(MouseEvent e) {

		
	}

	public void mouseMoved(MouseEvent e) {

		
	}

	public void mouseClicked(MouseEvent e) {
		x++;
		y++;
		gui.getXY(x, y);
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

}
