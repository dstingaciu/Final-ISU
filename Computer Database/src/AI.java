import java.io.IOException;

public class AI {
	DataGUI gui=new DataGUI();
	public int y=gui.returnAY(),inst=0;
	
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
