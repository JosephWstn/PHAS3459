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

	public static BufferedReader dataAsBR(String urlName) throws Exception {
		URL u = new URL (urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);	
	}

	public static String maxdata(BufferedReader br) throws Exception {
		int maximumid =0;
		double maxmag =0, maxsec=0, maxlat=0, maxlong=0, maxdep=0, maxmaj=0, maxmin=0, maxaz=0, maxzerr = 0;
		int tot=0, maxmonth=0, maxyear = 0, maxday=0, maxminute=0, maxhour=0;
		String line;
		while ((line = br.readLine()) != null) {
			if ( !Character.isDigit(line.charAt(0))){
			}
			else {
				Scanner s = new Scanner(line);
				tot++;
				int year =  s.nextInt();
				int month =  s.nextInt();
				int day = s.nextInt();
				int hour = s.nextInt();
				int minute = s.nextInt();
				double second = s.nextDouble();
				double latitude = s.nextDouble();
				double longitude = s.nextDouble();
				double depth = s.nextDouble();
				double major = s.nextDouble();
				double minor = s.nextDouble();
				double azimuth = s.nextDouble();
				double zerr = s.nextDouble();

				double mag = s.nextDouble();

				if(mag > maxmag) {
					maxmag = mag;
					maximumid = s.nextInt();
					maxyear = year;
					maxmonth = month;
					maxday = day;
					maxhour = hour;
					maxminute = minute;
					maxsec = second;
					maxlat = latitude;
					maxlong = longitude;
					maxdep = depth;
					maxmaj = major;
					maxmin = minor;
					maxaz = azimuth;
					maxzerr = zerr;
				}
				else {
					int id = s.nextInt();
				}

				s.close();

			}
		}
		return( "Total number of Eathquakes is: " + tot + "\n" + "Maximum earthquake magnitude is: " + maxmag + ". ID of this is " + maximumid + ". This Eathquake happened on " + maxday +" / " + maxmonth + " / " + maxyear +" at time " + maxhour + ":"+ maxminute + ":"+ maxsec +".\nThe latitude was " + maxlat + " and the longitude was "+maxlong + ". \nIt occured at a depth of " + maxdep + " with an uncertainty of " + maxzerr + ". \nThe major and minor axis (km) and azimuth of 95% relative location are " + maxmaj +", "+ maxmin +", "+ maxaz + " respectively.");
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

	public static void main(String[] args) throws Exception {

		BufferedReader brdata = dataAsBR("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt");
		System.out.println(maxdata(brdata));

	}
}