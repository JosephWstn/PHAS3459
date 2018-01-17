package exam2;

import java.util.ArrayList;

/**
 * 
 * implements filter, filtering flights to a specified origin and destination
 *
 */
public class FilterLocations implements Filter{

	String origin, destination;

	public FilterLocations(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}



	
	@Override
	//method to loop througha list of flights, and return the ones that start and end at specified locations
	public ArrayList<Flight> filter(ArrayList<Flight> list) {

		//initialise an arraylist of filtered flights
		ArrayList<Flight> filtered = new ArrayList<Flight>();


		//loop through the unfiltered list, looking if the destination and origin match
		for(Flight f : list) {

			String currentOrigin = f.getAirportO();
			String currentDestination = f.getAirportD();

	
			if ((currentOrigin).equals(this.origin) && (currentDestination).equals(this.destination)) {
				filtered.add(f);
			}
			else {
			
			}
		}

		return filtered;
	}


}
