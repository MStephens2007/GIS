
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Database {
	List<Data_Node> nodes = new ArrayList<Data_Node>();
	private boolean DEBUGTOGGLE = false;
	int counter = 0;
	
	public Database(Path file, String type){
		Scanner src;
		Charset charset = Charset.forName("US-ASCII");
		try(BufferedReader reader = Files.newBufferedReader(file, charset)){
			String line = null;
			
			while((line = reader.readLine()) != null){
				src = new Scanner(line);
				
					double x = src.nextDouble();
					double y = src.nextDouble();
					double time = src.nextDouble();
					double meas = src.nextDouble();
					Data_Node temp = new Data_Node(x,y,time,meas);
					nodes.add(temp);
					if(DEBUGTOGGLE){
						counter++;
						System.out.println(nodes.size() + ": list size");
						System.out.println(x + ", " + y + ", " + ", " + time + ", " + meas);
					}
			/*else if(type == "STATE"){
				//if(src.next() == "1"){
					//System.out.println("Waste");
				//}
				String x = src.next();
				String y = src.next();
				State_Node temp = new State_Node(x, y);
				nodes.add(temp);
				if(DEBUGTOGGLE){
					counter++;
					System.out.println(nodes.size() + ": list size");
					System.out.println(x + ", " + y + ", ");
				}
			}*/
			}
		} catch (IOException x){
			System.err.format("IOException: %s%n", x);
		}
		if(DEBUGTOGGLE){
			System.out.println("Data points:" + counter);
		}
	
	}
	public Data_Node getNode(int n){
		if(n < nodes.size()-1){
			return nodes.get(n);
		}
		else{
			System.err.println("OUT OF BOUNDS");
			Data_Node temp = new Data_Node(0,0,0,0);
			return temp;
		}
	}
	public int getSize(){
		return nodes.size();
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("There are " + nodes.size() + " data points");
		return sb.toString();
	}
	
	

}
