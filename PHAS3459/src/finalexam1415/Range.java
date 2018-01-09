package finalexam1415;

import java.util.ArrayList;

public class Range implements Calculation {

	@Override
	public double d(ArrayList<Measurement> list) {
		double max=0;
		double min = Double.POSITIVE_INFINITY;
		double range;

		//loop through measurements in list, finding the max and min level
		for(Measurement m : list){

			double currentLevel = m.getLevel();

			if (currentLevel > max){
				max = currentLevel;
			}

			if (currentLevel < min){
				min = currentLevel;
			}
		}

		range = max - min;

		return range;
	}



}
