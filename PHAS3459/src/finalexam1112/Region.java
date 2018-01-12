package finalexam1112;

import java.util.Scanner;

public class Region {

	
	String id, region;

	public Region(){}
	public Region(String line){
		Scanner sc = new Scanner(line).useDelimiter(",");

		this.id = sc.next();
		this.region=sc.next();

		sc.close();
	}
	
	//getters
	public String getID(){
		return this.id;
	}
	public String getRegion(){
		return this.region;
	}
}
