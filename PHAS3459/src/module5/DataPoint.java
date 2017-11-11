package module5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class DataPoint {

	double  x, y, ey;

	public DataPoint(double x, double y, double ey)throws Exception{
		this.x =x;
		this.y =y;
		this.ey = ey;
	}
	
	public double getx(){
		return x;
	}
	
	public double gety(){
		return y;
	}

	public double getey(){
		return ey;
	}
	
	
	public static void main(String[] args) throws Exception{
		//DataPoint dp = new DataPoint();
	}
}



