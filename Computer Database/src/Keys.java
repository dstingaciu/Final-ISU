import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keys implements KeyListener {
	DataGUI gui=new DataGUI();
	int y=gui.returnAY();
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_UP&&gui.returnAY()>0){
			y-=20;
		}else if (e.getKeyCode()== KeyEvent.VK_DOWN&&gui.returnAY()+150<=1024){
			y+=20;
		}
		gui.getAXY(y);
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {

		
	}

}
