package finalexam1415;

import java.util.HashMap;
import java.io.IOException;
import java.util.ArrayList;

public class ExamPart21415 {

	/*
	 * Find hashmap of means
	 * argument: HashMap. Key: The IDs of each arraylist of measurement. Values:  arraylist of the corresponding measurements
	 * output: HashMap. Key: IDs of each arraylist of measurement. Values: mean of that arraylist of measurements
	 */
	public static HashMap<String, Double> means (HashMap<String, ArrayList<Measurement>> map){

		//output is going to be a hashmap of keys: ID and values: means
		HashMap<String, Double> meanMap = new HashMap<String, Double>(); 

		//get an arraylist of the IDs from the hashmap
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(map.keySet());

		//loop through the ID arraylist
		for (String id : IDList){

			//get the arraylist of measurements for the current ID
			ArrayList<Measurement> currentMeasurements = map.get(id);

			//not entirely sure what this does, so it makes a Calculation object that finds the mean?
			Calculation meanC = new Mean();
			
			//find the mean
			double mean = meanC.d(currentMeasurements);
			
			
			//put the current id and mean in the arraylist
			meanMap.put(id, mean);
		}
		
		//return the map with IDs and means in it
		return meanMap;
	}
	
	/*
	 * Find hashmap of means
	 * argument: HashMap. Key: The IDs of each arraylist of measurement. Values:  arraylist of the corresponding measurements
	 * output: HashMap. Key: IDs of each arraylist of measurement. Values: mean of that arraylist of measurements
	 */
	public static HashMap<String, Double> ranges (HashMap<String, ArrayList<Measurement>> map){

		//output is going to be a hashmap of keys: ID and values: means
		HashMap<String, Double> rangeMap = new HashMap<String, Double>(); 

		//get an arraylist of the IDs from the hashmap
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(map.keySet());

		//loop through the ID arraylist
		for (String id : IDList){

			//get the arraylist of measurements for the current ID
			ArrayList<Measurement> currentMeasurements = map.get(id);

			//find the mean of the current ID using the calculation interface and the mean implementation
			Calculation rangeC = new Range();
			
			//find the mean
			double range = rangeC.d(currentMeasurements);
			
			
			//put the current id and mean in the arraylist
			rangeMap.put(id, range);
		}
		
		//return the map with IDs and means in it
		return rangeMap;
	}
	
	public static void main(String[] args) throws IOException {
		HashMap<String, Double> meanMap = means(ExamPart11415.dataIntoHashMap(ExamPart11415.MeasurementList("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-1999.txt")));
		HashMap<String, Double> rangeMap = ranges(ExamPart11415.dataIntoHashMap(ExamPart11415.MeasurementList("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-1999.txt")));
		System.out.println(meanMap);
		System.out.println(rangeMap);
	}

}
