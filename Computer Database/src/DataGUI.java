import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;
public class DataGUI extends JComponent {
		static JFrame frame;
		static JLabel blah;
		static int x,y,maxx=1280,maxy=1024,ax=1280,ay,p1=0,p2=0,dx=maxx/2,dy=maxy/2;
		static DataGUI link = new DataGUI(); 
		public static void main(String[]args){
			/*Scanner input=new Scanner(System.in);
			System.out.println("Enter X Resolution: ");
			int maxx=input.nextInt();
			System.out.println("Enter Y Resolution: ");
			int maxy=input.nextInt();
			input.close();
			*/
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

		}
		public void getXY(int b){
			y=b;
			link.repaint();
		}
		
		public void ballXY(int a,int b){
			dx=a;
			dy=b;
			link.repaint();
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
		public void getAXY(int b){
			ay=b;
			link.repaint();
		}
		
		public void paint(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.white);
			g2d.drawLine(maxx/2, 0, maxx/2, maxy);
			g2d.fillRect(x, y, 30, 150);
			g2d.fillRect(maxx-30, ay, 30, 150);
			g2d.setFont(new Font("Arial",Font.PLAIN,200));
			String p1S=Integer.toString(p1);
			String p2S=Integer.toString(p2);
			g2d.drawString(p1S,(maxx/2)-150,150);
			g2d.drawString(p2S,(maxx/2)+50,150);
			g2d.fillOval(dx, dy, 25, 25);
		}
		
}
