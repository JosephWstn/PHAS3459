package finalexam1516;
import java.util.ArrayList;
import java.util.HashMap;


public interface ArrivalTimeMethod {
	
	/*
	 *	 a method for finding the arrival time 
	 *   arguments: hashmap of keys: detector IDs. Values: arraylist of all the voltages from that detector
	 *   output: hashmap of keys: detector IDs. Values: arrival times  
	 */
	HashMap<String,Double> time (HashMap<String, ArrayList<Double>> map);
}
