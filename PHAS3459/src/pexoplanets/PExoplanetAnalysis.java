package pexoplanets;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class PExoplanetAnalysis {
	public static double minDis;
	public static int index;
	public static int counterDis;

	// reads data from URL & returns it as ArrayList
	public static ArrayList<PExoplanetData> dataFromURL(String urlName) throws Exception{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<PExoplanetData> list = new ArrayList<PExoplanetData>();
		String line;
		// scans each line of buffered reader
		while ((line = br.readLine()) != null){
			if (line.contains("NAME")){}
			else{
				// appends object to ArrayList
				PExoplanetData exodata = new PExoplanetData(line);
				list.add(exodata);
			}
		}	
		return list;
	}

	public static PExoplanetData ClosestEarth(ArrayList<PExoplanetData> exodata){
		PExoplanetData current = new PExoplanetData();
		PExoplanetData closest = new PExoplanetData();
		minDis = 100000.0;
		// iterating through to find min distance
		for (int i = 0; i < exodata.size(); i++){
			current = exodata.get(i);
			if (current.getDistance() == 0.0){}
			else{
				if (current.getDistance() < minDis){
					minDis = current.getDistance();
					closest = current;
				}
			}
		}
		return closest;
	}
	
	/*
	public static ArrayList<String> methodArray(ArrayList<PExoplanetData> exodata){
		ArrayList<String> methods = new ArrayList<String>();
		for (int i = 0; i<exodata.size(); i++){
			PExoplanetData current = exodata.get(i);
			if (methods.contains(current.getMethod())){}
			else{methods.add(current.getMethod());}
		}
		return methods;
	}
	*/

	public static void dataAnalysis (ArrayList<PExoplanetData> exodata){
		HashMap<String, ArrayList<PExoplanetData>> methodmap = new HashMap<String, ArrayList<PExoplanetData>>();
		for (PExoplanetData currentPlanet : exodata){
			String currentMethod = currentPlanet.getMethod();
			ArrayList<PExoplanetData> currentplanetinfo = methodmap.get(currentMethod);
			if(currentplanetinfo == null){
				methodmap.put(currentMethod, new ArrayList<PExoplanetData>());
			}
			methodmap.get(currentMethod).add(currentPlanet); 
		}


		Object [] methodArray = methodmap.keySet().toArray();
		for (int i =0; i < methodmap.size(); i++){
			int earliestyear = 2017;
			double lightestmass = Double.POSITIVE_INFINITY;
			PExoplanetData lightest = new PExoplanetData();
			PExoplanetData earliest = new PExoplanetData();
			System.out.println("\n \n For method " + methodArray[i] +" there were " + methodmap.get(methodArray[i]).size()+"\n");			

			for(int j =0; j<methodmap.get(methodArray[i]).size();j++){
				if(methodmap.get(methodArray[i]).get(j).getYear() < earliestyear){
					earliest = methodmap.get(methodArray[i]).get(j);
					earliestyear = methodmap.get(methodArray[i]).get(j).getYear();
				}
				if(methodmap.get(methodArray[i]).get(j).getMass() < lightestmass){
					lightest = methodmap.get(methodArray[i]).get(j);
					lightestmass = methodmap.get(methodArray[i]).get(j).getMass();
				}
			}
			System.out.println("For method "+methodArray[i]+" earliest planet was "+earliest+"\nand lightest planet was "+lightest+"\n \n \n ");
		}


	}





	/*
	public static void eachMethodTotal(ArrayList<PExoplanetData> exodata){
		PExoplanetData current = new PExoplanetData();
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<String> methods = methodArray(exodata);
		int totalM = methods.size();
		for (int i = 0; i < totalM; i++){
			count.add(0);
		}
		for (int k = 0; k < exodata.size(); k++){
			current = exodata.get(k);
			for (int j = 0; j < totalM; j++){
				if (current.getMethod().equals(methods.get(j))){
					count.set(j, count.get(j) + 1);
				}
			}
		}
		System.out.println(count + "+" + methods);
	}
	*/

	/*
	public static void minYear(ArrayList<PExoplanetData> exodata){
		PExoplanetData current = new PExoplanetData();
		ArrayList<Integer> years = new ArrayList<Integer>();
		ArrayList<String> methods = methodArray(exodata);
		int totalM = methods.size();
		int currentYear = 0;
		for (int i = 0; i < totalM; i++){
			years.add(100000);
		}
		for (int j = 0; j < totalM; j++){
			for (int k = 0; k < exodata.size(); k++){
				current = exodata.get(k);
				currentYear = current.getYear();
				if (methods.get(j).equals(current.getMethod())){
					if (currentYear < years.get(j)){
						years.set(j, currentYear);
					}
				}
			}
		}
		System.out.println(years);
	}
	
	*/

	/*
	public static void minMass(ArrayList<PExoplanetData> exodata){
		PExoplanetData current = new PExoplanetData();
		PExoplanetData lightest = new PExoplanetData();
		ArrayList<PExoplanetData> Lightest = new ArrayList<PExoplanetData>();
		ArrayList<Double> minMass = new ArrayList<Double>();
		ArrayList<String> methods = methodArray(exodata);
		int totalM = methods.size();
		for (int i = 0; i < totalM; i++){
			Lightest.add(current);
			minMass.add(1000000.0);
		}
		for (int j = 0; j < totalM; j++){
			for (int k = 0; k < exodata.size(); k++){
				current = exodata.get(k);
				if (methods.get(j).equals(current.getMethod())){
					if (current.getMass() == 0.0){}
					else if (current.getMass() < minMass.get(j)){
						minMass.set(j, current.getMass());
						lightest = current;
						Lightest.set(j, lightest);
					}
				}
			}
		}
		System.out.println(Lightest);
	}
	 */
	
	public static void main(String[] args) throws Exception{

		ArrayList<PExoplanetData> ExoExo = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2014-15/exoplanets.txt");

		System.out.println("Closest exoplanet to Earth: "+ClosestEarth(ExoExo));

		//eachMethodTotal(ExoExo);

		//minYear(ExoExo);

		//minMass(ExoExo);

		dataAnalysis(ExoExo);

	}
}
