package finalexam1617;

import java.io.IOException;
import java.util.ArrayList;

public class ExamPart21617 {

	//analysis - takes the amplitude list and the title info along with a method to classify sound and does it
	public static String analysis (ArrayList<Integer> ampList, ArrayList<Integer> titleInfo, SoundClassification SC){
		//classify the data based on the classification technique SC
		String sorted = SC.classification(ampList, titleInfo);
		return sorted;
	}
	
	public static void main(String[] args) throws IOException {
		//array list of the information in the title line of recording 01
		ArrayList<Integer> titleInfo01 = ExamPart11617.titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
		//array list of all the amplitudes in recording 01
		ArrayList<Integer> ampList01 = ExamPart11617.arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
		
		//initialise classification techniques to do with loudness and length 
		SoundClassification LS = new LongOrShort (ampList01, titleInfo01);
		SoundClassification LQ = new LoudOrQuiet (ampList01, titleInfo01);
		
		//carry out loud/quiet and long/short on recording01 info
		String LoS = analysis(ampList01, titleInfo01, LS);
		String LoQ = analysis(ampList01, titleInfo01, LQ);
		
		System.out.println("Recording01 is " + LoQ +" and " + LoS);
	}

}
