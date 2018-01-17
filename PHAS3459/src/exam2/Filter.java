package exam2;

import java.util.ArrayList;

/**
 * 
 * declares a way to filter flights, leaving only ones that satisfy a certain condition
 *
 */
public interface Filter {

	public ArrayList<Flight> filter (ArrayList<Flight> list);
}
