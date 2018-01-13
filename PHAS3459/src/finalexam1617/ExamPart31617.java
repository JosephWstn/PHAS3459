package finalexam1617;

import java.io.IOException;
import java.util.ArrayList;

public class ExamPart31617 {


	public static void main(String[] args) throws IOException {
		//array list of the information in the title line of recording 01
		ArrayList<Integer> titleInfo01 = ExamPart11617.titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
		ArrayList<Integer> titleInfo02 = ExamPart11617.titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt");
		ArrayList<Integer> titleInfo03 = ExamPart11617.titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt");
		ArrayList<Integer> titleInfo04 = ExamPart11617.titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt");
				
		//array list of all the amplitudes in recording 01
		ArrayList<Integer> ampList01 = ExamPart11617.arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
		ArrayList<Integer> ampList02 = ExamPart11617.arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt");
		ArrayList<Integer> ampList03 = ExamPart11617.arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt");
		ArrayList<Integer> ampList04 = ExamPart11617.arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt");

		//initialise classification technique to do with pitch
		SoundClassification LMH1 = new LowOrMediumOrHigh (ampList01, titleInfo01);
		SoundClassification LMH2 = new LowOrMediumOrHigh (ampList02, titleInfo02);
		SoundClassification LMH3 = new LowOrMediumOrHigh (ampList03, titleInfo03);
		SoundClassification LMH4 = new LowOrMediumOrHigh (ampList04, titleInfo04);

		//carry out low, medium or high teston recording01 info
		String LoMoH1 = ExamPart21617.analysis(ampList01, titleInfo01, LMH1);
		String LoMoH2 = ExamPart21617.analysis(ampList02, titleInfo02, LMH2);
		String LoMoH3 = ExamPart21617.analysis(ampList03, titleInfo03, LMH3);
		String LoMoH4 = ExamPart21617.analysis(ampList04, titleInfo04, LMH4);

		System.out.println("Recording01 is " + LoMoH1);
		System.out.println("Recording02 is " + LoMoH2);
		System.out.println("Recording03 is " + LoMoH3);
		System.out.println("Recording04 is " + LoMoH4);
	}
}