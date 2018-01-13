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
		//array list of the information in the title line of recordings
		ArrayList<Integer> titleInfo01 = ExamPart11617.titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
		ArrayList<Integer> titleInfo02 = ExamPart11617.titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt");
		ArrayList<Integer> titleInfo03 = ExamPart11617.titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt");
		ArrayList<Integer> titleInfo04 = ExamPart11617.titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt");
		
		//array list of all the amplitudes in recordings
		ArrayList<Integer> ampList01 = ExamPart11617.arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
		ArrayList<Integer> ampList02 = ExamPart11617.arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt");
		ArrayList<Integer> ampList03 = ExamPart11617.arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt");
		ArrayList<Integer> ampList04 = ExamPart11617.arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt");
		
		//initialise classification techniques to do with loudness and length 
		SoundClassification LS1 = new LongOrShort (ampList01, titleInfo01);
		SoundClassification LQ1 = new LoudOrQuiet (ampList01, titleInfo01);
		
		SoundClassification LS2 = new LongOrShort (ampList02, titleInfo02);
		SoundClassification LQ2 = new LoudOrQuiet (ampList02, titleInfo02);
		
		SoundClassification LS3 = new LongOrShort (ampList03, titleInfo03);
		SoundClassification LQ3 = new LoudOrQuiet (ampList03, titleInfo03);
		
		SoundClassification LS4 = new LongOrShort (ampList04, titleInfo04);
		SoundClassification LQ4 = new LoudOrQuiet (ampList04, titleInfo04);
		
		//carry out loud/quiet and long/short on recording01 info
		String LoS1 = analysis(ampList01, titleInfo01, LS1);
		String LoQ1 = analysis(ampList01, titleInfo01, LQ1);
		
		String LoS2 = analysis(ampList02, titleInfo02, LS2);
		String LoQ2 = analysis(ampList02, titleInfo02, LQ2);
		
		String LoS3 = analysis(ampList03, titleInfo03, LS3);
		String LoQ3 = analysis(ampList03, titleInfo03, LQ3);
		
		String LoS4 = analysis(ampList04, titleInfo04, LS4);
		String LoQ4 = analysis(ampList04, titleInfo04, LQ4);
		System.out.println("Recording01 is " + LoQ1 +" and " + LoS1);
		System.out.println("Recording02 is " + LoQ2 +" and " + LoS2);
		System.out.println("Recording03 is " + LoQ3 +" and " + LoS3);
		System.out.println("Recording04 is " + LoQ4 +" and " + LoS4);
	}
}