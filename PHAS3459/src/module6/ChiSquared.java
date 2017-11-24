package module6;

import java.util.ArrayList;
import java.util.Collection;

public class ChiSquared implements GoodnessOfFitCalculator {
	
	public double goodnessOfFit(Collection <DataPoint> p, Theory t){
		double chiSq = 0;

		//loop through DataPoints in ArrayList
		for(DataPoint dp : p){

			//use getters to assign x, y, ey
			double yt = t.y(dp.getx());
			double ym = dp.gety();
			double ey = dp.getey();

			//update X^2
			chiSq += (Math.pow((ym - yt),2))/(Math.pow(ey, 2)); 
		}
		return chiSq;
	}
	
	
}	
