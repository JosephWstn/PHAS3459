package exam2;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * Uses the implementations of Filter. Finding flights according to origin/destination, duration and cost
 *
 */
public class ExamPart2 {

	
	//method to find the fastest flights
	public static Flight quickest(ArrayList<Flight> list) {
		//initialise what will be the quickest flight
		Flight quickest = new Flight();
		
		//start minimum time at a maximum value
		double minTime = Double.POSITIVE_INFINITY;
		
		//initialise current duration so it isn't recreated every loop, just respecified
		double currentDuration;
		
		
		//loop through flight, finding the quickest
		for (Flight f : list) {
			currentDuration = ExamPart1.duration(f);
			
			//if duration is a new minimum, reassign quickest and minTime
			if(currentDuration < minTime) {
				quickest = f;
				minTime= currentDuration;
			}
		}
		return quickest;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Flight> allFlights = ExamPart1.flightList("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/flights.txt");
		
		//create a filter from LHR to ATH
		Filter f1 = new FilterLocations("LHR", "ATH");
		
		//create a filter for duration of less than 4 hrs 
		Filter f2 = new FilterDuration(4);
		
		//create a filter for a price limit of 200
		Filter f3 = new FilterCost(200);
		
		//apply the filtering required
		ArrayList<Flight> filteredLocation = f1.filter(allFlights);
		ArrayList<Flight> filteredDuration = f2.filter(filteredLocation);
		ArrayList<Flight> filteredCost = f3.filter(filteredDuration);
		
		
		
		//note: the duration list returned will not be correct as the duration method doesn't take into account time zones
		System.out.println("Flights from LHR to ATH: "+filteredLocation);
		System.out.println("Of these, flights that take no more than 4 hours: " + filteredDuration);
		System.out.println("Quickest of these flights that cost no more than £200: "+ quickest(filteredCost));
		
		
		
	}
	
}
