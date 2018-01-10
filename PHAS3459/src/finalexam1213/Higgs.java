package finalexam1213;

import java.util.Scanner;

public class Higgs {

	String id;
	double energy;

	public Higgs(){}
	public Higgs(String line){
		Scanner sc = new Scanner(line);
		this.id = sc.next();
		this.energy = sc.nextDouble();
		sc.close();
	}
	
	//getters
	public String getID() {
		return this.id;
	}
	
	public double getEnergy() {
		return this.energy;
	}
}