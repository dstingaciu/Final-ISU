import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Mouse implements MouseListener, MouseMotionListener{
	DataGUI gui=new DataGUI();
	int y=0;
	public void mouseDragged(MouseEvent e) {
		if(gui.returnY()+150<=1024&&gui.returnY()>=0&&e.getY()+150<=1024&&e.getY()<=(gui.returnY()+150)){
			y=e.getY();
			gui.getXY(y);
		}
		System.out.println("Mouse: "+(gui.returnY()+150));

		
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
