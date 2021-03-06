import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.swing.*;


public class Mapping {
	static JFrame frame;
	static MapPanel p;
	static Database Gis_Data;
	static State_Database State_Data;
	public Mapping(boolean gui){
		// TODO Auto-generated method stub
		
		//Path measurements = FileSystems.getDefault().getPath("pm25_2009_measured.txt");
		//Gis_Data = new Database(measurements, "GIS");
		Path boundaries = FileSystems.getDefault().getPath("st99_d00.dat");
		State_Database State_Data = new State_Database(boundaries);
		//System.out.println(Gis_Data.toString());
		//System.out.println(State_Data.toString());
		if(gui)makeGUI();
	}
	public void toggle(boolean gui){
		if(gui){
			makeGUI();
		}
	}
	public static void testRange(Database db){
		double max_x = db.getNode(0).getX();
		double min_x = max_x;
		double max_y = db.getNode(0).getY();
		double min_y = max_y;
		for(int i = 1; i < db.getSize(); i++){
			Data_Node temp = db.getNode(i);
			if(temp.getX() > max_x){
				max_x = temp.getX();
			}else if(temp.getX() < min_x){
				min_x = temp.getX();
			}
			if(temp.getY() > max_y){
				max_y = temp.getY();
			}else if(temp.getY() < min_y){
				min_y = temp.getY();
			}
		}
		
		System.out.println("Max X value is "+ max_x + ", min value is "+ min_x + ". Difference is " + (max_x - min_x));
		System.out.println("Max Y value is "+ max_y + ", min value is "+ min_y + ". Difference is " + (max_y - min_y));
	}
	public static void makeGUI(){
		frame = new JFrame();
		frame.setSize(1900,1200);
		frame.setTitle("Map");
		frame.setVisible(true);
		p = new MapPanel(Gis_Data,State_Data);
		frame.add(p);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

}
