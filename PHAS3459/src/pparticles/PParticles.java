package pparticles;

import java.util.Scanner;

public class PParticles {
	public int charge;
	public double momentum;
	public double theta;
	public double phi;
	public String label;

	public PParticles() {}
	public PParticles(String line){
		Scanner sc = new Scanner(line);
		if (line.contains("E")){this.label = line;}
		else{
		this.charge = sc.nextInt();
		this.momentum = sc.nextDouble();
		this.theta = sc.nextDouble();
		this.phi = sc.nextDouble();}
		sc.close();
	}



	public String toString() {
		return "Particles [charge=" + charge + ", momentum=" + momentum + ", theta=" + theta + ", phi=" + phi + "]";
	}

	public int getCharge() {
		return charge;
	}
	public double getMomentum() {
		return momentum;
	}
	public double getTheta() {
		return theta;
	}
	public double getPhi() {
		return phi;
	}
	public String getLabel() {
		return label;
	}

}

