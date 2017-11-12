package module5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class DataPoint {

	double  x, y, ey;

	/*
	 * Constructor object DataPoint of 3 doubles
	 * (x value, y value, error in y value)
	 */
	public DataPoint(double x, double y, double ey)throws Exception{
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
}