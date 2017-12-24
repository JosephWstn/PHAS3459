package finalexam1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

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
			SignalData currentLine = new SignalData (line);
			list.add(currentLine);
		}

		return list;
	}

	public int totalNumberOfPulses(ArrayList<SignalData> list){
		int tot=0;
		for (int i =0; i< list.size(); i++){
			tot += list.get(i).getVoltList().size();
		}
		return tot;
	}



	public static void main(String[] args) {

	}

}
