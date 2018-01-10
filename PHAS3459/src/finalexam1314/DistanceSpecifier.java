package finalexam1314;

import java.io.IOException;
import java.util.ArrayList;

public class DistanceSpecifier implements RegionSpecifier {

	double distance, lat, longt;

	public DistanceSpecifier(double lat, double longt, double distance){
		this.distance = distance;
		this.lat = lat;
		this.longt = longt;
	}

	@Override
	public ArrayList<PlantInfo> specifiedList(ArrayList<PlantInfo> list) {
		//arraylist that will be the output - includes only the plant infos that are within distance
		ArrayList<PlantInfo> specimensWithinDistance= new ArrayList<PlantInfo>();

		//loop through the list to be specified
		for (PlantInfo pi : list){

			//find distance of current PlantInfo to specified point
			//note: fuck this equation 
			double haversinlat = (0.5*(1-Math.cos(this.lat - pi.getLat())));
			double haversinlongt = (0.5*(1-Math.cos(this.longt - pi.getLongt())));
			double h = haversinlat + (Math.cos(pi.getLat())*Math.cos(this.lat)*haversinlongt);

			double currentDistance = 2*6371*Math.asin(Math.sqrt(h));

			//if this latitude falls within the range, add it to the new list
			if (currentDistance < this.distance){
				specimensWithinDistance.add(pi);
			}
		}
		return specimensWithinDistance;
	}

	
}