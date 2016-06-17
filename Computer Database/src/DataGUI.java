import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
public class DataGUI extends JComponent{
		static JFrame frame,menu;
		static JLabel blah;
		static JPanel menuP=new JPanel();
		static int x,y,maxx=900,maxy=600,ax=maxx-30,ay,p1=0,p2=0,dx=maxx/2,dy=maxy/2,scorePosX1,scorePosX2;
		static DataGUI link = new DataGUI(); 
		static Ball ball=new Ball(dx,dy,maxx,maxy);
		static String winner=" ";
		static boolean gamestate,trip=false;
		HighScores hs=new HighScores();


		public static void main(String[]args) throws InterruptedException, IOException{
			
			link.showMenu();
			while(!gamestate){
				System.out.println();
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
			JPanel blah=new JPanel(new BorderLayout());
			blah.setBorder(new BevelBorder(BevelBorder.RAISED));
			JLabel title=new JLabel("PONG",SwingConstants.CENTER);
			title.setFont(new Font("Arial",Font.PLAIN,100));
			JPanel north=new JPanel(new GridLayout(0,1,5,5));
			north.add(title);
			blah.add(north,BorderLayout.NORTH);
			JPanel center = new JPanel(new GridLayout(0,1,10,10));
			JButton start=new JButton("Start");
			start.setFont(new Font("Arial",Font.PLAIN,50));
			JButton exit=new JButton("Exit");
			exit.setFont(new Font("Arial",Font.PLAIN,50));
			JButton HTP=new JButton("How to Play");
			HTP.setFont(new Font("Arial",Font.PLAIN,50));
			title.setForeground(Color.white);
			title.setBackground(Color.black);
			start.setBackground(Color.black);
			start.setForeground(Color.white);
			exit.setBackground(Color.black);
			exit.setForeground(Color.white);
			HTP.setForeground(Color.white);
			HTP.setBackground(Color.black);
			center.add(start);
			center.add(HTP);
			center.add(exit);
			start.addActionListener(new StartEvent());
			exit.addActionListener(new ExitEvent());
			HTP.addActionListener(new HTPEvent());
			center.setBorder(new EmptyBorder(40,70,40,70));
			blah.add(center, BorderLayout.CENTER);
			blah.setBackground(Color.black);
			blah.setForeground(Color.black);
			north.setBackground(Color.black);
			north.setForeground(Color.black);
			center.setBackground(Color.black);
			center.setForeground(Color.black);
			
			menu.setContentPane(blah);
			menu.setVisible(true);
			menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
		public void instructionMenu(){
			String a="Player 1 is on the left, using the mouse";
			String b="Player 2 is on the right using the arrow";
			String c="keys on the keyboard";
			String d="the objective of the game is to hit the";
			String e="ball with your paddle";
			String f="the player wins a point when their opponent";
			String g="gets lets a ball through";
			String h="Press P to pause the game";
			JPanel blah=new JPanel(new BorderLayout());
			JPanel inst=new JPanel();
			JLabel aq=new JLabel(a,SwingConstants.CENTER);
			JLabel bq=new JLabel(b,SwingConstants.CENTER);
			JLabel cq=new JLabel(c,SwingConstants.CENTER);
			JLabel dq=new JLabel(d,SwingConstants.CENTER);
			JLabel eq=new JLabel(e,SwingConstants.CENTER);
			JLabel fq=new JLabel(f,SwingConstants.CENTER);
			JLabel gq=new JLabel(g,SwingConstants.CENTER);
			JLabel hq=new JLabel(h,SwingConstants.CENTER);
			aq.setFont(new Font("Arial",Font.PLAIN,30));
			aq.setForeground(Color.white);
			aq.setBackground(Color.black);
			bq.setFont(new Font("Arial",Font.PLAIN,30));
			bq.setForeground(Color.white);
			bq.setBackground(Color.black);
			cq.setFont(new Font("Arial",Font.PLAIN,30));
			cq.setForeground(Color.white);
			cq.setBackground(Color.black);
			dq.setFont(new Font("Arial",Font.PLAIN,30));
			dq.setForeground(Color.white);
			dq.setBackground(Color.black);
			eq.setFont(new Font("Arial",Font.PLAIN,30));
			eq.setForeground(Color.white);
			eq.setBackground(Color.black);
			fq.setFont(new Font("Arial",Font.PLAIN,30));
			fq.setForeground(Color.white);
			fq.setBackground(Color.black);
			gq.setFont(new Font("Arial",Font.PLAIN,30));
			gq.setForeground(Color.white);
			gq.setBackground(Color.black);
			hq.setForeground(Color.white);
			hq.setBackground(Color.black);
			hq.setFont(new Font("Arial",Font.PLAIN,30));
			inst.setForeground(Color.white);
			inst.setBackground(Color.black);
			inst.add(aq);
			inst.add(bq);
			inst.add(cq);
			inst.add(dq);
			inst.add(eq);
			inst.add(fq);
			inst.add(gq);
			inst.add(hq);
			
			blah.setBorder(new BevelBorder(BevelBorder.RAISED));
			blah.add(inst, BorderLayout.CENTER);
			JPanel south = new JPanel(new GridLayout(0,1,10,10));
			JButton start=new JButton("Start");
			start.setFont(new Font("Arial",Font.PLAIN,50));
			JButton back=new JButton("Go Back");
			back.setFont(new Font("Arial",Font.PLAIN,50));
			start.setForeground(Color.white);
			start.setBackground(Color.black);
			back.setForeground(Color.white);
			back.setBackground(Color.black);
			start.addActionListener(new StartEvent());
			back.addActionListener(new BackEvent());
			south.add(start);
			south.add(back);
			south.setBorder(new EmptyBorder(40,70,40,70));
			south.setForeground(Color.white);
			south.setBackground(Color.black);
			blah.add(south, BorderLayout.SOUTH);
			menu.setContentPane(blah);
			menu.revalidate();
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
				
				g2d.drawString(p1S,properScore1(),150);
				g2d.drawString(p2S,(maxx/2)+50,150);
				g2d.fillOval(dx, dy, 25, 25);
				g2d.setFont(new Font("Arial",Font.PLAIN,50));
				g2d.drawString(winner, maxx/3, maxy/2);
		}
		
		public int properScore1(){
			if(p1>=10){
				scorePosX1=(maxx/2)-300;
			}else{
				scorePosX1=(maxx/2)-150;
			}
			return scorePosX1;
			
		}
		public int properScore2(){
			if(p2>=10){
				scorePosX2=(maxx/2)+100;
			}else{
				scorePosX2=(maxx/2)+50;
			}
			return scorePosX2;
			
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
		
		class HTPEvent implements ActionListener{

			public void actionPerformed(ActionEvent event) {
				instructionMenu();
				
			}
			
		}
		class BackEvent implements ActionListener{

			public void actionPerformed(ActionEvent event) {
				showMenu();
				
			}
		}
		
		
}
