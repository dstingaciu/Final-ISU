import java.io.IOException;

public class AI {
	DataGUI gui=new DataGUI();
	public int y=gui.returnAY(),inst=0;
	
	/*If ai is enabled then make the paddle move towards y pos of ball
	 * pre: ai must be enabled
	 * post:moves p2's paddle
	 */
	public void doAI()throws IOException{
		int n=(int)(Math.random()*15+0);
		if(gui.returnAY()+(150+n)<gui.returnDY()){
			y+=2;
			gui.getAY(y);
		}else if(gui.returnAY()-n>gui.returnDY()){
			y-=2;
			gui.getAY(y);
		}
	}
}
