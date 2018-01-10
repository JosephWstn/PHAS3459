package finalexam1314;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DistanceTest {
	
	//set up the distance method value: within 50km of lat -30.967 and long 75.430
	static RegionSpecifier distanceMethod = new DistanceSpecifier(-30.967, 75.430, 50);

	//set up the distance method value: animals within 100km of lat -30.967 and long 75.430
	static RegionSpecifier distanceMethodAnimals = new DistanceSpecifier(-30.967, 75.430, 100);
	
	
	//finds mean height of certain specimen 
	//argument: arraylist of specimens, id of specimen of interest
	//output: mean height of the specimens of interest
	public static double meanNT(ArrayList<PlantInfo> list, String id){
		double sum =0;
		double num = 0;
		//loop through list
		for (PlantInfo pi : list){
			//loop if id of current PlantInfo matches one of interest
			if(pi.getID().equals(id)){
				
				//add one to sum and total number
				sum += pi.getHeight();
				num++;
			}
		}
		return sum/num;
	}
	
	//finds names of animals in arraylist
	//argumet: arraylist of animals plantinfo
	//output: arraylist of the full name of the animals that appear in the list
	public static ArrayList<String> animalsWithin100km (ArrayList<PlantInfo> list, HashMap<String, String> names){
		ArrayList<String> animals = new ArrayList<String>();
		
		//loop through animal PlantInfo list
		for(PlantInfo pi : list){
			//find the ID of the current animal
			String currentID = pi.getID();
			//if arraylist doesn't already contain this animal, add it
			if(!animals.contains(names.get(currentID))){
				animals.add(names.get(currentID));
			}
		}
		return animals;
	}
	
	public static void main(String[] args) throws IOException {

		//this is the PlantInfo list that needs to be specified
		ArrayList<PlantInfo> plantList = ExamPart11314.listFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-plants.txt");

		
		//specify it into the lists within distance
		ArrayList<PlantInfo> plantsWithinDistance = distanceMethod.specifiedList(plantList);
		
		//find the mean height of the specimen NT within the distance 50km
		System.out.println("Mean height of Urtica dioica within 50km of specified location: "+meanNT(plantsWithinDistance, "NT"));
		
		//for part 3, this is the animal list to be specified
		ArrayList<PlantInfo> animalList = ExamPart11314.listFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-animals.txt");

		//specify animal list into the list within distance
		ArrayList<PlantInfo> animalsWithinDistance = distanceMethodAnimals.specifiedList(animalList);
		
		//hashmap matching animal IDs with scientific names
		HashMap<String, String> animalNames = ExamPart11314.nameMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-animals.txt");
		
		//list of animals within 100km of position
		System.out.println("Animals within 100km of the specified point were: "+ animalsWithin100km(animalsWithinDistance, animalNames));
	}
}
