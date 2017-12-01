package module6;

import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {

	private static Theory bestTheory(Collection<DataPoint> data,
			Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(data, theory);
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}



	public static void main(String[] args) throws Exception {
		
		ArrayList<DataPoint> data = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		
		Theory plOne = new PowerLawTheory(2);
		Theory plTwo = new PowerLawTheory(2.05);
		Theory qOne = new QuadraticTheory(1,10,0);
		ArrayList<Theory> ct = new ArrayList<Theory>();
		ct.add(plOne);
		ct.add(plTwo);
		ct.add(qOne);
		
		GoodnessOfFitCalculator gofC = new ChiSquared();
		
		Theory bT = bestTheory(data, ct, gofC);
		System.out.println("The best theory is "+bT);
	}
}