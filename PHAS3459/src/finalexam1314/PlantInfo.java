package finalexam1314;

import java.util.Scanner;

/**
 * Contains constructor and getter method for the survey plants site
 * @author Joseph
 *
 */

public class PlantInfo {


	//member variables
	double lat, longt;
	String id;
	int height;

	public PlantInfo(){}
	public PlantInfo(String line){
		Scanner sc = new Scanner(line);

		//the if statement is for part 3 - it makes this constructor also work for animal info as the animal info doesn't provide a height
		this.lat = sc.nextDouble();
		this.longt = sc.nextDouble();
		this.id = sc.next();
		if (sc.hasNextInt()){
			this.height= sc.nextInt();
			sc.close();
		}
		else {
			sc.close();
		}
	}

	//getters
	public double getLat(){
		return this.lat;
	}

	public double getLongt(){
		return this.longt; 
	}

	public String getID(){
		return this.id;
	}

	public int getHeight(){
		return this.height;
	}
}