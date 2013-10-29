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
	private boolean DEBUGTOGGLE = false;
	int counter = 0;
	public State_Database(Path file){
		Scanner src;
		Charset charset = Charset.forName("US-ASCII");
		try(BufferedReader reader = Files.newBufferedReader(file, charset)){
			String line = null;
			
			while((line = reader.readLine()) != null){
				src = new Scanner(line);
					Matcher matcher = coordinatePat.matcher(src.nextLine());
					while(matcher.find()){
						
						if(counter > 1){
							System.out.print(matcher.group());
							System.out.print(": " + "Line " + counter);
							System.out.println();
							counter = 0;
						}else{
							System.out.print(matcher.group() + " ");
						}
						counter++;
						
					}
					if(DEBUGTOGGLE){
						counter++;
						System.out.println(nodes.size() + ": list size");
					}
			
			}
		} catch (IOException x){
			System.err.format("IOException: %s%n", x);
		}
		if(DEBUGTOGGLE){
			System.out.println("Data points:" + counter);
		}
	}
	public int getSize(){
		return nodes.size();
	}
	public State_Node getNode(int i){
		State_Node temp = nodes.get(i);
		return temp;
	}
}
