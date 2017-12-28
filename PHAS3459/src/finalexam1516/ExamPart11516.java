package finalexam1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class ExamPart11516 {

	//make an arraylist of all of the signal data
	public static ArrayList<SignalData> pulsesList(String urlName) throws IOException{
		//initialise the arraylist of integers
		ArrayList<SignalData> list = new ArrayList<SignalData>();
		
		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null){
			SignalData currentLine = new SignalData(line);
			list.add(currentLine);
		}

		return list;
	}

	//set up hashmap of detectors and distances
	public static HashMap<String, Double> detectorDistances (String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		HashMap<String, Double> detectorDistancesMap = new HashMap<String, Double>();
		while ((line = br.readLine()) != null){
			Detectors currentDetector = new Detectors(line);
			
			//put the ID and the distance in the hashmap
			detectorDistancesMap.put(currentDetector.getID(),currentDetector.getDistance());
		}
		return detectorDistancesMap;
	}


	/*
	 * turns arraylist of signaldatas into hashmap
	 * keys: detector IDs
	 * values: all of the voltages by the detectors
	 * 
	 * note from after doing this:
	 * this would be a million times easier if it was HashMap<String, ArrayList<ArrayList<Double>> in order to keep each reading for each 
	 * detector seperate as we need this later in the exam. How it works at the moment is it stores all of the data from each detector
	 * in one massive arraylist. i cba to change it all so i've had to make it work later in the code.
	 * I might re-write it so it's not awful like this so i can use this exact code in the exam.
	 */
	public static HashMap<String, ArrayList<Double>> dataIntoHashMap (ArrayList<SignalData> list){

		// Create HashMap of ArrayLists to store signal data using team as key
		HashMap<String, ArrayList<Double>> sortedSignals = new HashMap<String, ArrayList<Double>>();

		// Loop over complete data list
		for (SignalData data: list) {

			// Retrieve ID for that signal
			String ID = data.getID();

			// Extract voltage list from HashMap using this ID
			ArrayList<Double> thisVoltageList = sortedSignals.get(ID);

			// If this list is empty, create a new ArrayList of signals
			if (thisVoltageList == null) {
				sortedSignals.put(ID, new ArrayList<Double>());
			}

			// Add current signal to list of signals for that ID
			sortedSignals.get(ID).addAll(data.getVoltList());

		}


		return sortedSignals;
	}


	//find total number of pulses in the entire set
	public static int totalNumberOfPulses(ArrayList<SignalData> list){
		int tot=0;
		
		//loop through the arraylist of data, getting the voltlist for each
		for (int i =0; i < list.size(); i++){
			tot += list.get(i).getVoltList().size();
		}
		return tot;
	}

	//mean amplitude of the entire set
	public static double meanAmplitude(ArrayList<SignalData> list){
		double sum = 0;
		ArrayList<Double> currentVolts = new ArrayList<Double>();
		
		//loop through data arraylist, summing the voltages
		for (int i = 0; i <list.size(); i++){
			currentVolts = list.get(i).getVoltList();
			for(int j=0; j<currentVolts.size(); j++){
				sum += currentVolts.get(j);
			}
		}
		
		//divide by total number of pulses
		return sum / (double) totalNumberOfPulses(list);
	}

	//number of signals from each detector
	public static ArrayList<Integer> individualNumberOfSignals(HashMap<String, ArrayList<Double>> map){
		//initialise arraylist that will contain number of signals for each detector
		ArrayList<Integer> numberOfSignals = new ArrayList<Integer>();
		
		//make an arraylist of the names of all the IDs from the hashmap
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll((map.keySet()));
		
		//loop through the hashmap
		for(int i =0; i < map.size(); i++){
			//get the number of volts of the current ID
			ArrayList<Double> currentVolts = map.get(IDList.get(i));
			numberOfSignals.add(currentVolts.size());
		}
		return numberOfSignals;
	}

	//mean amplitude from each detector
	public static ArrayList<Double> individualMeanAmplitudes (HashMap<String, ArrayList<Double>> map){
		//initialise arraylist that will contain the mean amplitudes from each detector
		ArrayList<Double> meanAmplitudes = new ArrayList<Double>();
		
		//get an arraylist of the IDs from the hashmap
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(map.keySet());
		
		//loop through the map
		for(int i =0; i < map.size(); i++){
			double sum = 0;
			
			//get the volt arraylist of the current ID
			ArrayList<Double> currentVolts = map.get(IDList.get(i));
			
			//loop throuh the volt arraylist, adding them up
			for(int j =0; j < currentVolts.size(); j++){
				sum += currentVolts.get(j);
			}
			
			//divide the voltage sum by the number of reading
			meanAmplitudes.add(sum/currentVolts.size());
		}
		return meanAmplitudes;
	}

	/*
	 * find the mean arrival times for each of the detectors
	 * arguments: hashmap. Keys: detector IDs. Values: arraylist of the voltages from that detector
	 * output: hashmap. Keys: detector IDs. Values: arrival times
	 * this method is kind of a shit show because i did my hashmap badly. I explain why in the method
	 */
	public static HashMap<String, Double> meanArrivalTimes(HashMap<String, ArrayList<Double>> map){

		//get an arraylist of the IDs from the map
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(map.keySet());

		//the max voltage and the time for the max voltage - will be reset for each loop
		double maxVoltage;
		double maxVTime;

		//hashmap of each ID and the average arrival time for that detector
		HashMap<String, Double> meanArrivalTimes = new HashMap<String, Double>();

		//array list of the arrival times in order to find the average
		ArrayList<Double> ArrivalTimes = new ArrayList<Double>();

		//mean arrival time of each data set, these will be added to the array list above
		double meanArrivalTime;

		//sum of the arrival times to find the average
		double arrivalTimeSum;

		//loop through the map - ie through all the detectors
		for(int i=0; i<map.size(); i++){

			//to start with, we want to reset/clear all of the data so it can start new for the new detector
			arrivalTimeSum = 0;
			maxVoltage = 0;
			meanArrivalTime = 0;
			maxVTime =0;
			ArrivalTimes.clear();

			/*
			 * i need this value of k because i messed up how i did the hashmap:
			 * the values in the hashmap are a big arraylist of all the voltages from a particular detector - it is no longer split up
			 * into the different data collection sets. I use this value of k to monitor how far along the big arraylist I have gone, so 
			 * I can kind of split it back up into the individual data sets.
			 * k needs to start at -1 as the loop that adds one to k runs on the first loop (j=0)
			 */
			int k =-1;

			//find the detector ID for the current loop
			String currentID = IDList.get(i); 

			//find the array list of voltages for the current detector ID
			ArrayList<Double> currentVoltages = map.get(currentID);

			//loop through the current voltages of the current detector ID
			for(int j = 0; j<currentVoltages.size(); j++){

				//current voltage is the value in position j in the currentVoltages arraylist
				double currentVoltage = currentVoltages.get(j);

				//update max voltage and arrivaltime(maxVTime) if we need to 
				if(currentVoltage > maxVoltage){
					maxVoltage = currentVoltage;

					//I take off (k*51) as this is how many values came before it in other sets (because it is looping through one big array of all the voltages from that detector)
					//the number of loops is the time because it says each loop is 1ns or something
					maxVTime = j-(k*51);
				}

				/*
				 *here's where my fuck up with the hashmap gets fixed. If the position in the voltages array is divisible by 51,
				 *(ie, every 51 values), the max voltage and arrival time gets reset, the sum gets updated and the value of k used above
				 *is updated. the value of 51 is used as each data set has 51 values. 
				 *This would have been better if the map was HashMap<String, ArrayList<ArrayList<Double>>>. This would allow the values in
				 *the map to be array lists of each set of readings from each detector to be in its own arraylist, as opposed to one big arraylist.
				 */
				if(j%51 ==0){
					//reset everything for the new data set
					ArrivalTimes.add(maxVTime);
					arrivalTimeSum += maxVTime;
					maxVoltage = 0;
					maxVTime = 0;
					k++;
				}
			}
			//mean arrival time is the sum of arrival times / the number of readings from that detector, which would be k as that got updated every 51 values
			meanArrivalTime = arrivalTimeSum/k;

			//put the currentID and the mean arrival time in the hashmap of mean arrival times
			meanArrivalTimes.put(currentID, meanArrivalTime);
		}
		return meanArrivalTimes;
	}


	/*
	 *find the speeds of the things ie mean arrival times / distance
	 *argument: HashMap. Key: detector IDs. Values: mean arrival times for each detector
	 *output: arraylist of the speeds for each detector
	 *NOTE: this method does not use raw data. It uses the hashmap that is outputted from the meanArrivalTime method above.
	 *using this hashmap as the argument saves a bunch of repeated code 
	 */
	public static ArrayList<Double> speeds (HashMap<String, Double> meanArrivalTimes, HashMap<String,Double> distances){
		//as usual, find the IDList arraylist (maybe i should have made this a method by itself to save room)
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(meanArrivalTimes.keySet());

		//arraylist that will contain the speed for each detector
		ArrayList<Double> speeds = new ArrayList<Double>();

		double currentArrivalTime, currentDistance, currentSpeed;

		//loop through detectors 
		for (int i  =0; i<meanArrivalTimes.size(); i++){

			//get current ID
			String currentID = IDList.get(i);

			//update everything for this ID
			currentArrivalTime = meanArrivalTimes.get(currentID);
			currentDistance = distances.get(currentID);

			currentSpeed = currentDistance / currentArrivalTime;
			speeds.add(currentSpeed);
		}
		return speeds;
	}

	public static void main(String[] args) throws IOException {
		//arraylist of all of the signal datas
		ArrayList<SignalData> sDList = pulsesList("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/signals.txt");

		//hashmap of the distances data
		HashMap<String, Double> distanceMap = detectorDistances("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/detectors.txt");
		//total number of pulses in the data
		System.out.print("Total number of pulses: "+ totalNumberOfPulses(sDList));

		//turn the signal data into a hashmap
		HashMap<String, ArrayList<Double>> sDMap = dataIntoHashMap(sDList);
		
		//find and print everything i need
		System.out.println();
		System.out.println("Mean of all pulses: "+meanAmplitude(sDList));
		System.out.println("The detectors are: "+ sDMap.keySet());
		System.out.println("The number of signals for each detector are: " + individualNumberOfSignals(sDMap));
		System.out.printf("The mean amplitudes of signals for each detector are: " + individualMeanAmplitudes(sDMap));
		System.out.println();
		HashMap<String, Double> meanAT = meanArrivalTimes(sDMap);
		System.out.println("The mean arrival times for each detector are: "+ meanAT);
		System.out.println();
		System.out.println("The speeds of each detector are: "+ speeds(meanAT, distanceMap));
	}
}