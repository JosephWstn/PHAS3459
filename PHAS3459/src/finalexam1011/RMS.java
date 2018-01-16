package finalexam1011;

import java.util.ArrayList;
import java.util.HashMap;

public class RMS implements Statistic{


	HashMap<Integer, ArrayList<Reading>> yearMap= new HashMap<Integer, ArrayList<Reading>>();
	HashMap<String, String> countries = new HashMap<String, String>();
	
	public RMS (HashMap<Integer, ArrayList<Reading>> yearMap, HashMap<String, String> countries){
		this.countries = countries;
		this.yearMap=yearMap;
	}

	@Override
	public double y(String country, int year, int month) {
		
		int squareSum = 0;
		
		//get the arraylist of the data in the year of interest from the year hashmap
		ArrayList<Reading> yearOfInterestData = this.yearMap.get(year);
		
		//sort the readings in the current year into a hashmap where keys are countries and values are the readings in the country
		HashMap<String, ArrayList<Reading>> currentYearSortedByCountries = ExamPart21011.countryReadingsMap(yearOfInterestData, this.countries);

		
		
		//get the arraylist of the readings in the country of interest from the hashmap
		ArrayList<Reading> countryOfInterestInYearOfInterestData = currentYearSortedByCountries.get(country);
		
		//loop through the data finding the RMS
		for(Reading r : countryOfInterestInYearOfInterestData){
			ArrayList<Integer> tempList = r.getMonthData();
			for(Integer i : tempList){
				squareSum += (Math.pow(i, 2));
			}
		}
		return Math.sqrt(squareSum/this.yearMap.size());
	}
}