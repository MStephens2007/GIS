import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JSplitPane;


public class GUI extends JFrame{
	public String mapToggle = "Map: ON";
	GUIbuttons buttons;
	public GUI(){
		JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		logoPanel logo = new logoPanel();
		sp.add(logo);
		sp.add(buttons = new GUIbuttons());
		sp.setResizeWeight(.8);
		sp.setEnabled(false);
		sp.setDividerSize(1);
		add(sp);
		
	}
	public static void main(String[] args) {
		GUI frame = new GUI();
		frame.setTitle("GIS");
		frame.setSize(400,550);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
