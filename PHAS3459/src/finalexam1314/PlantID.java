package finalexam1314;

import java.util.Scanner;

public class PlantID {


	//member variables
	String id, name;


	//how to read each line like always
	// for part 3 - this works with the animal IDs as well despite being called PlantID
	public PlantID(String line){
		Scanner sc = new Scanner(line);
		this.id = sc.next();
		this.name = (sc.next()+" " +sc.next());
		sc.close();
	}
	
	public String getID(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
}
