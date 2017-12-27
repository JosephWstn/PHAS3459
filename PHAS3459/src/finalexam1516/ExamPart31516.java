package finalexam1516;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExamPart31516 {

	public static HashMap<String, ArrayList<Double>> comparison (ArrivalTimeMethod voltMethodATM, ArrivalTimeMethod thresholdMethodATM, HashMap<String,ArrayList<Double>> data){
		
		HashMap<String,Double> voltMethod = voltMethodATM.time(data);
		HashMap<String,Double> thresholdMethod = thresholdMethodATM.time(data);
		
		ArrayList<String> IDList = new ArrayList<String>();
		HashMap<String, ArrayList<Double>> biggestDifference = new HashMap<String, ArrayList<Double>>();
		IDList.addAll((voltMethod.keySet()));
		ArrayList<Double> biggestDifferentVolts = new ArrayList<Double>();
		
		String currentID;
		String maxDifferenceID ="";
		double thresholdTime, voltageTime;
		double maxDifference =0;
		
		for(int i =0; i<voltMethod.size(); i++){
			currentID = IDList.get(i);
			voltageTime = voltMethod.get(currentID);
			thresholdTime = thresholdMethod.get(currentID);
			if (Math.abs(voltageTime-thresholdTime)> maxDifference){
				maxDifferenceID = currentID;
			}
			
		}
		biggestDifferentVolts.add(voltMethod.get(maxDifferenceID));
		biggestDifferentVolts.add(thresholdMethod.get(maxDifferenceID));
		biggestDifference.put(maxDifferenceID, biggestDifferentVolts);
		return biggestDifference;
	}
	
	public static void main(String[] args) throws IOException {
		//arraylist of all of the signal datas
		ArrayList<SignalData> sDList = ExamPart11516.pulsesList("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/signals.txt");
		//turn the data into a hashmap
		HashMap<String, ArrayList<Double>> sDMap = ExamPart11516.dataIntoHashMap(sDList);
		ArrivalTimeMethod maxVoltMAT = new MaxVoltMethod(sDMap);
		ArrivalTimeMethod thresholdMAT = new ThresholdMethod(sDMap);
		
		HashMap<String, ArrayList<Double>> stuff = comparison(maxVoltMAT, thresholdMAT, sDMap);
		System.out.println("khbakjn"+ stuff);
	}
}
