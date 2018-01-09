package finalexam1415;

import java.io.IOException;
import java.util.ArrayList;

public class ExamPart31415 {

	//finds largest surge. Maybe i was meant to use the calculation interface but who tf cares
	public static Measurement largestSurge(ArrayList<Measurement> list){
		double largestSurge = 0;
		double currentSurge;
		Measurement largestSurgeDetails = new Measurement();
		for(Measurement m : list){
			currentSurge = m.getLevel() - m.getPLevel(); 
			
			if (currentSurge > largestSurge){
				largestSurge = currentSurge;
				largestSurgeDetails =m;
			}
		}
		
		return largestSurgeDetails;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		ArrayList<Measurement> list1 = ExamPart11415.MeasurementList("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-1999.txt");
		Measurement surge1 = largestSurge(list1);
		System.out.println("Largest Surge details: "+ surge1);
		double largestSurgeValue1 = surge1.getLevel() - surge1.getPLevel(); 
		System.out.println("Surge: " + largestSurgeValue1);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		ArrayList<Measurement> list2 = ExamPart11415.MeasurementList("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2004.txt");
		Measurement surge2 = largestSurge(list2);
		System.out.println("Largest Surge details: "+ surge2);
		double largestSurgeValue2 = surge2.getLevel() - surge2.getPLevel(); 
		System.out.println("Surge: " + largestSurgeValue2);
	}
}
