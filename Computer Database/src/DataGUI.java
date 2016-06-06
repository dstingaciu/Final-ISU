import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.*;
public class DataGUI {
		JFrame frame;
		JLabel blah;
		JPanel panel,menu;
		public DataGUI(){

			frame=new JFrame("Poker");
			
			panel=new JPanel();
			panel.setLayout(new GridBagLayout());
			frame.setContentPane(panel);
			panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
			
			
			frame.getContentPane().setBackground(Color.gray);
			frame.setContentPane(panel);
			frame.pack();
			frame.setVisible(true);
			frame.setSize(1280,1024);
			
			JButton add=new JButton("Add");
			JButton remove=new JButton("Remove");
			JButton exit=new JButton("Exit");
			panel.add(add);
			panel.add(remove);
			panel.add(exit);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}
