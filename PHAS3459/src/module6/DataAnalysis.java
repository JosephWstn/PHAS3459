package module6;

import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {

	/*
	 * Selects the theory in the collection<Theory> that is the closest fit to the DataPoints using the method defined by GoodnessOfFitCalculator
	 * Arguments: Collection of Datapoints, Collection of Theories to be compared, The goodness of fit calculation that will be used
	 * Returns: Theory best matching datapoints 
	 */
	private static Theory bestTheory(Collection<DataPoint> data,
			Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		
		//first to know when the first loop is 
		boolean first = true;
		
		//initialise the first chiSquared
		double bestGoodnessOfFit = 0.0;
		
		//initialise the theory that gives best ChiSq
		Theory bestTheory = null;
		
		//loop through the theories in the collection
		for (Theory theory : theories) {
			
			//calculate ChiSquared for current theory
			double gof = gofCalculator.goodnessOfFit(data, theory);
			
			//During first loop, set the current theory as the best
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			}
			//if ChiSq for this theory is the smallest, set this theory as the best and update the best ChiSq
			else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}

	public static void main(String[] args) throws Exception {
		
		//Set the ArrayList of datapoints from the URL
		ArrayList<DataPoint> data = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		
		//Set theory of y=x^2
		Theory plOne = new PowerLawTheory(2);
		
		//Set theory of y=x^(2.05)
		Theory plTwo = new PowerLawTheory(2.05);
		
		//Set theory of y= x^2 + 10x
		Theory qOne = new QuadraticTheory(1,10,0);
		
		//Initialise ArrayList of Theories
		ArrayList<Theory> ct = new ArrayList<Theory>();
		
		//add above three theories to ArrayList of theories
		ct.add(plOne);
		ct.add(plTwo);
		ct.add(qOne);
		
		//set goodness of fit calculator to the chisquared method
		GoodnessOfFitCalculator gofC = new ChiSquared();
		
		//use bestTheory to find the best of the three above theories
		Theory bT = bestTheory(data, ct, gofC);
		System.out.println("The theory with the lowest Chi Sqaured is "+bT);
	}
}