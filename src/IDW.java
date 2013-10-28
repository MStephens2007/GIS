import java.nio.file.Path;
import java.nio.file.Paths;


@SuppressWarnings("unused")
public class IDW {
	
	/*-------------------NOTES FOR LATER-----------------------
	 * --------------------------------------------------------
	 * THE FIRST VALUE OR X0,Y0,T0 IS THE PREDICTED VALUE AT LOCATION (
	 */
	private static Data_Node One;
	
	
	
	public IDW(Data_Node One){
		this.One = One;
	}
	public static double lamda(double p, double dI, Data_Node two){
		double answer = 0;
		//top half
		//double di = Math.pow((1/dist(D), arg1)
		double top = Math.pow((1/dist(two)), p);
		//bottom half
		//double bot = sigma(Math.pow(dist(two), p));
		return answer;
	}
	public static double dist(Data_Node Two){
		double answer = 0;
		double x0 = One.getX();
		double x1 = Two.getX();
		double y0 = One.getY();
		double y1 = Two.getY();
		double t0 = One.getTime();
		double t1 = Two.getTime();
		
		answer = Math.pow((x0 - x1), 2) + Math.pow((y0 - y1), 2) + Math.pow((t0 - t1), 2);
		answer = Math.pow(answer, .5);
		return answer;
		
	}
	
	
	public static int sigma(int i, int n, int f){
		int sum = 0;
		for(; i <= n; i++){
			sum += Math.pow(i, f);
			System.out.println(sum);
		}
		return sum;
	}

}
