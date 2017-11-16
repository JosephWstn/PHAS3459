package pexoplanets;

import java.util.Scanner;

public class PExoplanetData {
	public String name;
	public int year;
	public String method;
	public double mass;
	public double separation;
	public double distance;

	public PExoplanetData() {}
	public PExoplanetData(String line){
		Scanner sc = new Scanner(line);
		sc.useDelimiter(",");
		this.name = sc.next();
		this.year = sc.nextInt();
		this.method = sc.next();
		this.mass = sc.nextDouble();
		this.separation = sc.nextDouble();
		if (sc.hasNext()){
			this.distance = sc.nextDouble();
		}
		else{sc.close();}
		sc.close();
	}

	public String toString() {
		return "[Exoplanet " + name + ", discovered in " + year + ", with method " + method + ", mass=" + mass
				+ ", separation=" + separation + ", distance=" + distance + "]";
	}

	public String getName() {
		return name;
	}
	public int getYear() {
		return year;
	}
	public String getMethod() {
		return method;
	}
	public double getMass() {
		return mass;
	}
	public double getSeparation() {
		return separation;
	}
	public double getDistance() {
		return distance;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public void setSeparation(double separation) {
		this.separation = separation;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}


}
