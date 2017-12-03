package module6;

public class DataPoint {

	//member variables for x, y and ey(error in y)
	double  x, y, ey;

	//empty constructor
	public DataPoint() {};

	/*
	 * Constructor object DataPoint of 3 doubles
	 * (x value, y value, error in y value)
	 */
	public DataPoint(double x, double y, double ey) throws Exception{
		this.x =x;
		this.y =y;
		this.ey = ey;
	}

	//getter method for x
	public double getx(){
		return x; 
	}

	//getter method for y
	public double gety(){
		return y;
	}
	
	//getter method for ey (error in y)
	public double getey(){
		return ey;
	}
	
	//To string method to display the coordinates
	// \u00B1 is the +- sign 
	public String toString() {
		return ("x = " + this.x + ", y = " + this.y + " \u00B1 "+ this.ey );
	}
}