package finalexam1516;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExamPart31516 {

	/*
	 * this method is to compare the two methods
	 * Arguments: the two arrival time methods to be compared (could've put these in a collection and used a loop but fuck it) and the hashmap of data
	 * output: hashmap. Key: ID of the detector with biggest difference. value: arraylist with 2 components: arrival time of the two compared methods  
	 */
	public static HashMap<String, ArrayList<Double>> comparison (ArrivalTimeMethod voltMethodATM, ArrivalTimeMethod thresholdMethodATM, HashMap<String,ArrayList<Double>> data){
		
		//hashmaps of arrival times from the two arrival time methods
		HashMap<String,Double> voltMethod = voltMethodATM.time(data);
		HashMap<String,Double> thresholdMethod = thresholdMethodATM.time(data);
		
		//find the IDList again
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll((voltMethod.keySet()));
		
		//hashmap of the biggest difference (this will be the output described above)
		HashMap<String, ArrayList<Double>> biggestDifference = new HashMap<String, ArrayList<Double>>();
		
		//array list of the arrival times for the two methods that have the biggest difference
		ArrayList<Double> biggestDifferentArrivalTime = new ArrayList<Double>();
		
		//initialise stuff we need
		String currentID;
		String maxDifferenceID ="";
		double thresholdTime, voltageTime;
		double maxDifference =0;
		
		//loop through the data(doesn't matter which data set we loop through as theyre the same size)
		for(int i =0; i<voltMethod.size(); i++){
			
			//get the current ID
			currentID = IDList.get(i);
			
			//get the average arrival time of the current ID for the two methods
			voltageTime = voltMethod.get(currentID);
			thresholdTime = thresholdMethod.get(currentID);
			
			//if their difference is the biggest yet, update the ID of the max difference
			if (Math.abs(voltageTime-thresholdTime)> maxDifference){
				maxDifferenceID = currentID;
			}
			
		}
		
		//now we've found the detector ID with the biggest difference, we can extract that data from the data hashmaps
		
		//add the mean arrival times for this ID for the two methods to an arraylist
		biggestDifferentArrivalTime.add(voltMethod.get(maxDifferenceID));
		biggestDifferentArrivalTime.add(thresholdMethod.get(maxDifferenceID));
		
		//add this ID and the arraylist of the two arrival times to the hashmap
		biggestDifference.put(maxDifferenceID, biggestDifferentArrivalTime);
		return biggestDifference;
	}
	
	public static void main(String[] args) throws IOException {
		//arraylist of all of the signal datas
		ArrayList<SignalData> sDList = ExamPart11516.pulsesList("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/signals.txt");
		
		
		//turn the data into a hashmap
		HashMap<String, ArrayList<Double>> sDMap = ExamPart11516.dataIntoHashMap(sDList);
		
		//initialise arrivaltimemethods for the two methods
		ArrivalTimeMethod maxVoltMAT = new MaxVoltMethod(sDMap);
		ArrivalTimeMethod thresholdMAT = new ThresholdMethod(sDMap);
		
		
		HashMap<String, ArrayList<Double>> biggestDifference= comparison(maxVoltMAT, thresholdMAT, sDMap);
		System.out.println("The detector with the biggest difference for the two methods and the two arrival times were: "+ biggestDifference);
	}
}
