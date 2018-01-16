package finalexam1011;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import finalexam1516.SignalData;

public class ExamPart21011 {


	//sorts the data into a hashmap of: keys: country full names. Value: arraylist of readings done in that country
	public static HashMap<String, ArrayList<Reading>> countryReadingsMap (ArrayList<Reading> list, HashMap<String, String> countries){

		//hashmap that will be returned
		HashMap<String, ArrayList<Reading>> countryReadingMap = new HashMap<String, ArrayList<Reading>>();

		//loop through the data
		for (Reading r : list){

			//get the current country ID from the first two letters of the station ID
			String currentCountryID = r.getID().substring(0,2);

			//get current country full name by using the country hashmap and the current country ID
			String currentCountryName = countries.get(currentCountryID);

			//look to see if our hashmap already has a value for this country name key 
			ArrayList<Reading> thisReading = countryReadingMap.get(currentCountryName);

			//if this country hasn't been put in yet it will be null, so put it in, the arraylist is empty now
			if (thisReading == null){
				countryReadingMap.put(currentCountryName, new ArrayList<Reading>());
			}

			//then add the reading to the arraylist of readings in the right place in the hashmap
			countryReadingMap.get(currentCountryName).add(r);

		}
		return countryReadingMap;
	}

	//this returns the maximum mean temperature of the countries given by the method above
	public static HashMap<String, Double> meanMaxTemperatures (HashMap<String, ArrayList<Reading>> map){

		//initialise hashmap to be madee
		HashMap<String, Double> meanMaxTemperatures = new HashMap<String, Double>();

		//arraylist of the country names from the map keyset
		ArrayList<String> countryList = new ArrayList<String>();
		countryList.addAll((map.keySet()));

		//initialise values that will be calculated each loop
		int maxTemp =0;
		int sum =0;
		double average;
		ArrayList<Integer> maxTemps = new ArrayList<Integer>();

		//loops through the map of countries
		for (String country : countryList){

			//current country data 
			ArrayList<Reading> currentCountryData = map.get(country);

			//loops through the data in the current country
			for(Reading r : currentCountryData){

				//finds current list of temperatures
				ArrayList<Integer> currentTempList = r.getMonthData();

				//loops through the current list of temperatures
				for(int temp : currentTempList){

					//if the current temperature is bigger than max, update max
					if (temp > maxTemp){
						maxTemp = temp;
					}
				}

				//add the maximum found temperature to an arraylist of temperatures
				maxTemps.add(maxTemp);
			}

			//sum up the maximum temperatures from all the values in this country
			for (int i : maxTemps){
				sum+= i;
			}

			//find the average by dividing the sum by the total number of readings
			average = (double) sum / (double) maxTemps.size();
			//add the average to the hashmap
			meanMaxTemperatures.put(country, average);
			//reset necessary values ready for the next country
			sum =0;
			maxTemp=0;
			maxTemps.clear();
		}
		return meanMaxTemperatures;
	}

	//make a hashmap of: keys: years. Values: arraylist of all the readings in that year
	public static HashMap<Integer, ArrayList<Reading>> yearlyReadingsMap (ArrayList<Reading> list){

		//hashmap that will be returned
		HashMap<Integer, ArrayList<Reading>> yearlyReadingMap = new HashMap<Integer, ArrayList<Reading>>();

		//loop through the data
		for (Reading r : list){

			int currentYear = r.getYear();

			//look to see if our hashmap already has a value for this country name key 
			ArrayList<Reading> thisReading = yearlyReadingMap.get(currentYear);

			//if this country hasn't been put in yet it will be null, so put it in, the arraylist is empty now
			if (thisReading == null){
				yearlyReadingMap.put(currentYear, new ArrayList<Reading>());
			}

			//then add the reading to the arraylist of readings in the right place in the hashmap
			yearlyReadingMap.get(currentYear).add(r);

		}
		return yearlyReadingMap;
	}

	/*
	 * finds the countries in which the lowest mean max temperature happened for each year
	 * Inputs: HashMap that has Keys: years(int). Values: ArrrayList of the readings that happened in this year
	 * 		   HashMap that has Keys: The ID of each country (String). Values: The full name of this country (String).
	 * Output: HashMap of Key: Each year (int). Value: An arrayList of all the countries in which the lowest mean max temperature occured
	 */
	public static HashMap<Integer, ArrayList<String>> lowestMeanMaxCountryEachYear (HashMap<Integer, ArrayList<Reading>> yearsMap, HashMap<String, String> countries){

		HashMap<Integer, ArrayList<String>> eachYearLowestMeanMaxCountry = new HashMap<Integer, ArrayList<String>>();

		//make an arraylist of the years in the years map 
		ArrayList<Integer> yearList = new ArrayList<Integer>();		
		yearList.addAll((yearsMap.keySet()));

		//loop through these years ie loop through the hashmap of yearly data
		for (int year : yearList){

			//the arraylist of readings that were taken in the current year
			ArrayList<Reading> currentYearReadings = yearsMap.get(year);

			//sort the readings in the current year into a hashmap where keys are countries and values are the readings in the country
			HashMap<String, ArrayList<Reading>> currentYearSortedByCountries = countryReadingsMap(currentYearReadings, countries);

			//sort this hashmap into a hashmap of Key: country names and value: this countries' max temperature
			HashMap<String, Double> meanMaxTemperatures = meanMaxTemperatures(currentYearSortedByCountries);


			//sort this hashmap into an arraylist of the countries which had the lowest mean max temperature this year (ie will be 1 long unless two countries had the same lowest  mean max) 
			ArrayList<String> countriesWithLowestMaxTemp = lowestMeanMaxTemps(meanMaxTemperatures);


			//put this year and the country/countries with the lowest mean max this year into the hashmap
			eachYearLowestMeanMaxCountry.put(year, countriesWithLowestMaxTemp);
		}

		return eachYearLowestMeanMaxCountry;
	}


