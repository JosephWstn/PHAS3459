package finalexam1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;



public class ExamPart11 {

	//make an arraylist of all of the specimen data
	public static ArrayList<Background> backgroundListFromURL(String urlName) throws IOException{
		//initialise the arraylist of backgrounds
		ArrayList<Background> list = new ArrayList<Background>();

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		//skip title line
		br.readLine();
		//loop through text adding it to the list
		while ((line = br.readLine()) != null){
			Background currentLine = new Background(line);

			//add this if statement because it was putting a (0,0,0) reading at the start that i couldn't get rid of
			if(currentLine.getMin() == 0) {}
			else {
				list.add(currentLine);
			}
		}
		return list;
	}

	//make an arraylist of all of the specimen data
	public static HashMap<String, ArrayList<Double>> energyMapFromURL(String urlName) throws IOException{

		//initialise HashMap
		HashMap<String, ArrayList<Double>> energyMap = new HashMap<String, ArrayList<Double>>();

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		//skip title line
		br.readLine();


		//loop through text adding energy to the two arraylists
		while ((line = br.readLine()) != null){
			Higgs currentLine = new Higgs(line);

			//get ID for this signal
			String ID = currentLine.getID();

			//look for this key in the map
			ArrayList<Double> thisIDDetections = energyMap.get(ID);

			//if it hasn't been made yet, add it		
			if (thisIDDetections == null){
				energyMap.put(ID, new ArrayList<Double>());
			}

			//add the current list to the detections from this ID
			energyMap.get(ID).add(currentLine.getEnergy());

		}

		return energyMap;
	}

	//calculates number of readings within a certain range
	public static double readingsInRange (ArrayList<Background> list, int min, int max) {
		int currentMin, currentMax;
		double totEvents=0;
		for (Background bc : list) {
			currentMin = bc.getMin();
			currentMax = bc.getMax();

			if (currentMin >= min && currentMax <= max) {
				totEvents += bc.getEvents();
			}
		}
		return totEvents;
	}

	/*
	 * Method that bins data into widths of 1
	 * Input: HashMap<String, ArrayList<Double>>. Key: name of the detectors. Value: arraylist of the energy detections (doubles) made by this detector
	 * Output: HashMap<String, HashMap<Integer, Integer>>. Key: name of the detectors. Value: the corresponding hashmap of bin minimum (key) and frequency of energy measurements (value).
	 */
	public static HashMap<String, HashMap<Integer, Integer>> binHiggsData(HashMap<String, ArrayList<Double>> energyMap){

		//hashmap. Keys: detector name. Value: the hashmap above
		HashMap<String, HashMap<Integer, Integer>> bothDetectorsBinnedData = new HashMap<String, HashMap<Integer, Integer>>();

		//arraylist of the detector in the map so we can loop through all of them 
		ArrayList<String> detectorList = new ArrayList<String>();
		detectorList.addAll(energyMap.keySet());

		//loop through all of the detectors (in this case, just GG and ZZ)
		for (String detector : detectorList){

			//initialise values - this needs to be done in this for loop to reset for each detector
			int currentValueBin;
			int currentFreq;	
			int newFreq;
			double currentValueBinD;

			//hashmap. Keys: each bin minimum. Value: number of readings in that bin
			HashMap<Integer, Integer> numberOfReadingsInEachBin = new HashMap<Integer, Integer>();

			//find the current list of data for this detector
			ArrayList<Double> currentData = energyMap.get(detector);

			ArrayList<Integer> flooredValues = new ArrayList<Integer>();

			//loop through all of the data in the set for this detector
			for (double currentE : currentData){

				//round the value down, this is what the bin will be
				currentValueBinD =  Math.floor(currentE);
				currentValueBin = (int) currentValueBinD;

				flooredValues.add(currentValueBin);


				//look for this value in the hashmap of bins and frequency
				Integer frequency = numberOfReadingsInEachBin.get(currentValueBin);



				//if this bin hasn't been put into the hashmap yet, put it in
				if (frequency == null){
					numberOfReadingsInEachBin.put(currentValueBin, 1);
				}

				//if it has, add one to the frequency
				else{
					currentFreq = numberOfReadingsInEachBin.get(currentValueBin);
					newFreq = currentFreq +1;
					numberOfReadingsInEachBin.put(currentValueBin, newFreq);
				}
			}

			//System.out.println(Collections.min(currentData));

			//if there have been frequencies of zero, they won't have been added, add them now
			for (int i = Collections.min(flooredValues); i < Collections.max(flooredValues); i++){
				Integer currentReadings = numberOfReadingsInEachBin.get(i);

				if (currentReadings == null){

					numberOfReadingsInEachBin.put(i, 0);
				}
			}

			//put the detector and the corresponding frequency data into the hashmap
			bothDetectorsBinnedData.put(detector, numberOfReadingsInEachBin);

		}
		return bothDetectorsBinnedData;
	}

