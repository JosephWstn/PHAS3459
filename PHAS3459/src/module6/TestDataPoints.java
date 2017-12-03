package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TestDataPoints {

	/*
	 * Method to convert a .txt URL of x, y, ey on each line to an ArrayList of DataPoints
	 * Arguments: String URL 
	 * Returns ArrayList of DataPoints
	 */
	public static  ArrayList<DataPoint> dataFromURL (String url) throws Exception {
		//read URL and convert it to buffered reader
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//initialise DataPoint ArrayList to be filled  
		ArrayList<DataPoint> list = new ArrayList<DataPoint>();
		 
		//String line to be set to each line of the URL
		String line;
		
		//scans each line of buffered reader
		while ((line = br.readLine()) != null){
			
			//scans current line, setting the values of x, y and ey into a data point
			Scanner sc = new Scanner(line);
			DataPoint currentPoint = new DataPoint();
			currentPoint.x = sc.nextDouble();
			currentPoint.y=sc.nextDouble();
			currentPoint.ey = sc.nextDouble();
			
			//if the line has a label, set the values as a LabelledDataPoint and add it to the ArrayList
			if (sc.hasNext()) {
				LabelledDataPoint currentLabelled = new LabelledDataPoint (currentPoint.x, currentPoint.y, currentPoint.ey, sc.next());
				
				//add the labelled datapoint to the arraylist
				list.add(currentLabelled);
				sc.close();
			}
			else {
				//add the current data point to the ArrayList
				list.add(currentPoint);
				sc.close();
			}
		}	
		return list;
	}


	public static void main(String[] args) throws Exception {
		
		//make the ArrayList of DataPoints from the URL
		ArrayList<DataPoint> dataArrayList = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		
		//print each data point
		for (int i = 0; i<dataArrayList.size(); i ++) {
			System.out.println(dataArrayList.get(i));
		}

	}

}
