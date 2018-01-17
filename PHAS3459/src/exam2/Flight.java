package exam2;

import java.util.Scanner;

/**
 * 
 * create object "Flight" which contains all the information about a particular flight
 *
 */
public class Flight {

	//member variables for all of the information about a flight
	String code, airportO, airportD;
	int yearO, monthO, dayO, hourO, minO, yearD, monthD, dayD, hourD, minD;
	double price;
	Date dateO, dateD;
	Time timeO, timeD;

	public Flight() {}

	//loops through the line from the URL, assigning each value
	public Flight(String line){
		Scanner sc = new Scanner(line).useDelimiter(", | \\s");
		
		this.code = sc.next();
		this.airportO=sc.next();
		this.airportD=sc.next();
		
		Date dateO = new Date(sc.next());
		this.dateO = dateO;
		Time timeO = new Time(sc.next());
		this.timeO = timeO;
		Date dateD = new Date(sc.next());
		this.dateD = dateD;
		Time timeD = new Time(sc.next());
		this.timeD = timeD;
		this.price = sc.nextDouble();
		sc.close();
	}

	//getter methods for all the componenents
	
	
	public String getCode() {
		return this.code;
	}


	public String getAirportO() {
		return (this.airportO);
	}


	public String getAirportD() {
		return (this.airportD);
	}

	
	public double getPrice() {
		return this.price;
	}

	public Date getDateO() {
		return (this.dateO);
	}

	public Date getDateD() {
		return (this.dateD);
	}

	public Time getTimeO() {
		return (this.timeO);
	}

	public Time getTimeD() {
		return (this.timeD);
	}
	
	public String toString() {
		return(this.code);
	}
}
