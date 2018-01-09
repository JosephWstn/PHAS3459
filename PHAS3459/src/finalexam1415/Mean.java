package finalexam1415;

import java.util.ArrayList;

public class Mean implements Calculation {

	//member variable of my arraylist of measurements
	ArrayList<Measurement> list = new ArrayList<Measurement>();
	
	//constructor of my mean method - not sure if i technically need this but it told me it did
	public Mean(){}
	public Mean(ArrayList<Measurement> list){
		this.list = list;
	}
	
	//the override method to actually calculate the mean
	@Override
	public double d(ArrayList<Measurement> list) {
		double sum =0;

		//loop through the measurements in the arraylist, adding up the levels
		for (Measurement m : list){
			sum += m.getLevel();
		}
		
		//mean = sum / number of values obv
		double mean = sum/list.size();

		return mean;
	}


}
