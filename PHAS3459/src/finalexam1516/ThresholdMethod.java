package finalexam1516;

import java.util.ArrayList;
import java.util.HashMap;

public class ThresholdMethod implements ArrivalTimeMethod {

	HashMap<String, ArrayList<Double>> map = new HashMap<String, ArrayList<Double>>();

	double threshold;
	
	public ThresholdMethod(){}
	public ThresholdMethod(double threshold){
		this.threshold = threshold;
	}

	//note - almost all of this is copied and pasted from exampart21516 as it is finding the same thing.
	//only difference is the arrival time is the time until the first reading above 1V
	@Override
	public HashMap<String,Double> time(HashMap<String, ArrayList<Double>> map) {


		//this is to get an arraylist of the IDs from the map
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(map.keySet());

		//the time for the max voltage - will be reset for each loop
		double arrivalTime;

		//hashmap of each ID and the average arrival time for that detector
		HashMap<String, Double> meanArrivalTimes = new HashMap<String, Double>();

		//array list of the arrival times in order to find the average
		ArrayList<Double> ArrivalTimes = new ArrayList<Double>();

		//arrival time of each data set, these will be added to the array list above
		double meanArrivalTime;

		//sum of the arrival times to find the average
		double arrivalTimeSum;

		//loop through the map - ie through all the detectors
		for(int i=0; i<map.size(); i++){

			//to start with, we want to reset/clear all of the data so it can start new for the new detector
			arrivalTimeSum = 0;
			meanArrivalTime = 0;
			arrivalTime =0;
			ArrivalTimes.clear();
			boolean firstAboveThreshold = true;

			/*
			 * i need this value of k because i messed up how i did the hashmap:
			 * the values in the hashmap is an arraylist of all the voltages from a particular detector - it is no longer split up
			 * into the different data collection sets. I use this value of k to monitor how far along the big array I have gone, and
			 * correct this mistake.
			 * k needs to start at -1 as the loop that adds one to k runs on the first loop (j=0)
			 */
			int k =-1;

			//find the detector ID for the current loop
			String currentID = IDList.get(i); 

			//find the array list of voltages for the current detector ID
			ArrayList<Double> currentVoltages = map.get(currentID);

			//loop through the current voltages of the current detector ID
			for(int j = 0; j<currentVoltages.size(); j++){

				//current voltages is the value in position j in the currentVoltages array
				double currentVoltage = currentVoltages.get(j);

				//update what the arrival time is if this is the fist in this data set above 1V 
				if(currentVoltage > this.threshold && firstAboveThreshold == true){
					//I take off (k*51) as this is how many values came before it in other sets (because it is looping through one big array of all the voltages from that detector)
					arrivalTime = j-(k*51);
					firstAboveThreshold = false;
				}

				/*
				 *here's where my fuck up with the hashmap gets fixed. If the position in the voltages array is divisible by 51,
				 *(ie, every 51 values), the max voltage and arrival time gets reset, the sum gets updated and the value of k used above
				 *is updated.
				 *This would have been better if the map was HashMap<String, ArrayList<ArrayList<Double>>>. This would allow the values in
				 *the map to be array lists of each set of readings from each detector to be in its own arraylist, as opposed to one big arraylist.
				 */
				if(j%51 ==0){
					ArrivalTimes.add(arrivalTime);
					arrivalTimeSum += arrivalTime;
					arrivalTime= 0;
					k++;
					
					//first is now true as we've covered 51 values so are going into a new data set
					firstAboveThreshold = true;
				}
			}
			//mean arrival time is the sum of arrival times / the number of readings from that detector, which would be k as that got updated every 51 values
			meanArrivalTime = arrivalTimeSum/k;

			//put the currentID and the mean arrival time in the hashmap of mean arrival times
			meanArrivalTimes.put(currentID, meanArrivalTime);
		}
		return meanArrivalTimes;
	}

	public String toString(){
		return time(this.map).toString();

	}

}
