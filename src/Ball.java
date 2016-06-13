
public class Ball {
	
	int dx,dy,maxx,maxy,pax,pay,pbx,pby,direction,p1=0,p2=0;
	DataGUI gui=new DataGUI();
	public Ball(int dx,int dy,int maxx,int maxy){
		this.dx=dx;
		this.dy=dy;
		this.maxx=maxx;
		this.maxy=maxy;
	}
	public void main() throws InterruptedException{
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
		if(hitDetection()==1){
			gui.setWinner1();
		}else{
			gui.setWinner2();
		}
		
	}
	
	public void dR(){
		dx++;
		dy++;
	}
	public void dL(){
		dx--;
		dy++;
	}
	public void uR(){
		dx++;
		dy--;
	}
	public void uL(){
		dx--;
		dy--;
	}
	public int returnDX(){
		return dx;
	}
	public int returnDY(){
		return dy;
	}
	
	//Send x and y coordinates back to gui
	public int hitDetection() throws InterruptedException{
		Thread.sleep(10);
		if(dx<=0){
			p1++;
			gui.setP1(p1);
			dx=maxx/2;
			dy=maxy/2;
			return 1;
		}else if(dx>maxx){
			p2++;
			gui.setP2(p2);
			dx=maxx/2;
			dy=maxy/2;
			hitDetection();
			return 2;
		}
		
		if((direction==1&&dy>=maxy)||(direction==1&&dx<(gui.returnX()+30)&&dy<(gui.returnY()+150))||(direction==1&&dx<(gui.returnAX()+30)&&dy<(gui.returnAY()+150))){
			direction=3;
			gui.getDX(dx);
			gui.getDY(dy);
			hitDetection();
		}else if (direction==2&&dy>=maxy||(direction==2&&dx<(gui.returnX()+30)&&dy<(gui.returnY()+150))||(direction==2&&dx<(gui.returnAX()+30)&&dy<(gui.returnAY()+150))){
			direction=4;
			gui.getDX(dx);
			gui.getDY(dy);
			hitDetection();
		}else if(direction==3&&dy<=0||(direction==3&&dx<(gui.returnX()+30)&&dy<(gui.returnY()+150))||(direction==3&&dx<(gui.returnAX()+30)&&dy<(gui.returnAY()+150))){
			direction=1;
			gui.getDX(dx);
			gui.getDY(dy);
			hitDetection();
		}else if(direction==4&&dy<=0||(direction==4&&dx<(gui.returnX()+30)&&dy<(gui.returnY()+150))||(direction==4&&dx<(gui.returnAX()+30)&&dy<(gui.returnAY()+150))){
			direction=2;
			gui.getDX(dx);
			gui.getDY(dy);
			hitDetection();
		}
		
		if(direction==1){
			dR();
			gui.getDX(dx);
			gui.getDY(dy);
			hitDetection();
		}else if(direction==2){
			dL();
			gui.getDX(dx);
			gui.getDY(dy);
			hitDetection();
		}else if(direction==3){
			uR();
			gui.getDX(dx);
			gui.getDY(dy);
			hitDetection();
		}else if(direction==4){
			uL();
			gui.getDX(dx);
			gui.getDY(dy);
			hitDetection();
		}
		return 3;
	}
		
}
