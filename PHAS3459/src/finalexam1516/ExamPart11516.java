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
		//boolean to only consider the first line
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
	 * this would be a million times easier if it was HashMap<ArrayList<ArrayList<Double>> in order to keep each reading for each 
	 * detector seperate as we need this later in the exam, i cba to change it all so i've had to make it work later in the code.
	 * I might re-write it so it's not awful like this so i can use this exact code in the exam.
	 */
	public static HashMap<String, ArrayList<Double>> dataIntoHashMap (ArrayList<SignalData> list){

		// Create HashMap of ArrayLists to store Batter data using team as key
		HashMap<String, ArrayList<Double>> sortedSignals = new HashMap<String, ArrayList<Double>>();

		// Loop over complete Batter list
		for (SignalData data: list) {

			// Retrieve team for that Batter
			String ID = data.getID();

			// Extract Batter list from HashMap using this team
			ArrayList<Double> thisVoltageList = sortedSignals.get(ID);

			// If this list is empty, create a new ArrayList of Batters
			if (thisVoltageList == null) {
				sortedSignals.put(ID, new ArrayList<Double>());
			}

			// Add current Batter to list of Batters for that team
			sortedSignals.get(ID).addAll(data.getVoltList());

		}


		return sortedSignals;
	}


	//find total number of pulses in the entire set
	public static int totalNumberOfPulses(ArrayList<SignalData> list){
		int tot=0;
		for (int i =0; i < list.size(); i++){
			tot += list.get(i).getVoltList().size();
		}
		return tot;
	}

	//mean amplitude of the entire set
	public static double meanAmplitude(ArrayList<SignalData> list){
		double sum = 0;
		ArrayList<Double> currentVolts = new ArrayList<Double>();
		for (int i = 0; i <list.size(); i++){
			currentVolts = list.get(i).getVoltList();
			for(int j=0; j<currentVolts.size(); j++){
				sum += currentVolts.get(j);
			}
		}
		return sum / (double) totalNumberOfPulses(list);
	}

	//number of signals from each detector
	public static ArrayList<Integer> individualNumberOfSignals(HashMap<String, ArrayList<Double>> map){
		ArrayList<Integer> numberOfSignals = new ArrayList<Integer>();
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll((map.keySet()));
		for(int i =0; i < map.size(); i++){
			ArrayList<Double> currentVolts = map.get(IDList.get(i));
			numberOfSignals.add(currentVolts.size());
		}
		return numberOfSignals;
	}

	//mean amplitude from each detector
	public static ArrayList<Double> individualMeanAmplitudes (HashMap<String, ArrayList<Double>> map){
		ArrayList<Double> meanAmplitudes = new ArrayList<Double>();
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(map.keySet());
		for(int i =0; i < map.size(); i++){
			double sum = 0;
			ArrayList<Double> currentVolts = map.get(IDList.get(i));
			for(int j =0; j < currentVolts.size(); j++){
				sum += currentVolts.get(j);
			}
			meanAmplitudes.add(sum/currentVolts.size());
		}
		return meanAmplitudes;
	}

	//find the mean arrival times for each of the detectors - this method is kind of a shit show because i did my hashmap badly. I explain why in the method
	public static HashMap<String, Double> meanArrivalTimes(HashMap<String, ArrayList<Double>> map){

		//this is to get an arraylist of the IDs from the map
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(map.keySet());

		//the max voltage and the time for the max voltage - will be reset for each loop
		double maxVoltage;
		double maxVTime;

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
			maxVoltage = 0;
			meanArrivalTime = 0;
			maxVTime =0;
			ArrivalTimes.clear();

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

				//update max voltage and arrivaltime if we need to 
				if(currentVoltage > maxVoltage){
					maxVoltage = currentVoltage;

					//I take off (k*51) as this is how many values came before it in other sets (because it is looping through one big array of all the voltages from that detector)
					maxVTime = j-(k*51);
				}

				/*
				 *here's where my fuck up with the hashmap gets fixed. If the position in the voltages array is divisible by 51,
				 *(ie, every 51 values), the max voltage and arrival time gets reset, the sum gets updated and the value of k used above
				 *is updated.
				 *This would have been better if the map was HashMap<String, ArrayList<ArrayList<Double>>>. This would allow the values in
				 *the map to be array lists of each set of readings from each detector to be in its own arraylist, as opposed to one big arraylist.
				 */
				if(j%51 ==0){
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

	//find the speeds of the things ie mean arrival times / distance
	public static ArrayList<Double> speeds (HashMap<String, Double> meanArrivalTimes, HashMap<String,Double> distances){
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(meanArrivalTimes.keySet());

		ArrayList<Double> meanArrivalTimesList = new ArrayList<Double>();
		ArrayList<Double> speeds = new ArrayList<Double>();

		double currentArrivalTime, currentDistance, currentSpeed;

		//loop through detectors 
		for (int i  =0; i<meanArrivalTimes.size(); i++){

			//get current ID
			String currentID = IDList.get(i);

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

		//turn the data into a hashmap
		HashMap<String, ArrayList<Double>> sDMap = dataIntoHashMap(sDList);
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