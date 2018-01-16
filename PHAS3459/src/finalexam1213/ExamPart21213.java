package finalexam1213;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExamPart21213 {


	public static HashMap<Double, HashMap<Double, Double>> predictionsAtDifferentMasses(double mMin, double mMax, double N, double w,
			ArrayList<Background> measured){
		
		HashMap<Double, HashMap<Double, Double>> predictionsAtDifferentMasses = new HashMap<Double, HashMap<Double, Double>>();
		HashMap<Double, Double> predictions = new HashMap<Double, Double>();
		for(double m = mMin; m <= mMax; m++){
			PredictedHiggs pHGG = new Gaussian(N, m, w);
			predictions = pHGG.predicted(measured, 1, 100, 200);
			predictionsAtDifferentMasses.put(m, predictions);
		}
		return predictionsAtDifferentMasses;
	}
	
	public static void main(String[] args) throws IOException {
		
		HashMap<String, ArrayList<Double>> higgsMap = ExamPart11.energyMapFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/higgsData.txt");
		HashMap<String, HashMap<Integer, Integer>> binHiggsData = ExamPart11.binHiggsData (higgsMap);
		ArrayList<Background> GGData = ExamPart11.binnedDataToBackground(binHiggsData, "GG");
		ArrayList<Background> ZZData = ExamPart11.binnedDataToBackground(binHiggsData, "ZZ");
		
		HashMap<Double, HashMap<Double, Double>> ggRun = predictionsAtDifferentMasses(110.5, 179.5, 100, 2, GGData);
		HashMap<Double, HashMap<Double, Double>> zzRun = predictionsAtDifferentMasses(110.5, 179.5, 6, 1, ZZData);
		
	}

}