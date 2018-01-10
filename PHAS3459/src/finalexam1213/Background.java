package finalexam1213;

import java.util.Scanner;

public class Background {


	//member variables
	double events;
	int min, max;

	public Background(){}
	public Background(String line){
		Scanner sc = new Scanner(line);
		if(Character.isLetter(line.charAt(0))) {
		}
		else {
			this.min = sc.nextInt();
			this.max = sc.nextInt();
			this.events = sc.nextDouble();
			sc.close();
		}
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

	public String toString() {
		return ("Min: "+this.min +"\nMax: " + this.max + "\nEvents: "+this.events);

	}

}