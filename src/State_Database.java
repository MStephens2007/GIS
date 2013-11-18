import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.*;


public class State_Database {
	List<State_Node> nodes = new ArrayList<State_Node>();
	Pattern coordinatePat = Pattern.compile("[0][.][0-9]*[eE][+-][0-9]*");
	int[] startSet = new int[50];
	private boolean DEBUGTOGGLE = true;
	int counter = 0;
	public State_Database(Path file){
		populateSet();
		Scanner src;
		Charset charset = Charset.forName("US-ASCII");
		try(BufferedReader reader = Files.newBufferedReader(file, charset)){
			String line = null;
			while((line = reader.readLine()) != null){
				if(line.length() == 56){
					src = new Scanner(line);
					double x, y;
					x = src.nextDouble();
					y = src.nextDouble();
					State_Node temp = new State_Node(x, y);
					nodes.add(temp);
					if(DEBUGTOGGLE){
						counter++;
						System.out.println(x + ", " + y);
					}
				}
			}
			
			
			
	} catch (IOException x){
			System.err.format("IOException: %s%n", x);
		}
	}
	public int getSize(){
		return nodes.size();
	}
	private double ennumerate(String x){
		double output = 0;
		Scanner src = new Scanner(x);
		//Pattern base = Pattern.compile("[0][.][0-9]*");
		//Matcher match = base.matcher(x);
		
			System.out.println(src.nextDouble());
		
		return output;
	}
	
	public State_Node getNode(int i){
		State_Node temp = nodes.get(i);
		return temp;
	}
	private void populateSet(){
		for(int i = 1; i <= 50; i++){
			startSet[i-1] = i;
		}
	}
	private boolean search(int key){
		for(int i = 0; i < startSet.length; i++){
			if(startSet[i] == key){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		String output = "The data base is "+ nodes.size() + " nodes large";
		return output;
	}
}


