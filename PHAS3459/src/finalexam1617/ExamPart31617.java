package finalexam1617;

import java.io.IOException;
import java.util.ArrayList;

public class ExamPart31617 {


	public static void main(String[] args) throws IOException {
		//array list of the information in the title line of recording 01
		ArrayList<Integer> titleInfo01 = ExamPart11617.titleInfo("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
		//array list of all the amplitudes in recording 01
		ArrayList<Integer> ampList01 = ExamPart11617.arrayListFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");

		//initialise classification technique to do with pitch
		SoundClassification LMH = new LowOrMediumOrHigh (ampList01, titleInfo01);

		//carry out low, medium or high teston recording01 info
		String LoMoH = ExamPart21617.analysis(ampList01, titleInfo01, LMH);

		System.out.println("Recording01 is " + LoMoH);
	}

}

