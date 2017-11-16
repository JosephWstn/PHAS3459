package Earthquakes;

import java.util.Scanner;

public class EQPoints {
	// defining member variables
	public int year;
	public int month;
	public int day;
	public int hour;
	public int minutes;
	public double seconds;
	public double lat;
	public double lon;
	public double depth;
	public double eh1;
	public double eh2;
	public int az;
	public double errdepth;
	public double mag;
	public int ID;


	// constructor for Earthquake data
	public EQPoints() {}
	public EQPoints(String line){
		Scanner sc = new Scanner(line);
		this.year = sc.nextInt();
		this.month = sc.nextInt();
		this.day = sc.nextInt();
		this.hour = sc.nextInt();
		this.minutes = sc.nextInt();
		this.seconds = sc.nextDouble();
		this.lat = sc.nextDouble();
		this.lon = sc.nextDouble();
		this.depth = sc.nextDouble();
		this.eh1 = sc.nextDouble();
		this.eh2 = sc.nextDouble();
		this.az = sc.nextInt();
		this.errdepth = sc.nextDouble();
		this.mag = sc.nextDouble();
		this.ID = sc.nextInt();
		sc.close();	
	}

	public String toString() {
		return "Earthquake: "+day+"/"+month+"/"+year+", " + hour + ":"
				+ minutes + ":" + seconds + "GMT, lat=" + lat + ", lon=" + lon + ", depth=" + depth + ", eh1="
				+ eh1 + ", eh2=" + eh2 + ", az=" + az + ", errdepth=" + errdepth + ", mag=" + mag + ", ID=" + ID + "]";
	}

	public double getDepth(){
		return this.depth;
	}
	public double getDeptherr(){
		return this.errdepth;
	}
	public int getMonth(){
		return this.month;
	}
	public double getMag(){
		return this.mag;
	}
	public int getID(){
		return this.ID;
	}



}
