package finalexam1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class ExamPart11011 {



	//ArrayList of the Readings
	public static ArrayList<Reading> readingListFromURL(String urlName) throws IOException{
		//initialise the arraylist of readings
		ArrayList<Reading> list = new ArrayList<Reading>();
		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		//boolean to only consider the first line
		String line;
		while ((line = br.readLine()) != null){
			Reading currentLine = new Reading(line);
			list.add(currentLine);
		}
		return list;
	}
	
	//hashmap of country and code
	public static HashMap<String, String> countryMapFromURL(String urlName) throws IOException{
		//initialise the arraylist of readings
		HashMap<String, String> map = new HashMap<String, String>();
		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null){
			Country currentLine = new Country(line);
			map.put(currentLine.getID(), currentLine.getCountry());
		}
		return map;
	}

	//hashmap of station and code
	public static HashMap<String, String> stationMapFromURL(String urlName) throws IOException{
		//initialise the arraylist of readings
		HashMap<String, String> map = new HashMap<String, String>();
		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null){
			Station currentLine = new Station(line);
			map.put(currentLine.getID(), currentLine.getStation());
		}
		return map;
	}
	
	
	
	//hashmap of the readings with data type as the keys
	public static HashMap<String, ArrayList<Reading>> typeMap(ArrayList<Reading> list){

		// Create HashMap of ArrayLists to store signal data using team as key
		HashMap<String, ArrayList<Reading>> typeMap = new HashMap<String, ArrayList<Reading>>();

		// Loop over complete data list
		for (Reading currentReading: list) {

			// Retrieve ID for that signal
			String type = currentReading.getType();

			// Extract reading list from HashMap using this ID
			ArrayList<Reading> thisReading = typeMap.get(type);

			// If this list is empty, create a new ArrayList of signals
			if (thisReading == null) {
				typeMap.put(type, new ArrayList<Reading>());
			}

			// Add current signal to list of signals for that ID
			typeMap.get(type).add(currentReading);

		}


		return typeMap;
	}
	
	//finds an arraylist of all the times the highest temperature happened
	public static ArrayList<Reading> maxTemp(ArrayList<Reading> list){
		ArrayList<Reading> maxTemps = new ArrayList<Reading>();
		int maxTemp = 0;
		
		//loop through temp readings
		for (Reading r : list){
			
			//finds current list of temperatures
			ArrayList<Integer> currentTempList = r.getMonthData();
			
			//loops through the current list of temperatures
			for(int temp : currentTempList){
				
				//if the current temperature is bigger than max, update max, and clear the arraylist of highest temp data
				if (temp > maxTemp){
					maxTemp = temp;
					maxTemps.clear();
					maxTemps.add(r);
				}
				//if the temp is the same, then just add onto it
				if (temp == maxTemp){
					maxTemps.add(r);
				}
			}
		}
		return maxTemps;
	}
	
	public static void main(String[] args) throws IOException {
		ArrayList<Reading> readingList = readingListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2010-11/final/readings.txt");
		HashMap<String, ArrayList<Reading>> typeMap = typeMap(readingList);
		
		HashMap<String, String> countries = countryMapFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2010-11/final/countries.txt");
		HashMap<String, String> stations = stationMapFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2010-11/final/stations.txt");
		ArrayList<Reading> dataTMAX = typeMap.get("TMAX");
		ArrayList<Reading> maxTemps = maxTemp(dataTMAX);
		
		System.out.println(dataTMAX);
		System.out.println("The highest temperature recorded was: "+Collections.max(maxTemps.get(0).getMonthData()));
		System.out.println("The information about the times the highest temperature was recorded is: \n"+maxTemps);
		
	}

}
