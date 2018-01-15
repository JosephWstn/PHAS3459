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

	public static ArrayList<String> lowestMeanMaxTemps(HashMap<String, Double> map){
		//arraylist of the country names from the map keyset
		ArrayList<String> countryList = new ArrayList<String>();
		countryList.addAll((map.keySet()));
		
		ArrayList<String> countriesWithLowestMaxTemp = new ArrayList<String>();
		double currentMeanMaxTemp;
		double lowestMeanMaxTemp = Double.POSITIVE_INFINITY;
		
		for(String country : countryList){
			currentMeanMaxTemp = map.get(country);
			
			if (currentMeanMaxTemp == lowestMeanMaxTemp){
				countriesWithLowestMaxTemp.add(country);
			}
			
			if(currentMeanMaxTemp < lowestMeanMaxTemp){
				lowestMeanMaxTemp = currentMeanMaxTemp;
				countriesWithLowestMaxTemp.clear();
				countriesWithLowestMaxTemp.add(country);
			}

		}
		return countriesWithLowestMaxTemp;
	}
	
	
	public static void main(String[] args) throws IOException {
		ArrayList<Reading> readingList = ExamPart11011.readingListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2010-11/final/readings.txt");
		HashMap<String, ArrayList<Reading>> typeMap = ExamPart11011.typeMap(readingList);
		ArrayList<Reading> dataTMAX = typeMap.get("TMAX");

		HashMap<String, String> countries = ExamPart11011.countryMapFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2010-11/final/countries.txt");

		HashMap<String, ArrayList<Reading>> countryReadingMap = countryReadingsMap(dataTMAX, countries);
		System.out.println(countryReadingMap);
		
		HashMap<String, Double> meanMaxTemperatures = meanMaxTemperatures(countryReadingMap);
		System.out.println(meanMaxTemperatures);
		
		ArrayList<String> countryMinMaxMeanTemperature = lowestMeanMaxTemps(meanMaxTemperatures);
		System.out.println(countryMinMaxMeanTemperature);
		
	}


}
