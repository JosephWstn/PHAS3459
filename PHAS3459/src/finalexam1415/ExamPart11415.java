package finalexam1415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ExamPart11415 {

	//make an arraylist of all of the measurement data
	public static ArrayList<Measurement> MeasurementList(String urlName) throws IOException{
		//initialise the arraylist of integers
		ArrayList<Measurement> list = new ArrayList<Measurement>();

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		//loop through text adding it to the list
		while ((line = br.readLine()) != null){
			Measurement currentLine = new Measurement(line);
			list.add(currentLine);
		}

		return list;
	}

	//
	public static HashMap<String, String> siteMap(String urlName) throws IOException{
		HashMap<String, String> map = new HashMap<String, String>(); 

		//read the URL and set it to a buffered reader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		//loop through text adding it to the map
		while ((line = br.readLine()) != null){
			if (!line.contains("Site")){
				IDCode currentLine = new IDCode(line);
				map.put(currentLine.getID(), currentLine.getSite());
			}
		}
		return map;
	}

	//find the measurement with the highest sea level
	public static Measurement maxLevel(ArrayList<Measurement> list){
		Measurement maxLvlMeasurement = new Measurement();
		double maxLvl = 0;
		double currentLvl;
		for (Measurement m :list){
			currentLvl = m.getLevel();
			if (currentLvl > maxLvl){
				maxLvl = currentLvl;
				maxLvlMeasurement = m;
			}
		}
		return maxLvlMeasurement;
	}


	public static void main(String[] args) throws IOException {
		ArrayList<Measurement> measurementList = MeasurementList("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-1999.txt");
		HashMap<String, String> siteMap = siteMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt");
		Measurement maxLvlM = maxLevel(measurementList);
		System.out.println("Maximum level: "+maxLvlM.getLevel());
		System.out.println("ID of site: " + maxLvlM.getID());
		System.out.println("Site: "+ siteMap.get(maxLvlM.getID()));
		System.out.println("Year: "+maxLvlM.getYear()+"\nMonth: "+maxLvlM.getMonth()+"\nDay: "+maxLvlM.getDay()+"\nHour: "+maxLvlM.getHour()+"\nMinute: "+maxLvlM.getMinute());
	}
}