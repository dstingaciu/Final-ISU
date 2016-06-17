import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;



public class Keys implements KeyListener {
	DataGUI gui=new DataGUI();
	int y=gui.returnAY();
	boolean kx,ky;
	public void keyPressed(KeyEvent e) {
		//if up arrow is pressed move p2's paddle up by 50 or if down arrow is pressed move down by 50
		if(e.getKeyCode()== KeyEvent.VK_UP&&gui.returnAY()>0&&!gui.returnAI()){
			y-=50;
		}else if (e.getKeyCode()== KeyEvent.VK_DOWN&&gui.returnAY()+150<=gui.returnMaxy()&&!gui.returnAI()){
			y+=50;
		}
		gui.getAY(y);
		//if player presses escape end game and process
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
			try {
				gui.finalScore();
			} catch (IOException e1) {
				System.out.println("Error writing final score to file");
			}
			System.exit(0);
		}
		//if player presses game change gamestate to false and pause the game or unpause if already paused
		if(e.getKeyCode()==KeyEvent.VK_P&&gui.returnGS()){
			gui.setGS(false);
		}else if(e.getKeyCode()==KeyEvent.VK_P&&gui.returnGS()==false){
			gui.setGS(true);
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {

		
	}

}
