import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;


public class MapPanel extends JPanel{
	Database db;
	int counter = 0;
	JButton jbtNextDay;
	
	public MapPanel(Database db){
		this.db = db;
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		int getHeight = this.getHeight();
		int getWidth = this.getWidth();
		g2.drawLine(0, getHeight/2, getWidth, getHeight/2);
		g2.drawLine(getWidth/2, 0, getWidth/2, getHeight);
		for(int i = 1; i < db.getSize(); i++){
			Data_Node temp = db.getNode(i);
			char[] txt = {'*'};
			g2.drawChars(txt, 0, 1,(int)(temp.getX()*-10), (int)(temp.getY()*10));
			System.out.println("Drawing at " + temp.getX()*-10 + ", " + temp.getY()*10);
		}
		
		/*if(counter < db.getSize()){
			Data_Node temp = db.getNode(counter);
			char[] txt = {'*'};
			g.drawChars(txt, 0, 1,(int)temp.getX()*-10, (int)temp.getY()*10);
		}
		counter++;
		if(counter % 1000 == 0){
			System.out.println("finished " + counter);
		}*/
			
	}
	
}
