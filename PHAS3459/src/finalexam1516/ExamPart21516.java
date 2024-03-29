package finalexam1516;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExamPart21516 {

	
	//two arrival time methods: the max voltage and the first above a threshold
	static ArrivalTimeMethod mVM = new MaxVoltMethod();
	static ArrivalTimeMethod thresholdMethod1V = new ThresholdMethod(1);
	
	
	public static void main(String[] args) throws IOException {
		//arraylist of all of the signal datas
		ArrayList<SignalData> sDList = ExamPart11516.pulsesList("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/signals.txt");
		//turn the data into a hashmap
		HashMap<String, ArrayList<Double>> sDMap = ExamPart11516.dataIntoHashMap(sDList);
		

		
		HashMap<String, Double> maxVoltATMap = mVM.time(sDMap);
		HashMap<String, Double> thresholdMathodATMap = thresholdMethod1V.time(sDMap);
		
		System.out.println("The mean arrival times for the maximum volt method: "+ maxVoltATMap);
		System.out.println();
		System.out.println("The mean arrival times for the threshold method are: "+ thresholdMathodATMap);
	}
}


