
public class Data_Node {
	double x, y, time, measurement;
	public Data_Node(double x, double y, double time, double measurement){
		this.x = x;
		this.y = y;
		this.time = time;
		this.measurement = measurement;
	}
	//todo: Make getters and setters
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public double getTime(){
		return time;
	}
	public double getMeasurement(){
		return measurement;
	}
}
