package finalexam1516;

import java.util.Scanner;

public class Detectors {

	//member variables
	double distance;
	String id;
	
	//how to read each line like always
	public Detectors(){}
	public Detectors(String line){
		Scanner sc = new Scanner(line);
		this.id=sc.next();
		this.distance = sc.nextDouble();
		sc.close();
	}
	
	//getter methods
	public String getID(){
		return this.id;
	}
	
	public double getDistance(){
		return this.distance;
	}
}