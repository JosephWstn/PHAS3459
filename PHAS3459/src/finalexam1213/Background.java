package finalexam1213;

import java.util.Scanner;

public class Background {


	//member variables
	double events;
	int min, max;

	public Background(){}
	public Background(String line){
		Scanner sc = new Scanner(line);
		this.min = sc.nextInt();
		this.max = sc.nextInt();
		this.events = sc.nextDouble();
		sc.close();

	}


	//getters

	public int getMin() {
		return this.min;
	}

	public int getMax() {
		return this.max;
	}

	public double getEvents() {
		return this.events;
	}
	
	//setters when turning the actual readings into this format
	public void setEvents(double e){
		 this.events = e;
	}
	
	//setters when turning the actual readings into this format
	public void  setMin(int m){
		this.min= m;
	}
	
	//setters when turning the actual readings into this format
	public void  setMax(int m){
		this.max = m;
	}
	
	
	public String toString() {
		return ("Min: "+this.min +" Max: " + this.max + " Events: "+this.events +"  ");

	}

}