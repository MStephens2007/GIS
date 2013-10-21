
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
	private boolean DEBUGTOGGLE = true;
	int counter = 0;
	public static void main(String[] args) {
		Path p1 = Paths.get("pm25_2009_measured.txt");
		Database myGIS = new Database(p1);
		
	}
	public Database(Path file){
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
			}
		} catch (IOException x){
			System.err.format("IOException: %s%n", x);
		}
		if(DEBUGTOGGLE){
			System.out.println("Data points:" + counter);
		}
	}

}
