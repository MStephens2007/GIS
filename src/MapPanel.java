import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;


public class MapPanel extends JPanel{
	Database db;
	State_Database sdb;
	int counter = 0;
	JButton jbtNextDay;
	Boolean borderDraw = true;
	Boolean dataDraw = false;
	public MapPanel(Database gisData, State_Database stateData){
		this.db = gisData;
		this.sdb = stateData;
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		int getHeight = this.getHeight();
		int getWidth = this.getWidth();
		if(dataDraw){
		for(int i = 0; i < db.getSize(); i++){
			Data_Node temp = db.getNode(i);
			char[] txt = {'*'};
			g2.drawChars(txt, 0, 1,(int)(temp.getX()*-10), (int)(temp.getY()*10));
			System.out.println("Drawing at " + temp.getX()*-10 + ", " + temp.getY()*10);
		}
		}
		if(borderDraw){
			//for(int i = 0; i < 100000; i++){
				System.out.println(sdb.toString());
			//}
		}
			
	}
	
}
