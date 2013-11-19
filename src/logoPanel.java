import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class logoPanel extends JPanel{
	BufferedImage logo;
	public logoPanel(){
		try{
			logo = ImageIO.read(new File("logo.png"));
		}catch (IOException e){
			
		}
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("Drawing image");
		g.drawImage(logo,22,0,null);
	}
}
