import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Mouse implements MouseListener, MouseMotionListener{
	DataGUI gui=new DataGUI();
	int x=0,y=0;
	public void mouseDragged(MouseEvent e) {
		if(e.getX()<=(gui.returnX()+640)&&e.getY()<=(gui.returnY()+150)&&e.getY()+150<1024){
			y=e.getY();
			gui.getXY(x, y);
		}

		
	}

	public void mouseMoved(MouseEvent e) {

		
	}

	public void mouseClicked(MouseEvent e) {


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
