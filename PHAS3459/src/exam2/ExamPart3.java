package exam2;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * analysis for part 3: finding quickest changeover flight
 *
 */
public class ExamPart3 {

	
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Flight> allFlights = ExamPart1.flightList("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/flights.txt");
		
		//create a filter for quickest two flights
		Filter quickestLayoverFilter = new TwoStageFlights("LHR", "CPT");

		
		//apply the filtering to find the 
		ArrayList<Flight>  quickestTwoFlights = quickestLayoverFilter.filter(allFlights);

		
		//note: the list returned will not be correct as the duration method doesn't account for time zones
		System.out.println("Quickest way to LHR to CPT including a layover is to take the two flights; " + quickestTwoFlights);

		
	}	
}
