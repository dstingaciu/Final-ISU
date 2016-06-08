import java.awt.Color;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;

import javax.swing.*;
public class DataGUI extends JComponent {
		static JFrame frame;
		static JLabel blah;
		static int x,y,maxx=1280,maxy=1024;
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

			frame.setSize(maxx,maxy);
			frame.add(link);
			frame.addMouseListener(new Mouse());
			frame.addMouseMotionListener(new Mouse());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setBackground(Color.white);
			frame.setVisible(true);

		}
		public void getXY(int a,int b){
			x=a;
			y=b;
			link.repaint();
		}
		public int returnX(){
			return x;
		}
		public int returnY(){
			return y;
		}
		
		public void paint(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawRect(x, y, 30, 150);
			g2d.drawRect(maxx, maxy, 30, 150);
		}
}
