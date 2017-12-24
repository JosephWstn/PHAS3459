package finalexam1516;

import java.util.Scanner;

public class Detectors {

	double distance;
	String id;
	
	public Detectors(){}
	public Detectors(String line){
		Scanner sc = new Scanner(line);
		this.id=sc.next();
		this.distance = sc.nextDouble();
		sc.close();
	}
	
	public String getID(){
		return this.id;
	}
	
	public double getDistance(){
		return this.distance;
	}
}