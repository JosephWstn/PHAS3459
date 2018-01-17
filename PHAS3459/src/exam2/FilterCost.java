package exam2;

import java.util.ArrayList;


/**
 * 
 * implements filter, filtering flights to under a certain cost limit
 *
 */
public class FilterCost implements Filter {

	
	double limit;
	
	//constructor for cost filter
	public FilterCost(double limit) {
		this.limit = limit;
	}
	
	//method to take a list of flights and return a list of those under a certain cost
	@Override
	public ArrayList<Flight> filter(ArrayList<Flight> list) {
		//initialise list of filtered flihts
		ArrayList<Flight> filtered = new ArrayList<Flight>();
		
		for (Flight f : list) {
			double currentCost = f.getPrice();
			
			if(currentCost <= limit) {
				filtered.add(f);
			}
		}
		return filtered;
	}

}
