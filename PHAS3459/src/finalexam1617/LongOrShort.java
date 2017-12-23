package finalexam1617;

import java.util.ArrayList;

public class LongOrShort implements SoundClassification{

	//member variables - the lists of amplitude and the info in the title
	ArrayList<Integer> ampList, titleInfo;
	
	//constructor for LongOrShort method
	public LongOrShort (ArrayList<Integer> ampList, ArrayList<Integer> titleInfo){
		this.ampList = ampList;
		this.titleInfo = titleInfo;
	}
	
	@Override
	//classification method to find of the recording is long or short
	public String classification(ArrayList<Integer> ampList, ArrayList<Integer> titleInfo) {
		String sortLS;
		
		//call the duration method from other class and see if it's longer or shorter than 1
		if (ExamPart11617.duration(titleInfo) > 1){
			sortLS = "long";
		}
		else{
			sortLS = "short";
		}
		return sortLS;
	}

}
