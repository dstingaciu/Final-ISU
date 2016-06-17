import java.io.IOException;

public class AI {
	DataGUI gui=new DataGUI();
	public int y=gui.returnAY(),inst=0;
	
	/*If ai is enabled then make the paddle move towards y pos of ball
	 * pre: ai must be enabled
	 * post:moves p2's paddle
	 */
	public void doAI()throws IOException{
		if(gui.returnAY()+150<gui.returnDY()){
			y++;
			gui.getAY(y);
		}else if(gui.returnAY()>gui.returnDY()){
			y--;
			gui.getAY(y);
		}
	}
}
