package midtermpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import com.sun.javafx.collections.MappingChange.Map;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import module5.DataPoint;

public class EarthQuakes {

	public static String dataAnalysis(String urlName) throws Exception {
		URL u = new URL (urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);	
		
		double max = 0;
		String line;
		while ((line = br.readLine()) != null) {
			
			Scanner s = new Scanner(line);
			
			String year = s.next();
			/*
			double month = s.nextDouble();
			double day = s.nextDouble();
			double hour = s.nextDouble();
			double minute = s.nextDouble();
			double second = s.nextDouble();
			double latitude = s.nextDouble();
			double longitude = s.nextDouble();
			double depth = s.nextDouble();
			double major = s.nextDouble();
			double minor = s.nextDouble();
			double azimuth = s.nextDouble();
			double zerr = s.nextDouble();
			
			double mag = s.nextDouble();
			
			if(mag > max) {
				max = mag;
				int maximumid = s.nextInt();
			}
			else {
				int id = s.nextInt();
			}
			*/
			s.close();
			return year;
		}
		return "";
	}
	

	/*
	public static HashMap<Integer, Double> idmag(BufferedReader br) throws IOException {
		//buffered reader to scanner
		Scanner s = new Scanner(br);
		String line;
		HashMap<Integer, Double> data = new HashMap<Integer, Double>();
		Double mag; 
		while ((line = br.readLine()) != null) {
			if (line.isEmpty() || Character.isSpaceChar(line.charAt(0)) || Character.isLetter(line.charAt(0))){
			}

			else{
				s.nextDouble();
				s.nextDouble();
				s.nextDouble();
				s.nextDouble();
				s.nextDouble();
				s.nextDouble();
				s.nextDouble();
				s.nextDouble();
				s.nextDouble();
				s.nextDouble();
				s.nextDouble();
				s.nextDouble();
				s.nextDouble();
				mag = s.nextDouble();
				int id = s.nextInt();
				//update sum
				data.put(id,mag);
			}
		}
		return data;
	}
	 */

	/*
	public static double maxmag (BufferedReader br) throws IOException {
		//buffered reader to scanner
		double max = 0;
		int maximumid = 0;
		String line;
		while ((line = br.readLine()) != null) {
			
			Scanner s = new Scanner(line);
			double year = s.nextDouble();
			double month = s.nextDouble();
			double day = s.nextDouble();
			double hour = s.nextDouble();
			double minute = s.nextDouble();
			double second = s.nextDouble();
			double latitude = s.nextDouble();
			double longitude = s.nextDouble();
			double depth = s.nextDouble();
			double major = s.nextDouble();
			double minor = s.nextDouble();
			double azimuth = s.nextDouble();
			double zerr = s.nextDouble();
			double mag = s.nextDouble();
			if(mag > max) {
				max = mag;
				maximumid = s.nextInt();
			}
			else {
				int id = s.nextInt();
			}
			s.close();
		}
		return max;
	}
*/

	public static void main(String[] args) throws Exception {

		String maxmag = dataAnalysis("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt");
		System.out.println(maxmag);

	}
}