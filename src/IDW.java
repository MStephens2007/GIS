import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class IDW {

	/*-------------------NOTES FOR LATER-----------------------
	 * --------------------------------------------------------
	 * THE FIRST VALUE OR X0,Y0,T0 IS THE PREDICTED VALUE AT LOCATION (
	 */

	private static double lamda(double p, double x, double y, double t,
			Data_Node node, Data_Node[] nodes) {

		double top = Math.pow((1 / dist(x, y, t, node)), p);

		double bot = 0;
		int k = 1;
		while (k <= nodes.length) {
			bot += Math.pow(1 / (dist(x, y, t, nodes[k - 1])), p);
			k++;
		}

		return top / bot;
	}

	//distance formula
	private static double dist(double x, double y, double t, Data_Node node) {
		return Math.pow(Math.pow((node.x - x), 2) + Math.pow((node.y - y), 2)
				+ Math.pow((node.time - t), 2), 0.5);
	}

	//measurement at time
	private static double WiT(double time, Data_Node neighbor, int n,
			Data_Node[] allValues) {
		Data_Node begining = neighbor, ending = neighbor;
		for (Data_Node d : allValues) {
			if (d.time < begining.time)
				begining = d;
			if (d.time > ending.time)
				ending = d;
		}
		double bottom = ending.time - begining.time;
		double firstTime = begining.measurement
				* ((ending.time - time) / (bottom));
		double secondTime = ending.measurement
				* ((time - begining.time) / (bottom));
		double answer = firstTime + secondTime;

		return answer;

	}

	// Main formula to calculate, xcoord, ycorrd, time, number of neighbors,
	// factor
	public static double W(double x, double y, double t, int n, double p) {
		Data_Node[] nodes = getNearestNeighbors(x, y, t, n);
		int answer = 0;

		int i = 1;
		while (i <= n) {
			// System.out.println("WIT: " + WiT(t,
			// nodes[i-1],n,getAllValuesOf(nodes[i-1])));
			answer += lamda(p, x, y, t, nodes[i - 1], nodes)
					* WiT(t, nodes[i - 1], n, getAllValuesOf(nodes[i - 1]));
			i++;
		}

		return answer;
	}

	//get all the nodes of a certain x,y coordinate
	private static Data_Node[] getAllValuesOf(Data_Node d) {
		ArrayList<Data_Node> dataNodes = new ArrayList<Data_Node>();
		for (Data_Node data : Mapping.Gis_Data.nodes)
			if (d.x == data.x && d.y == data.y)
				dataNodes.add(data);

		Data_Node[] nodes = new Data_Node[dataNodes.size()];
		return dataNodes.toArray(nodes);

	}

	//get the n amount of nearest neighbors
	private static Data_Node[] getNearestNeighbors(double x, double y,
			double t, int n) {
		ArrayList<Data_Node> dataNodes = new ArrayList<Data_Node>();
		double[] distances = new double[n];

		int i = 1;
		while (i <= n) {
			dataNodes.add(Mapping.Gis_Data.nodes.get(i - 1));
			distances[i - 1] = dist(x, y, t, Mapping.Gis_Data.nodes.get(i - 1));
			i++;
		}

		for (Data_Node data : Mapping.Gis_Data.nodes) {
			for (i = 0; i < distances.length; i++)
				if (dist(x, y, t, data) < distances[i]
						&& !dataNodes.contains(data)) {

					dataNodes.remove(dataNodes.get(i));
					dataNodes.add(i, data);
					distances[i] = dist(x, y, t, data);
				}
		}
		Data_Node[] data1 = new Data_Node[dataNodes.size()];
		return dataNodes.toArray(data1);

		/*
		 * ArrayList<Data_Node> dataNodes = new ArrayList<Data_Node>();
		 * ArrayList<Data_Node> runningPoints = new ArrayList<Data_Node>();
		 * ArrayList<Double> distances = new ArrayList<Double>(); double
		 * distance; for(Data_Node data: Mapping.Gis_Data.nodes){ if(data.x != x
		 * && data.y != y){ distance = Math.abs(Math.sqrt(Math.pow(x-data.x,2) +
		 * Math.pow(y-data.y, 2))); distances.add(distance); } }
		 * while(distances.size()!=n)
		 */
	}

	/*
	 * public static int sigma(int i, int n, int f){ int sum = 0; for(; i <= n;
	 * i++){ sum += Math.pow(i, f); System.out.println(sum); } return sum; }
	 */
}