	//turns the frequency hashmap into an array of backgrounds
	/*
	 * Inputs: - the HashMap of keys: detectors. Values: a hashmap of lower bin value (key) and frequency
	 *         - The detector that you want to be in the list
	 * Outputs: Arraylist of the readings in the form of background objects for the specified detector
	 */
	public static ArrayList<Background> binnedDataToBackground (HashMap<String, HashMap<Integer, Integer>> frequencyMap, String detector){

		//get the data of the desired detector
		HashMap<Integer, Integer> frequencyTable = frequencyMap.get(detector);

		//arraylist of the bin minimums in the map so we can loop through all of them 
		ArrayList<Integer> binMinimums = new ArrayList<Integer>();
		binMinimums .addAll(frequencyTable.keySet());



		ArrayList<Background> actualReadings = new ArrayList<Background>();

		//initialise the values that the background object needs
		int currentFrequency;
		int currentMax;
		int currentMin;

		//loop throuhg the keyset of the frequency table 
		for (int binMin : binMinimums){

			//current frequency/events is the value in the frequency table
			currentFrequency = frequencyTable.get(binMin);

			//minimum is the key in the frequency table
			currentMin = binMin;

			//bin width of 1, so max is min +1
			currentMax = binMin +1;


			//make a new background object to be added to the arraylist
			Background r = new Background();

			//set the events, min and max found above
			r.setEvents(currentFrequency);
			r.setMin(currentMin);
			r.setMax(currentMax);

			//add to the arraylist
			actualReadings.add(r);

		}
		return actualReadings;

	}

	public  static double logLikelihoodEq(double pred, double meas){
		return ((pred - meas) + (meas * Math.log(meas/pred)));
	}

	public static double logLiklihood(ArrayList<Background> pred, ArrayList<Background> meas){
		double predP, measP;
		double sum = 0;

		for (int i=0; i < pred.size(); i++){
			predP = pred.get(i).getEvents();
			measP = meas.get(i).getEvents();

			if(predP ==0 || measP ==0){}
			else{
				sum+= logLikelihoodEq(predP, measP);
			}
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {

		ArrayList<Background> listZZ = backgroundListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundZZ.txt");
		ArrayList<Background> listGG = backgroundListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundGG.txt");
		Background r = new Background();

		r.setEvents(0);
		r.setMax(201);
		r.setMin(200);
		listZZ.add(r);
		listGG.add(r);

		HashMap<String, ArrayList<Double>> higgsMap = energyMapFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/higgsData.txt");
		System.out.println("Expected readings between 120 and 140 for ZZ: "+readingsInRange(listZZ, 120, 140));
		System.out.println("Expected readings between 120 and 140 for GG: "+readingsInRange(listGG, 120, 140));
		System.out.println();
		HashMap<String, HashMap<Integer, Integer>> binHiggsData = binHiggsData (higgsMap);

		ArrayList<Background> GGData = binnedDataToBackground(binHiggsData, "GG");
		ArrayList<Background> ZZData = binnedDataToBackground(binHiggsData, "ZZ");

		System.out.println("Actual readings between 120 and 140 for ZZ: "+readingsInRange(ZZData, 120, 140));
		System.out.println("Actual readings between 120 and 140 for GG: "+readingsInRange(GGData, 120, 140));





		double logLiklihoodGG = logLiklihood(listGG, GGData);
		double logLiklihoodZZ = logLiklihood(listZZ, ZZData);
		System.out.println();
		System.out.println("Log likelihood for GG data: "+logLiklihoodGG);
		System.out.println("Log likelihood for ZZ data: "+logLiklihoodZZ);

	}
}
