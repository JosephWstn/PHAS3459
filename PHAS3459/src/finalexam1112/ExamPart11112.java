package finalexam1112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class ExamPart11112 {


	//make an arraylist of all of the ABOccurrences data
	public static ArrayList<OccurrencesAB> abListFromURL(String urlName) throws IOException{
		//initialise the arraylist of Population
		ArrayList<OccurrencesAB> list = new ArrayList<OccurrencesAB>();

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		br.readLine();
		//loop through text adding it to the list
		while ((line = br.readLine()) != null){
			OccurrencesAB currentLine = new OccurrencesAB(line);
			list.add(currentLine);
		}
		return list;
	}

	//make an arraylist of all of the XYZOccurrences data
	public static ArrayList<OccurrencesXYZ> xyzListFromURL(String urlName) throws IOException{
		//initialise the arraylist of Population
		ArrayList<OccurrencesXYZ> list = new ArrayList<OccurrencesXYZ>();

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		br.readLine();
		//loop through text adding it to the list
		while ((line = br.readLine()) != null){
			OccurrencesXYZ currentLine = new OccurrencesXYZ(line);
			list.add(currentLine);
		}
		return list;
	}

	//hashmap of the region and their IDs
	public static HashMap<String, String> regionNameMap(String urlName) throws IOException{
		HashMap<String, String> map = new HashMap<String, String>(); 

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		br.readLine();

		//loop through text adding it to the map
		while ((line = br.readLine()) != null){
			Region currentLine = new Region(line);
			map.put(currentLine.getID(), currentLine.getRegion());
		}
		return map;
	}

	//hashmap of the region and their IDs
	public static HashMap<String, Integer> populationMap(String urlName) throws IOException{
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		br.readLine();

		//loop through text adding it to the map
		while ((line = br.readLine()) != null){
			Population currentLine = new Population(line);
			map.put(currentLine.getID(), currentLine.getPopulation());
		}
		return map;
	}

	//make a hashmap of the AB Occurrences from the arraylist
	//keys: location IDs
	//values: OccurrenceAB objects
	public static HashMap<String, OccurrencesAB> abDataIntoHashMap (ArrayList<OccurrencesAB> list){

		// Create HashMap of ArrayLists to store specimen data using team as key
		HashMap<String, OccurrencesAB> sortedOccurrences = new HashMap<String, OccurrencesAB>();

		// Loop over complete data list
		for (OccurrencesAB data: list) {

			// Retrieve ID for that plant specimen
			String ID = data.getID();

			// Extract measurement list from HashMap using this ID
			OccurrencesAB thisRegionOccurrence = sortedOccurrences.get(ID);

			// if it cannot find this in the hashmap, put it in
			if (thisRegionOccurrence == null) {
				sortedOccurrences.put(ID, data);
			}
		}
		return sortedOccurrences;
	}

	//make a hashmap of the XYZ Occurrences from the arraylist
	//keys: location IDs
	//values: OccurrenceXYZ objects
	public static HashMap<String, OccurrencesXYZ> xyzDataIntoHashMap (ArrayList<OccurrencesXYZ> list){

		// Create HashMap of ArrayLists to store specimen data using team as key
		HashMap<String, OccurrencesXYZ> sortedOccurrences = new HashMap<String, OccurrencesXYZ>();

		// Loop over complete data list
		for (OccurrencesXYZ data: list) {

			// Retrieve ID for that plant specimen
			String ID = data.getID();

			// Extract measurement list from HashMap using this ID
			OccurrencesXYZ thisRegionOccurrence = sortedOccurrences.get(ID);

			// if it cannot find this in the hashmap, put it in
			if (thisRegionOccurrence == null) {
				sortedOccurrences.put(ID, data);
			}
		}
		return sortedOccurrences;
	}

	//find total population
	public static int totalPopulation(HashMap<String, Integer> map){
		int totalPop=0;
		//get an arraylist of all of the region IDs
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(map.keySet());

		for (String id: IDList){
			totalPop += map.get(id);
		}
		return totalPop;
	}

	//find the population that is considered by the AB data
	public static int ABPopulation(HashMap<String, OccurrencesAB> abMap, HashMap<String, Integer> populationMap, int totalPopulation){
		//get an arraylist of all of the region IDs
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(populationMap.keySet());

		//since some regions don't have data for AB, we'll start by assuming that it has all of them, and if we come across a location that it doesn't have, then we'll take that off 
		int populationForABData = totalPopulation;

		//now loop through all of the region IDs
		for(String id : IDList){
			//we need to check if there was data for this region for AB data
			if (abMap.get(id) == null){
				populationForABData -= populationMap.get(id);
			}

		}
		return populationForABData;
	}

	//makes hashmap of each disease
	public static HashMap<String, Double> disPerCapita (HashMap<String, OccurrencesXYZ> xyzMap, HashMap<String, OccurrencesAB> abMap, HashMap<String, Integer> populationMap, int totalPopulation){

		//HashMap that will be returned of each disease and it's number of diseased per capita
		HashMap<String, Double> diseasesPerCapita = new HashMap<String, Double>();

		//get an arraylist of all of the region IDs
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(populationMap.keySet());

		int xTot =0;
		int yTot =0;
		int zTot =0;
		int aTot =0;
		int bTot =0;

		//since some regions don't have data for AB, we'll start by assuming that it has all of them, and if we come across a location that it doesn't have, then we'll take that off 
		int populationForABData = totalPopulation;
		int populationForXYZData = totalPopulation;

		//now loop through all of the region IDs
		for(String id : IDList){

			//we need to check if there was data for this region for AB data
			if (xyzMap.get(id) == null){
				populationForXYZData -= populationMap.get(id);
			}
			else{
				//find the number of each disease in this location
				int xOcc = xyzMap.get(id).getOccX();
				int yOcc = xyzMap.get(id).getOccY();
				int zOcc = xyzMap.get(id).getOccZ();

				//add them to totals
				xTot += xOcc;
				yTot += yOcc;
				zTot += zOcc;
			}



			//we need to check if there was data for this region for AB data
			if (abMap.get(id) == null){
				populationForABData -= populationMap.get(id);
			}
			else{
				int aOcc = abMap.get(id).getOccA();
				int bOcc = abMap.get(id).getOccB();
				aTot += aOcc;
				bTot +=bOcc;
			}
		}
		double xPC = (double)xTot/(double) populationForXYZData;
		double yPC = (double) yTot/(double) populationForXYZData;
		double zPC =  (double) zTot/ (double) populationForXYZData;
		double aPC = (double) aTot/(double) populationForABData;
		double bPC = (double) bTot/(double) populationForABData;

		diseasesPerCapita.put("X", xPC);
		diseasesPerCapita.put("Y", yPC);
		diseasesPerCapita.put("Z", zPC);
		diseasesPerCapita.put("A", aPC);
		diseasesPerCapita.put("B", bPC);

		return diseasesPerCapita;
	}

	public static HashMap<String, String> maxAndMinCapita (HashMap<String, OccurrencesXYZ> xyzMap, HashMap<String, OccurrencesAB> abMap, HashMap<String, Integer> populationMap, HashMap<String, String> names){
		//get an arraylist of all of the region IDs
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(populationMap.keySet());

		double maxCapita = 0;
		double minCapita = Double.POSITIVE_INFINITY;
		String maxCapitaLoc = "";
		String minCapitaLoc = "";
		double currentPerCapita;
		double currentTot;

		int totalCurrent=0;
		int currX=0;
		int currY =0;
		int currZ =0;
		int currA=0;
		int currB=0;

		HashMap<String, String> minAndMax = new HashMap<String, String>();

		for (String id : IDList){


			if (xyzMap.get(id) != null){
				currX = xyzMap.get(id).getOccX();
				currY = xyzMap.get(id).getOccY();
				currZ = xyzMap.get(id).getOccZ();
			}
			else{}

			//we need to check if there was data for this region for AB data
			if (abMap.get(id) != null){
				currA = abMap.get(id).getOccA();
				currB = abMap.get(id).getOccB();

				currentTot = currX + currY + currZ + currA + currB; 
				currentPerCapita = currentTot / populationMap.get(id);
			}
			else{
				currentTot = currX + currY + currZ; 
				currentPerCapita = currentTot / populationMap.get(id);
			}

			if (currentPerCapita > maxCapita){
				maxCapita = currentPerCapita;
				maxCapitaLoc = names.get(id);
			}

			if (currentPerCapita < minCapita){
				minCapita = currentPerCapita;
				minCapitaLoc = names.get(id);
			}
		}
		minAndMax.put("Max: ", maxCapitaLoc);
		minAndMax.put("Min: ", minCapitaLoc);

		return minAndMax;
	}

	public static void main(String[] args) throws IOException {
		ArrayList<OccurrencesAB> abList = abListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/occurrencesAB.txt");

		ArrayList<OccurrencesXYZ> xyzList = xyzListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/occurrencesXYZ.txt");
		HashMap<String, OccurrencesXYZ> xyzMap = xyzDataIntoHashMap(xyzList);
		HashMap<String, OccurrencesAB> abMap = abDataIntoHashMap(abList);
		HashMap<String, String> names = regionNameMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/regions.txt");
		HashMap<String, Integer> populationMap = populationMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/populations.txt");
		int totalPop = totalPopulation(populationMap);
		HashMap<String, Double> disPerCapita  = disPerCapita(xyzMap, abMap,populationMap, totalPop);
		HashMap<String, String> maxAndMinCapita = maxAndMinCapita(xyzMap, abMap, populationMap, names);

		System.out.println("Total Population: "+ totalPop);
		System.out.println("Diseases per capita: " + disPerCapita);
		System.out.println("Max and min per capita: "+maxAndMinCapita);

	}

}
