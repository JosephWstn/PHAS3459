package module6;

public class DataPoint {

	double  x, y, ey;

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

	//getter methods for x, y and ey

	public double getx(){
		return x;
	}

	public double gety(){
		return y;
	}

	public double getey(){
		return ey;
	}

	public String toString() {
		return ("No Label: x = " + this.x + ", y = " + this.y + " \u00B1 "+ this.ey );
	}

}

