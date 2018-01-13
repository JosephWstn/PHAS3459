package finalexam1011;

import java.util.ArrayList;
import java.util.Scanner;

public class Station {

	String id, station, namePart;
	
	public Station(){}
	public Station(String line){
		Scanner sc = new Scanner(line);
		String fullName = "";
		
		this.id = sc.next();
		while(sc.hasNext()){		
			namePart = sc.next();
			fullName += namePart +" ";
		}

		this.station = fullName;
	}
	
	//getters
	
	public String getID(){
		return this.id;
	}
	
	public String getStation(){
		return this.station;
	}
}
