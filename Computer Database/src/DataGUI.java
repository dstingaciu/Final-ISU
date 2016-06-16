import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
public class DataGUI extends JComponent{
		static JFrame frame,menu;
		static JLabel blah;
		static JPanel menuP=new JPanel();
		static int x,y,maxx=900,maxy=600,ax=maxx-30,ay,p1=0,p2=0,dx=maxx/2,dy=maxy/2;
		static DataGUI link = new DataGUI(); 
		static Ball ball=new Ball(dx,dy,maxx,maxy);
		static String winner=" ";
		static boolean gamestate,trip=false;
		HighScores hs=new HighScores();


		public static void main(String[]args) throws InterruptedException, IOException{
			
			link.showMenu();
			while(!gamestate){
			if(gamestate){
				trip=true;
				menu.setVisible(false);
				menu.dispose();
				frame=new JFrame("Pong");
				frame.setUndecorated(true);
				frame.setSize(maxx,maxy);
				frame.add(link);
				frame.addMouseListener(new Mouse());
				frame.addMouseMotionListener(new Mouse());
				frame.addKeyListener(new Keys());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setBackground(Color.black);
				frame.setVisible(true);
				ball.main();
			}
			}
			if(!trip){
				menu.setVisible(false);
				menu.dispose();
				frame=new JFrame("Pong");
				frame.setUndecorated(true);
				frame.setSize(maxx,maxy);
				frame.add(link);
				frame.addMouseListener(new Mouse());
				frame.addMouseMotionListener(new Mouse());
				frame.addKeyListener(new Keys());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setBackground(Color.black);
				frame.setVisible(true);
				ball.main();
			}
			

		}
		public void showMenu(){
			menu=new JFrame("Pong");
			menu.setUndecorated(true);
			menu.setSize(maxx, maxy);
			menu.setContentPane(menuP);
			JButton start=new JButton("Start");
			JButton exit=new JButton("Exit");
			start.setBackground(Color.black);
			start.setForeground(Color.white);
			exit.setBackground(Color.black);
			exit.setForeground(Color.white);
			start.addActionListener(new StartEvent());
			exit.addActionListener(new ExitEvent());
			menuP.add(start);
			menuP.add(exit);
			menuP.setBackground(Color.black);
			menu.setVisible(true);
			menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
		public void getXY(int b){
			y=b;
			link.repaint();
		}
		public void getDX(int a){
			dx=a;
			link.repaint();
		}
		public boolean returnGS(){
			return gamestate;

		}
		public void setGS(boolean x){
			gamestate=x;
		}
		public void getDY(int b){
			dy=b;
			link.repaint();
		}
		
		public void ballXY(int a,int b){
			dx=a;
			dy=b;
			link.repaint();
		}
		
		public int returnMaxX(){
			return maxx;
		}
		public int returnMaxy(){
			return maxy;
		}
		public int returnX(){
			return x;
		}
		public int returnY(){
			return y;
		}
		public int returnAY(){
			return ay;
		}
		public int returnAX(){
			return ax;
		}
		public void getAXY(int b){
			ay=b;
			link.repaint();
		}
		public void setP1(int a){
			p1=a;
			link.repaint();
		}
		public void setP2(int b){
			p2=b;
			link.repaint();
		}
		public void setWinner1() throws InterruptedException, IOException{
			winner="Player 1 Wins";
			writeRoundsP1();
			link.repaint();
			Thread.sleep(1000);
			winner="";
			link.repaint();
			ball.main();
		}
		public void setWinner2() throws InterruptedException, IOException{
			winner="Player 2 Wins";
			writeRoundsP2();
			link.repaint();
			Thread.sleep(1000);
			winner="";
			link.repaint();
			ball.main();
		}
		
		public void writeRoundsP1() throws IOException{
			String P1winner="Player 1 has clinched the match to make it "+p1+" to "+p2;
			hs.HighScore(P1winner);
		}
		
		public void writeRoundsP2() throws IOException{
			String P2Winner="Player 2 has clinched the match to make it "+p1+" to "+p2;
			hs.HighScore(P2Winner);
		}
		
		public void finalScore() throws IOException{
			if(p1>p2){
				hs.HighScore("The final score is "+p1+" to "+p2+" for player one");
				hs.HighScore("===========================END OF SESSION===========================");
			}else if(p2>p1){
				hs.HighScore("The final score is "+p1+" to "+p2+" for player two");
				hs.HighScore("===========================END OF SESSION===========================");
			}else{
				hs.HighScore("The final score is tied "+p1+" to "+p2);
				hs.HighScore("===========================END OF SESSION===========================");
			}
				
		}
		
		public void paint(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(Color.white);
				g2d.drawLine(maxx/2, 0, maxx/2, maxy);
				g2d.fillRect(x, y, 30, 150);
				g2d.fillRect(ax, ay, 30, 150);
				g2d.setFont(new Font("Arial",Font.PLAIN,200));
				String p1S=Integer.toString(p1);
				String p2S=Integer.toString(p2);
				g2d.drawString(p1S,(maxx/2)-150,150);
				g2d.drawString(p2S,(maxx/2)+50,150);
				g2d.fillOval(dx, dy, 25, 25);
				g2d.setFont(new Font("Arial",Font.PLAIN,50));
				g2d.drawString(winner, maxx/2, maxy/2);
		}
		
		class StartEvent implements ActionListener{

			public void actionPerformed(ActionEvent event) {
				gamestate=true;

				
			}
			
		}
		
		class ExitEvent implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
				
			}
			
		}
		
		
}
