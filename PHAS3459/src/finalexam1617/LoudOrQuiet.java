package finalexam1617;

import java.util.ArrayList;

public class LoudOrQuiet implements SoundClassification {

	//member variables
	ArrayList<Integer> ampList, titleInfo;
	
	//constrcutor for loud or quiet test
	public LoudOrQuiet (ArrayList<Integer> ampList, ArrayList<Integer> titleInfo){
		this.ampList = ampList;
		this.titleInfo = titleInfo;
	}
	
	@Override
	//this will test if the amplitude from ExamPart11617 is greater than or less than -20dBFS 
	public String classification(ArrayList<Integer> ampList, ArrayList<Integer> titleInfo) {
		String sortLQ;
		if (ExamPart11617.amplitude(ampList, titleInfo) > -20){
			sortLQ = "loud";
		}
		else {
			sortLQ = "quiet";
		}
		return sortLQ;
	}
}