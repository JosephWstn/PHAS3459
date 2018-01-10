package finalexam1314;

import java.io.IOException;
import java.util.ArrayList;

public class LatitudeSpecifier implements RegionSpecifier{

	double min, max;

	//constructor. Latitude specifier is dependant on a max and min latitude
	public LatitudeSpecifier(double min, double max){
		this.min = min;
		this.max = max;
	}

	//set up the two latitude method values: above and below -30. These are static because the two specifying bits in the main method only worked if they were static
	//above -30
	static RegionSpecifier latitudeMethod1 = new LatitudeSpecifier(-30, Double.POSITIVE_INFINITY);
	
	//below -30
	static RegionSpecifier latitudeMethod2 = new LatitudeSpecifier(Double.NEGATIVE_INFINITY, -30);


	//so this takes the whole arraylist and gives out a specified arraylist 
	@Override
	public ArrayList<PlantInfo> specifiedList(ArrayList<PlantInfo> list) { 

		//arraylist that will be the output - includes only the plant infos that are within the range
		ArrayList<PlantInfo> specimensInsideRange = new ArrayList<PlantInfo>();

		//loop through the list to be specified
		for (PlantInfo pi : list){

			//latitude of current PlantInfo
			double currentLat = pi.getLat();

			//if this latitude falls within the range, add it to the new list
			if (currentLat > this.min && currentLat < this.max){
				specimensInsideRange.add(pi);
			}
		}
		return specimensInsideRange;
	}



	public static void main(String[] args) throws IOException {
		//this is the PlantInfo list that needs to be specified
		ArrayList<PlantInfo> plantList = ExamPart11314.listFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-plants.txt");
		
		//specify it into the two lists above and below -30
		ArrayList<PlantInfo> plantsAboveNegative30 = latitudeMethod1.specifiedList(plantList);
		ArrayList<PlantInfo> plantsBelowNegative30 = latitudeMethod2.specifiedList(plantList);
	}

}
