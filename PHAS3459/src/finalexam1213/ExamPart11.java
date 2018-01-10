package finalexam1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class ExamPart11 {

	//make an arraylist of all of the specimen data
	public static ArrayList<Background> listFromURL(String urlName) throws IOException{
		//initialise the arraylist of backgrounds
		ArrayList<Background> list = new ArrayList<Background>();

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

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

		//initialise the arraylists of energy for two IDs	
		ArrayList<Double> GGList = new ArrayList<Double>();
		ArrayList<Double> ZZList = new ArrayList<Double>();

		//initialise HashMap
		HashMap<String, ArrayList<Double>> energyMap = new HashMap<String, ArrayList<Double>>();

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		//loop through text adding energy to the two arraylists

		while ((line = br.readLine()) != null){
			Higgs currentLine = new Higgs(line);

			if(line.contains("Channel")) {
				System.out.println("title");
			}

			else if(currentLine.getID() == "GG \\s") {
				GGList.add(currentLine.getEnergy());
				System.out.println("GGadd");
			}
			
			else if(currentLine.getID()=="ZZ \\s") {
				System.out.println("ZZadd");
				ZZList.add(currentLine.getEnergy());
			}
			else {
				//System.out.println("failed: "+currentLine.getID()+"\n"+currentLine.getEnergy()+"\n\n");
			}
		}

		//put everything into the map
		energyMap.put("GG", GGList);
		energyMap.put("ZZ", ZZList);

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


	public static void main(String[] args) throws IOException {

		ArrayList<Background> listZZ = listFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundZZ.txt");
		ArrayList<Background> listGG = listFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundGG.txt");
		HashMap<String, ArrayList<Double>> higgsMap = energyMapFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/higgsData.txt");
		System.out.println("Expected readings between 120 and 140 for ZZ: "+readingsInRange(listZZ, 120, 140));
		System.out.println("Expected readings between 120 and 140 for GG: "+readingsInRange(listGG, 120, 140));
		System.out.println("Number of protential GG higgs: "+ higgsMap.get("GG").size());
		System.out.println("Number of protential ZZ higgs: "+ higgsMap.get("ZZ").size());
	}

}
