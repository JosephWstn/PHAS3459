package finalexam1011;

import java.util.ArrayList;
import java.util.HashMap;

public class LowestMeanMaxTemp implements Statistic{

	
	HashMap<String, Double> map = new HashMap<String, Double>();
	
	LowestMeanMaxTemp(HashMap<String, Double> map){
		this.map= map;
	}
	
	
	@Override
	public double y(String country, int year, int month) {
		
		//arraylist of the country names from the map keyset
		ArrayList<String> countryList = new ArrayList<String>();
		countryList.addAll((this.map.keySet()));

		//arraylist that will be outputted
		double currentMeanMaxTemp;
		double lowestMeanMaxTemp = Double.POSITIVE_INFINITY;

		//loop through the hashmap from the keyset
		for(String currentCountry : countryList){
			
			//get the current country's mean max temp from the map
			currentMeanMaxTemp = this.map.get(currentCountry);

			//if the current temperature is LOWER than the current lowest, clear the list and start again with the new lowest
			if(currentMeanMaxTemp < lowestMeanMaxTemp){
				lowestMeanMaxTemp = currentMeanMaxTemp;
			}

		}
		return lowestMeanMaxTemp;
	}
}