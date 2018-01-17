package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * 
 * Analysis for part 1. extracts information from URLs, stored them in collections and analyzes them
 *
 */

public class ExamPart1 {

	//make an arraylist of all of all the recorded flights
	public static ArrayList<Flight> flightList(String urlName) throws IOException{
		//initialise the arraylist of flights
		ArrayList<Flight> list = new ArrayList<Flight>();

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null){
			
			Flight currentLine = new Flight(line);
			list.add(currentLine);
		}
		return list;
	}

	//make an arraylist of all of all the airports
	public static ArrayList<Airport> airportList(String urlName) throws IOException{
		//initialise the arraylist of airports
		ArrayList<Airport> list = new ArrayList<Airport>();

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null){
			Airport currentLine = new Airport(line);
			list.add(currentLine);
		}
		return list;
	}


	//make hashmap of airport code and names form the arraylist
	public static HashMap<String, String> airportNameMap (ArrayList<Airport> list){

		// Create HashMap of Strings to store airport names using code as key
		HashMap<String, String> sortedAirports = new HashMap<String, String>();

		// Loop over complete data list
		for (Airport ap: list) {

			// Retrieve code for that signal
			String code = ap.getCode();

			// Extract airport name from HashMap using this code
			String name = sortedAirports.get(code);

			// If this name is empty, add it to the hashmap
			if (name == null) {
				sortedAirports.put(code,ap.getName());
			}


		}
		return sortedAirports;
	}
	
	//make hashmap of airport code and timezone form the arraylist
	public static HashMap<String, String> airportZoneMap (ArrayList<Airport> list){

		// Create HashMap of Strings to store airport names using code as key
		HashMap<String, String> sortedAirports = new HashMap<String, String>();

		// Loop over complete data list
		for (Airport ap: list) {

			// Retrieve code for that signal
			String code = ap.getCode();

			// Extract airport timezone from HashMap using this code
			String zone = sortedAirports.get(code);

			// If this zone is empty, add it to the hashmap
			if (zone == null) {
				sortedAirports.put(code,ap.getTimeZone());
			}

		}
		return sortedAirports;
	}
	
	
	//finds the duration of a flight
	//i could not get the conversion of time zones to work
	public static double duration (Flight f) {
		
		//get take off and landing times and dates
		Time t1 = f.getTimeO();
		Time t2 = f.getTimeD();
		Date d1 = f.getDateO();
		Date d2 = f.getDateD();
		
		//calculate destination
		double hours = t1.getHour() - t2.getHour();
		double minutes = t1.getMin() - t2.getMin();
		double duration = (hours) + (minutes/60) ;
		return duration;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		//take data from URLs and collect them
		ArrayList<Flight> flightList = flightList("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/flights.txt");
		ArrayList<Airport> airportList = airportList("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/airports.txt");
		HashMap<String, String> aPNameMap = airportNameMap(airportList);
		HashMap<String, String> aPZoneMap = airportZoneMap(airportList);
		

		//loop through all flights, printing necessary data
		for(Flight f : flightList) {
			System.out.println("Code: " + f.getCode() );
			System.out.println("Origin: " + aPNameMap.get(f.getAirportO()));
			System.out.println("Destination: " + aPNameMap.get(f.getAirportD()));
			System.out.println("Takeoff time: " + f.getTimeO());
			System.out.println("Landing local time: " + f.getTimeD());
			
			//note - duration will be incorrect as the duration method doesn't account for timezones
			System.out.println("Duration: " +duration(f) +"hrs");
			System.out.println("Cost: £"+f.getPrice());
			System.out.println();
		}
		
	}
}
