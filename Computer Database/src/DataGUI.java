import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;

import javax.swing.*;
public class DataGUI extends JPanel {
		JFrame frame;
		JLabel blah;
		int x,y;
		DataGUI link = new DataGUI(); 
		public DataGUI(){

			frame=new JFrame("Poker");
			
			frame.getContentPane().setBackground(Color.gray);
			frame.pack();
			frame.setVisible(true);
			frame.setSize(1280,1024);
			frame.add(link);
			frame.addMouseListener(new Mouse());
			frame.addMouseMotionListener(new Mouse());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public void getXY(int a,int b){
			x=a;
			y=b;
		}
		
		class surface extends JPanel{
		
			public void paint(Graphics g){
				Graphics2D g2d = (Graphics2D) g;
				g2d.drawOval(x, y, 300, 300);
			}
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				paint(g);
			}
		}
}
