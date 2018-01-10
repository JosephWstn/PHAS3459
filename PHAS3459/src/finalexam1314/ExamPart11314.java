package finalexam1314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;



public class ExamPart11314 {


	//make an arraylist of all of the specimen data
	public static ArrayList<PlantInfo> listFromURL(String urlName) throws IOException{
		//initialise the arraylist of PlantInfo
		ArrayList<PlantInfo> list = new ArrayList<PlantInfo>();

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		//loop through text adding it to the list
		while ((line = br.readLine()) != null){
			PlantInfo currentLine = new PlantInfo(line);
			list.add(currentLine);
		}
		return list;
	}

	//make a hashmap of the data sorted into the IDs, i have this and the arraylist so i can just use which ever is most convenient
	public static HashMap<String, ArrayList<PlantInfo>> dataIntoHashMap (ArrayList<PlantInfo> list){

		// Create HashMap of ArrayLists to store specimen data using team as key
		HashMap<String, ArrayList<PlantInfo>> sortedPlantInfo= new HashMap<String, ArrayList<PlantInfo>>();

		// Loop over complete data list
		for (PlantInfo data: list) {

			// Retrieve ID for that plant specimen
			String ID = data.getID();

			// Extract measurement list from HashMap using this ID
			ArrayList<PlantInfo> thisPlantInfoList = sortedPlantInfo.get(ID);

			// If this list is empty, create a new ArrayList of measurements
			if (thisPlantInfoList == null) {
				sortedPlantInfo.put(ID, new ArrayList<PlantInfo>());
			}

			// Add current measurement to list of measurements for that ID
			sortedPlantInfo.get(ID).add(data);
		}
		return sortedPlantInfo;
	}


	//hashmap of the plants and their IDs
	public static HashMap<String, String> nameMap(String urlName) throws IOException{
		HashMap<String, String> map = new HashMap<String, String>(); 

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		//loop through text adding it to the map
		while ((line = br.readLine()) != null){
			PlantID currentLine = new PlantID(line);
			map.put(currentLine.getID(), currentLine.getName());
		}
		return map;
	}

	//find the mean height in an arraylist of plant infos
	public static double meanHeight (ArrayList<PlantInfo> list){
		double sum =0;
		for(PlantInfo pi : list){
			sum+= pi.getHeight();
		}
		double mean = sum/list.size();
		return mean;
	}

	//do the whole of part 1 analysis here. prints out the names, means and number of specimens as it loops
	//returns a hashmap of keys: names of max and min mean. values: values of max and min means
	public static HashMap<String, Double> partOneAnalysis(HashMap<String, String> nameIDs, HashMap<String, ArrayList<PlantInfo>> plantMap){
		//get an arraylist of the IDs from the hashmap
		ArrayList<String> IDList = new ArrayList<String>();
		IDList.addAll(nameIDs.keySet());

		//HashMap which will have 2 parts: the max and min means.
		//keys will be the scientific names of the max/min plant
		//values will be the corresponding means
		HashMap<String, Double> maxAndMinMean = new HashMap<String,Double>();

		//initialise min and max stuff
		double maxMean = 0;
		double minMean = Double.POSITIVE_INFINITY;
		String maxMeanName ="";
		String minMeanName ="";

		//loop through IDs
		for (String id : IDList){
			//find mean of current PlantInfos
			double currentMean = meanHeight(plantMap.get(id));
			
			//find current number of specimens
			double numberOfSpecimens = plantMap.get(id).size();
			
			//print out the info needed for 2nd bullet point
			System.out.println(nameIDs.get(id) +":");
			System.out.println("Mean: "+currentMean);
			System.out.println("Number of specimens: "+numberOfSpecimens);
			System.out.println();

			//update max if necessary
			if (currentMean > maxMean){
				maxMean = currentMean;
				maxMeanName = nameIDs.get(id);
			}

			//update min if necessary
			if (currentMean < minMean){
				minMean = currentMean;
				minMeanName = nameIDs.get(id);
			}

		}

		//add the max and min info to the hashmap
		maxAndMinMean.put(minMeanName, minMean);
		maxAndMinMean.put(maxMeanName, maxMean);

		return maxAndMinMean;
	}

	public static void main(String[] args) throws IOException {
		HashMap<String, String> names = nameMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-plants.txt");
		ArrayList<PlantInfo> plantList = listFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-plants.txt");
		HashMap<String, ArrayList<PlantInfo>> plantMap = dataIntoHashMap(plantList);

		System.out.println(partOneAnalysis(names, plantMap));
	}
}