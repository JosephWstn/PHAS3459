package exam2;

import java.util.ArrayList;

/**
 * 
 * implements filter, finding quickest flight from a location to another, including a chnage-over  
 *
 */
public class TwoStageFlights implements Filter {

	String origin, destination;

	//constructor of a two stage flight, inputs are the origin and the final destination
	public TwoStageFlights (String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}


	//method to find the layover time between 2 flights
	public double layoverT(Flight f1, Flight f2) {
		double hours = f2.getTimeO().getHour() -  f1.getTimeD().getHour();
		double minutes = f2.getTimeO().getMin() - f1.getTimeD().getMin();

		return (hours +(minutes/60));
	}


	//method that finds the cheapest flights from an origin to a destination, considering journeys with layover
	@Override
	public ArrayList<Flight> filter(ArrayList<Flight> list) {

		//current origin and destination to be upadte for each flight
		String currentOrigin, currentDestination;

		//doubles that will be added to find the times
		double totalTime, firstTime, secondTime, layoverTime;

		//strings of where the first flight will land, and second flight will leave
		String firstFlightLands, secondFlightLeaves;

		//arraylist of the flights in the fastest changeover
		ArrayList<Flight> quickestPair = new ArrayList<Flight>();
		double quickestTime = Double.POSITIVE_INFINITY;

		//arraylist of flights for potenntial first and second flights
		ArrayList<Flight> firstFlight = new ArrayList<Flight>();
		ArrayList<Flight> secondFlight = new ArrayList<Flight>();


		//loop through all unfiltered flights
		for (Flight f : list) {

			currentOrigin = f.getAirportO();
			currentDestination = f.getAirportD();

			//find any flights leaving from desired origin 
			if ((currentOrigin).equals(this.origin)) {		
				firstFlight.add(f);
			}


			//find any flights arriving at the desired locations
			if ((currentDestination).equals(this.destination)) {
				secondFlight.add(f);
			}
		}


		//loop through the first flights, and find corresponding second flights, and find total flight time
		for(Flight f2 : firstFlight) {

			for (Flight f3 : secondFlight) {

				firstFlightLands = f2.getAirportD();
				secondFlightLeaves = f3.getAirportO();


				//if the landing of the first flight corresponds with the landing of the second site
				if(firstFlightLands.equals(secondFlightLeaves)) {

					//find the total time
					firstTime = ExamPart1.duration(f2);
					secondTime = ExamPart1.duration(f3);		
					layoverTime = layoverT(f2, f3);

					totalTime = firstTime + secondTime + layoverTime;

					//update quickest time if needed
					if(totalTime < quickestTime) {
						quickestTime = totalTime;
						quickestPair.clear(); 
						quickestPair.add(f2);
						quickestPair.add(f3);
					}

				}
			}
			
		}
		return quickestPair;
	}
}
