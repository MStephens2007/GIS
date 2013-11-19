import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;


public class GUIbuttons extends JPanel{
	String mapToggle = "Map: OFF";
	JButton jbtMapToggle;
	Mapping map;
	public GUIbuttons(){
		this.setLayout(new GridLayout(7,2));
		jbtMapToggle = new JButton(mapToggle);
		JButton jbtIDWCompute = new JButton("Compute IDW");
		JLabel jlXIDW = new JLabel("X Value");
		JLabel jlYIDW = new JLabel("Y Value");
		JLabel jlNIDW = new JLabel("N Value");
		JLabel jlPIDW = new JLabel("P Value");
		
		final JTextField jtaXIDW = new JTextField(4);
		final JTextField jtaYIDW = new JTextField(4);
		final JTextField jtaNIDW = new JTextField(4);
		final JTextField jtaPIDW = new JTextField(4);
		
		JLabel jlAnswer = new JLabel("IDW Computation");
		final JTextField jtaAnswer = new JTextField(4);
		JLabel jlTIDW = new JLabel("T Value");
		final JTextField jtaTIDW = new JTextField(4);
		jtaAnswer.setEditable(false);
		add(jbtMapToggle);
		add(jbtIDWCompute);
		
		add(jlXIDW);
		add(jtaXIDW);
		
		add(jlYIDW);
		add(jtaYIDW);
		
		add(jlNIDW);
		add(jtaNIDW);
		
		add(jlPIDW);
		add(jtaPIDW);
		
		add(jlTIDW);
		add(jtaTIDW);
		
		add(jlAnswer);
		add(jtaAnswer);
		//adding action listeners
		jbtMapToggle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(jbtMapToggle.getText() == "Map: ON"){
					jbtMapToggle.setText("Map: OFF");
				}else{
					jbtMapToggle.setText("Map: ON");
					map.toggle(true);
				}
			}
		});
		jbtIDWCompute.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String tempX = jtaXIDW.getText();
				String tempY = jtaYIDW.getText();
				String tempN = jtaNIDW.getText();
				String tempP = jtaPIDW.getText();
				String tempT = jtaTIDW.getText();
				Scanner src = new Scanner(tempX);
				double x = src.nextDouble();
				src = new Scanner(tempY);
				double y = src.nextDouble();
				src = new Scanner(tempN);
				int n = src.nextInt();
				src = new Scanner(tempP);
				double p = src.nextDouble();
				src = new Scanner(tempT);
				double t = src.nextDouble();
				map = new Mapping(false);
				double answer = idwMethod(x,y,t,n,p);
				jtaAnswer.setText(""+answer);
			}
		});
		
	}
	private double idwMethod(double x, double y, double t, int n, double p){
		IDW computation = new IDW(x,y,t,n,p);
		double answer = IDW.getIDW();
		return answer;
	}
	
}
