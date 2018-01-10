package finalexam1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


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
		
		ArrayList<Background> list = listFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundZZ.txt");
		System.out.println(readingsInRange(list, 120, 140));
	}

}
