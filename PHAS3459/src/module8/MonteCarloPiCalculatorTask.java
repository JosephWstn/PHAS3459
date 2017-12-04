package module8;

import java.util.Random;
import java.util.concurrent.Callable;

public class MonteCarloPiCalculatorTask implements Callable<Double> {

	//member variable for how many points to be checked
	private final long n_points;

	//constructor for MonteCarlo method using nPoints
	public MonteCarloPiCalculatorTask(long nPoints) {
		this.n_points = nPoints;
	}

	//call method for MonteCarlo method
	@Override
	public Double call() {
		//consider random value
		Random rand = new Random();
		long n_in = 0;

		//loop through n_points
		for (long iPoint = 0; iPoint < n_points; ++iPoint) {

			//carry out MonteCarlo method to find pi/4
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			double r2 = x*x + y*y;
			if (r2 < 1.0) ++n_in;
		}
		return 4.0 * n_in / n_points;
	}
}
