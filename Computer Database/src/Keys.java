import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;


public class Keys implements KeyListener {
	DataGUI gui=new DataGUI();
	int y=gui.returnAY();
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_UP&&gui.returnAY()>0){
			y-=20;
		}else if (e.getKeyCode()== KeyEvent.VK_DOWN&&gui.returnAY()+150<=gui.returnMaxy()){
			y+=20;
		}
		gui.getAXY(y);
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_P&&gui.returnGS()){
			gui.setGS(false);
			System.out.println("False");
		}else if(e.getKeyCode()==KeyEvent.VK_P&&gui.returnGS()==false){
			gui.setGS(true);
			System.out.println("True");
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {

		
	}

}
