package finalexam1213;

import java.util.ArrayList;
import java.util.HashMap;

public class Gaussian implements PredictedHiggs{

	double N, m , w;

	public Gaussian(double N, double m, double w){
		this.N=N;
		this.m=m;
		this.w=w;
	}


	public double f(double E){
		return (this.N/this.w * Math.sqrt(2 * Math.PI ))*(Math.pow(Math.E, - Math.pow((E-this.m),2)/(2*Math.pow(this.w, 2))));
	} 

	@Override
	public HashMap<Double, Double> predicted(ArrayList<Background> measured, double binWidth, double min, double max) {
		
		HashMap<Double, Double> predicted = new HashMap<Double, Double>();

		double eH, eL, pred;

		//loop through the measured data
		for (double i = min; i<max; i += binWidth){
			
			//find the max and min of this bin
			eL = i;
			eH = i+binWidth;

			//find predicted using the value of F
			pred = 0.5 * (f(eH) + f(eL)) * (eH - eL);
			
			predicted.put(i, pred);
		}
		return predicted;


	}
}
