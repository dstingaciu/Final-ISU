
public class Ball {
	
	int dx,dy,maxx,maxy,pax,pay,pbx,pby,direction;
	DataGUI gui=new DataGUI();
	
	public void Ball(int dx,int dy,int maxx,int maxy,int pax,int pay,int pbx,int pby){
		this.dx=dx;
		this.dy=dy;
		this.maxx=maxx;
		this.maxy=maxy;
		this.pax=pax;
		this.pay=pay;
		this.pbx=pbx;
		this.pby=pby;
	}
	public void main(){
		direction=(int)(Math.random()*4+1);
		if(direction==1)
			dR();
		else if(direction==2)
			dL();
		else if(direction==3)
			uR();
		else if(direction==4)
			uL();
		
		
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
	
	//Send x and y coordinates back to gui
	public int hitDetection() throws InterruptedException{
		Thread.sleep(1000);
		if(dx<=0){
			return 1;
		}else if(dx>maxx){
			return 2;
		}
		
		if(direction==1&&dy>=maxy){
			direction=3;
			hitDetection();
		}else if (direction==2&&dy>=maxy){
			direction=4;
			hitDetection();
		}else if(direction==3&&dy<=0){
			direction=1;
			hitDetection();
		}else if(direction==4&&dy<=0){
			direction=2;
			hitDetection();
		}
		
		if(direction==1){
			dR();
			hitDetection();
		}else if(direction==2){
			dL();
			hitDetection();
		}else if(direction==3){
			uR();
			hitDetection();
		}else if(direction==4){
			uL();
			hitDetection();
		}
		return 3;
	}
		
}