	/*
	 * Inputs: hashmap of keys: country names. Values: each countries mean max
	 * outputs: arraylist of the country/countries with the lowest mean max
	 */
	public static ArrayList<String> lowestMeanMaxTemps(HashMap<String, Double> map){
		//arraylist of the country names from the map keyset
		ArrayList<String> countryList = new ArrayList<String>();
		countryList.addAll((map.keySet()));

		//arraylist that will be outputted
		ArrayList<String> countriesWithLowestMaxTemp = new ArrayList<String>();
		double currentMeanMaxTemp;
		double lowestMeanMaxTemp = Double.POSITIVE_INFINITY;

		//loop through the hashmap from the keyset
		for(String country : countryList){

			//get the current country's mean max temp from the map
			currentMeanMaxTemp = map.get(country);

			//if the current temperature is EQUAL to the current minimum, add it to the list
			if (currentMeanMaxTemp == lowestMeanMaxTemp){
				countriesWithLowestMaxTemp.add(country);
			}

			//if the current temperature is LOWER than the current lowest, clear the list and start again with the new lowest
			if(currentMeanMaxTemp < lowestMeanMaxTemp){
				lowestMeanMaxTemp = currentMeanMaxTemp;
				countriesWithLowestMaxTemp.clear();
				countriesWithLowestMaxTemp.add(country);
			}

		}

		return countriesWithLowestMaxTemp;
	}


	/*
	 * Inputs: hashmap of keys: country names. Values: each countries mean max
	 * outputs: arraylist of the country/countries with the lowest mean max
	 * this one uses the interface to find the lowest max temperature
	 */
	public static ArrayList<String> lowestMeanMaxTemps2(HashMap<String, Double> map){
		//arraylist of the country names from the map keyset
		ArrayList<String> countryList = new ArrayList<String>();
		countryList.addAll((map.keySet()));

		//arraylist that will be outputted
		ArrayList<String> countriesWithLowestMaxTemp = new ArrayList<String>();
		double currentMeanMaxTemp;

		//use interface to find the minimum
		Statistic lowestMeanMaxStat = new LowestMeanMaxTemp(map);
		double lowestMeanMax = lowestMeanMaxStat.y("Country", 1, 1);

		//loop through the hashmap from the keyset
		for(String country : countryList){

			//if the current temperature is EQUAL to the minimum, add it to the list
			if (map.get(country) == lowestMeanMax){
				countriesWithLowestMaxTemp.add(country);
			}
		}
		System.out.println(lowestMeanMax);
		return countriesWithLowestMaxTemp;
	}


	public static HashMap<String, Double> findRMSOfAYear(HashMap<Integer, ArrayList<Reading>> yearMap, HashMap<String, ArrayList<Reading>> countryReadings, int year, HashMap<String, String> countries){

		//arraylist of the country names from the map keyset
		ArrayList<String> countryNames = new ArrayList<String>();
		countryNames.addAll((countryReadings.keySet()));

		HashMap<String, Double> countryAndLargestRMS = new HashMap<String, Double>();
		String largestRMSCountry ="";
		double largestRMS = 0;

		for(String country : countryNames){


			Statistic rootMeanSquare = new RMS(yearMap, countries);
			double RMSq = rootMeanSquare.y(country, year, 1);
			if (RMSq > largestRMS){
				largestRMS = RMSq;
				largestRMSCountry = country;

			}

		}

		countryAndLargestRMS.put(largestRMSCountry, largestRMS);
		return countryAndLargestRMS;
	}



	public static void main(String[] args) throws IOException {
		ArrayList<Reading> readingList = ExamPart11011.readingListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2010-11/final/readings.txt");
		HashMap<String, ArrayList<Reading>> typeMap = ExamPart11011.typeMap(readingList);
		ArrayList<Reading> dataTMAX = typeMap.get("TMAX");
		//
		HashMap<String, String> countries = ExamPart11011.countryMapFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2010-11/final/countries.txt");
		//
		HashMap<String, ArrayList<Reading>> countryReadingMap = countryReadingsMap(dataTMAX, countries);
		//
		//		HashMap<String, Double> meanMaxTemperatures = meanMaxTemperatures(countryReadingMap);
		//		System.out.println(meanMaxTemperatures);
		//
		//		ArrayList<String> countryMinMaxMeanTemperature = lowestMeanMaxTemps(meanMaxTemperatures);
		//		System.out.println("Country with lowest mean max temperatre: "+countryMinMaxMeanTemperature);
		//
		HashMap<Integer, ArrayList<Reading>> yearlyMap = yearlyReadingsMap(dataTMAX);
		//
		//		HashMap<Integer, ArrayList<String>> yearlyCountrylWithLowestMeanMax = lowestMeanMaxCountryEachYear(yearlyMap, countries);
		//		System.out.println("The country with the lowest mean max each year is: \n"+yearlyCountrylWithLowestMeanMax);
		//		
		//		ArrayList<String> string = lowestMeanMaxTemps2(meanMaxTemperatures);
		//		System.out.println("Country with lowest mean max temperatre: "+string);
		for (int i=1961; i<1973; i++){
			HashMap<String, Double> largestRMS = findRMSOfAYear(yearlyMap, countryReadingMap,i, countries);
			System.out.println("The country with the Largest RMS, and the corresponding RMS in "+ i +" was: " +largestRMS);
		}

	}


}
