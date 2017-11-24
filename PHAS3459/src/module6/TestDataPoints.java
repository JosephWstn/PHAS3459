package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TestDataPoints {

	public static  ArrayList<DataPoint> dataFromURL (String url) throws Exception {
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<DataPoint> list = new ArrayList<DataPoint>();
		String line;
		//scans each line of buffered reader
		while ((line = br.readLine()) != null){
			Scanner sc = new Scanner(line);
			DataPoint currentPoint = new DataPoint();
			currentPoint.x = sc.nextDouble();
			currentPoint.y=sc.nextDouble();
			currentPoint.ey = sc.nextDouble();
			if (sc.hasNext()) {
				LabelledDataPoint currentLabelled = new LabelledDataPoint (currentPoint.x, currentPoint.y, currentPoint.ey, sc.next());
				list.add(currentLabelled);
				sc.close();
			}
			else {
				list.add(currentPoint);
				sc.close();
			}
		}	
		return list;
	}


	public static void main(String[] args) throws Exception {
		
		ArrayList<DataPoint> dataArrayList = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		for (int i = 0; i<dataArrayList.size(); i ++) {
			System.out.println(dataArrayList.get(i));
		}

	}

}
