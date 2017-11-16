package Earthquakes;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


public class EarthquakeAnalysis {

	public static double maxMag;
	public static int counterMag;
	public static int index1;
	public static int counterMonth;
	public static double maxDepth;
	public static int index3;	
	public static double bestDepth;

	// reads data from URL & returns it as ArrayList
	public static ArrayList<EQPoints> dataFromURL(String urlName) throws Exception{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<EQPoints> list = new ArrayList<EQPoints>();
		String line;
		boolean first = true;
		maxMag = 0.0;
		// scans each line of buffered reader
		while ((line = br.readLine()) != null){
			if (Character.isDigit(line.charAt(0))){
				// appends EQPoints object to ArrayList
				EQPoints points = new EQPoints(line);
				list.add(points);
				// iterating through to find max magnitude
				if (first == true){
					maxMag = points.getMag();
					first = false;
				}
				if (points.getMag() > maxMag){
					maxMag = points.getMag();
					index1 = counterMag;
				}
				counterMag = counterMag + 1;
			}
		}	
		return list;
	}

	public static ArrayList<Integer> quakesPerMonth(ArrayList<EQPoints> data){
		ArrayList<Integer> count = new ArrayList<Integer>();
		for (int i = 0; i < 12; i++){
			count.add(0);
		}
		EQPoints quake = new EQPoints();
		for (int k = 0; k < data.size(); k++){
			quake = data.get(k);
			int currentMonth = quake.getMonth();
			count.set(currentMonth - 1, count.get(currentMonth -1) + 1);
		}
		return count;
	}

	public static ArrayList<EQPoints> maxDepthPerMonth(ArrayList<EQPoints> data){
		ArrayList<EQPoints> mdpm = new ArrayList<EQPoints>();
		ArrayList<Double> depths = new ArrayList<Double>();
		EQPoints quake = new EQPoints();
		for (int i = 0; i < 12; i++){
			depths.add(0.0);
			mdpm.add(null);
		}
		for (int k = 0; k < data.size(); k++){
			quake = data.get(k);
			int Month = quake.getMonth();
			if (quake.getDepth() > depths.get(Month - 1)){
				depths.set(Month - 1, quake.getDepth());
				mdpm.set(Month-1, quake);
			}
		}
		return mdpm;
	}

	public static ArrayList<EQPoints> bestDepthPerMonth(ArrayList<EQPoints> data){
		ArrayList<EQPoints> mdpm = new ArrayList<EQPoints>();
		ArrayList<Double> depths = new ArrayList<Double>();
		EQPoints quake = new EQPoints();
		for (int i = 0; i < 12; i++){
			depths.add(Double.POSITIVE_INFINITY);
			mdpm.add(null);
		}
		for (int k = 0; k < data.size(); k++){
			quake = data.get(k);
			int Month = quake.getMonth();
			if (quake.getDeptherr() < depths.get(Month - 1) && quake.getDeptherr() >= 0){
				depths.set(Month - 1, quake.getDeptherr());
				mdpm.set(Month-1, quake);
			}
		}
		return mdpm;
	}


	public static void main (String args[]) throws Exception{

		// finding and printing total number of earthquakes recorded
		ArrayList<EQPoints> EQData = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt");
		int size = EQData.size(); // size of array
		
		System.out.println("The total number of quakes recorded was: "+ size);

		System.out.println(quakesPerMonth(EQData));

		System.out.println(maxDepthPerMonth(EQData));

		System.out.println(bestDepthPerMonth(EQData));

		System.out.println("The maximum magnitude recorded was: "+ maxMag);

		System.out.println(EQData.get(index1));


	}








}

