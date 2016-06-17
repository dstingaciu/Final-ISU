import java.io.IOException;


public class Ball {
	
	int dx,dy,maxx,maxy,pax,pay,pbx,pby,direction,p1=0,p2=0,aix,aiy;
	DataGUI gui=new DataGUI();
	AI ai=new AI();
	/*
	 * gets neccessary variables for calculations
	 * pre:none
	 * post: assigns value to variables
	 */
	public Ball(int dx,int dy,int maxx,int maxy){
		this.dx=dx;
		this.dy=dy;
		this.maxx=maxx;
		this.maxy=maxy;
	}

	/*
	 * Moves ball to bottom right corner
	 * pre:none
	 * post:changes y and x post of ball
	 */
	public void dR(){
		dx++;
		dy++;
	}
	/*
	 * Moves ball to bottom left corner
	 * pre:none
	 * post:changes y and x post of ball
	 */
	public void dL(){
		dx--;
		dy++;
	}
	/*
	 * Moves ball to upper right corner
	 * pre:none
	 * post:changes y and x post of ball
	 */
	public void uR(){
		dx++;
		dy--;
	}
	/*
	 * Moves ball to upper left corner
	 * pre:none
	 * post:changes y and x post of ball
	 */
	public void uL(){
		dx--;
		dy--;
	}
	/*
	 * Returns x pos of ball
	 * pre:none
	 * post:none
	 */
	public int returnDX(){
		return dx;
	}
	/*
	 * Returns y pos of ball
	 * pre:none
	 * post:none
	 */
	public int returnDY(){
		return dy;
	}
	/*
	 * Returns direction
	 * pre:none
	 * post:none
	 */
	public int returnDirection(){
		return direction;
	}
	
	/*
	 * Moves ball first time and continually goes into hit detection until one player wins
	 * pre:Gamestate must be true
	 * post:none
	 */
	public void main() throws InterruptedException, IOException{
		direction=(int)(Math.random()*4+1);
		if(direction==1)
			dR();
		else if(direction==2)
			dL();
		else if(direction==3)
			uR();
		else if(direction==4)
			uL();
		gui.getDX(dx);
		gui.getDY(dy);
		int n=3;
		gui.setDirection(direction);
		do{
			if(gui.returnGS()){
				n=hitDetection();
				if(gui.returnAI()){
					ai.doAI();
					}
			}
		}while(n>2);
		if(n==2){
			gui.setWinner1();
		}else{
			gui.setWinner2();
		}
		
	}
	/*continually checks where ball is and where its moving based on its direction, it also detects if it hits a wall or paddle
	 * and changes direction accordingly
	 * pre:Gamestate must be true
	 * post:none
	 */
	
	public int hitDetection() throws InterruptedException, IOException{
		gui.setDirection(direction);
		Thread.sleep(2);
		if(dx<=0){
			p2++;
			gui.setP2(p2);
			dx=maxx/2;
			dy=maxy/2;
			return 1;
		}else if(dx>maxx){
			p1++;
			gui.setP1(p1);
			dx=maxx/2;
			dy=maxy/2;
			return 2;
		}
		
		if((direction==1&&dy>=maxy-25)){
			direction=3;
			uR();
			gui.getDX(dx);
			gui.getDY(dy);
		}else if (direction==2&&dy>=maxy-25){
			dR();
			direction=4;
			gui.getDX(dx);
			gui.getDY(dy);
		}else if(direction==3&&dy<=0){
			direction=1;
			dR();
			gui.getDX(dx);
			gui.getDY(dy);
			
		}else if(direction==4&&dy<=0){
			direction=2;
			dL();
			gui.getDX(dx);
			gui.getDY(dy);
			
		}else if(direction==1&&(dx>=gui.returnAX()-30&&dy>gui.returnAY()&&dy<gui.returnAY()+150)){
			direction=2;
			dL();
			gui.getDX(dx);
			gui.getDY(dy);
		}else if(direction==2&&(dx<=gui.returnX()+30&&dy>gui.returnY()&&dy<gui.returnY()+150)){
			direction=1;
			dR();
			gui.getDX(dx);
			gui.getDY(dy);
		}else if(direction==3&&(dx>=gui.returnAX()-35&&dy>gui.returnAY()-10&&dy<gui.returnAY()+150)){
			direction=4;
			uL();
			gui.getDX(dx);
			gui.getDY(dy);
		}else if (direction==4&&(dx<=gui.returnX()+30&&dy>gui.returnY()&&dy<gui.returnY()+150)){
			direction=3;
			uR();
			gui.getDX(dx);
			gui.getDY(dy);
		}
		
		if(direction==1){
			dR();
			gui.getDX(dx);
			gui.getDY(dy);
		}else if(direction==2){
			dL();
			gui.getDX(dx);
			gui.getDY(dy);
		}else if(direction==3){
			uR();
			gui.getDX(dx);
			gui.getDY(dy);
		}else if(direction==4){
			uL();
			gui.getDX(dx);
			gui.getDY(dy);
		}
		return 3;
	}
		
		
}
