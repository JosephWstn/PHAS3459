package exam2;

import java.util.ArrayList;


/**
 * 
 * implements filter, filtering flights to below a certain duration limit
 *
 */
public class FilterDuration implements Filter{

	double limit;
	
	//constructor for filter duration
	public FilterDuration(double limit) {
		this.limit = limit;
	}
	
	@Override
	//returns the flights in a list that are below a certain time limit
	public ArrayList<Flight> filter(ArrayList<Flight> list) {

		//initialise arraylist of filtered flights
		ArrayList<Flight> filtered = new ArrayList<Flight>();
		
		//loop through flights, finding ones lower than limit	
		for (Flight f : list) {
			if (ExamPart1.duration(f) <= this.limit) {
				filtered.add(f);
			}
		}
		return filtered;
	}
	

	
	
	
}
