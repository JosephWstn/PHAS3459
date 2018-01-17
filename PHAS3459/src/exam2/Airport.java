package exam2;

import java.util.Scanner;


/**
 * 
 * create object "Airport" which contains all the information about a particular airport
 *
 */
public class Airport {


	String code, name, timeZone;


	public Airport() {}	
	//loops through the line from the URL, assigning each value
	public Airport(String line){
		Scanner sc = new Scanner(line).useDelimiter(",");

		this.code = sc.next();
		this.name=sc.next();
		this.timeZone = sc.next();

		sc.close();
	}
	
	//getters
	public String getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getTimeZone() {
		return this.timeZone;
	}
}
